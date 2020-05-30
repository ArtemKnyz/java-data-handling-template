package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class SimpleBigNumbersService implements BigNumbersService {

    /**
     * Метод делит первое число на второе с заданной точностью
     * Например 1/3 с точностью 2 = 0.33
     *
     * @param range точность
     * @return результат
     */
    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        return new BigDecimal(a).divide(
                new BigDecimal(b), 2, RoundingMode.HALF_UP);
    }

    /**
     * Метод находит простое число по номеру
     *
     * @param range номер числа, считая с числа 2
     * @return простое число
     */
    @Override
    public BigInteger getPrimaryNumber(int range) {
        int countSimpleValues = 0;
        int simpleCount = 0;

        for (simpleCount = 2; simpleCount < Integer.MAX_VALUE; simpleCount++) {
            for (int j = 2; j < simpleCount; j++) {
                if (simpleCount % j == 0) {
                    break;
                }
                if (simpleCount == j + 1) {
                    countSimpleValues++;
                }
            }
            if (countSimpleValues == range) {
                break;
            }
        }
        return BigInteger.valueOf(simpleCount);
    }
}

