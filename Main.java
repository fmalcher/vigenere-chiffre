import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String[] alphabets = {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            // "0123456789"
        };

        String text = "Hall5o Welt! wie g3eht e%s dir mir gehts gut";
        String key = "Katze063gzufgjlsdknf";

        Chiffre c = new Chiffre(alphabets);
        String result = c.encode(text, key);
        
        System.out.println(result);
    }

}