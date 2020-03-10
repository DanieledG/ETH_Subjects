package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.Random;

import org.junit.jupiter.api.Test;

import sorting.*;

class SortingTests {

	@Test
	void testMinHeap() {
		MinHeap MinH = new MinHeap();
		MinH.insert(5); 	MinH.insert(2);
		MinH.insert(4);		MinH.insert(8);
		MinH.insert(2);		MinH.insert(1);
		MinH.insert(10);	MinH.insert(0);
		MinH.insert(20);	MinH.insert(12);

		assert MinH.checkHeapCondition(MinH.root);
		
		int root = MinH.extractRoot();
		assertEquals(0, root);
		root = MinH.extractRoot();
		assertEquals(1, root);
		root = MinH.extractRoot();
		assertEquals(2, root);
		root = MinH.extractRoot();
		assertEquals(2, root);
	}
	
	@Test
	void testSwapKeys() {
		MinHeap MinHeap = new MinHeap();
		IntNode n = new IntNode(10);
		IntNode m = new IntNode(5);
		MinHeap.swapKeys(n, m);
		assertEquals(n.key, 5);
		assertEquals(m.key, 10);
		int[] A = {1, 4, 7, 0};
		Sorting.swapKeys(A, 0, 3);
		Sorting.swapKeys(A, 1, 1);
		
		int[] solution = {0, 4, 7, 1};
		assertArrayEquals(solution, A);
		
	}
	
	@Test
	void testHeapSorting() {
		MaxHeap MaxHeap = new MaxHeap();
		MaxHeap.insert(7); 		MaxHeap.insert(1);
		MaxHeap.insert(3);		MaxHeap.insert(9);
		MaxHeap.insert(4);		MaxHeap.insert(8);
		MaxHeap.insert(6);		MaxHeap.insert(5);
		MaxHeap.insert(10);		MaxHeap.insert(2);
		int[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] result = new int[10];
		for (int i = 9; i >= 0; i--) {
			result[i] = MaxHeap.extractRoot();
		}
		
		assertArrayEquals(solution, result);
	}
	
