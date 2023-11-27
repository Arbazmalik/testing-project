package com.example.mutation.mutation.project;

import org.junit.jupiter.api.Test;

import static com.example.mutation.mutation.project.utils.*;
import static com.example.mutation.mutation.project.utils.RailfenceDecryptData;
import static org.junit.jupiter.api.Assertions.*;

class utilsTest {
    @Test
    void caesarEncryptData() {
        String actualEncryptedStr1 = CaesarEncryptData("hello", 3);
        assertEquals("khoor", actualEncryptedStr1);

        String actualEncryptedStr2 = CaesarEncryptData("aloha", 2);
        assertEquals("cnqjc", actualEncryptedStr2);

        String actualEncryptedStr3 = CaesarEncryptData("maybe", 5);
        assertEquals("rfdgj", actualEncryptedStr3);

        String actualEncryptedStr4 = CaesarEncryptData("attack", 21);
        assertEquals("voovxf", actualEncryptedStr4);


    }

    @Test
    void caesarDecryptData() {
        String actualEncryptedStr1 = CaesarDecryptData("khoor", 3);
        assertEquals("hello", actualEncryptedStr1);

        String actualEncryptedStr2 = CaesarDecryptData("cnqjc", 2);
        assertEquals("aloha", actualEncryptedStr2);

        String actualEncryptedStr3 = CaesarDecryptData("rfdgj", 5);
        assertEquals("maybe", actualEncryptedStr3);

        String actualEncryptedStr4 = CaesarDecryptData("voovxf", 21);
        assertEquals("attack", actualEncryptedStr4);

    }


    @Test
    void vernamEncryptData() {
        String result = VernamEncryptData("HELLO","MONEY");
        assertEquals("TSYPM", result);

        String result_one = VernamEncryptData("TOMORROW","SANDWICH");
        assertEquals("LOZRNZQD", result_one);

        String result_two = VernamEncryptData("HOLD","LOCK");
        assertEquals("SCNN", result_two);

        String result_three = VernamEncryptData("ALERT","WATCH");
        assertEquals("WLXTA", result_three);

    }

    @Test
    void vernamDecryptData() {
        String result = VernamDecryptData("TSYPM","MONEY");
        assertEquals("HELLO", result);

        String result_one = VernamDecryptData("LOZRNZQD","SANDWICH");
        assertEquals("TOMORROW", result_one);

        String result_two = VernamDecryptData("SCNN","LOCK");
        assertEquals("HOLD", result_two);

        String result_three = VernamDecryptData("WLXTA","WATCH");
        assertEquals("ALERT", result_three);

    }


    @Test
    void vinegereEncryptData() {
        String key= GenerateKey("ALOHAANDHELLO","LOCK");
        String result = VinegereEncryptData("ALOHAANDHELLO",key);
        assertEquals("LZQRLOPNSSNVZ", result);

        String key_one= GenerateKey("YESTERDAY","LOCK");
        String result_one = VinegereEncryptData("YESTERDAY",key_one);
        assertEquals("JSUDPFFKJ", result_one);

        String key_two= GenerateKey("WELCOME","CODE");
        String result_two = VinegereEncryptData("WELCOME",key_two);
        assertEquals("YSOGQAH", result_two);

        String key_three= GenerateKey("CASTLE","INVADE");
        String result_three = VinegereEncryptData("CASTLE",key_three);
        assertEquals("KNNTOI", result_three);


    }

    @Test
    void vinegereDecryptData() {
        String key= GenerateKey("LZQRLOPNSSNVZ","LOCK");
        String result = VinegereDecryptData("LZQRLOPNSSNVZ",key);
        assertEquals("ALOHAANDHELLO", result);

        String key_one= GenerateKey("JSUDPFFKJ","LOCK");
        String result_one = VinegereDecryptData("JSUDPFFKJ",key_one);
        assertEquals("YESTERDAY", result_one);

        String key_two= GenerateKey("YSOGQAH","CODE");
        String result_two = VinegereDecryptData("YSOGQAH",key_two);
        assertEquals("WELCOME", result_two);

        String key_three= GenerateKey("KNNTOI","INVADE");
        String result_three = VinegereDecryptData("KNNTOI",key_three);
        assertEquals("CASTLE", result_three);


    }

    @Test
    void playfairEncryptData() {
//        SetKey("diamond");
        String result = PlayfairEncryptData("birmingham","diamond");
        assertEquals("hbtidbhkmo", result);

        String result_one = PlayfairEncryptData("mountain","rain");
        assertEquals("ohtbqnnb", result_one);

        String result_two = PlayfairEncryptData("tresspassing","lock");
        assertEquals("usmxumcurmpf", result_two);

        String result_three = PlayfairEncryptData("tresspassing","encode");
        assertEquals("uscqulfqqlob", result_three);

    }

    @Test
    void playfairDecryptData() {
//        SetKey("diamond");
        String result = PlayfairDecryptData("hbtidbhkmo","diamond");
        assertEquals("birmingham", result);

        String result_one = PlayfairDecryptData("ohtbqnnb","rain");
        assertEquals("mountain", result_one);

        String result_two = PlayfairDecryptData("usmxumcurmpf","lock");
        assertEquals("tresspassing", result_two);

        String result_three = PlayfairDecryptData("uscqulfqqlob","encode");
        assertEquals("tresspassing", result_three);

    }

    @Test
    void railfenceEncryptData() {
        String result = RailfenceEncryptData("attack at once",3);
        assertEquals("actctaka net o",result);

        String result_one = RailfenceEncryptData("roger that",4);
        assertEquals("rto hgraet",result_one);

        String result_two = RailfenceEncryptData("Feel the magic in the air",12);
        assertEquals("Fae ieerlh tt hnei  mcaig",result_two);

        String result_three = RailfenceEncryptData("Enemy down",7);
        assertEquals("Enemnyw od",result_three);


    }

    @Test
    void railfenceDecryptData() {
        String result = RailfenceDecryptData("actctaka net o",3);
        assertEquals("attack at once",result);

        String result_one = RailfenceDecryptData("rto hgraet",4);
        assertEquals("roger that",result_one);

        String result_two = RailfenceDecryptData("Fae ieerlh tt hnei  mcaig",12);
        assertEquals("Feel the magic in the air",result_two);

        String result_three = RailfenceDecryptData("Enemnyw od",7);
        assertEquals("Enemy down",result_three);
    }

    @Test
    void lowerToUpper() {
        String result = LowerToUpper("Axel");
        assertEquals("AXEL",result);

        String result_one = LowerToUpper("comebackAgain");
        assertEquals("COMEBACKAGAIN",result_one);

        String result_two = LowerToUpper("");
        assertEquals("",result_two);

        String result_three = LowerToUpper("TEST");
        assertEquals("TEST",result_three);

    }

    @Test
    void keyGen() {
        String keyWord = "example";
        String expectedKey = "examplebcdfghiknoqrstuvwyz";

        // Call the KeyGen method
        String actualKey = KeyGen(keyWord);

        // Assert that the generated key matches the expected key
        assertEquals(expectedKey, actualKey);

        String keyWord_one = "checkmate";
        String expectedKey_one = "checkmatebdfgilnopqrsuvwxyz";

        // Call the KeyGen method
        String actualKey_one = KeyGen(keyWord_one);

        // Assert that the generated key matches the expected key
        assertEquals(expectedKey_one, actualKey_one);
    }


}