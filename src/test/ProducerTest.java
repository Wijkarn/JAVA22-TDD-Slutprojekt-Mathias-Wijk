package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.mockedObjects.BufferHelper;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockProducer;

class ProducerTest {
	MockProducer mp;

	@BeforeEach
	void beforeEach() {
		mp = new MockProducer(new BufferHelper());
	}

	@Test
	@DisplayName("Size of buffer = 1")
	void getBufferCheckSizeEquals1() {
		mp.addItem();
		assertEquals(1, mp.getBuffer().getBuffer().size());
	}

	@Test
	@DisplayName("Size of buffer = 2")
	void getBufferCheckSizeEquals2() {
		mp.addItem();
		mp.addItem();
		assertEquals(2, mp.getBuffer().getBuffer().size());
	}

	@Test
	@DisplayName("Size of buffer = 20")
	void getBufferCheckSizeEquals20() {
		for (int i = 0; i < 20; i++) {
			mp.addItem();
		}
		assertEquals(20, mp.getBuffer().getBuffer().size());
	}

	@Test
	@DisplayName("Size of buffer = 10")
	void getBufferCheckSizeEquals10() {
		for (int i = 0; i < 11; i++) {
			mp.addItem();
		}
		MockConsumer mc = new MockConsumer(mp.getBuffer());
		mc.removeItem();
		assertEquals(10, mp.getBuffer().getBuffer().size());
	}

}
