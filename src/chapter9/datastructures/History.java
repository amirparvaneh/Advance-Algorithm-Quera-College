package chapter9.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class History {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack st = new Stack<>();
        int n =in.nextInt();
        int len =0;

        for (int i=0 ; i<n ; i++ )
        {
            String order = in.next();
            //System.out.println(len);
            if ( ! order.equals("undo"))
            {

                String  ind =  in.next();
                int index = (Integer.parseInt(ind) -1) ;

                if ( order.equals("insert"))
                {
                    //String str = (String)st.peek();
                    //System.out.println(str);
                    String s = in.next();
                    len++;

                    if ( st.empty() || st.peek() == null )
                    {
                        st.push(s);
                        len=1;
                    }
                    else
                    {
                        char [] ans = new char [len];
                        char old [] = ((String) st.peek()).toCharArray();

                        for (int  j = (((String) st.peek()).length()-1) ; j >= index ; j-- )
                        {
                            ans[j+1] = old[j];

                        }

                        ans[ index ] = s.charAt(0) ;
                        for (int j=0 ; j < index ; j++ )
                            ans[j] = old[j];

                        String fin = String.valueOf(ans);

                        st.push(fin);
                    }


                }
                else if ( order.equals("delete")){
                    //String str = (String)st.peek();

                    len--;
                    if ( len == 0 )
                        st.push(null);
                    else {

                        char [] ans = new char [len];
                        char old [] = ((String) st.peek()).toCharArray();
                        for (int j = index ; j < ((String) st.peek()).length()-1  ; j++ )
                        {
                            //System.out.println(old[j+1]);
                            ans[j] = old[j+1];
                        }
                        for (int j =0 ; j<index ; j++)
                        {
                            ans [j] = old[j];
                        }

                        st.push(String.valueOf(ans));
                    }

                }
            }
            else if ( order.equals("undo")){
                if ( st.size() == 1 )
                    len =0;
                if ( ! st.empty() )
                    st.pop();
                if ( ! st.empty() && st.peek() != null )
                    len = ((String) st.peek()).length();
                else
                    len=0;
                //System.out.println( "   poped + " + st.pop() ) ;
            }


        }
        //String str = (String)st.peek();
        //System.out.println(str.length());
        if ( ! st.empty() && st.peek() != null )
            System.out.println(st.pop());
        else
            System.out.println( );




    }

}
