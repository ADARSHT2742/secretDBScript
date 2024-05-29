package com.example.demo.Utilities;

public class Main {
	public static void main(String[] args) {
		try {
			// Create an instance of StringEncryptorDecryptor
			StringEncryptorDecryptor encryptorDecryptor = new StringEncryptorDecryptor();

			// Message to be encrypted
			String originalMessage = "Hello, this is a secret message.";

			// Encrypt the message
			String encryptedMessage = encryptorDecryptor.encrypt(originalMessage);
			System.out.println("Encrypted message: " + encryptedMessage);

			// Decrypt the message
			String decryptedMessage = encryptorDecryptor.decrypt(encryptedMessage);
			System.out.println("Decrypted message: " + decryptedMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
