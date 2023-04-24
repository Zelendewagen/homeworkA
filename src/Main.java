//Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//1)ArrayIndexOutOfBoundsException при колличестве строк меньше 5
//2)NumberFormatException если массив содержит не только цифры


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
        first();
        second();
        third();

        int arr[] = {10, 20, 30};
        int arr2[] = {3, 3, 0};
//        System.out.println(Arrays.toString(subtraction(arr, arr2)));

        System.out.println(Arrays.toString(divide(arr,arr2)));
    }

    public static void first() {
        int i = 10 % 0;
    }

    public static void second() {
        int array[] = {1, 2, 3};
        System.out.println(array[4]);
    }

    public static void third() {
        File f = new File("Z://java/file.txt");
        try {
            FileReader fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
    //каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
    //Если длины массивов не равны, необходимо как-то оповестить пользователя.
    public static int[] subtraction(int first[], int second[]) {
        if (first.length != second.length) {
            throw new RuntimeException("Длины массивов не равны!");
        } else {
            int result[] = new int[first.length];
            for (int i = 0; i < first.length; i++) {
                result[i] = first[i] - second[i];
            }
            return result;
        }
    }


    //* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,и возвращающий новый массив,
    //каждый элемент которого равен частному элементов двух входящих массивов ddddddddе.
    //Если длины массивов не равны, необходимо как-то оповестить пользователя.
    //Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
    public static int[]divide(int first[],int second[]){
        if (first.length != second.length) {
            throw new RuntimeException("Длины массивов не равны!");
        } else {
            int result[] = new int[first.length];
            for (int i = 0; i < first.length; i++) {
                if(first[i] == 0 || second[i]==0){
                    throw new RuntimeException("На ноль делить нельзя!");
                }
                result[i] = first[i] / second[i];
            }
            return result;
        }
    }
}