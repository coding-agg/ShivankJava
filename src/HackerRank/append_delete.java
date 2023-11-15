package HackerRank;

public class append_delete {
    public static void main(String[] args) {
        String hello = appendAndDelete("aba","aba",7);
        System.out.println(hello);
    }
    public static String appendAndDelete(String s, String t, int k) {
        int ans = 0;
        if(s.length() > t.length()){
            ans = s.length() - t.length();
            s = s.substring(0,t.length());
        }
        if(k == 0 && s.equals(t)){
            return "Yes";
        }
        while(k>ans){
            if(s.length() == 0 && k-ans>=t.length()){
                return "Yes";
            }
            if(s.equals(t) && k-ans>=(2*s.length())){
                return "Yes";
            }
            if(s.equals(t.substring(0,s.length())) && s.length() != t.length()){
                s = s+t.charAt(s.length());
            }
            else{
                s = s.substring(0,s.length()-1);
            }
            ans++;
        }
        if(k == ans && s.equals(t)){
            System.out.println(ans);
            System.out.println(s);
            System.out.println(t);
            return "Yes";
        }
        System.out.println(ans);
        System.out.println(s);
        System.out.println(t);
        return "No";
    }
}
