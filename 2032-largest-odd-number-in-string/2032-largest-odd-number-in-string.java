class Solution {
    public String largestOddNumber(String num) {
        // traverse from the end of the string/number till find any odd number
        for(int i = num.length()-1; i>=0; i--) {
            if(num.charAt(i)%2==1) 
                return num.substring(0, i+1);
        }
        // if nothing is returned from the whole loop means that given string/number is even hence we have to return empty string
        return "";
    }
}