package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.mockedObjects.ItemHelper;

class ItemTest {

	ItemHelper item;

	@BeforeEach
	void beforeEach() {
		item = new ItemHelper("oof");
	}

	@Test
	@DisplayName("lower case setId")
	void setIdLowerCase() {
		String id = "yeet";
		item.setId(id);
		assertEquals(id, item.getId());
	}

	@Test
	@DisplayName("lower case constructor")
	void itemConstructorLowerCase() {
		assertEquals("oof", item.getId());
	}

	@Test
	@DisplayName("test setId if upper case converts to lower case")
	void setIdUpperCase() {
		String id = "YEET";
		item.setId(id);
		assertEquals(id.toLowerCase(), item.getId());
	}

	@Test
	@DisplayName("test if item id isn't uppercase")
	void itemConstructorUpperCase() {
		String id = "YEET";
		ItemHelper item = new ItemHelper(id);
		assertEquals(id.toLowerCase(), item.getId());
	}

	@Test
	@DisplayName("test if item id is empty string")
	void itemConstructorEmptyString() {
		String id = "";
		ItemHelper item = new ItemHelper(id);
		assertTrue(item.getId().isBlank());
	}

	@Test
	@DisplayName("test if item id is empty string")
	void setIdEmptyString() {
		String id = "";
		item.setId(id);
		assertTrue(item.getId().isBlank());
	}

	@Test
	@DisplayName("toString upper case")
	void toStringUpperCase() {
		String id = "YEET";
		item.setId(id);
		assertEquals(id.toLowerCase(), item.toString());
	}

	@Test
	@DisplayName("toString lower case")
	void toStringLowerCase() {
		String id = "yeet";
		item.setId(id);
		assertEquals("yeet", item.toString());
	}

	@Test
	@DisplayName("toString empty string")
	void toStringEmptyString() {
		String id = "";
		item.setId(id);
		assertTrue(item.toString().isBlank());
	}

	@Test
	@DisplayName("test if setId = null")
	void setIdCheckNull() {
		assertThrows(NullPointerException.class, () -> item.setId(null));
	}

	@Test
	@DisplayName("test if constructor = null")
	void constructorCheckNull() {
		assertThrows(NullPointerException.class, () -> new ItemHelper(null));
	}

}

/*-
 * new thread(() ->{
 * assertThrows(InterruptException.class,() -> remove)
 * }
 * )
 * thread.start()
 * thread.interrupt()
 * 
 * NoSuchElementException
 */
