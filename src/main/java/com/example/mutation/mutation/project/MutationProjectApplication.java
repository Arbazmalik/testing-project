package com.example.mutation.mutation.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static com.example.mutation.mutation.project.utils.*;

@SpringBootApplication
public class MutationProjectApplication {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	static Scanner scanner = new Scanner(System.in);
	static Scanner sc= new Scanner((System.in));

	//------------------------------------------------------------------- Ceaser start

	public static String Caesar() {

		System.out.println("Enter input string ");
		String inputstring = sc.nextLine();
		System.out.println("Enter key ");

		int key = Integer.parseInt(sc.nextLine());

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose an operation:");
		System.out.println("1) Encrypt");
		System.out.println("2) Decrypt");

		String ciphertext,decrypttext;
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("You chose to encrypt.");
				return CaesarEncryptData(inputstring,key);
//				break;

			case 2:
				System.out.println("You chose to decrypt.");
				return CaesarDecryptData(inputstring,key);
//				break;

			default:
				System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
				break;
		}
		scanner.close();
		return "";
	};
	//------------------------------------------------------------------- vinegere start




	public static String Vinegere() {
		System.out.println("Enter input string ");
		String inputstring = sc.nextLine();
		System.out.println("Enter key (string) ");
		String key = sc.nextLine();
		String str = LowerToUpper(inputstring);
		String keyword = GenerateKey(inputstring,LowerToUpper(key));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose an operation:");
		System.out.println("1) Encrypt");
		System.out.println("2) Decrypt");

		String ciphertext, decrypttext;
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("You chose to encrypt.");
				return VinegereEncryptData(inputstring, keyword);
//				break;

			case 2:
				System.out.println("You chose to decrypt.");
				return VinegereDecryptData(inputstring, keyword);
//				break;

			default:
				System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
				break;
		}
		return "";
	}
//-------------------------------------------------------------------------------------playfair starts
//static public String KeyWord        = new String();
//	static public String Key            = new String();
//	static public char   matrix_arr[][] = new char[5][5];


	public static String Playfair() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter keyword");
		String keyword = sc.next();
		//SetKey(keyword);
		//KeyGen();

		System.out
				.println("Enter word to encrypt or decrypt : (Make sure length of message is even)");

		String key_input = sc.next();
		if (key_input.length() % 2 == 1) {
			System.out.println("Message length should be even");
		} else {
			System.out.println("Choose an operation:");
			System.out.println("1) Encrypt");
			System.out.println("2) Decrypt");
			System.out.println("Enter a keyword:");
			String ciphertext, decrypttext;
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("You chose to encrypt.");
					return PlayfairEncryptData(key_input,keyword);
//					break;

				case 2:
					System.out.println("You chose to decrypt.");
					return PlayfairDecryptData(key_input,keyword);
//					break;

				default:
					System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
					break;
			}
		}
		return "";
	}
//------------------------------------------------------------------------- Railfence

	public static String Railfence() {
		System.out.println("Enter input string ");
		String inputstring = sc.nextLine();
		System.out.println("Enter key (integer) ");
		int key= sc.nextInt();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose an operation:");
		System.out.println("1) Encrypt");
		System.out.println("2) Decrypt");

		String ciphertext, decrypttext;
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("You chose to encrypt.");
				return RailfenceEncryptData(inputstring, key);
//				break;

			case 2:
				System.out.println("You chose to decrypt.");
				return RailfenceDecryptData(inputstring, key);
//				break;

			default:
				System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
				break;
		}
		return "";
	}
//------------------------------------------------------------- vernam


public static String Vernam() {
	System.out.println("Enter input string ");
	String inputstring = sc.nextLine();
	System.out.println("Enter key (string) ");
	String key= sc.nextLine();

	Scanner scanner = new Scanner(System.in);
	System.out.println("Choose an operation:");
	System.out.println("1) Encrypt");
	System.out.println("2) Decrypt");

//	String ciphertext, decrypttext;
	int choice = scanner.nextInt();

	switch (choice) {
		case 1:
			System.out.println("You chose to encrypt.");
			return VernamEncryptData(inputstring, key);

		case 2:
			System.out.println("You chose to decrypt.");
			return VernamDecryptData(inputstring, key);

		default:
			System.out.println("Invalid choice. Please enter 1 for encryption or 2 for decryption.");
			break;
	}
	return "";
}

	public static void main(String[] args) {
		SpringApplication.run(MutationProjectApplication.class, args);


		System.out.print("Choose a cipher method:");
		System.out.println("1) Caesar Cipher");
		System.out.println("2) Vigenère Cipher");
		System.out.println("3) Vernam Cipher");
		System.out.println("4) Rail Fence Cipher");
		System.out.println("5) Playfair Cipher");

		int choice = scanner.nextInt();

		switch(choice) {
			case 1:
				System.out.println("You chose Caesar Cipher.");
				System.out.println(Caesar());
				break;
			case 2:
				System.out.println("You chose Vigenère Cipher.");
				System.out.println(Vinegere());
				break;

			case 3:
				System.out.println("You chose Vernam Cipher.");
				System.out.println(Vernam());
				break;

			case 4:
				System.out.println("You chose Rail Fence Cipher.");
				System.out.println(Railfence());
				break;
			case 5:
				System.out.println("You chose Playfair Cipher.");
				System.out.println( Playfair());
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				break;
		}

		scanner.close();
		sc.close();
	}



}
