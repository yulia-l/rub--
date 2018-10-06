package ru.geekbrains.amor;

public class SearchSymbols {

    public SearchSymbols() {    }

    public int[] searchSymbols(char[] str1, char[] askWords) {
        int[] counts = new int[askWords.length];

        for (int i = 0; i < str1.length; i++) {
            for (int o = 0; o < askWords.length; o++) {
                if (str1[i] == askWords[o]) {
                    counts[o] = counts[o] + 1;
                }
            }
        }
       /* System.out.println("Найдены искомые символы:");
        for (int i = 0; i < askWords.length; i++) {
            System.out.print(askWords[i] + " - ");
            System.out.println(counts[i]);
        }*/
        return counts;


    /*public int[] searchSymbols(String str, char[] askWords) {

        //public Saver searchSymbols(Saver s)

        /*MyInput go = new MyInput();         //пыталась дать этому классу ссылку на класс, где вводятся переменные
        go.Scan();   */                      // str и askWords, которых ему не хватает в Main

        /*char[] words = str.toCharArray();
        int[] counts = new int[askWords.length];

        for (int i = 0; i < words.length; i++) {
            for (int o = 0; o < askWords.length; o++) {
                if (words[i] == askWords[o]) {
                    counts[o] = counts[o] + 1;
                }
            }
        }*/


    }
}
