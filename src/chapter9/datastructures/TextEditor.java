package chapter9.datastructures;

import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int head =0 , len=0 ;
        char a [] = new char [n];
        for (int i=0 ; i<n ; i++)
        {
            String str = in.next();
            if ( n== 9 )
            {
                System.out.println("ahh");
                return;
            }
            if ( str.equals("-"))
                head--;
            else if ( str.equals("+"))
                head++;
            if (str.equals("insert"))
            {
                String s = in.next();
                for (int j = len -1  ; j >= head ; j--)
                {
                    a[j+1] = a[j];
                }
                head++;
                len++;
                a[head-1] = s.charAt(0);
            }
        }
        for (int i=0 ; i<len ; i++)
            System.out.print(a[i]);
    }
}