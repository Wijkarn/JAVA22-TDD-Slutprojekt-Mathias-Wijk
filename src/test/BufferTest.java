package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockBufferHelper;

class BufferTest {

	@Test
	@DisplayName("Test if add returns true")
	void addCheckIfTrue() {
		MockBufferHelper buffer = new MockBufferHelper();
		assertTrue(buffer.add(new Item("yeet")));
	}
	
	@Test
	@DisplayName("Test if remove, removes the same item")
	void removeCheckIfSameItem() {
		MockBufferHelper buffer = new MockBufferHelper();
		Item item = new Item("yeet");
		buffer.add(item);
		assertEquals(item, buffer.remove());
	}

}
