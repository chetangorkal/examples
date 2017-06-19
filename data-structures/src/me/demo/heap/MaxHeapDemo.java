package me.demo.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeapDemo {

	int heap[], heapSize = 0;

	public MaxHeapDemo() {
		heapSize = 0;
	}

	/**
	 * Function to build the max-heap
	 * 
	 * @param inputData
	 */
	private void maxHeapify(int[] inputData) {

		heap = new int[inputData.length + 1];
		// fill the heap from 1 index to make life easier

		// if a parent node is at ith index the the left child is at 2*i and
		// right child is at
		// 2*i+1
		// insert from the back to the front

		for (int i = 0; i < inputData.length; i++) {
			heap[heapSize + 1] = inputData[i];

			heapify(inputData[i]);
			++heapSize;
		}
	}

	/**
	 * This method will balance the heap according to the properties of the heap
	 * 
	 * @param value
	 * @param data
	 */
	private void heapify(int value/* , int[] data */) {

		// int index = data.length-1;
		int index = heapSize + 1;
		// System.out.println("index "+index+" heap[index/2]"+heap[index/2]);
		while (index > 1 && heap[index / 2] < value) {
			// swap parent with child
			int temp = heap[index / 2];
			heap[index / 2] = heap[index];
			heap[index] = temp;

			index /= 2;
		}

	}

	/**
	 * THis method remove the maximum element from the heap and re-balances the
	 * heap according to the Max heap property
	 * 
	 * @return
	 */
	public int removeMax() {

		if (heapSize == 0)
			throw new NoSuchElementException("The heap is empty");

		int result = -1;

		result = heap[1];
		heap[1] = heap[heapSize];
		--heapSize;

		// now balance the heap according to the max heap property

		for (int i = 1; i < heapSize; i *= 2) {
			if (i * 2 < heapSize && heap[i] < heap[i * 2] && i * 2 + 1 < heapSize && heap[i * 2] > heap[i * 2 + 1]) {
				// swap the two elements
				int max = heap[i * 2];
				heap[i * 2] = heap[i];
				heap[i] = max;
			} else if (i * 2 + 1 < heapSize && heap[i] < heap[i * 2 + 1]) {
				int max = heap[i * 2 + 1];
				heap[i * 2 + 1] = heap[i];
				heap[i] = max;
			}
		}
		System.out.println(Arrays.toString(heap));
		return result;
	}

	public void add(int value) {
		int index = heapSize + 1;
		if (index >= heap.length)
			heap = Arrays.copyOf(heap, heapSize + 16);
		heap[index] = value;

		while (index > 1 && heap[index / 2] < heap[index]) {
			// swap parent with child
			int temp = heap[index / 2];
			heap[index / 2] = heap[index];
			heap[index] = temp;

			index /= 2;
		}
	}

	/**
	 * Main method to test the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxHeapDemo heapDemo = new MaxHeapDemo();
		heapDemo.maxHeapify(new int[] { 3, 2, 6, 7, 9 });
		System.out.println(Arrays.toString(heapDemo.heap));
		System.out.println("the maximum element is =" + heapDemo.heap[1]);
		System.out.println("remmoved max ele is = " + heapDemo.removeMax());
	}
}