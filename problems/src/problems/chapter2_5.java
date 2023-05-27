package problems;
import java.util.*;
public class chapter2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        rev(arr, n);
        sc.close();
		

	}
	static void rev(int arr[], int n) {
		int[] arr1 = new int[n];
		int j = n - 1;
		for(int i = 0; i < n; i++) {
			arr1[j] = arr[i];
			j = j - 1;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
