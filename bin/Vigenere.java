package esteganografia_mat_discreta;

import java.util.Scanner;

// Versao original:
// https://rosettacode.org/wiki/Vigen%C3%A8re_cipher#Java

public class Vigenere {

	Scanner scanner = new Scanner(System.in);

	public static String encrypt(String text, String key) {
		String res = "";
		text = text.toUpperCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'A' || c > 'Z')
				continue;
			res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}

	public static String decrypt(String text, String key) {
		String res = "";
		text = text.toUpperCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'A' || c > 'Z')
				continue;
			res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}

	public String leituraMensagem(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	public int leituraOpcao(String prompt) {
		System.out.print(prompt);
		int numero = scanner.nextInt();
		scanner.nextLine();
		return numero;
	}
}
