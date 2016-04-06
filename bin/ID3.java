package esteganografia_mat_discreta;

import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractFrameBodyTextInformation;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.AbstractID3v2Frame;
import org.farng.mp3.id3.AbstractID3v2FrameBody;
import org.farng.mp3.id3.FrameBodyTMOO;
import org.farng.mp3.id3.ID3v2_4Frame;

public class ID3 {

	private static MP3File mp3file;
	private static AbstractID3v2 tag;
	private static AbstractID3v2Frame frame;
	private static AbstractID3v2FrameBody frameBody;

	public static void main(String[] args) {

		try {
			mp3file = new MP3File("C:\\Users\\Kaio\\Music\\sample.mp3");
			tag = mp3file.getID3v2Tag();

			// adicionaMensagemAoArquivo("eanes_123456");

			System.out.println(tag);

			mp3file.save();
		} catch (IOException | TagException e) {
			e.printStackTrace();
		}
	}

	public static void adicionaMensagemAoArquivo(String mensagem) throws IOException, TagException {

		if (tag.hasFrame("TMOO")) {
			((AbstractFrameBodyTextInformation) (tag.getFrame("TMOO")).getBody()).setText(mensagem);
		} else {
			frame = criaFrame();
			tag.setFrame(frame);
			tag.getFrame("TMOO").setBody(frameBody);
			((FrameBodyTMOO) frame.getBody()).setText(mensagem);
		}
	}

	public static AbstractID3v2Frame criaFrame() {
		frameBody = new FrameBodyTMOO((byte) 0, "");
		return new ID3v2_4Frame(frameBody);
	}

	public String getFrameMensagem() {
		frame = tag.getFrame("TMOO");
		return ((FrameBodyTMOO) frame.getBody()).getText();

	}

}
