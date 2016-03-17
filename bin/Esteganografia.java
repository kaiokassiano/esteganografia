package esteganografia_mat_discreta;

import org.farng.mp3.MP3File;
import org.farng.mp3.id3.AbstractID3v2;

// #LiberaOPushKaio
public class Esteganografia {

	private static Vigenere vigenere;

	public static void main(String[] args) {

		vigenere = new Vigenere();

		int opcao = vigenere.leituraOpcao("O que deseja fazer?\n1- Encriptar\n2- Decriptar\nOpcao: ");

		switch (opcao) {
		case 1:
			String mensagemOriginal = vigenere.leituraMensagem("\nDigite a mensagem a ser ocultada: ");
			String chaveEncriptar = vigenere.leituraMensagem("Digite a chave: ");

			String encriptar = Vigenere.encrypt(mensagemOriginal, chaveEncriptar);
			System.out.println(encriptar);
			break;

		case 2:
			String mensagemEncriptada = vigenere.leituraMensagem("\nDigite a mensagem a ser recuperada: ");
			String chaveDecriptar = vigenere.leituraMensagem("Digite a chave: ");

			String decriptar = Vigenere.decrypt(mensagemEncriptada, chaveDecriptar);
			System.out.println(decriptar);
			break;
		}
	}
}
