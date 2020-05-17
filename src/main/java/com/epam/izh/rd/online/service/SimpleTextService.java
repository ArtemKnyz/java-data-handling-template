package com.epam.izh.rd.online.service;

import java.util.regex.Pattern;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     * <p>
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base   - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base
                .replaceAll(remove, "");

    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     * <p>
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        return Pattern.matches(".+\\?", text);
    }

    /**
     * Реализовать функционал соединения переданных строк.
     * <p>
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        StringBuffer concatenateString = new StringBuffer("");
        for (String stringInput : elements) {
            concatenateString.append(stringInput);
        }
        return concatenateString.toString();
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     * <p>
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        StringBuffer stringBuffer = new StringBuffer("");
        boolean UpperCase = false;
        try {
            char[] c = text.toCharArray();
            if (Character.isUpperCase(c[0])) {
                UpperCase = true;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Строчка не должна быть пустой!");
        }
        for (char charFromText : text.toCharArray()) {
            if (UpperCase) {
                stringBuffer = stringBuffer.append(Character.toLowerCase(charFromText));
                UpperCase = false;
            } else {
                stringBuffer = stringBuffer.append(Character.toUpperCase(charFromText));
                UpperCase = true;
            }
        }
        return stringBuffer.toString();
    }


    /**
     * Метод определяет, является ли строка палиндромом.
     * <p>
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     * <p>
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        return false; //TODO
    }
}
