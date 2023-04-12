package Homework.Homework01Extra;

import java.util.ArrayList;
import java.util.List;

public class Homework01 {
    public static void main(String[] args) {
        // Using Array
        int[] inputArray = new int[]{1, 1, 1, 1};
        int[] resultArray = sequenceArray(inputArray, 9);
//        System.out.println(Arrays.toString(sequenceArray(inputArray, 5)));
        countsArray(resultArray, 5, 7);

        // Using List
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(1);
        inputList.add(1);
        inputList.add(1);
        List<Integer> resultList = sequenceList(inputList, 9);
//        System.out.println(sequenceList(inputList, 5));
        countsList(resultList, 5, 7);

        Tree tree = new Tree();
        tree.fill(9);


    }
    // Array method
    private static int[] sequenceArray(int[] array, int row) {
        int[] result = new int[array.length * 2];
        for (int i = 2; i <= row; i++) {
            for (int j = 0; j < array.length; j++) {
                int k = j * 2;
                result[k] = array[j];
                result[k + 1] = array[j] + 1;
            }
            array = result;
            if(i != row) {
                result = new int[array.length * 2];
            }
        }
        return result;
    }

    //Array method results
    private static void countsArray(int[] array, int value1, int value2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value1) {
                count1++;
            } else if (array[i] == value2) {
                count2++;
            }
        }
        System.out.printf("\nNumber %d appears %d times;\nNumber %d appears %d times.", value1, count1, value2, count2);
    }

    // List method

    private static List<Integer> sequenceList(List<Integer> input, int row) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 2; i <= row; i++) {
            for (int j = 0; j < input.size(); j++) {
                temp.add(input.get(j));
//                System.out.println(input.get(j));
                temp.add(input.get(j) + 1);
//                System.out.println(input.get(j) + 1);
            }
            if(i == row) {
                resultList = temp;
            } else {
                input = temp;
                temp = new ArrayList<>();
            }
        }
        return resultList;
    }

    private static void countsList(List<Integer> list, int value1, int value2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == value1) {
                count1++;
            } else if (list.get(i) == value2) {
                count2++;
            }
        }
        System.out.printf("\nNumber %d appears %d times;\nNumber %d appears %d times.", value1, count1, value2, count2);
    }

}
