package order.domain;

import static order.domain.MenuType.DRINK;
import static order.domain.MenuType.MAIN;
import static order.domain.MenuType.SERVICE;
import static order.domain.MenuType.SIDE;
import static order.global.constant.ErrorMessage.INVALID_ORDER_FORMAT;

import java.util.Arrays;

public enum Menu {
    // 메인 메뉴
    PIZZA("피자", 25000, MAIN),
    HAMBURGER("햄버거", 10000, MAIN),
    CHICKEN("치킨", 23000, MAIN),

    // 사이드 메뉴
    FRENCH_FRIES("감자튀김", 5000, SIDE),
    CHEESE_STICK("치즈스틱", 7000, SIDE),
    SALAD("샐러드", 8000, SIDE),

    // 음료 메뉴
    COLA("콜라", 2000, DRINK),
    ZERO_COLA("제로 콜라", 2500, DRINK),
    ORANGE_JUICE("오렌지 주스", 3000, DRINK),

    // 서비스 메뉴
    DUMPLING("만두", 0, SERVICE);

    private String name;
    private int price;
    private MenuType menuType;

    Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public static Menu findMenuByName(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_FORMAT.get()));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }
}
