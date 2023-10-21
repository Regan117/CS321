package src;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class WorkFlowTest {
	public ArrayList mockCurrentTasks = new ArrayList<Integer>();
	public ArrayList mockFinishedTasks = new ArrayList<Integer>();
	public int task1 = 1;
	public int task2 = 2;
	public int task3 = 3;
	public int task4 = 4;

	public final WorkFlow wf = new WorkFlow(task1);


	@Test
	public void testSendTasks() throws Exception {
		//checks if it's in the current list, if so don't send else send
		mockCurrentTasks.add(task1);
		assertEquals(-1,wf.SendTasks(task1));
		assertEquals(-1,wf.SendTasks(-24));
		assertEquals(task2,wf.SendTasks(task2));
	}

	@Test
	public void testStoreFinishedTasks() throws Exception {
		//returns the index of the stored task if possible
		assertEquals(0,wf.StoreFinishedTasks(task1));
		//this function should only fail if the list does not exist in which case the method would return -1 
		assertEquals(-1,wf.StoreFinishedTasks(task1));
	}

}
