//Time Complexity : O(n^2)
//Space Complexity : O(1)
class LongestPalindromicSubstring {
    int start;
    int end;
    public String longestPalindrome(String s) {
        int n = s.length();
        this.start = 0;
        this.end = 0;
        for(int i = 0; i < n; i++) {
            extendsAround(s,i,i);//checking for odd length longest palindromic substring
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                extendsAround(s,i,i+1); //checking for even length longest palindromic substring
            }
        }
        return s.substring(start, end+1);
    }

    private void extendsAround(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if(right-left > end-start) {
            start = left;
            end = right;
        }
    }
}
//DP Approach
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i-j <= 1 || dp[i-1][j+1]) {
                        dp[i][j] = true;
                        if(end-start < i-j) {
                            start = j;
                            end = i;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, end+1);
    }
}