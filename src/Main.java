import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//Не забудьте закрыть соединение с файлом.
//
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
public class Main {
    public static void main(String[] args) throws IOException {
        String[] data = enter();
        parsing(data);
        saveFilee(data);

    }

    public static String[] enter() throws IOException {
        System.out.println("Введите в произвольном порядке, через пробел, данные: " +
                "ФИО, пол(М или Ж), дата рождения и номер телефона\n" +
                "Пример: Иванов Иван Иванович М 01.01.1001 71234567890");
        Scanner scan = new Scanner(System.in);
        String info = scan.nextLine();
        String[] data = info.split(" ");
        if (data.length > 6) {
            throw new IOException("Введено больше данных, чем нужно");
        }
        if (data.length < 6) {
            throw new IOException("Введено меньше данных чем нужно");
        }
        return data;
    }


    public static void parsing(String[] data) throws IOException {
        String birthday = null, gender = null;
        Long number = null;

        List<String> allNames = new ArrayList<>();
        for (String i : data) {
            if (i.contains(".")) {
                birthday = i;
            } else if (i.equals("М") || i.equals("Ж")) {
                gender = i;
            } else if (i.matches("\\d+")) {
                number = Long.parseLong(i);
            } else {
                allNames.add(i);
            }
        }

//      Проверка на корректность ввода.
        if (birthday == null) {
            throw new IOException("Не верно введена дата рождения.\n" +
                    "Вводите следующим форматом: dd.mm.yyyy");
        }
        if (number == null) {
            throw new IOException("Не верно введен номер телефона.\n" +
                    "Вводите только цифры");
        }
        if (gender == null) {
            throw new IOException("Не верно введен пол.\n" +
                    "Вводите одной буквой 'М' или 'Ж'");
        }

//      Сортировка пузырьком ФИО по длине (фамилия должная быть короче отчества и длиньше имени);
        String fname = allNames.get(0);
        String lname = allNames.get(1);
        String fathername = allNames.get(2);
        String tempName;
        if (fname.length() > fathername.length()) {
            tempName = fathername;
            fathername = fname;
            fname = tempName;
        }
        if (fname.length() > lname.length()) {
            tempName = lname;
            lname = fname;
            fname = tempName;
        }
        if (lname.length() > fathername.length()) {
            tempName = fathername;
            fathername = lname;
            lname = tempName;
        }

//      Заполнение отсортированных данных
        for (int i = 0; i < data.length; i++) {
            switch (i) {
                case 0:
                    data[i] = lname;
                    break;
                case 1:
                    data[i] = fname;
                    break;
                case 2:
                    data[i] = fathername;
                    break;
                case 3:
                    data[i] = birthday;
                    break;
                case 4:
                    data[i] = number.toString();
                    break;
                case 5:
                    data[i] = gender;
                    break;
                default:
                    break;
            }
        }
    }

    public static void saveFilee(String[] data) {
        String filename = data[0];
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (String i : data) {
                writer.append("<" + i + ">");
            }
            writer.append("\n");
        } catch (RuntimeException | IOException e) {
            System.out.println(e);
        }

    }
}