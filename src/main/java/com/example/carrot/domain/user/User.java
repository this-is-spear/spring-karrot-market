package com.example.carrot.domain.user;

import com.example.carrot.domain.images.UserImage;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String loginId; //로그인 ID
    private String name; //사용자 이름
    private String password;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "user")
    private UserImage userImage;

    public void setUserImage(UserImage userImage) {
        this.userImage = userImage;
        userImage.setUser(this);
    }
}
