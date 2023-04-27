import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(first());
        second();
        third();
        fourth();
    }

    //Задание 1:
    //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float)
    // и возвращает введенное значение.
    // Ввод текста вместо числа не должно приводить к падению приложения,
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.
    public static float first() {

        boolean check = true;
        while (check) {
            System.out.println("Введите дробное число: ");
            Scanner scan = new Scanner(System.in);
            try {
                float count = scan.nextFloat();
                return count;

            } catch (RuntimeException e) {
                System.out.println("Ошибка ввода. Попробуйте еще раз.");
            }
        }
        return 0;
    }


    //Задание 2:
    //Исправление ошибок в коде.

    public static void second() {
        double[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }


    //Задание 3:
    //Исправление ошибок в коде.
    public static void third() {

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    //Задание 4:
    //Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    //Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    public static void fourth() throws RuntimeException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите что нибудь:");
        String str = scan.nextLine();
        if (str.length() < 1) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        } else {
            if (str.equals(" "))
                System.out.println("Вы ввели пробел, интересно...");
            else System.out.println(str);
        }
    }
}