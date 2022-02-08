package com.example.carrot.domain.images;

import com.example.carrot.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("user_images")
public class UserImage extends Image{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserImage(String originalFilename, String storeFileName) {
        super(originalFilename, storeFileName);
    }
}
