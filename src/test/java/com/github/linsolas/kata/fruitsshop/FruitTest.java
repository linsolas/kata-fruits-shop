package com.github.linsolas.kata.fruitsshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitTest {

    @Test
    public void check_pomme() {
        assertThat(Fruit.what("pomme")).isEqualTo(Fruit.POMME);
    }
    @Test
        public void check_pommes() {
            assertThat(Fruit.what("pommes")).isEqualTo(Fruit.POMME);
        }

}
