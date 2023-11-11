package chapter2.timeanalysis;

import java.util.Scanner;

public class Triangles3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        long len = Integer.parseInt(first.trim().split(" ")[0].trim());
        long response = 0;
        if(len%3==0)
            response = 1;
        for(long largest=(len-1)/2 ; largest>len/3 ; largest--) {
            long others = (len - largest) ;
            long invalids = Math.max(0, others-largest-1);
            response += others/2 - invalids;
        }
        System.out.println(response);
    }
}