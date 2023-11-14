package chapter4.reverseAlgorithm;

import java.util.*;
public class GreyCode {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        generateGrayarr(n);
    }

    static ArrayList<String> generateGray(int n)
    {
        if (n <= 0)
        {
            ArrayList<String> temp =
                    new ArrayList<String>(){{add("0");}};
            return temp;
        }
        if(n == 1)
        {
            ArrayList<String> temp =
                    new ArrayList<String>(){{add("0");add("1");}};
            return temp;
        }
        ArrayList<String> recAns = generateGray(n - 1);
        ArrayList<String> mainAns = new ArrayList<String>();
        for(int i = 0; i < recAns.size(); i++)
        {
            String s = recAns.get(i);
            mainAns.add("0" + s);

        }

        for(int i = recAns.size() - 1; i >= 0; i--)
        {
            String s = recAns.get(i);
            mainAns.add("1" + s);
        }
        return mainAns;
    }
    static void generateGrayarr(int n)
    {
        ArrayList<String> arr = new ArrayList<String>();
        arr = generateGray(n);
        for (int i = 0 ; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
    }

}