package Recursion;

public class ReversePrintString {
    public static void print(int n,String str){
        if(n==str.length()){
            return;
        }
        print(n+1,str);
        System.out.print(str.charAt(n));
    }

    public static void main(String[] args) {
        ReversePrintString.print(0,"abcdef");
    }
}
