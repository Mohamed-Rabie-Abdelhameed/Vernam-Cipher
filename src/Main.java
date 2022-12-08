import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Plain Text");
        String plainText = input.nextLine();
        String cipherText;
        String[] key = generateKey(plainText.length());
        cipherText = encrypt(plainText,key);
        System.out.println("encrypted " + cipherText);
        System.out.println("decrypted " + encrypt(cipherText, key));
        System.out.println("---------------------------------");
        System.out.println("Binary Plain Text: " + Arrays.toString(toBinary(plainText)));
        System.out.println("Binary Key:        " + Arrays.toString(key));

    }


     private static String[] toBinary(String plainText){
        char[] charArray = plainText.toCharArray();
        String[] binaryChars= new String[plainText.length()];
        for(int i=0; i<charArray.length; i++){
            binaryChars[i] = String.format("%8s",Integer.toBinaryString(charArray[i])).replaceAll(" ", "0");
        }
    return binaryChars;
    }


    private static int findRandom()
    {
        return (1 + (int)(Math.random() * 100)) % 2;
    }


    private static String[] generateKey(int plainTextLength){
        String[] keyBinaryChars = new String[plainTextLength];
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i<plainTextLength; i++){
            temp.setLength(0) ;
            for(int j = 0; j <8; j++){
                int randomBit = findRandom();
                temp.append(randomBit);
            }
            keyBinaryChars[i] = temp.toString();
        }
        return  keyBinaryChars;
    }


    // encrypt method is used for both encrypting and decrypting using the same key
    private static String encrypt(String plainText, String[] key){
        String[] binaryPlainText = toBinary(plainText);
        String[] binaryCipherText = new String[binaryPlainText.length];
        StringBuilder temp = new StringBuilder();
        for(int i =0; i < binaryPlainText.length; i++){
            temp.setLength(0);
            for(int j = 0; j < 8; j++){
                char bit1 = binaryPlainText[i].charAt(j);
                char bit2 = key[i].charAt(j);
                temp.append(bit1 ^ bit2);
            }
            binaryCipherText[i] = temp.toString();
        }
        return binaryToString(binaryCipherText);
    }


    private static  String binaryToString(String[] binary){
        StringBuilder str =new StringBuilder();
        for(String item : binary){
            str.append((char) Integer.parseInt(item, 2));
        }
        return str.toString();
    }
}