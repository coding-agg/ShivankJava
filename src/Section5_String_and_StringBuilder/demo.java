package Section5_String_and_StringBuilder;

public class demo {
    public static void main(String[] args) {
        String str = "Hello" ;
        System.out.println(str);
        String str2 = "hello" ;
        System.out.println(str2);
        int item = 10 ;
        System.out.println(str.charAt(str.length()-1));
        System.out.println(str.substring(4,4)) ;
        System.out.println(str.concat(str2)) ;
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str.indexOf("El"));
        System.out.println(str.startsWith("He"));
        String str3 = new String("Hello") ;
        if(str.equals(str3)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        char a = 'a' ;
        char b = 'b' ;
        int c = a-b ;
        System.out.println(c);

    }
}
