package test.mockedObjects;

import main.Item;
import main.Producer;

public class MockProducer implements Producer {

	private MockBufferHelper buffer;

	public MockProducer(MockBufferHelper buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
	}

	@Override
	public void stopRunning() {
	}

	public MockBufferHelper getBuffer() {
		return buffer;
	}

	public void addItem() {
		buffer.add(new Item("" + Math.floor(Math.random() * 100)));
	}

}
