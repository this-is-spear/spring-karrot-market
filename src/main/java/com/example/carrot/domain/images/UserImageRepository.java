package com.example.carrot.domain.images;

public interface UserImageRepository {
    Long save(UserImage item);
    UserImage findById(Long id);
}
