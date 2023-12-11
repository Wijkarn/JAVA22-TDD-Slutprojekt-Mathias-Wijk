package test.mockedObjects;

import main.Item;
import main.Producer;

public class MockProducer implements Producer {

	private BufferHelper buffer;

	public MockProducer(BufferHelper buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
	}

	@Override
	public void stopRunning() {
	}

	public BufferHelper getBuffer() {
		return buffer;
	}

	public void addItem() {
		buffer.add(new Item("" + Math.floor(Math.random() * 100)));
	}

}
