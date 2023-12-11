package test.mockedObjects;

import java.util.Queue;

import main.Buffer;
import main.Item;

public class MockBufferHelper extends Buffer{

	public Queue<Item> getBuffer() {
		return buffer;
	}
	
}
