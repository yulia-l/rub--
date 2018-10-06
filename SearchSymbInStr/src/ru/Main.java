package ru.geekbrains.amor;

import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        /*String str;
        String strAskWord;

        System.out.println("Введите исходный текст:");
        Scanner read = new Scanner(System.in);
        str = read.nextLine();
        System.out.println("Введите искомые символы:");
        strAskWord = read.nextLine();

        char[] askWords = strAskWord.toCharArray();*/

       MyInput go = new MyInput();          //создаем объект, который будет ссылкой на класс MyInput

       Saver s = go.scan();

        SearchSymbols obj = new SearchSymbols();

        int[] counts = obj.searchSymbols(s.str1, s.askWords);           //вызов метода searchSymbols и cвойств объекта s

        System.out.println("Найдены искомые символы:");
        for (int i = 0; i < s.askWords.length; i++) {
            System.out.print(s.askWords[i] + " - ");
            System.out.println(counts[i]);
        }

    }
}



        /*выводит по очереди символы как проходит по циклу
        String a = ("abc");
        char[] b = a.toCharArray();                     //превращает строку в массив
        for (int i = 0; i < b.length; i++) {
            System.out.println(i);
        }*/

//String str = "Мама мыла раму";
//char[] askWords = {'м'};

/*программа ищет соответствия с заданным символом и считает их кол-во
        /*String str = ("шла саша по шоссе");
        char[] words = str.toCharArray();            //превращает строку в массив
        char letter = 'ш';                           //даем значение искомому эл-ту массива
        int count = 0;                               //переменная для подсчета соответствий
        for (int i = 0; i < words.length; i++) {    //или for(char symbol:s.toCharArray()) проходит по массиву
            if (words[i] == letter) {               //тогда if(symbol==letter)
                count++;
                //System.out.println("Кол-во соответствий: " + count);          не сюда!
            }
        }
        System.out.println("Кол-во соответствий: " + count);
        }*/

/*сравнение имволов в одном массиве с символами в другом
        String str = ("шла саша по шоссе");
        String str1 = ("мама мыла раму");
        char[] words = str.toCharArray();
        char[] askWords = str1.toCharArray();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int o = 0; o < askWords.length; o++) {
                if (words[i] == askWords[o]) {
                    count++;
                }
            }
        }
        if (count > 0){
            System.out.println("Соответствие есть");
        }
        else {
            System.out.println("Нет соответствий");
        }
        //System.out.println("Кол-во соответствий: " + count);
    }*/

/*выводим символ и сколько раз он встречается в строке
        String str = ("шла саша по шоссе");
        char[] words = str.toCharArray();
        //char[] askWords = str1.toCharArray();
        char[] askWords = {'м', 'а', ' ', 'ы', 'л', 'р', 'у'};
        int count = 0;
        int[] counts = new int[askWords.length];
        for (int i = 0; i < words.length; i++) {
            for (int o = 0; o < askWords.length; o++) {
                if (words[i] == askWords[o]) {
                    count++;
                    counts[o] = counts[o] + 1;
                    //summ += int[] nums
                }
            }
        }
        for (int i = 0; i < askWords.length; i++) {
            System.out.print(askWords[i] + " - ");
            System.out.println(counts[i]);
        }*/

            //System.out.println(Arrays.toString(askWords));
//System.out.println(Arrays.toString(counts)); // [...]
//System.out.println(str.length()); //выводит кол-во эл-в в массиве
//public static int binarySearch(String[]words, String[]askWords);

        /*String str = ("шла,саша,по,шоссе");
        String[] words = str.split(",");            //разделяет массив на строки по указанному знаку regex
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }*/






