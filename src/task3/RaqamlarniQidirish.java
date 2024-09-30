package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaqamlarniQidirish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Papka yo'lini kiriting: ");
        String folderPath = scanner.nextLine();
        System.out.print("Fayl nomini kiriting (.txt): ");
        String fileName = scanner.nextLine();
        File file = new File(folderPath, fileName);

        if (file.exists() && !file.isDirectory()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                Pattern pattern = Pattern.compile("\\b\\d{2,}\\b");
                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        System.out.print(matcher.group()+" ");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(fileName + " fayli " + folderPath + " papkasida topilmadi.");
        }
        scanner.close();
    }
}
