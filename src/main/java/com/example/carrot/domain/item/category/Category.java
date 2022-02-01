package com.example.carrot.domain.item.category;


public enum Category implements BaseEnumCode<String>{
    A("디지털기기"),
    B("생활가전"),
    C("가구/인테리어"),
    D("유아동"),
    E("생활/가공식품"),
    F("유아도서"),
    G("여성의류"),
    H("남성패션/잡화"),
    I("게임/취미"),
    J("뷰티/미용"),
    K("반려동물용품"),
    L("도서/티켓/음반"),
    M("식품"),
    N("기타 중고물품"),
    O("중고차");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
