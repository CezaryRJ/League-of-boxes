package GUI;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MusicPlayer {
	String file;
	Clip clip;
	File soundFile;

	public MusicPlayer(String file) {
		this.file = file;
		soundFile = new File(file);

	}

	public void play() throws Exception {
		AudioInputStream audioInputStream = AudioSystem
				.getAudioInputStream(soundFile);
		
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();

	}

	public void stop() {
		clip.stop();
	}
	
	public void changemusic(String a){
		file = a;
		
	}
	
	public void setVolume(int volume){
		FloatControl gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume); 
	}

}
                      