	@Test
	void backwardsSortingTest() {
		final int[] toSort = {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] solution = {90, 88, 10, 9, 9, 9, 5, 4, 3, 2, 1,};
		MinHeap minHeap = new MinHeap();
		
		int[] resultHeap = minHeap.heapsort(toSort);
		
		assertArrayEquals(solution, resultHeap);
	}
	@Test
	void sortingTest1() {
		int[] toSort = {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] solution = {1, 2, 3, 4, 5, 9, 9, 9, 10, 88, 90};

		MaxHeap maxheap = new MaxHeap();
		int[] resultMerge = Mergesort.mergesort(toSort, 0, toSort.length-1);
		int[] toSort1 = {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] resultQuick = Quicksort.quicksort(toSort1, 0, toSort.length-1);
		int[] toSort2 = {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] resultHeap = maxheap.heapsort(toSort2);
		int[] toSort3 = {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] resultBubble = Bubblesort.bubblesort(toSort3);
		int[] toSort4= {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] resultInsertion = Insertionsort.insertionsort(toSort4);
		int[] toSort5= {4, 5, 2, 90, 88, 9, 9, 9, 1, 3, 10};
		int[] resultHeapsort = Heapsort.sort(toSort5);

		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);	
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultInsertion);
		assertArrayEquals(solution, resultHeapsort);
	}
	
	@Test
	void sortingTest2() {
		int[] toSort = {1, 65, 7, 02304, 289, 8, 12, 4, 9, 9};
		int[] solution = {1, 4, 7, 8, 9, 9, 12, 65, 289, 02304};

		MaxHeap maxheap = new MaxHeap();
		int[] resultMerge = Mergesort.mergesort(toSort, 0, toSort.length-1);
		int[] toSort1 = {1, 65, 7, 02304, 289, 8, 12, 4, 9, 9};
		int[] resultQuick = Quicksort.quicksort(toSort1, 0, toSort.length-1);
		int[] toSort2 = {1, 65, 7, 02304, 289, 8, 12, 4, 9, 9};
		int[] resultHeap = maxheap.heapsort(toSort2);
		int[] toSort3 = {1, 65, 7, 02304, 289, 8, 12, 4, 9, 9};
		int[] resultBubble = Bubblesort.bubblesort(toSort3);
		int[] toSort4 = {1, 65, 7, 02304, 289, 8, 12, 4, 9, 9};
		int[] resultInsertion = Insertionsort.insertionsort(toSort4);
		
		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);	
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultInsertion);
	}
	
	@Test
	void testAllEqual() {
		final int[] toSort = {1, 1, 1, 1, 1, 1, 1};
		int[] solution = {1, 1, 1, 1, 1, 1, 1};

		MaxHeap maxheap = new MaxHeap();
		int[] resultMerge = Mergesort.mergesort(toSort, 0, toSort.length-1);
		int[] resultQuick = Quicksort.quicksort(toSort, 0, toSort.length-1);
		int[] resultHeap = maxheap.heapsort(toSort);
		int[] resultBubble = Bubblesort.bubblesort(toSort);
		int[] resultInsertion = Insertionsort.insertionsort(toSort);
		
		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultInsertion);
	}
	
	@Test
	void testAlreadySorted() {
		int[] toSort = {1, 2, 3, 4, 5, 6, 7};
		int[] solution = {1, 2, 3, 4, 5, 6, 7};

		MaxHeap maxheap = new MaxHeap();
		int[] resultMerge = Mergesort.mergesort(toSort, 0, toSort.length-1);
		int[] resultQuick = Quicksort.quicksort(toSort, 0, toSort.length-1);
		int[] resultHeap = maxheap.heapsort(toSort);
		int[] resultBubble = Bubblesort.bubblesort(toSort);
		int[] resultInsertion = Insertionsort.insertionsort(toSort);
		
		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultInsertion);
	}
	
	@Test
	void testSortedBackwards() {
		int[] toSort = {7, 6, 5, 4, 3, 2, 1};
		int[] solution = {1, 2, 3, 4, 5, 6, 7};

		MaxHeap maxheap = new MaxHeap();
		int[] resultMerge = Mergesort.mergesort(toSort, 0, toSort.length-1);
		int[] toSort1 = {7, 6, 5, 4, 3, 2, 1};
		int[] resultQuick = Quicksort.quicksort(toSort1, 0, toSort.length-1);
		int[] toSort2 = {7, 6, 5, 4, 3, 2, 1};
		int[] resultHeap = maxheap.heapsort(toSort2);
		int[] toSort3 = {7, 6, 5, 4, 3, 2, 1};
		int[] resultBubble = Bubblesort.bubblesort(toSort3);
		int[] toSort4 = {7, 6, 5, 4, 3, 2, 1};
		int[] resultInsertion = Insertionsort.insertionsort(toSort4);
		
		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultInsertion);
	}
	
	@Test
	void testLargeNumbers() {
		Random RNG = new Random();
		MaxHeap maxheap = new MaxHeap();
		AVLTree AVL = new AVLTree();
		List<Integer> solutionList = new LinkedList<Integer>();
		
		int size = 1000;
		int[] randArray1 = new int[size];
		for (int i = 0; i < size; i++) {
			int next = RNG.nextInt();
			randArray1[i] = next;
			solutionList.add(next);
			AVL.insert(next);
		}
		
		AVL.inOrder(AVL.root);
		int[] resultAVL = new int[size];
		for (int i = 0; i < size; i++) {
			resultAVL[i] = AVL.inOrder.get(i);
		}
		solutionList.sort(null);
		int[] solution = new int[size];
		Iterator<Integer> itr = solutionList.iterator();
		int i = 0;
		while(itr.hasNext()) {
			int next = itr.next();
			solution[i] = next;
			i++;
			itr.remove();
		}
		int[] randArray2 = randArray1.clone();
		int[] resultBubble = Bubblesort.bubblesort(randArray1);
		int[] randArray3 = randArray2.clone();
		int[] resultMerge = Mergesort.mergesort(randArray2, 0, randArray2.length-1);
		int[] randArray4 = randArray3.clone();
		int[] resultHeap = maxheap.heapsort(randArray3);
		int[] randArray5 = randArray4.clone();
		int[] resultQuick = Quicksort.quicksort(randArray4, 0, randArray4.length-1);
		int[] resultInsertion = Insertionsort.insertionsort(randArray5);

		assertArrayEquals(solution, resultMerge);
		assertArrayEquals(solution, resultQuick);
		assertArrayEquals(solution, resultHeap);
		assertArrayEquals(solution, resultInsertion);
		assertArrayEquals(solution, resultBubble);
		assertArrayEquals(solution, resultAVL);

	}
	
	@Test
	void testAVL() {
		AVLTree AVL = new AVLTree();
		AVL.insert(1);
		AVL.insert(1);
		AVL.insert(2);
		AVL.insert(3);
		AVL.insert(8);
		AVL.insert(6);
		AVL.insert(5);
		AVL.inOrder(AVL.root);
		assertEquals(3, AVL.root.key);
	}
	
	@Test
	void testRank() {
		AVLTree AVL = new AVLTree();
		Random RNG = new Random();
		int size = 1000;
		int[] randArray1 = new int[size];
		int x = 1000;
		int counter = 0;
		for (int i = 0; i < size; i++) {
			int next = RNG.nextInt();
			randArray1[i] = next;
			AVL.insert(next);
			if (next%20 == 0) {
				int j = i/4;
				 while(randArray1[j] <= 1000) {
					 j++;
				 }
				 counter++;
				AVL.delete(randArray1[j]);
			}
		}
		System.out.println(counter);
		Mergesort.mergesort(randArray1, 0, size-1);
		int res = SmallerEqualCounter.smallerEqualThan(x, randArray1);
		assertEquals(res, AVL.rank(x));
	}
}
