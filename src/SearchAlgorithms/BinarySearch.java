package SearchAlgorithms;

import java.util.Arrays;

/**
 * Created by anton on 2017-04-10.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {45, 32, 128, 42, 9, 83, 52, 96, 1, 75, 152, 16, 222, 12, 9};
        int[] sortedData = sort(data);
        int toFind = 9;
        int found = search(sortedData, toFind);
        for(int a : sortedData) {
            System.out.print(a + ", ");
        }
        System.out.println("");
        if(found == -1) System.out.println("Could not find data");
        else System.out.printf("%d Found at index: %d", toFind, found);
    }

    private static int[] sort(int[] data) {
        int lowestindex;
        for(int i = 0; i < data.length; i++) {
            lowestindex = i;
            for(int j = i; j < data.length; j++) {
                if(data[j] < data[lowestindex]) {
                    lowestindex = j;
                }
            }
            swap(data, lowestindex, i);
        }
        return data;
    }

    private static int search(int[] data, int toFind) {
        if(data.length == 0) return -1;
        int middle = data.length/2;
        if(toFind == data[middle]) return middle;
        if(data.length == 2) {
            if(toFind == data[middle-1]) return middle-1;
        }
        if(toFind < data[middle]) return search(newArray(data, 0, middle), toFind);
        else return middle+search(newArray(data, middle, data.length), toFind);
    }

    private static int[] newArray(int[] data, int min, int max) {
        int length = max-min;
        int[] array = new int[length];
        for(int i = min; i < max; i++) {
            array[i-min] = data[i];
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
