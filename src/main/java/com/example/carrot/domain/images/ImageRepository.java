package com.example.carrot.domain.images;

public interface ImageRepository {
    public Long save(Image image);

    public Image findById(Long id);
}
