package com.example.mutation.mutation.project;

import java.util.Arrays;
import java.util.Scanner;

public class utils {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc= new Scanner((System.in));
    public static String CaesarEncryptData(String inputStr, int shiftKey) {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();
        // encryptStr to store encrypted data
        String encryptStr = "";
        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++) {
            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            // get encrypted char for each char of inputStr
            int encryptPos = (shiftKey + pos) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);
            // add encrypted char to encrypted string
            encryptStr += encryptChar;
        }
        // return encrypted string
        return encryptStr;
    }

    public static String CaesarDecryptData(String inputStr, int shiftKey) {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();
        // decryptStr to store decrypted data
        String decryptStr = "";
        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++) {
            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            // get decrypted char for each char of inputStr
            int decryptPos = (pos - shiftKey) % 26;
            // if decryptPos is negative
            if (decryptPos < 0){
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);
            // add decrypted char to decrypted string
            decryptStr += decryptChar;
        }
        // return decrypted string
        return decryptStr;
    }

    static String GenerateKey(String str, String key) {
        int x = str.length();

        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    // This function returns the encrypted text
// generated with the help of the key
    static String VinegereEncryptData(String str, String key) {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++) {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text
// and returns the original text
    static String VinegereDecryptData(String cipher_text, String key) {
        String orig_text="";

        for (int i = 0 ; i < cipher_text.length() &&
                i < key.length(); i++) {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }

    // This function will convert the lower case character to Upper case
    static String LowerToUpper(String s) {
        StringBuffer str =new StringBuffer(s);
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }
    public static String  SetKey(String k)

    {
        String K_adjust = new String();
        boolean flag = false;
        K_adjust = K_adjust + k.charAt(0);
        for (int i = 1; i < k.length(); i++) {
            for (int j = 0; j < K_adjust.length(); j++) {
                if (k.charAt(i) == K_adjust.charAt(j)) {
                    flag = true;
                }
            }
            if (flag == false)
                K_adjust = K_adjust + k.charAt(i);
            flag = false;
        }
        //KeyWord = K_adjust;
        return K_adjust;
    }


    public static String KeyGen(String KeyWord){
        boolean flag = true;
        char current;
        String Key = KeyWord;
        for (int i = 0; i < 26; i++) {
            current = (char) (i + 97);
            if (current == 'j')
                continue;
            for (int j = 0; j < KeyWord.length(); j++) {
                if (current == KeyWord.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                Key = Key + current;
            flag = true;
        }

        System.out.println(Key);
        Matrix(Key);
        return Key;
    }


    private static char[][] Matrix(String Key) {
        int counter = 0;
        char   matrix_arr[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix_arr[i][j] = Key.charAt(counter);
                System.out.print(matrix_arr[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
        return matrix_arr;
    }


    private static String Format(String old_text) {
        int i = 0;
        int len = 0;
        String text = new String();
        len = old_text.length();
        for (int tmp = 0; tmp < len; tmp++) {
            if (old_text.charAt(tmp) == 'j') {
                text = text + 'i';
            } else
                text = text + old_text.charAt(tmp);
        }

        len = text.length();
        for (i = 0; i < len; i = i + 2) {
            if (text.charAt(i + 1) == text.charAt(i)) {
                text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
            }
        }
        return text;
    }


    private static String[] Divid2Pairs(String new_string) {
        String Original = Format(new_string);
        int size = Original.length();
        if (size % 2 != 0) {
            size++;
            Original = Original + 'x';
        }

        String x[] = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++) {
            x[i] = Original.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return x;

    }


    public static int[] GetDiminsions(char letter,char matrix_arr[][]) {
        int[] key = new int[2];
        if (letter == 'j')
            letter = 'i';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix_arr[i][j] == letter) {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }
    //parses an input string to remove numbers, punctuation,
    public static String PlayfairEncryptData (String Source,String key)
    {
        String src_arr[] = Divid2Pairs(Source);
        String Code = new String();
        char one;
        char two;
        int part1[] = new int[2];
        int part2[] = new int[2];

        char   matrix_arr[][] = Matrix(SetKey(KeyGen(key)));
        for (int i = 0; i < src_arr.length; i++) {
            one = src_arr[i].charAt(0);
            two = src_arr[i].charAt(1);
            part1 = GetDiminsions(one,matrix_arr);
            part2 = GetDiminsions(two,matrix_arr);

            if (part1[0] == part2[0]) {
                if (part1[1] < 4)
                    part1[1]++;
                else
                    part1[1] = 0;
                if (part2[1] < 4)
                    part2[1]++;
                else
                    part2[1] = 0;
            } else if (part1[1] == part2[1]) {
                if (part1[0] < 4)
                    part1[0]++;
                else
                    part1[0] = 0;
                if (part2[0] < 4)
                    part2[0]++;
                else
                    part2[0] = 0;
            } else {
                int temp = part1[1];
                part1[1] = part2[1];
                part2[1] = temp;
            }

            Code = Code + matrix_arr[part1[0]][part1[1]]
                    + matrix_arr[part2[0]][part2[1]];
        }
        return Code;

    }

    public static String PlayfairDecryptData(String Code,String key) {

        String Original = new String();
        String src_arr[] = Divid2Pairs(Code);
        char one;
        char two;
        int part1[] = new int[2];
        int part2[] = new int[2];
        char   matrix_arr[][] = Matrix(SetKey(KeyGen(key)));
        for (int i = 0; i < src_arr.length; i++) {

            one = src_arr[i].charAt(0);
            two = src_arr[i].charAt(1);
            part1 = GetDiminsions(one,matrix_arr);
            part2 = GetDiminsions(two,matrix_arr);

            if (part1[0] == part2[0]) {
                if (part1[1] > 0)
                    part1[1]--;
                else
                    part1[1] = 4;
                if (part2[1] > 0)
                    part2[1]--;
                else
                    part2[1] = 4;
            } else if (part1[1] == part2[1]) {
                if (part1[0] > 0)
                    part1[0]--;
                else
                    part1[0] = 4;
                if (part2[0] > 0)
                    part2[0]--;
                else
                    part2[0] = 4;
            } else {
                int temp = part1[1];
                part1[1] = part2[1];
                part2[1] = temp;
            }
            Original = Original + matrix_arr[part1[0]][part1[1]]
                    + matrix_arr[part2[0]][part2[1]];

        }
        return Original;

    }
    public static String RailfenceEncryptData(String text,
                                              int key)
    {
        // create the matrix to cipher plain text
        // key = rows , length(text) = columns
        char[][] rail = new char[key][text.length()];

        // filling the rail matrix to distinguish filled
        // spaces from blank ones
        for (int i = 0; i < key; i++)
            Arrays.fill(rail[i], '\n');

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            // check the direction of flow
            // reverse the direction if we've just
            // filled the top or bottom rail
            if (row == 0 || row == key - 1)
                dirDown = !dirDown;

            // fill the corresponding alphabet
            rail[row][col++] = text.charAt(i);

            // find the next row using direction flag
            if (dirDown)
                row++;
            else
                row--;
        }

        // now we can construct the cipher using the rail
        // matrix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                if (rail[i][j] != '\n')
                    result.append(rail[i][j]);

        return result.toString();
    }

    // This function receives cipher-text and key
    // and returns the original text after decryption
    public static String RailfenceDecryptData(String cipher,
                                              int key) {

        // create the matrix to cipher plain text
        // key = rows , length(text) = columns
        char[][] rail = new char[key][cipher.length()];

        // filling the rail matrix to distinguish filled
        // spaces from blank ones
        for (int i = 0; i < key; i++)
            Arrays.fill(rail[i], '\n');

        // to find the direction
        boolean dirDown = true;

        int row = 0, col = 0;

        // mark the places with '*'
        for (int i = 0; i < cipher.length(); i++) {
            // check the direction of flow
            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            // place the marker
            rail[row][col++] = '*';

            // find the next row using direction flag
            if (dirDown)
                row++;
            else
                row--;
        }

        // now we can construct the fill the rail matrix
        int index = 0;
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                if (rail[i][j] == '*'
                        && index < cipher.length())
                    rail[i][j] = cipher.charAt(index++);

        StringBuilder result = new StringBuilder();

        row = 0;
        col = 0;
        for (int i = 0; i < cipher.length(); i++) {
            // check the direction of flow
            if (row == 0)
                dirDown = true;
            if (row == key - 1)
                dirDown = false;

            // place the marker
            if (rail[row][col] != '*')
                result.append(rail[row][col++]);

            // find the next row using direction flag
            if (dirDown)
                row++;
            else
                row--;
        }
        return result.toString();
    }
    public static String VernamEncryptData(String text,
                                           String key) {

        // Initializing cipherText
        String cipherText = "";

        // Initialize cipher array of key length
        // which stores the sum of corresponding no.'s
        // of plainText and key.
        int cipher[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'A'
                    + key.charAt(i)
                    - 'A';
        }

        // If the sum is greater than 25
        // subtract 26 from it
        // and store that resulting value
        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }

        // Converting the no.'s into integers
        // Convert these integers to corresponding
        // characters and add them up to cipherText
        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'A';
            cipherText += (char)x;
        }
        // Returning the cipherText
        return cipherText;
    }

    public static String VernamDecryptData(String s,
                                           String key) {
        // Initializing plain text
        String plainText = "";

        // Initializing integer array of key length
        // which stores difference
        // of corresponding no.'s of
        // each character of cipherText and key
        int plain[] = new int[key.length()];

        // Running for loop for each character
        // subtracting and storing in the array
        for (int i = 0; i < key.length(); i++) {
            plain[i]
                    = s.charAt(i) - 'A'
                    - (key.charAt(i) - 'A');
        }
        // If the difference is less than 0
        // add 26 and store it in the array.
        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
        }
        // Converting int to corresponding char
        // add them up to plainText
        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'A';
            plainText += (char)x;
        }
        // Returning plainText
        return plainText;
    }
}
