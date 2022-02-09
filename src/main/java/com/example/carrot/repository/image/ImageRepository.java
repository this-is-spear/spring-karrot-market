package com.example.carrot.repository.image;

import com.example.carrot.domain.images.Image;

public interface ImageRepository {
    public Long save(Image image);

    public Image findById(Long id);
}
