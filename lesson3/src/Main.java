import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные через пробел в формате 'Фамилия Имя Отчество номер телефона': ");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 4) {
            System.err.println("Неверное количество данных");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String phoneNumberStr = data[3];

        try {
            int phoneNumber = parsePhoneNumber(phoneNumberStr);
            String output = lastName + " " + firstName + " " + middleName + " " + phoneNumberStr;

            writeFile(lastName, output);

            System.out.println("Данные успешно записаны в файл");
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    private static int parsePhoneNumber(String phoneNumberStr) {
        return Integer.parseInt(phoneNumberStr);
    }

    private static void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}