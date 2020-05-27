package com.epam.izh.rd.online.repository;

import java.io.File;
import java.util.Arrays;

public class SimpleFileRepository implements FileRepository {
    long countFiles;
    long countDirectories = 1;

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {
        File[] listFilesAndDirectories = new File(path).listFiles();
        try {
            if (!Arrays.asList(listFilesAndDirectories).isEmpty()) {
                for (File entry : listFilesAndDirectories) {
                    if (entry.isFile()) {
                        countFiles++;
                    } else countFilesInDirectory(path + "//"
                            + entry.getName());
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return countFiles;
    }


    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {

        File[] listFilesAndDirectories = new File(path).listFiles();
        try {
            for (File entry : listFilesAndDirectories) {
                if (entry.isDirectory()) {
                    countDirectories++;
                    countDirsInDirectory(path + "//" + entry.getName());
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            System.out.println("введите корректный путь к директории");
        }
        return countDirectories;
    }


    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        return;
    }

    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    @Override
    public boolean createFile(String path, String name) {
        return false;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        return null;
    }
}
