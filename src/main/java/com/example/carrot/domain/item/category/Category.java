package com.example.carrot.domain.item.category;


public enum Category implements BaseEnumCode<String>{
    DIGITAL_DEVICES("디지털기기"),
    HOUSEHOLD_APPLIANCES("생활가전"),
    FURNITURE_AND_INTERIOR("가구/인테리어"),
    CHILDHOOD_STUFF("유아동"),
    DAILY_PROCESSED_FOOD("생활/가공식품"),
    CHILDREN_BOOKS("유아도서"),
    WOMEN_CLOTHING("여성의류"),
    MAN_CLOTHING("남성패션/잡화"),
    GAME_AND_HOBBY("게임/취미"),
    BEAUTY("뷰티/미용"),
    PET_SUPPLIES("반려동물용품"),
    BOOKS_TICKETS_RECORDS("도서/티켓/음반"),
    FOOD("식품"),
    USED_ITEMS("기타 중고물품"),
    USED_CAR("중고차");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
