public class ArraySorter
{
    
    /**
     * Swaps two integers in an array list to sort. Repeats until no more swaps were made in one pass.
     */
    public int[] bubbleSort(int[] array)
    {
        int n = array.length;
        int temp;
        
        boolean sorted = false;
        
        while(!sorted){ //Check if swaps were made; if none, then done
        	sorted = true;
        	
            for(int i = 0; i < n - 1; i++){
            	
                if(array[i] > array[i+1]){
                	sorted = false;
                	
                	//Swap
                    temp = array[i+1]; 
                    array[i+1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
    
    
    /**
     * Finds a minimum element and puts it at the beginning.
     * Beginning point advances until the end is reached.
     */
    public int[] selectionSort(int[] array){
        int n = array.length;
        int temp;
        
        //Outer loop; advances start point
        for(int i = 0; i < n; i++){
            int minIndex = i;
            
            //Inner loop; finds minimum element
            for(int j = i; j < n; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            
            //Puts minimum element at the start
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
    
    
    /**
     * Swaps and continues to swap two integers until a sublist is sorted.
     * It is sorted when the sublist is the whole list.
     */
    public int[] insertionSort(int[] array){
        int n = array.length;
        int key;
        
        for(int i = 0; i < n; i++){
        	key = array[i];
        	int j = i - 1;
        	
        	//Swaps j until either it reaches the start or is sorted
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

        return array;
    }
    
    
    /**
     * Splits and splits an array into numerous other ones, sorting those
     * and then combining them.
     */
    public int[] mergeSort (int[] array) {
    	int n = array.length;
    	
    	//Once array is broken enough, return to combination (or if array started w/ just 1 element)
    	if(n < 2) {
    		return array;
    	}
    	
    	//Break array into halves
    	int[] left = new int[n/2];
    	for(int i = 0; i < left.length; i++) {
    		left[i] = array[i];
    	}
    	
    	int[] right = new int[n - n/2];
    	for(int i = 0; i < right.length; i++) {
    		right[i] = array[i + n/2];
    	}
    	
    	//Continue to break halves into more halves
    	mergeSort(left);
    	mergeSort(right);
    	
    	//Sort and combine
    	actuallyMerge(array, left, right);
    	return array;
    }

    
	private void actuallyMerge(int[] output, int[] left, int[] right) {
		int l = 0;
		int r = 0;
		int i = 0;
		
		//Combine two halves into an output array
		while(l < left.length && r < right.length) {
			if(left[l] <= right[r]) {
				output[i++] = left[l++];
			}
			else {
				output[i++] = right[r++];
			}
		}
		for(; l < left.length;) {
			output[i++] = left[l++];
		}
		for(; r < right.length;) {
			output[i++] = right[r++];
		}
	}
    
	
	/**
	 * An improved insertion sort. Sorts the subsets of the set.
	 * Reference: https://www.baeldung.com/java-shell-sort
	 */
	public int[] shellSort (int[] array) {
		int n = array.length;
		
		//Halve the interval every time.
		for(int interval = n/2; interval > 0; interval /= 2) {
			
			//Insertion Sort
			for(int i = interval; i < n; i++) {
				int key = array[i];
				int j = i;
				
				//Swaps j until either it reaches the start of the subset or is sorted
				while(j >= interval && array[j - interval] > key) {
					array[j] = array[j - interval];
					j -= interval;
				}
				array[j] = key;
			}
			
		}
		
		return array;
	}
	
	
	/**
	 * Sorts an array using divide-and-conquer.
	 */
	public int[] quickSort (int[] array) {
		//Quick overload to set up recursion
		return quickSort(array, 0, array.length - 1);
	}
	private int[] quickSort(int[] array, int start, int end) {
		if(start < end) {
			int splitIndex = partition(array, start, end);
			
			//Separately and recursively sort each partition
			quickSort(array, start, splitIndex - 1);
			quickSort(array, splitIndex + 1, end);
		}
		return array;
	}
	private int partition(int[] array, int start, int end) {
		//Choosing the end to be the pivot
		int pivot = array[end]; 
		//Index of where pivot will go when done
		int pivotSpot = start - 1;
		
		for(int i = start; i < end; i++) {
			if(array[i] < pivot) {
				pivotSpot++;
				
				int temp = array[pivotSpot];
				array[pivotSpot] = array[i];
				array[i] = temp;
			}
		}
		
		//Move pivot
		int temp = array[pivotSpot + 1];
		array[pivotSpot + 1] = array[end];
		array[end] = temp;
		
		return pivotSpot + 1;
	}
	
	/**
	 * Sorts an array by translating it into a MaxHeap.
	 * The root gets popped to the end of the array.
	 * The heap is reorganized, and so on and so forth until the heap is empty.
	 */
	public int[] heapSort (int[] array) {
		int n = array.length;
		
		//Builds the heap (rearranges the array)
		for(int i = n/2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}
		
		//Pretend to pop from the heap each pass
		for(int i = n - 1; i > 0; i--) {
			//Put root at the end
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			/*re*/heapify(array, i, 0);
		}
		
		return array;
	}
	private void heapify(int[] array, int size, int i) {
		int largest = i; //Root
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		//Find largest
		if (left < size && array[left] > array[largest]) {
			largest = left;
		}
		if (right < size && array[right] > array[largest]) {
			largest = right;
		}
		
		//Relocate largest
		if(largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			//Organize rest of tree
			heapify(array, size, largest);
		}
		
	}
	
	/**
	 * Sorts an array by... checking it over and over until a miracle happens.
	 */
	public int[] miracleSort(int[] array) {
		while(!validate(array)) {
			//pray();
		}
		return array;
	}
	
	/**
	 * Verifies whether or not an array is sorted.
	 */
	public boolean validate(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
}
