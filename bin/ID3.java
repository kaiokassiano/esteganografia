package esteganografia_mat_discreta;

import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractFrameBodyTextInformation;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.AbstractID3v2Frame;
import org.farng.mp3.id3.AbstractID3v2FrameBody;
import org.farng.mp3.id3.FrameBodyTYER;
import org.farng.mp3.id3.ID3v2_4Frame;

public class ID3 {

	private MP3File mp3file;
	private AbstractID3v2 tag;
	private AbstractID3v2Frame frame;
	private AbstractID3v2FrameBody frameBody;

	public ID3() throws IOException, TagException {

		mp3file = new MP3File("C:\\Users\\Kaio\\Music\\sample.mp3");
		tag = mp3file.getID3v2Tag();
	}

	public void adicionaMensagemAoArquivo(String mensagem) throws IOException, TagException {

		if (tag.hasFrame("TYER")) {
			System.out.println(tag);
			((AbstractFrameBodyTextInformation) (tag.getFrame("TYER")).getBody()).setText(mensagem);
			System.out.println(tag);
		} else {
			frame = criaFrame();
			tag.setFrame(frame);
			tag.getFrame("TYER").setBody(frameBody);
			((FrameBodyTYER) frame.getBody()).setText(mensagem);
		}
		this.mp3file.save();
	}

	public AbstractID3v2Frame criaFrame() {
		frameBody = new FrameBodyTYER((byte) 0, "");
		return new ID3v2_4Frame(frameBody);
	}

	public String getFrameMensagem() {
		frame = tag.getFrame("TYER");
		return ((FrameBodyTYER) frame.getBody()).getText();

	}
}
