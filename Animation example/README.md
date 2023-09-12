# Animation Example with Bouncing Balls

This Java application, "Animation Example with Bouncing Balls," demonstrates a simple animation using JavaFX. It creates colorful bouncing balls that move vertically along a path and can be controlled interactively. This readme provides an overview of the code and its functionality.

## Features

- Create and display bouncing balls with random colors.
- Control the speed of the animation with a slider.
- Move balls up and down the screen.
- Add and remove balls dynamically.
- Pause and resume individual or all animations.
- Select a ball to highlight it with a red border.

## Code Structure

The code consists of a single Java class named `AnimationExample`, which extends the JavaFX `Application` class. Here's a breakdown of its key components:

- **BouncingBall Class**: An inner class that encapsulates the properties of a bouncing ball, including its circle shape, path transition, and methods to change its color.

- **JavaFX Initialization**: In the `start` method, the JavaFX application is initialized. It sets up the user interface elements, including buttons, a slider, and the animation pane.

- **Add and Remove Balls**: The `addBall` and `removeBall` methods allow you to add new bouncing balls to the animation and remove selected ones.

- **Change Direction**: The `changeDirection` method allows you to change the direction (up or down) of the selected ball(s).

- **Create Bouncing Ball**: The `createBouncingBall` method creates a new bouncing ball with a random color, vertical path, and fade-in/fade-out effect. These balls are added to the animation.

- **Toggle Pause**: The `togglePause` method allows you to pause and resume the animation for individual or all balls.

- **Speed Control**: The `speed` method adjusts the animation speed based on the slider's value.

- **Select Ball**: The `selectBall` method highlights a selected ball with a red border, allowing you to track it easily.

- **Random Color Generation**: The `getRandomColor` method generates random colors for the bouncing balls.

## Running the Application

To run the application, follow these steps:

1. Ensure you have JavaFX properly configured in your development environment.

2. Create a Java project and add the provided code to a Java class.

3. Run the `main` method in the `AnimationExample` class.

4. The application window will open, allowing you to interact with the bouncing balls.

## Usage Instructions

- Use the "Add Ball" button to add new bouncing balls to the animation.

- Select a ball by clicking on it to highlight it with a red border.

- Control the animation speed using the slider labeled "Speed."

- Move balls up and down the screen using the "Up" and "Down" buttons.

- Remove a selected ball using the "Remove Ball" button.

- Pause and resume the animation for all or individual balls using the "Pause/Resume" button.

## Enjoy the Animation!

Feel free to experiment with the application to create a mesmerizing display of bouncing balls with different speeds and colors. This simple animation example showcases the capabilities of JavaFX for creating interactive graphical user interfaces.
