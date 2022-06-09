package com.springboot.restaurant;

import com.springboot.restaurant.dao.CartRepository;
import com.springboot.restaurant.dao.ItemRepository;
import com.springboot.restaurant.dao.UserRepository;
import com.springboot.restaurant.entity.Cart;
import com.springboot.restaurant.entity.CartItem;
import com.springboot.restaurant.entity.Item;
import com.springboot.restaurant.entity.User;
import com.springboot.restaurant.service.CartService;
import com.springboot.restaurant.service.ItemService;
import com.springboot.restaurant.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.*;



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
	//Cart
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

    // SERVICE LAYER

	User user3 = new User("susan", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", 1);

	@Autowired
    private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void findUserByIdTest(){
		String id="susan";

		when(userRepository.findById(id)).thenReturn(
				Optional.of(user)
		);
		Assertions.assertEquals("$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", userService.findById(id).getPassword());

	}
	@Test
	void saveUserTest() {
		userService.save(user3);
		verify(userRepository, times(1)).save(user3);
	}
	@Autowired
	private ItemService itemService;

	@MockBean
	private ItemRepository itemRepository;

	@Mock
	private Model model;


	@Test
	void findAllProductsTest() {
		when(itemRepository.findAll()).thenReturn(
				Stream.of(
						item1,
						item2
				).collect(Collectors.toList()));

		Assertions.assertEquals(2, itemRepository.findAll().size());

	}

	@Test
	void findProductByIdTest() {
		int id=1;

		when(itemRepository.findById(id)).thenReturn(
				Optional.of(item1)
		);

		Assertions.assertEquals("Idly", itemService.findById(id).getItemName());
	}

	@Test
	void saveProductTest() {
		itemService.save(item1);
		verify(itemRepository, times(1)).save(item1);
	}

	@Test
	void deleteProductTest() {
		int id = 1;
		itemService.deleteById(id);
		verify(itemRepository, times(1)).deleteById(id);
	}

	@Autowired
	private CartService cartService;

	@MockBean
	private CartRepository cartRepository;

	@Test
	void findCartByIdTest() {
		int id=1;

		when(cartRepository.findById(id)).thenReturn(
				Optional.of(cart)
		);

		Assertions.assertEquals(75, cartService.findById(id).getTotal());
	}

	@Test
	void saveCartTest() {
		cartService.save(cart);
		verify(cartRepository, times(1)).save(cart);
	}

	@Test
	void deleteCartTest() {
		int id = 1;
		cartService.deleteById(id);
		verify(cartRepository, times(1)).deleteById(id);
	}

}


