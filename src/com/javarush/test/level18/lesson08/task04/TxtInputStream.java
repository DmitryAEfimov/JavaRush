package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    private String fileName;
    private static final String EXTENSION = "txt";

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);
        this.fileName = fileName;
        if (!checkExtension(EXTENSION)) {
            throw new UnsupportedFileNameException();
        }
    }

    private boolean checkExtension(String extension) {
        return fileName.substring(fileName.lastIndexOf(".")+1).equalsIgnoreCase(extension);
    }

}

