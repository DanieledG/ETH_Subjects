package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import dynamicProgramming.*;
import org.junit.jupiter.api.Test;

class DPTest {

	@Test
	void LATtest() {
		int[] array = {3, 2, 4, 6, 5, 7, 1};
		int[] lat = LAT.lat(array); 
		int[] solution = {2, 4, 5, 7};
		assertArrayEquals(solution, lat);		
	}
	
//	@Test
//	void LATtest2() {
//		int[] array = {4, 2 ,5, 7, 5, 8, 6};
//		int[] lat = LAT.lat(array); 
//		int[] solution = {2, 5, 7, 8};
//		assertEquals(4, lat.length);
//		assertArrayEquals(solution, lat);
//	}
	@Test
	void DoubleTest() {
		int[] A = {4, 9, 3, 2, 8, 10, 12, 3, 9, 11, 12};
		int[] B = {2, 4, 3, 8, 20, 14, 10, 9, 7, 11};
		int[] LATsol = {2, 3, 9, 11, 12};
		int[] LGTsol = {4, 3, 8, 10, 9, 11};
		int[] Acopy = A.clone();
		int[] LATres = LAT.lat(A);
		int[] LGTres = LGT.lgt(Acopy, B);
		assertArrayEquals(LATsol, LATres);
		assertArrayEquals(LGTsol, LGTres);
	}
	
	@Test
	void LGTTest() {
		int[] A = {1, 5, 12, 4, 8, 10, 11, 23, 59};
		int[] B = {1, 4, 10, 11, 12, 8};
		int[] solution = {1, 4, 10, 11};
		int[] res = LGT.lgt(A, B);
		assertArrayEquals(solution, res);
	}
	
	@Test
	void minEditDTest() {
		String a = "Ziege";
		String b = "Tiger";
		int sol = 3;
		int res = MinEditingDistance.minED(a, b);
		assertEquals(sol, res);
		a = "ciaomammaguardacomemidiverto";
		b = "amodonaldtrump";

		MinEditingDistance.minED(a, b);
	}

	@Test
	void matrixTest() {
		int[][] matrices = new int[2][6];
		matrices[0][0] = 30; matrices[1][0] = 35;
		matrices[0][1] = 35; matrices[1][1] = 15;
		matrices[0][2] = 15; matrices[1][2] = 5;
		matrices[0][3] = 5;	 matrices[1][3] = 10;
		matrices[0][4] = 10; matrices[1][4] = 20;
		matrices[0][5] = 20; matrices[1][5] = 25;

		int sol = 15125;
		int res = MatrixChain.multiplication(matrices);
		assertEquals(sol, res);
	}
	
	@Test
	void matrixTest2() {
		int[][] matrices = new int[2][6];
		matrices[0][0] = 6; matrices[1][0] = 4;
		matrices[0][1] = 4; matrices[1][1] = 5;
		matrices[0][2] = 5; matrices[1][2] = 3;
		matrices[0][3] = 3; matrices[1][3] = 8;
		matrices[0][4] = 8; matrices[1][4] = 2;
		matrices[0][5] = 2; matrices[1][5] = 7;

		int sol = 250;
		int res = MatrixChain.multiplication(matrices);
		assertEquals(sol, res);
	}
	
	@Test
	void subsetSumTest(){
		int[] numbers = {7, 10, 13, 15, 18, 21, 24};
		int sum = 43;
		boolean[] solution = {false, true, false, true, true, false, false};
		boolean[] result = SubsetSum.subset(numbers, sum);
		assertArrayEquals(solution, result);
	}
	
	@Test
	void knapsackTest() {
		int[][] items = {{1, 5, 3, 4}, {15, 10, 9, 5}};
		int weight = 8;
		boolean[] sol = {true, false, true, true};
		boolean[] res = Knapsack.knapsack(items, weight);
		assertArrayEquals(sol, res);
	}
	
	@Test
	void failTest(){
		int[][] items = null;
		boolean error = false;
		try {
			Knapsack.knapsack(items, 0);
		}
		catch(AssertionError e){
			error = true;
		}
		assertTrue(error);
	}
}
