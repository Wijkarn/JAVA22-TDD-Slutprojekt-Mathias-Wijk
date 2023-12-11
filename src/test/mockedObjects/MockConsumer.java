package test.mockedObjects;

import main.Consumer;
import main.Item;

public class MockConsumer implements Consumer {

	private MockBufferHelper buffer;

	public MockConsumer(MockBufferHelper buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
	}

	@Override
	public void stopRunning() {
	}

	public Item removeItem() {
		return buffer.remove();
	}

}
