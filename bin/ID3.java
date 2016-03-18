package esteganografia_mat_discreta;

import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.AbstractID3v2Frame;
import org.farng.mp3.id3.AbstractID3v2FrameBody;
import org.farng.mp3.id3.FrameBodyTENC;
import org.farng.mp3.id3.FrameBodyTYER;
import org.farng.mp3.id3.ID3v2_3;
import org.farng.mp3.id3.ID3v2_4Frame;

public class ID3 {

	private static MP3File mp3file;
	private static AbstractID3v2Frame frame;
	private static AbstractID3v2FrameBody frameBody;
	private static AbstractID3v2 tag;
	private static AbstractID3v2Frame codificadoPor;

	public void adicionaMensagemAoArquivo(String mensagem) throws IOException, TagException {
		mp3file = new MP3File(
				"D:\\Pastas PC\\Músicas\\Death\\(1998) Death - The Sound Of Perseverance\\03 - Spirit Crusher.mp3");
		tag = (ID3v2_3) mp3file.getID3v2Tag();
		codificadoPor = tag.getFrame("TENC");
		((FrameBodyTENC) codificadoPor.getBody()).setText(mensagem);
	}

	public static void main(String[] args) throws IOException, TagException {
		// mp3file = new MP3File("C:\\Users\\Kaio\\Music\\sample.mp3");
		// tag = (ID3v2_3) mp3file.getID3v2Tag();
		// codificadoPor = tag.getFrame("TENC");
		// if (codificadoPor == null) {
		// corpoFrame = new FrameBodyTENC((byte) (8859 - 1), " ");
		// codificadoPor = new ID3v2_4Frame(corpoFrame);
		// ((FrameBodyTENC) codificadoPor.getBody()).setText("WAT");
		// System.out.println(codificadoPor);
		// } else {
		// ((FrameBodyTENC) codificadoPor.getBody()).setText("WAT");
		// System.out.println(codificadoPor);
		// }

		mp3file = new MP3File(
				"D:\\Pastas PC\\Músicas\\Death\\(1998) Death - The Sound Of Perseverance\\03 - Spirit Crusher.mp3");
		tag = mp3file.getID3v2Tag();

		frameBody = new FrameBodyTYER((byte) 0, "MERDA");
		frame = new ID3v2_4Frame(frameBody);

		if (tag.hasFrame("TYER")) {
			tag.getFrame("TYER").setBody(frameBody);
		} else {
			tag.setFrame(frame);
			tag.getFrame("TYER").setBody(frameBody);
		}
		mp3file.save();
	}
}
