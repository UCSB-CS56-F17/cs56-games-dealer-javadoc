package edu.ucsb.cs56.projects.games.dealer;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * This class is used to play a sound effect.
 * @author Kin Kwan Poon
 * @version cs56 F16
 *
 */
public class SoundEffect {
	/**
	 * This is a overloaded play sound method, which will play a random sound
	 * within the specific category. 
	 * (e.g. There are 4 sound effects for deal card to hand.) 
	 * @param filenamePrefix The name of the category
	 * @param randomBegins the beginning number of the category
	 * @param randomEnds the end number of the category
	 */
	public static void playSound(String filenamePrefix,int randomBegins,int randomEnds){
		int random=randomBegins+(int)(Math.random()*((randomEnds-randomBegins)+1));
		filenamePrefix+=Integer.toString(random)+".wav";
		playSound(filenamePrefix);
	}
	/**
	 * This is the method to play a sound effect.
	 * @param filename the filename under sound directory
	 */
    public static synchronized void playSound(String filename) {
	new Thread(new Runnable() {
		public void run() {
		    try {
			Clip clip;
			File sound = new File("sound/"+filename);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(sound);
			AudioFormat format = inputStream.getFormat();
			DataLine.Info info=new DataLine.Info(Clip.class,format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);
			clip.start();
		    } catch (Exception e) {
			System.out.println("play sound error: " + e.getMessage() );
		    }
		}
	    }).start();
    }
}
