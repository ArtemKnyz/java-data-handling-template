package com.epam.izh.rd.online.repository;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        File[] listFilesAndDirectories = new File[0];
        try {
            listFilesAndDirectories = new File(getClass()
                    .getResource("/" + path).toURI()).listFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
        File[] listFilesAndDirectories = new File[0];
        try {
            listFilesAndDirectories = (new File(getClass()
                    .getResource("/" + path).toURI())).listFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
        if(from==null||to==null){
            System.out.println("Parametrs of method is null ");
            return;
        }
        try {
            File fromDir = new File((new File(getClass()
                    .getResource("/" + from)
                    .toURI()))
                    .getPath());
            File toDir = new File((new File(getClass()
                    .getResource("/" + to)
                    .toURI()))
                    .getPath());
            File[] listTxtFiles = fromDir.listFiles((dir, name) -> name.endsWith("txt"));
            if (listTxtFiles.length == 0) {
                return;
            }
            for (File file : listTxtFiles) {
                Files.copy(Paths.get(file.getPath())
                        , Paths.get(toDir.getPath()
                                , file.getName()));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("some");
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
        try {
            File sourceDir = new File((new File(getClass()
                    .getResource("/")
                    .toURI()))
                    .getPath());
            File newDir = new File(sourceDir + "/" + path);
            if (!newDir.exists()) {
                newDir.mkdir();
            }
            Files.createFile(Paths.get(newDir + "/" + name));
        } catch (IOException e) {
            System.out.println("Error creating file");
            return false;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        String contentFromFile = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getClass()
                .getResource("/" + fileName).toURI())))) {
            contentFromFile = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File[] listFilesAndDirectories = new File[0];
        try {
            listFilesAndDirectories = (new File(getClass()
                    .getResource("/" + fileName).toURI())).listFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contentFromFile;
    }
}