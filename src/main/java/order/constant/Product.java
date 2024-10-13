package order.constant;

import static order.constant.ProductType.*;

public enum Product {
    // 메인
    PIZZA("피자", 25000, MAIN),
    HAMBURGER("햄버거", 10000, MAIN),
    CHICKEN("치킨", 23000, MAIN),

    // 사이드
    FRENCH_FRIES("감자튀김", 5000, SIDE),
    MOZZARELLA_STICK("치즈스틱", 7000, SIDE),
    SALAD("샐러드", 8000, SIDE),

    // 음료
    COLA("콜라", 2000, DRINK),
    ZERO_COLA("제로 콜라", 2500, DRINK),
    ORANGE_JUICE("오렌지 주스", 3000, DRINK),

    // 서비스
    DUMPLING("서비스 만두", 0, SERVICE);

    private final String name;
    private final Integer price;
    private final ProductType type;

    Product(String name, Integer price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }
}
