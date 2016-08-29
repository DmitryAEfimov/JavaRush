package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;
import java.util.Calendar;
import java.util.Random;

public class Solution {
    private static final int[] KEY = {0x45, 0x57, 0x21, 0xFA, 0xE3, 0x09, 0x20, 0xD1, 0x26, 0x98,
                                      0x3B, 0x85, 0xA8, 0x23, 0x01, 0xCC, 0xD7, 0x71, 0x67, 0x34,
                                      0x50, 0xE0, 0x11, 0xAA, 0xD1, 0x00, 0x3F, 0x9A, 0xB1, 0x6C,
                                      0x0F, 0xB0, 0xBB, 0x72, 0x80, 0x08, 0x3A, 0x3A, 0xBF, 0x5D,
                                      0x37, 0x80, 0xAA, 0x74, 0x12, 0x10, 0xAD, 0xC6, 0xC2, 0x07,
                                      0x41, 0x3F, 0x18, 0xF0, 0xE7, 0x8B, 0xD9, 0x59, 0xAB, 0x60,
                                      0xDD, 0x7A, 0xE1, 0x66};
    private static final int HEADER_LENGTH = 59;
    private static final int TAIL_LENGTH = 53;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    private static Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
    private static File inFile;
    private static File outFile;
    private static byte[] buffer = new byte[max(HEADER_LENGTH, TAIL_LENGTH)];

    private static int max(int int1, int int2) {
        return int1 > int2 ? int1 : int2;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        try {
            initFiles(args[1], args[2]);
            openStreams();

            switch (args[0]) {
                case "-e":
                    addGabarge(HEADER_LENGTH);
                    encode();
                    addGabarge(TAIL_LENGTH);
                    break;
                case "-d":
                    decode();
                    break;
                default:
                    System.out.println("Wrong key. Use -e for encode or -d for decode");
                    return;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            closeStreams();
        }
    }

    private static void encode() throws IOException {
        long encodeSize = fis.available();
        for (int i = 0; i < encodeSize; i++) {
            int value = fis.read();
            value ^= KEY[i%KEY.length];
            fos.write(value);
        }
    }

    private static void decode() throws IOException {
        fis.skip(HEADER_LENGTH);
        long decodeSize = fis.available() - TAIL_LENGTH;
        for (int i = 0; i < decodeSize; i++) {
            int value = fis.read();
            value ^= KEY[i%KEY.length];
            fos.write(value);
        }
    }

    private static void closeStreams() throws IOException {
        if (fis != null) fis.close();
        if (fos != null) fos.close();
    }

    private static void openStreams() throws IOException {
        fis = new FileInputStream(inFile);
        fos = new FileOutputStream(outFile);
    }

    private static void addGabarge(int length) throws IOException {
        rnd.nextBytes(buffer);
        fos.write(buffer, 0, length);
    }

    private static void initFiles(String fileName, String fileOutputName) throws FileNotFoundException {
        inFile = new File(fileName);
        outFile = new File(fileOutputName);

        if (!inFile.exists()) {
            throw new FileNotFoundException("File " + inFile + " does not exisits.");
        }
    }
}
