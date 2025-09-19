package com.saucedemo.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static final Target INVENTORY_CONTAINER = Target.the("inventory container")
            .located(By.id("inventory_container"));

    public static final Target PAGE_TITLE = Target.the("page title")
            .located(By.className("title"));

    public static final Target SHOPPING_CART_BADGE = Target.the("shopping cart badge")
            .located(By.className("shopping_cart_badge"));

    public static final Target PRODUCT_ITEMS = Target.the("product items")
            .located(By.className("inventory_item"));

    public static final Target FIRST_ADD_TO_CART_BUTTON = Target.the("first add to cart button")
            .located(By.xpath("(//button[contains(@class, 'btn_inventory')])[1]"));

    public static final Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .located(By.className("shopping_cart_link"));
}
