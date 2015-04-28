package com.github.linsolas.kata.fruitsshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsShopTest {

    FruitsShop casher = new FruitsShop();

    private void check(String fruit, String val) {
        assertThat(casher.doSomethingWithInput(fruit)).isEqualTo(val);
    }

    @Test
    public void should_handle_input() {
        check("foobar", "0");
    }

    @Test
    public void test_pommes() {
        check("pommes", "100");
    }

    @Test
    public void test_pommes_with_spaces() {
        check("  pommes  ", "100");
    }

    @Test
    public void test_cart() {
        check("cerises", "75");
        check("pommes", "175");
        check("cerises", "230");
        check("bananes", "380");
        check("pommes", "480");
    }

    @Test
    public void test_with_promo() {
        check("pommes", "100");
        check("cerises", "175");
        check("cerises", "230");
    }

    @Test
    public void test_with_2_promo() {
        check("pommes", "100");
        check("cerises", "175");
        check("cerises", "230");
        check("cerises", "305");
        check("cerises", "360");
    }

    @Test
    public void test_complete_chart_with_promo() {
        check("cerises", "75");
        check("pommes", "175");
        check("cerises", "230");
        check("bananes", "380");
        check("cerises", "455");
        check("cerises", "510");
        check("pommes", "610");
    }


    @Test
    public void manage_3_fruits() {
        check("pommes,cerises,bananes", "325");
    }

    @Test
    public void manage_3_fruits_plus_1() {
        check("pommes,cerises,bananes", "325");
        check("pommes", "425");
    }

    @Test
    public void manage_new_promo() {
        check("cerises", "75");
        check("cerises", "130");
        check("bananes", "280");
        check("bananes", "280");
    }

    @Test
    public void localization_apple() {
        check("cerise", "75");
        check("apples", "175");
        check("cerises", "230");
        check("bananes", "380");
        check("bananes", "380");
    }

    @Test
    public void check_all() {
        check("cerises", "75");
        check("apples", "175");
        check("cerises", "230");
        check("bananes", "380");
        check("pommes", "480");
        check("mele", "580");
    }

    @Test
    public void check_promo_by_localization() {
        check("mele", "100");
        check("apples", "200");
        check("apples", "300");
        check("pommes", "400");
        check("apples", "400");
        check("mele", "400");
        check("cerise", "475");
        check("cerise", "530");
    }

    @Test
    public void test_with_csv_and_loc() {
        check("mele,apples,apples,pommes,apples,mele,cerises,cerises,bananes", "680");
    }

    @Test
    public void super_promo() {
        check("mele,apples,apples,mele", "250");
        check("bananes", "200");
        System.out.println("-----------");
        check("mele,apples,apples,pommes,mele", "150");
    }

}
