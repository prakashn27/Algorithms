import java.io.*;
/*
program to find the repetition of letters in string

@author: mr.prakashnatarajan@gmail.com
*/
class RepetitionInString
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String test = "abcda";
        int checker = 0;
        for(int i = 0; i < test.length(); i++) {
            int val = test.charAt(i) - 'a';     //get the reference bit wrt 'a'
            if((checker & (1 << val)) > 0)      //compares for repetition by multiplying with checker
                System.out.println("TRUE");
            checker |= (1<<val);        //everytime we are adding that with checker
        }
    }
}
