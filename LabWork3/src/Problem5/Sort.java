package Problem5;

public class Sort {
	
	static <E> void swap(E [] array, int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static <E extends Comparable<E>> void bubbleSort(E [] array) {
		for (int i = 0; i < array.length; i++) 
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) == 1)
					swap(array, j, j + 1);
			}
	}
	
	static <E extends Comparable<E>> int partition(E[] array, int low, int high){
        E pivot = array[high];
 
        int j = low;
  
        for (int i = low; i < high; i++) {
        	if(array[i].compareTo(pivot) == -1) {
        		swap(array, i, j);
        		j++;
        	}
        }
        swap(array, j, high);
        return j;
    }
  

	static <E extends Comparable<E>> void quickSort(E [] array, int low , int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
		}
	}
	

}
    

	
	
	

