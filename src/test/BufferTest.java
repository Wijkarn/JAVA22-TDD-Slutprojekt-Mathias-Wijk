package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockBufferHelper;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockProducer;

class BufferTest {

	MockBufferHelper buffer;
	MockConsumer mc;
	MockProducer mp;
	Item item;

	@BeforeEach
	void beforeEach() {
		buffer = new MockBufferHelper();
		mc = new MockConsumer(buffer);
		mp = new MockProducer(buffer);
		item = new Item("yeet");
	}

	@Test
	@DisplayName("Test if add returns true")
	void addCheckIfTrue() {
		assertTrue(mp.addItem(item));
	}

	@Test
	@DisplayName("Test if add, adds item to buffer")
	void addCheckIfAddedToBuffer() {
		mp.addItem(item);
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
		mp.addItem(null);
		assertFalse(buffer.getBuffer().isEmpty());
	}

	@Test
	@DisplayName("Test if remove, removes item if empty")
	void remoteWhenBufferEmpty() {
		Thread thread = new Thread(() -> assertThrows(InterruptedException.class, () -> mc.removeItem()));
		thread.start();
		thread.interrupt();
	}

	@Test
	@DisplayName("Size of buffer = 1")
	void getBufferCheckSizeEquals1() {
		mp.addItem(item);
		assertEquals(1, buffer.getBuffer().size());
	}

	@Test
	@DisplayName("Test if remove, removes the same item")
	void removeCheckIfSameItem() {
		mp.addItem(item);
		assertEquals(item, mc.removeItem());
	}

	@Test
	@DisplayName("Testing if console output is right")
	void addCheckConsole() {
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		mp.addItem(item);
		String consoleOutput = outputStreamCaptor.toString().trim();

		assertEquals("[yeet]", consoleOutput);

		System.setOut(System.out);
	}

}
