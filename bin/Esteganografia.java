package esteganografia_mat_discreta;

import java.io.IOException;

import org.farng.mp3.TagException;

public class Esteganografia {

	private static Vigenere vigenere;
	private static ID3 id3;

	public static void main(String[] args) throws IOException, TagException {

		id3 = new ID3();
		vigenere = new Vigenere();

		int opcao = vigenere.leituraOpcao("O que deseja fazer?\n1- Encriptar\n2- Decriptar\nOpcao: ");

		switch (opcao) {

		case 1:

			try {
				String mensagemOriginal = vigenere.leituraMensagem("\nDigite a mensagem a ser ocultada: ");
				String encriptar = Vigenere.encrypt(mensagemOriginal);
				id3.adicionaMensagemAoArquivo(encriptar);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;

		case 2:

			String decriptar = id3.getFrameMensagem();
			System.out.println("\n" + Vigenere.decrypt(decriptar));
			break;
		}
	}
}
