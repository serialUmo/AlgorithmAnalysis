import java.util.Random;

public class AlgorithmTester
{
	
	public static int[] generateTest(int length) {
		Random random = new Random();
		int[] test = new int[length];
        for(int i = 0; i < length; i++){
            test[i] = random.nextInt(200000) + 1;
        }
        return test;
	}
	
    public static void main(String[] args){
        ArraySorter sorter = new ArraySorter();
        double timeStart;
        int[] test;

        System.out.println("Correctly functioning algorithms: \n");
        test = generateTest(100);
        System.out.println("Bubble: " + sorter.validate(sorter.bubbleSort(test)));
        test = generateTest(100);
        System.out.println("Selection: " + sorter.validate(sorter.selectionSort(test)));
        test = generateTest(100);
        System.out.println("Insertion: " + sorter.validate(sorter.insertionSort(test)));
        test = generateTest(100);
        System.out.println("Merge: " + sorter.validate(sorter.mergeSort(test)));
        test = generateTest(100);
        System.out.println("Shell: " + sorter.validate(sorter.shellSort(test)));
        test = generateTest(100);
        System.out.println("Quick: " + sorter.validate(sorter.quickSort(test)));
        test = generateTest(100);
        System.out.println("Heap: " + sorter.validate(sorter.heapSort(test)));

        System.out.println("\nBUBBLE SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.bubbleSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nSELECTION SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.selectionSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nINSERTION SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.insertionSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nMERGE SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.mergeSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nSHELL SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.shellSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nQUICK SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.quickSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
        
        System.out.println("\nHEAP SORT ===============");
        for(int count = 1; count <= 20; count++){
            
            System.out.println("Size: " + (10000 * count) + " ----------");
            test = generateTest(10000 * count);
            
            timeStart = System.currentTimeMillis();
            sorter.heapSort(test);
            System.out.println("Time: " + (System.currentTimeMillis() - timeStart) + "ms");
        }
    }
}