# Temperature Converter Application

The **Temperature Converter** is a Java Swing application that allows users to convert temperatures between Celsius, Fahrenheit, and Kelvin units. This application provides an intuitive graphical interface for performing temperature conversions and saving conversion results to a file. This readme provides an overview of the code and its functionality.

## Features

- Convert temperatures between Celsius (°C), Fahrenheit (°F), and Kelvin (K).
- Graphical user interface (GUI) with buttons, checkboxes, and radio buttons.
- Input temperature to convert.
- View conversion results and system messages in a text area.
- Save conversion and system messages to a file.
- Load and view saved conversion history from a file.
- Help menu for displaying user instructions.

## Code Structure

The code is structured in a single Java class named `temperatureConverter`, which extends the Swing `JFrame` class. Here's an overview of its key components:

- **Swing Components**: The GUI elements are created, including buttons (`saveB`, `clearB`, `exeB`), checkboxes (`celCB`, `farCB`, `kCB`), radio buttons (`celRB`, `farRB`, `kRB`), a text field (`userTF`), and a text area (`sysTA`).

- **ButtonGroup**: Radio buttons are grouped together using the `ButtonGroup` to ensure only one radio button can be selected at a time.

- **Menu Bar**: A menu bar (`men`) is added with "File" and "Help" menus. The "File" menu includes options to open a file (`open`), exit the application (`exit`), and the "Help" menu displays a simple help message.

- **Layout**: Components are laid out using the `GridBagLayout` manager for precise control over their placement within the GUI.

- **Action Listeners**: Action listeners are added to buttons for performing actions such as conversion, clearing fields, and saving results. Mouse listeners are used to change button background colors when hovering. A key listener is added to the save button for saving results when the Enter key is pressed.

- **Conversion Logic**: The `convert` method handles the temperature conversion logic based on user input and selected options (e.g., Celsius to Fahrenheit, Kelvin to Celsius). Conversion results are displayed in the text area (`sysTA`).

- **File Handling**: The `save` method allows users to save conversion results to a file named "temperature.txt." The `read` method reads and displays the contents of a selected file.

- **Main Method**: The `main` method invokes the application's GUI on the Event Dispatch Thread.

## Running the Application

To run the Temperature Converter application, follow these steps:

1. Compile the Java code using a Java compiler.

2. Run the compiled application, and a graphical window will appear.

3. Use the provided GUI elements to perform temperature conversions, save results, and read saved conversion history.

## Usage Instructions

1. Select the temperature unit you want to convert from by clicking one of the radio buttons (Celsius, Fahrenheit, Kelvin).

2. Choose the target temperature units you want to convert to by selecting the corresponding checkboxes (Celsius, Fahrenheit, Kelvin).

3. Enter the temperature value you wish to convert into the text field.

4. Click the "Convert" button or press Enter to perform the conversion.

5. View the conversion results and system messages in the text area below.

6. To clear all fields and checkboxes, click the "Clear" button.

7. Save conversion results and system messages by clicking the "Save" button.

8. To open and view saved conversion history from a file, use the "File" menu's "Open" option.

9. If you need help, click the "Help" menu to display a simple help message.

## Enjoy Temperature Conversions!

The Temperature Converter application simplifies temperature conversions and provides a user-friendly interface for tracking your conversion history. Use it to perform conversions quickly and conveniently, and save your results for future reference.
