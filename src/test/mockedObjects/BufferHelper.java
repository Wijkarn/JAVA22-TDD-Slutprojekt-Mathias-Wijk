package test.mockedObjects;

import java.util.Queue;

import main.Buffer;
import main.Item;

public class BufferHelper extends Buffer{

	public Queue<Item> getBuffer() {
		return buffer;
	}
	
}
