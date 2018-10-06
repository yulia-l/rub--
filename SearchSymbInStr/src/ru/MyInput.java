package ru.geekbrains.amor;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyInput {
    //public void Scan() { }

    String str = new String();
    String strAskWord = new String();

    public Saver scan() {
        //char[][] mas = new char[str1.length][askWords.length];
        //String[][] mas = new String[str1.length][askWords.length]{{str}{askWords}};

        System.out.println("Введите исходный текст:");
        Scanner read = new Scanner(System.in);
        str = read.nextLine();
        char[] str1 = str.toCharArray();
        System.out.println("Введите искомые символы (через запятую или пробел):");
        strAskWord = read.nextLine();

        //Pattern forAskWord = Pattern.compile("[^, ]*\\S*");
        //Matcher askWordBeforeTest = forAskWord.matcher(strAskWord);

        SearchSymbols searchSymbols = new SearchSymbols();
        char[] zap = {,};
        String[] aW = new String[str1.length];
        char[] a = strAskWord.toCharArray();                    //массив из введенной строки искомых
        int[] f = searchSymbols.searchSymbols(zap, a);          //метод ищет , в массиве из введенной строки
            if (f[0] != 0) {                                //если в массиве f есть хоть 1 запятая
                aW = strAskWord.split(",");
            } else {                                        //если в массиве f нет ни 1 запятой
                aW = strAskWord.split(" ");
            }
        char[] askWords = new char[aW.length];

        //String[] arr = {"мама", "мыла", "раму"};
        //char[] arr2 = new char[arr.length];         //создаем массив для копии предидущего

        for (int i = 0; i < aW.length; i++) {
                askWords[i] = aW[i].charAt(0);
        }
        //char[] askWords = strAskWord.toCharArray();

            Saver saver = new Saver(str1, askWords);

            return saver;

        }
    }

