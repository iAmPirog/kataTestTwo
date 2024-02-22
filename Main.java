import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scann = new Scanner(System.in);
        String str1 = scann.nextLine();
        char mAction;
        String[] strs;
        if (str1.contains(" + ")) {
            strs = str1.split(" \\+ ");
            mAction = '+';
        } else if (str1.contains(" - ")) {
            strs = str1.split(" - ");
            mAction = '-';
        } else if (str1.contains(" * ")) {
            strs = str1.split(" \\* ");
            mAction = '*';
        } else if (str1.contains(" / ")) {
            strs = str1.split(" / ");
            mAction = '/';
        }else{
            throw new Exception("не верный знак действия");
        }
        if (mAction == '*' || mAction == '/') {
            if (strs[1].contains("\"")) throw new Exception("Делить или умножать можно только числа");
        }
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].replace("\"", ""); 
        }

        if (mAction == '+') {
            printInQuotes(strs[0] + strs[1]);
        } else if (mAction == '*') {
            int inter = Integer.parseInt(strs[1]);
            String result = "";
            for (int i = 0; i < inter; i++) {
                result+=strs[0];
            }
            printInQuotes(result);
        } else if (mAction == '-') {
            int index = strs[0].indexOf(strs[1]);
            if(index == -1){
                printInQuotes(strs[0]);
            }else{
                String result = strs[0].substring(0, index);
                result+=strs[0].substring(index+strs[1].length());
                printInQuotes(result);
            }
        }else{
            int newStr = strs[0].length()/Integer.parseInt(strs[1]);
            String result = strs[0].substring(0,newStr);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
}













