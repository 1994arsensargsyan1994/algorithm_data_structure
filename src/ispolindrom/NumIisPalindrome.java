package ispolindrom;

public class NumIisPalindrome {
    public static void main(String[] args) {
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x >= 1 && x <=9) return true;
        int res = 0;
        int input = x;
        while(input != 0){
            res = res * 10 + input % 10;
            input = input / 10;
        }
        return res == x;
    }
}
