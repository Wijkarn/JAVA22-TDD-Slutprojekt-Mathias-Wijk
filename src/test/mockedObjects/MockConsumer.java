package test.mockedObjects;

import main.Consumer;
import main.Item;

public class MockConsumer implements Consumer {

	private BufferHelper buffer;

	public MockConsumer(BufferHelper buffer) {
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
