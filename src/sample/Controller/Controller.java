package sample.Controller;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.Controller.Interface.IGameAnimationController;
import sample.Controller.Interface.IGameSoundController;
import sample.Model.Game;

public class Controller {

    private Game game = new Game();
    private IGameAnimationController animationController = new AnimationController();
    private IGameSoundController soundController = new SoundController();
    public GridPane gridPane;

    public Controller() {
        init();
    }

    public void init() {
        game.newGame();
    }

    public void buttonClick(ActionEvent actionEvent) {
        if (game.isGameOver()) {
            startNewGame();
            return;
        }
        Button button = (Button) actionEvent.getSource();
        int y = GridPane.getColumnIndex(button) - 1;
        int x = GridPane.getRowIndex(button) - 1;
        if (game.Move(x, y)) {
            button.setText(game.getStringCurrentState());
            if (game.checkConditions(x, y)) {
                soundController.playWin();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game over");
                alert.setContentText(game.getCurrentState() + " win!");
                alert.showAndWait();
            } else if (game.isDraw()) {
                soundController.playDraw();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game over");
                alert.setContentText("Draw!");
                alert.showAndWait();
            }
            else
            {
                if (game.getCurrentState() == Game.State.X) {
                    animationController.moveX(button);
                    soundController.playX();
                } else {
                    animationController.moveO(button);
                    soundController.playO();
                }
            }
            game.changeState();
        }

    }

    protected void startNewGame() {
        ObservableList<Node> nodes = gridPane.getChildren();
        nodes.forEach(node -> {
            ((Button) node).setText("");
        });
        game.newGame();
    }


}
