package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockBufferHelper;

class BufferTest {

	MockBufferHelper buffer;

	@BeforeEach
	void beforeEach() {
		buffer = new MockBufferHelper();
	}

	@Test
	@DisplayName("Test if add returns true")
	void addCheckIfTrue() {
		assertTrue(buffer.add(new Item("yeet")));
	}

	@Test
	@DisplayName("Test if add, adds item to buffer")
	void addCheckIfAddedToBuffer() {
		Item item = new Item("yeet");
		buffer.add(item);
		assertFalse(buffer.getBuffer().isEmpty());
	}

	@Test
	@DisplayName("Test if buffer is empty on init")
	void bufferEmpty() {
		assertTrue(buffer.getBuffer().isEmpty());
	}

	@Test
	@DisplayName("Test if add, adds null to buffer")
	void addNull() {
		buffer.add(null);
		assertFalse(buffer.getBuffer().isEmpty());
	}

	@Test
	@DisplayName("Test if remove, removes item if empty")
	void remoteWhenBufferEmpty() {
		Thread thread = new Thread(() -> assertThrows(InterruptedException.class, () -> buffer.remove()));
		thread.start();
		thread.interrupt();
	}

	@Test
	@DisplayName("Size of buffer = 1")
	void getBufferCheckSizeEquals1() {
		buffer.add(new Item("yeet"));
		assertEquals(1, buffer.getBuffer().size());
	}

}

/*-

 + test check if boolean is true
 + test to check if Buffer add method adds item in buffer list
 + test if buffer list is init empty
 + test if sysout adding null to list
 + tests remove if list is empty and tries to remove an item anyway
 + test if buffer is empty
test if buffer is not empty
tests add, if the right id is sent to list or if null is sent in
test  in the console if list has [null] and [abc]



	@Test
	@DisplayName("Test if remove, removes the same item")
	void removeCheckIfSameItem() {
		Item item = new Item("yeet");
		buffer.add(item);
		assertEquals(item, buffer.remove());
	}
*/