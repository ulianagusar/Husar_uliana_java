package org.example;
import java.util.ArrayList;
import java.util.List;
public class StringCalculator {


    public int add(String numbers ) {
        List<Integer> list = new ArrayList() ;
        int totalAmount = 0;
        char[] Arr = numbers.toCharArray();
        if (Arr.length == 0) {
            System.out.println("0");
            return totalAmount;

        }
        else if (Arr.length == 1){
            try {
                int value = Integer.parseInt(numbers);
                System.out.println(value);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("некоректні дані");
                return -1;
            }

        }
        else {
            String delimiter = "";
            if (Arr[0] == '/' && Arr[1] == '/') {

                numbers = numbers.substring(1);
                numbers = numbers.substring(1);
                delimiter = "";
                for (int i = 2; Arr[i] != '\n'; i++) {
                    numbers = numbers.substring(1);
                    delimiter = delimiter + Arr[i];

                }
            }
            if (Arr.length != 2) {
                if (Arr[2] == '[') {
                    final String[] arrdelimiter = delimiter.split("\\[|\\]\\[|\\]");
                    delimiter = "";
                    for (int i = 1; i < arrdelimiter.length; i++) {
                        String del = arrdelimiter[i];
                        char[] del1 = del.toCharArray();
                        for (int j = 0; j < del1.length; j++) {
                            if (del1[j] == '.' || del1[j] == '[' || del1[j] == ']' || del1[j] == '-' || del1[j] == '^' || del1[j] == '$' || del1[j] == '*' || del1[j] == '"' || del1[j] == '?' || del1[j] == '+' || del1[j] == '|' || del1[j] == '(' || del1[j] == ')' || del1[j] == '{' || del1[j] == '}' || del1[j] == '=') {

                                delimiter = delimiter + "\\" + del1[j];
                            } else {
                                delimiter = delimiter + del1[j];
                            }
                        }
                        delimiter = delimiter + "|";
                    }
                } else {
                    char[] del1 = delimiter.toCharArray();
                    delimiter = "";
                    for (int j = 0; j < del1.length; j++) {
                        if (del1[j] == '.' || del1[j] == '[' || del1[j] == ']' || del1[j] == '-' || del1[j] == '^' || del1[j] == '$' || del1[j] == '*' || del1[j] == '"' || del1[j] == '?' || del1[j] == '+' || del1[j] == '|' || del1[j] == '(' || del1[j] == ')' || del1[j] == '{' || del1[j] == '}' || del1[j] == '=') {

                            delimiter = delimiter + "\\" + del1[j];
                        } else {
                            delimiter = delimiter + del1[j];
                        }
                    }
                    delimiter = delimiter + "|";
                }
                if (Arr[0] != '/' && Arr[1] != '/') {
                    delimiter = "";
                } else {
                    numbers = numbers.substring(1);
                }
            }
            delimiter = delimiter + "," + "|\n";

            final String[] arrSplit = numbers.split(delimiter);
            for (int i = 0; i < arrSplit.length; i++) {
                try {
                int value = Integer.parseInt(arrSplit[i]);
                if (value < 0) {
                    list.add(value);
                }
                if (value <= 1000) {
                    totalAmount += value;
                }
                } catch (NumberFormatException e) {
                                   System.out.println("некоректні дані");
                                   return -1;
                }

            }

            if (list.isEmpty()) {
                System.out.println(totalAmount);
                return totalAmount;
            } else {
                System.out.println("ви ввели від'ємні числа");
                for (int i=0; i< list.size();i++) {
                    System.out.println(list.get(i));
                }
                return -1;
            }

        }
    }
}