import java.util.* ;
import java.io.*; 
public class NQueue {
	// Initialize your data structure.
	int[] front, rear, arr, next;
	int freespot;
	public NQueue(int n, int s) {
		// Write your code here.
		front = new int[n];
		rear = new int[n];
		arr = new int[s];
		next = new int[s];

		for(int i = 1; i < s; i++){
			next[i - 1] = i;
		}
		next[s - 1] = -1;

		for(int i = 0; i < n; i++){
			front[i] = -1;
			rear[i] = -1;
		}

		freespot = 0;
	}

	// Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
	public boolean enqueue(int x, int m) {
		// Write your code here.
		if(freespot == -1)
			return false;

		// finding the index
		int index = freespot;
		// updating the index
		freespot = next[index];
		
		// if the first element
		if(front[m-1] == -1){
			front[m-1] = index;
		}
		else{
			next[rear[m-1]] = index;	
		}	

		// set current space is -1 means now not empty
		next[index] = -1;
		// enqueue the element
		arr[index] = x;

		// update the rear via current rear
		rear[m-1] = index;

		return true;
		
	}

	// Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
	public int dequeue(int m) {
		// Write you code here.
		if(front[m-1] == -1)
			return -1;

		int index = front[m-1];
		front[m-1] = next[index];
		
		next[index] = freespot;
		freespot = index;

		return arr[index];

	}
};
