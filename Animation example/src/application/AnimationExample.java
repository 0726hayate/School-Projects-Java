package application;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;


public class AnimationExample extends Application {

	 private List<BouncingBall> balls = new ArrayList<>();
	    private boolean pause = false;
	    private Slider slide;
	    private BouncingBall selected = null;

	    @Override
	    public void start(Stage primaryStage) {
	        // Create a pane to hold the circles
	        Pane root = new Pane();

	        // Create a scene
	        Scene scene = new Scene(root, 600, 400);

	        // Create labels, buttons, and slider
	        Label speedLabel = new Label("Speed: ");
	        slide = new Slider(1, 5, 3);
	        slide.setShowTickMarks(true);
	        slide.setShowTickLabels(true);

	        // Add a listener to the slider to update the animation speed
	        slide.valueProperty().addListener((observable, oldValue, newValue) -> speed());

	        Button up = new Button("Up");
	        Button down = new Button("Down");
	        Button add = new Button("Add Ball");
	        Button remove = new Button("Remove Ball");
	        Button pauseResume = new Button("Pause/Resume");
	        
	        HBox box = new HBox(10, speedLabel, slide, up, down, add, remove, pauseResume);
	        box.setLayoutX(100);
	        box.setLayoutY(10);

	        // Add event handlers for buttons
	        up.setOnAction(e -> changeDirection(1)); 
	        down.setOnAction(e -> changeDirection(-1)); 
	        add.setOnAction(e -> addBall(root));
	        remove.setOnAction(e -> removeBall(root));
	        pauseResume.setOnAction(e -> togglePause());

	        root.getChildren().add(box);

	        primaryStage.setTitle("Animation Example");
	        primaryStage.setScene(scene);
	        primaryStage.show();
    }

    private void addBall(Pane root) {
        BouncingBall ball = createBouncingBall();
        balls.add(ball);
        root.getChildren().add(ball.getCircle());

        // Add event handler for the ball circle to allow selection
        ball.getCircle().setOnMouseClicked(e -> selectBall(ball));
    }

    private void removeBall(Pane root) {
        if (selected != null) {
            balls.remove(selected);
            root.getChildren().remove(selected.getCircle());
            selected = null;
        }
    }
    
    private void changeDirection(int direction) {
        for (BouncingBall ball : balls) {
            if (selected == null || ball == selected) {
                ball.getPathTransition().setRate(slide.getValue() * direction);
            }
        }
    }

    private BouncingBall createBouncingBall() {
        Circle circle = new Circle(20);
        circle.setFill(getRandomColor());

        // Create a path for PathTransition (vertical path)
        Path path = new Path();
        path.getElements().add(new MoveTo(300, 380));
        path.getElements().add(new LineTo(300, -20));

        // Create a PathTransition for moving the circle along the path
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setNode(circle);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false); // Disable auto-reverse
        pathTransition.setRate(slide.getValue()); // Set initial speed based on slider value
        pathTransition.play();
        
        // Create a FadeTransition for fading the circle in and out
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), circle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.2);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
  
        
        pathTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            // Check if the ball is off-screen and change color if needed
            BouncingBall ball = findBallByPathTransition(pathTransition);
            if (ball != null) {
                ball.changeColor();
            }
        });
        

        return new BouncingBall(circle, pathTransition);
    }
    
    private BouncingBall findBallByPathTransition(PathTransition pathTransition) {
        for (BouncingBall ball : balls) {
            if (ball.getPathTransition() == pathTransition) {
                return ball;
            }
        }
        return null;
    }

    private static Color getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }


    private void togglePause() {
        pause = !pause;
        for (BouncingBall ball : balls) {
            if (selected == null || ball == selected) {
                if (pause) {
                    ball.getPathTransition().pause();
                } else {
                    ball.getPathTransition().play();
                }
            }
        }
    }

    private void speed() {
        for (BouncingBall ball : balls) {
            if (selected == null || ball == selected) {
                ball.getPathTransition().setRate(slide.getValue());
            }
        }
    }

    private void selectBall(BouncingBall ball) {
        if (selected != null) {
            selected.getCircle().setStroke(Color.BLACK);
        }
        selected = ball;
        ball.getCircle().setStroke(Color.RED);
    }

    private static class BouncingBall {
        private Circle circle;
        private PathTransition pathTransition;

        public BouncingBall(Circle circle, PathTransition pathTransition) {
            this.circle = circle;
            this.pathTransition = pathTransition;
        }

        public Circle getCircle() {
            return circle;
        }

        public PathTransition getPathTransition() {
            return pathTransition;
        }

        // Check if the ball is off-screen and change its color
        public void changeColor() {
            double y = circle.getTranslateY();
            double radius = circle.getRadius();
            double top = 0 - radius; // Top position of the screen
            double bottom = 400 + radius; // Bottom position of the screen
            if (y <= top || y >= bottom) {
                circle.setFill(getRandomColor());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
