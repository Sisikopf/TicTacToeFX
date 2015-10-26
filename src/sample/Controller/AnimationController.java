package sample.Controller;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sample.Controller.Interface.IGameAnimationController;
import sample.Model.Game;

import java.awt.*;

/**
 * Created by Vladimir on 26.10.2015.
 */
public class AnimationController implements IGameAnimationController {

    private void rotateButton(Button button)
    {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(300),button);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }

    @Override
    public void moveX(Button button) {
      rotateButton(button);
    }

    @Override
    public void moveO(Button button) {
        rotateButton(button);
    }
}
