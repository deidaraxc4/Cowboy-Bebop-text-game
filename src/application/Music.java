package application;

import java.net.URL;

import javafx.scene.media.*;
import javafx.util.Duration;

public class Music {
	private Media media;
	private MediaPlayer mp;
	private boolean isPlaying;
	
	public Music(URL url) {
		media = new Media(url.toString());
		mp = new MediaPlayer(media);
		setMP();
	}


	//makes music loop after playing
	public void setMP() {
		mp.setOnEndOfMedia(new Runnable() {
			public void run() {
				mp.seek(Duration.ZERO);
			}
		});
	}
	
	public void play() {
		mp.play();
		isPlaying = true;
	}
	
	public void stop() {
		mp.stop();
		isPlaying = false;
	}
	
	public void pause() {
		mp.pause();
		isPlaying = false;
	}
	
	public boolean getStatus() {
		return isPlaying;
	}

}
