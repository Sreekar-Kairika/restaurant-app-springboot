package com.springboot.restaurant.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserTest {

    User user = new User("john", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", 1);
    Item item1 = new Item("Idly", 25);
    Item item2 = new Item("Doas", 50);

    CartItem cartItem = new CartItem(item1,2);
    Cart cart = new Cart(user, Arrays.asList(cartItem), 75, 2);



    @Test
    void setUserUserNameTest() {
        user.setUsername("john");

        Assertions.assertEquals("john", user.getUsername());
    }

    @Test
    void setUserPasswordTest() {
        user.setPassword("$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K");

        Assertions.assertEquals("$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", user.getPassword());
    }

    @Test
    void setUserEnabledTest() {
        user.setEnabled(1);

        Assertions.assertEquals(1, user.getEnabled());
    }

    @Test
    void setUserProductsTest() {
        user.setItems(Arrays.asList(item1, item1));

        Assertions.assertEquals(2, user.getItems().size());
    }

    @Test
    void setUserUserCartTest() {
        user.setCart(cart);

        Assertions.assertEquals(75, user.getCart().getTotal());
    }



}
