package com.example.carrot.repository.image.user;

import com.example.carrot.domain.images.UserImage;

public interface UserImageRepository {
    Long save(UserImage item);
    UserImage findById(Long id);
}
