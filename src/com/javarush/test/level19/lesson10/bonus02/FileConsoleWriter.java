package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException {
        char[] cbuf = {(char) c};
        this.write(cbuf, 0, 1);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        this.write(new String(cbuf), 0, cbuf.length);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.write(new String(cbuf), off, len);
    }

    @Override
    public void write(String str) throws IOException {
        this.write(str, 0, str.length());
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        System.out.print(str.substring(off, off+len));
    }
}
