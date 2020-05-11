package com.epam.izh.rd.online.service;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        File file = new File("F:\\Programmirovanie\\Java\\Examples\\Epam4\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String st = br.readLine();
           System.out.println(st);


            int i;
            //Pattern pattern1 = Pattern.compile("\\d{4}-^\\d{4}-^\\d{4}-\\d{4}");
            Pattern pattern1 = Pattern.compile("\\D+[\\d+\\s]{20}\\D+[\\d+\\s]{20}\\D+");
            Pattern pattern = Pattern.compile("[0-9]+");

            //String rep = "\\d\\d\\d\\d\\s\\d\\d\\d\\d";
            String rep = "[^\\d+{4}\\s\\d+{4}\\s\\d+{4}\\s^\\d+{4}\\s]";
            String star = "**** ****";
            Pattern pat = Pattern.compile(rep);
            Matcher mat = pat.matcher(st);
            System.out.println(mat.replaceAll(star));

            //Matcher matcher = pattern.matcher(st);
            Matcher matcher = pattern1.matcher(st);


            System.out.println("hello world");


            if (matcher.find()) {
                System.out.println(matcher.group());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        return null;
    }
}
