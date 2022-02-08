package com.example.carrot.web.item;

import com.example.carrot.domain.images.Image;
import com.example.carrot.domain.images.ItemImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ItemFileStore {
    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public List<ItemImage> storeFiles(List<MultipartFile> multipartFiles)
            throws IOException {
        List<ItemImage> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            } }
        return storeFileResult;
    }

    public ItemImage storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        
        return new ItemImage(originalFilename, storeFileName);
    }

    public String createStoreFileName(String originalFilename) {
        String extractExt = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extractExt;
    }

    public String extractExt(String originFilename) {
        int pos = originFilename.lastIndexOf(".");
        return originFilename.substring(pos + 1);
    }
}
