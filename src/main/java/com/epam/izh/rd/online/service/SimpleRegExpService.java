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

        try {
            FileReader fileFromResources = new FileReader(new File(getClass()
                    .getClassLoader()
                    .getResource("sensitive_data.txt")
                    .getFile()));

            String stringFromFile = new BufferedReader(fileFromResources).readLine();
            fileFromResources.close();
            return stringFromFile.replaceAll("(\\d+ )(\\d+\\s\\d+)( \\d+)", "$1**** ****$3");

        } catch (Exception ex) {
            System.out.println("error");
            return null;
        }

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
