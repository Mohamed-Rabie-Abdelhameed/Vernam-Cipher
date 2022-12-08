import java.util.Arrays;

public class test{
    public static void main(String[] args) {
        String p = "hello ahmed";
        String k = generateKey(p.length());
        StringBuilder bP = new StringBuilder();
        StringBuilder bK = new StringBuilder();
        for(int i =0; i<p.length(); i++){
            bP.append(String.format("%8s",Integer.toBinaryString(p.charAt(i))).replaceAll(" ", "0"));
            bK.append(String.format("%8s",Integer.toBinaryString(k.charAt(i))).replaceAll(" ", "0"));   
        }
        System.out.println(bP.toString());
        System.out.println(bK.toString());
        for(int j = 0; j<bP.length(); j++){
            System.out.print(bP.charAt(j) ^ bK.charAt(j));

        }
    }
    private static int findRandom()
    {
        return (1 + (int)(Math.random() * 100)) % 2;
    }


    private static String generateKey(int plainTextLength){
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
        return  Arrays.toString(keyBinaryChars);
    }
}

