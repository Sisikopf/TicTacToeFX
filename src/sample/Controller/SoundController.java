package sample.Controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sample.Controller.Interface.IGameSoundController;

import java.io.File;

/**
 * Created by Vladimir on 26.10.2015.
 */
public class SoundController implements IGameSoundController {

    private static final String PLAY_X_SOUND="sound/x_sound.wav";
    private static final String PLAY_O_SOUND="sound/o_sound.wav";
    private static final String PLAY_DRAW_SOUND="sound/draw_sound.wav";
    private static final String PLAY_WIN_SOUND="sound/win_sound.wav";

    private void playSound(String musicFile)
    {
        new Thread(() -> {
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }).start();
    }

    @Override
    public void playX() {
        playSound(PLAY_X_SOUND);
    }

    @Override
    public void playO() {
        playSound(PLAY_O_SOUND);
    }

    @Override
    public void playDraw() {
        playSound(PLAY_DRAW_SOUND);
    }

    @Override
    public void playWin() {
        playSound(PLAY_WIN_SOUND);
    }
}
