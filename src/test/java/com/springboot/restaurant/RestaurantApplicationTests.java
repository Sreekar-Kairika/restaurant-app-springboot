package com.springboot.restaurant;

import com.springboot.restaurant.entity.Cart;
import com.springboot.restaurant.entity.CartItem;
import com.springboot.restaurant.entity.Item;
import com.springboot.restaurant.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;


@SpringBootTest
class RestaurantApplicationTests {

	@Test
	void contextLoads() {
	}

	User user = new User("mary", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", 1);
	Item item1 = new Item("Idly", 25);
	Item item2 = new Item("Dosa", 50);

	CartItem cartItem = new CartItem(item1,2);
	Cart cart = new Cart(user, Arrays.asList(cartItem), 75, 2);


//User Entity
	@Test
	void setUserUserNameTest() {
		user.setUsername("mary");
		Assertions.assertEquals("mary", user.getUsername());
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

//	Items
	@Test
	void setUserItemssTest() {
		user.setItems(Arrays.asList(item1, item1));
		Assertions.assertEquals(2, user.getItems().size());
	}
	@Test
	void setItemIdTest() {
		item1.setPrice(1);
		Assertions.assertEquals(1, user.getEnabled());
	}

	void setCartItemCartTest() {
		cartItem.setCart(cart);

		Assertions.assertEquals(200.00, cartItem.getCart().getTotal());
	}




	@Test
	void setUserCartTest() {
		user.setCart(cart);
		Assertions.assertEquals(75, user.getCart().getTotal());
	}
	@Test
	void setCartTotalItems() {
		cart.setTotalItems(2);

		Assertions.assertEquals(2, cart.getTotalItems());
	}
	@Test
	void setCartIdTest() {
		cart.setId(1);

		Assertions.assertEquals(1, cart.getId());
	}


	@Test
	void setItemPriceTest(){
		item1.setPrice(30);
		Assertions.assertEquals(30, item1.getPrice());

	}

	@Test
	void setItemNameTest(){
		item1.setItemName("Upma");
		Assertions.assertEquals("Upma",item1.getItemName());

	}

	void setTotalTest(){
		cart.setTotal(3000);
		Assertions.assertEquals(3000, cart.getTotal());

	}
	void setTotalItemsTest(){
		cart.setTotalItems(4);
		Assertions.assertEquals(4, cart.getTotalItems());

	}
//	

	@Test
	void setCartItemIdTest() {
		cartItem.setId(1);
		Assertions.assertEquals(1, cartItem.getId());
	}

	@Test
	void setCartItemQuantity() {
		cartItem.setQuantity(5);
		Assertions.assertEquals(5, cartItem.getQuantity());
	}

}
