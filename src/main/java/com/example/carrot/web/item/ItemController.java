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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String saveItem(@Valid @ModelAttribute("itemForm") ItemForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        log.debug("[{}][{}] item form", MDC.get(CheckThreadLog.LOG_ID), form.toString());
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "items/item-form";
        }
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
        if (item == null) {
            log.debug("[{}][{}] not found itemId", MDC.get(CheckThreadLog.LOG_ID), id);
            return "redirect:/";
        }
        model.addAttribute("item", item);
        return "items/item-view";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource showImage(@PathVariable String filename) throws MalformedURLException {
        log.debug("[{}][{}] Show Image", MDC.get(CheckThreadLog.LOG_ID), filename);

        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

}
