import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    public static void main(String[] args) {

        // 1. Bubble Sort
        // int[] arr = {4, 1, 3, 9, 7};
        // bubbleSort(arr);
        // printArr(arr);

        // 2. Search an Element in Sorted and Rotated Array
        // int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        // int res = SearchElementSortedRotatedArray(arr);
        // System.out.println(res);

        // 3. Kadines Algo
        // int[] arr = {1, 2, 3, -2, 5};
        // System.out.println(kadinesAlgo(arr));

        // 4 Two Sum
        // int[] arr = {5,6,4,3,5,6,7,8,8,9,9,2,7,11,15};
        // int[] res = twoSum(arr,9);

        // 5. Set zeroes in matrix
        // System.out.println("------------");
        // for(int n:res)System.out.println(n);

        // int[][] matrix = new int[][] { {0,1,2,0}, { 3,4,5,2}, { 1,3,1,5 } };
        // // int[][] matrix = new int[][] { { 0, 1 } };
        // setZeroes(matrix);

        // var arr = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        // removeDuplicates(arr);

        // int[][] matrix2 = new int[][] { { 1, 5, 7, 9, 10, 11 }, { 6, 10, 12, 13, 20,
        // 21 }, { 9, 25, 29, 30, 32, 41 },
        // { 15, 55, 59, 63, 68, 70 }, { 40, 70, 79, 81, 95, 105 } };

        // int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11,
        // 12 } };
        // System.out.println("input");
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println("");
        // }
        // List<Integer> list = spiralOutput2DArray(matrix);
        // System.out.println("\noutput");
        // for (int n : list)
        // System.out.print(n + " ");

        cs50Mario(5);

    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int ii = 0; ii < i; ii++) {
                if (arr[ii] > arr[ii + 1]) {
                    int temp = arr[ii + 1];
                    arr[ii + 1] = arr[ii];
                    arr[ii] = temp;
                }
            }
        }
        return arr;
    }

    public static int SearchElementSortedRotatedArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void printArr(int[] arr) {
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static int kadinesAlgo(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0, intStart = -1, start = -1, end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > max) {
                max = sum;
                start = intStart;
                end = i;
            }
            if (sum < 0)
                sum = 0;
        }
        return max < 0 ? 0 : max;
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int ii = i; ii < len; ii++) {
                // System.out.println(ii);
                System.out.println("-----");
                System.out.println(nums[ii]);
                System.out.println(nums[ii - i]);
                System.out.println("-----");
                if (nums[ii] + nums[ii - i] == target)
                    return new int[] { ii, ii - i };
            }
        }
        return null;
    }

    public static void setZeroes(int[][] matrix) {

        // input:
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix[i].length; ii++) {
                System.out.print(matrix[i][ii]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        // soln:
        System.out.println("");
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        fr = true;
                    if (j == 0)
                        fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
            System.out.println();
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static int removeDuplicates(int[] nums) {
        int indx = 2;
        for (int i = 2; i < nums.length; i++) {
            System.out.print(i);
            System.out.print(nums[i] != nums[indx - 2]);
            System.out.println(indx);
            if (nums[i] != nums[indx - 2]) {
                nums[indx++] = nums[i];
            }
        }
        return indx;
    }

    public static List<Integer> spiralOutput2DArray(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top += 1;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right -= 1;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom -= 1;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left += 1;

        }
        return res;
    }

    public static void cs50Mario(int height) {
        if (height < 0)
            System.out.println("Invalid height!");
        for (int i = 0; i <= height; i++) {
            for (int j = height; j >= 0; j--) {
                if (j <= i)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.print(" ");
            for (int k = 0; k <= i; k++) {
                System.out.print("#");
            }

            System.out.println();
        }

    }

}
