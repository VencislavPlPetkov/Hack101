package week01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arr {

	public static String toString(int[] a) {

		String str = "";
		for (int i = 0; i <= a.length - 1; i++) {
			if (i != a.length - 1) {
				str += a[i] + ",";
				// System.out.println(sb);
			} else {
				str += a[i];
			}
		}
		return str;
	}

	public static void sort(int[] ar) {
		for (int i = 1; i < ar.length; i++) {
			int index = ar[i];
			int j = i;

			while (j > 0 && ar[j - 1] > index) {
				ar[j] = ar[j - 1];
				j--;
			}
			ar[j] = index;

		}

		/*
		 * for(int i=0; i<arr.length; i++){ for(int j=0; j<arr.length; j++){
		 * if(arr[i].compareTo(arr[j]) < 0){ T temp = arr[i]; arr[i] = arr[j];
		 * arr[j] = temp; } } } return arr;
		 */
	}

	public static int[] reverse(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = temp;
		}
		return arr;
	}

	public static String join(int[] a, String glue) {
		String str = "";
		for (int i = 0; i <= a.length - 1; i++) {
			if (i != a.length - 1) {
				str += a[i] + glue;
			} else {
				str += a[i];
			}
		}
		return str;
	}

	public static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return sum;
	}

	public static int[] range(int a, int b) {

		List<Integer> myList = new ArrayList<Integer>();
		for (int i = a; i < b; i++) {
			myList.add(i);

		}

		int[] arr = myList.stream().mapToInt(i -> i).toArray();

		return arr;
		/*
		 * int step = (from<to?1:-1); Integer[] arr = new
		 * Integer[Math.abs(from-to)]; int index = 0; for(int i=from; i!=to;
		 * i+=step) { arr[index] = i; index++; } return arr;
		 */
	}

	public static int[] filterOdd(int[] a) {

		int numberOfOdds = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				numberOfOdds++;
			}
		}
		int result[] = new int[numberOfOdds];
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				result[count] = a[i];
				count++;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int[] a = { 10, 20, -50, 80, 70, 66, -365 };

		System.out.println("Print the array to string:");
		System.out.println(ArrDraft.toString(a));

		System.out.println("Sort the array itself and print it sorted:");
		ArrDraft.sort(a);
		System.out.println(ArrDraft.toString(a));

		System.out.println("Print the reverse of the sorted array");
		ArrDraft.reverse(a);
		System.out.println(ArrDraft.toString(a));

		System.out.println("Output each element in a with -> between them");
		System.out.println(ArrDraft.join(a, "->"));

		System.out.println("Output the sum");
		System.out.println(ArrDraft.sum(a));

		System.out.println("Output array with elements from 1 to 10");
		System.out.println(ArrDraft.toString(ArrDraft.range(1, 10)));

		System.out.println("Print only the odd numbers");
		int[] temp = ArrDraft.filterOdd(a);
		System.out.println(ArrDraft.toString(temp));
	}

}
