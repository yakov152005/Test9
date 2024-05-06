import java.util.Scanner;
public class Answers {
    public static void main(String[] args) {

    }
    //---------------------------------------------------------------------
    public static void Ex1(){
        int[] arr1 = {6,9,7,8,12,12,10,7,7,9,11};
        int max1 = 5;
        boolean res1 = isProximityArray(arr1,max1);

        int[] arr2 = {5,8,11,7,12,9,10,13,16,12,8,18,10};
        int max2 = 7;
        boolean res2 = isProximityArray(arr2,max2);

        printArr(arr1);
        System.out.println(res1);
        printArr(arr2);
        System.out.println(res2);

        int[] arr3 = {5,8,11,7,12,9,10,13,16,12,8,18,10};
        int max3 = 5;
        System.out.println(isProximityArray(arr3,max3));
        int[] newArr = findMaxDifferenceTriple(arr3,max3);
        for(int index : newArr){
            System.out.print(index +" ");
        }

    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }
    //o(n)
    public static boolean isProximityArray(int[] array, int max){
        boolean res = true;
        int num1,num2,num3;
        for (int i = 0; i < array.length - 2; i++) {
            num1 = array[i];
            num2 = array[i+1];
            num3 = array[i+2];
            if (num1 - num2 > max || num1 - num3 > max ||
                    num2 - num3 > max || num2 - num1 > max
            || num3 - num2 > max || num3 - num1 > max){
                res = false;
                break;
            }
        }
        return res;
    }
    public static int highestDiff(int n1,int n2,int n3){
        int highestDiff = n1 - n2;
        if (n1 - n3 > highestDiff){
            highestDiff = n1-n3;
        }
        if (n2 - n1  > highestDiff) {
            highestDiff = n2 - n1;
        }
        if (n2 - n3 > highestDiff){
            highestDiff = n2 - n1;
        }
        if (n3 - n1 > highestDiff){
            highestDiff = n3 - n1;
        }
        if (n3 - n2 > highestDiff){
            highestDiff = n3 - n2;
        }
        return highestDiff;
    }
    //o(n)
    public static int[] findMaxDifferenceTriple(int[] arr, int max) {
        int[] newArr = new int[3];
        if (!isProximityArray(arr, max)) {
            int num1, num2, num3;
            int tempHighestDiff = 0;
            int highestDiff = 0;
            for (int i = 0; i < arr.length - 2; i++) {
                num1 = arr[i];
                num2 = arr[i + 1];
                num3 = arr[i + 2];
                tempHighestDiff = highestDiff(num1, num2, num3);
                if (tempHighestDiff > highestDiff){
                    highestDiff = tempHighestDiff;
                }
            }
            int currentHighestDiff = 0;
            for (int i = 0; i < arr.length - 2; i++) {
                num1 = arr[i];
                num2 = arr[i + 1];
                num3 = arr[i + 2];
                currentHighestDiff = highestDiff(num1, num2, num3);
                if (currentHighestDiff == highestDiff) {
                    newArr[0] = num1;
                    newArr[1] = num2;
                    newArr[2] = num3;
                    break;
                }
            }
        }
        return newArr;
    }
    //---------------------------------------------------------------------
    public static void Ex2(){
        String[] strings = {"Green","blue","red","Yellow","purple","pink","White"};
        char ch = getMostPopularInitialChar(strings);
        System.out.println(ch);
    }
    //o(n^2)
    public static char getMostPopularInitialChar(String[] strings){
        String str = "";
        char ch = ' ';
        int countForMostPopular = 0;
        int highestCount = 0;
        for (int i = 0; i < strings.length; i++) {
            str = strings[i].charAt(0)+"";
            for (int j = 0; j < strings.length; j++) {
                if (str.equalsIgnoreCase(strings[j].charAt(0) + "")) {
                    countForMostPopular++;
                }

                if (countForMostPopular > highestCount) {
                    highestCount = countForMostPopular;
                    ch = str.charAt(0);

                }
            }
            countForMostPopular = 0;
        }

        return ch;
    }
    //---------------------------------------------------------------------
    public static void Ex4(){
        int[] arr1 = {0,19,22,41,4};
        int[] arr2 = {4,41,22,19,0};
       boolean res = arraysAreReversed(arr1,arr2);
        System.out.println("The arrays are reversed? " + res);

    }
    public static int[] reversArr(int[] arr){
        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = arr.length -1 ; i > 0 ; i--) {
            temp[index++] = arr[i];
        }
        temp[temp.length - 1] = arr[0];
        return temp;
    }
    //o(n)
    public static boolean arraysAreReversed(int[] arr1,int[] arr2){
        int[] reversArr = reversArr(arr1);
        boolean res = true;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != reversArr[i]){
                res = false;
                break;
            }
        }
        return res;
    }
    //---------------------------------------------------------------------
    public static void Ex5(){
        boolean res = false;
        final int FOR_EXIT = 0;
        int number,max = 0 ,min = 30000000, avg = 0, countNumbers = 0, sum = 0;
        while (!res){
            System.out.println("Enter a number: ");
            number = s.nextInt();
            if (number % 10 == FOR_EXIT){
                res = true;
            }else {
                if (number > max){
                    max = number;
                }
                if (number < min){
                    min = number;
                }
                sum += number;
                countNumbers++;
            }
        }
        if (countNumbers == 0){
            countNumbers = 1;
            min = 0;
        }
        avg = (sum / countNumbers);
        System.out.println("|RESULT|--->");
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);
    }
    //---------------------------------------------------------------------
    public static void Ex6(){
        int[] arr = {4,7,1,4,7,1,4,7,1,4,7,1};
        int x = 4;
        boolean res = isXCopyArray(arr,x);
        System.out.println("Is copy X array? " + res);
    }
    public static boolean isXCopyArray(int[] arr, int x){
        boolean res = true;
        int temp = arr.length / x;
        return res;
    }

    public static Scanner s = new Scanner(System.in);
}
