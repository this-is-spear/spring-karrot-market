package com.example.carrot.web.item;

import com.example.carrot.domain.images.ItemImage;
import com.example.carrot.domain.item.Item;
import com.example.carrot.domain.item.ItemRepository;
import com.example.carrot.domain.item.MemoryItemRepository;
import com.example.carrot.web.filter.CheckThreadLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemFileStore fileStore;

    @GetMapping("/items/new")
    public String newItem(@ModelAttribute ItemForm form) {
        return "items/item-form";
    }

    @PostMapping("/items/new")
    public String saveItem(@ModelAttribute ItemForm form, RedirectAttributes redirectAttributes) throws IOException {
        log.debug("[{}][{}] item form", MDC.get(CheckThreadLog.LOG_ID), form.toString());

        Item item = saveItem(form);

        redirectAttributes.addAttribute("itemId", item.getId());

        return "redirect:/items/{itemId}";
    }

    private Item saveItem(ItemForm form) throws IOException {
        List<ItemImage> storeFiles = fileStore.storeFiles(form.getImageFiles());
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setItemContent(form.getItemContent());
        item.setItemCategory(form.getItemCategory());
        item.setItemPrice(form.getItemPrice());
        item.setImagesFiles(storeFiles);
        itemRepository.save(item);
        return item;
    }


    @GetMapping("/items/{id}")
    public String items(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id);
        model.addAttribute("item", item);
        return "items/item-view";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

}
