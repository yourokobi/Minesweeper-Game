import javax.swing.*; // For GUI components
import java.awt.*;    // For colors and layouts
import java.awt.event.*; // For event handling
import java.util.Random; // For generating random colors

// Base Component class
class Component {
    protected int x, y, width, height;

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}

// Interface for clickable components
interface Clickable {
    void onClick();
}

// Button class extending Component and implementing Clickable
class Button extends Component implements Clickable {
    private JButton button;

    public Button(String text, int x, int y, int width, int height, ActionListener action) {
        super(x, y, width, height);
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(action);
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void onClick() {
        System.out.println("Button clicked!");
    }
}

// Label class extending Component
class Label extends Component {
    private JLabel label;

    public Label(String text, int x, int y, int width, int height) {
        super(x, y, width, height);
        label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.BOLD, 16));
    }

    public JLabel getLabel() {
        return label;
    }

    public void updateText(String newText) {
        label.setText(newText);
    }
}

// Main application class
public class ColorClickerApp {
    public static void main(String[] args) {
        // Create the frame (container)
        JFrame frame = new JFrame("Color Clicker Game");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Random color generator
        Random random = new Random();

        // Create a label
        Label label = new Label("Click to start the color fun!", 100, 50, 300, 50);
        frame.add(label.getLabel());

        // Declare the Button object outside the action listener
        Button button = new Button("Change Color", 150, 150, 200, 50, null);

        // Add action listener to the button
        button.getButton().addActionListener(e -> {
            // Generate random color
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            frame.getContentPane().setBackground(randomColor);

            // Update label with a fun message
            String[] messages = {
                "Wow, that's colorful!",
                "Keep clicking for more colors!",
                "Bright and beautiful!",
                "Feeling creative yet?",
                "What a vibe!"
            };
            label.updateText(messages[random.nextInt(messages.length)]);
            button.onClick();
        });

        // Add the button to the frame
        frame.add(button.getButton());

        // Set the initial background color
        frame.getContentPane().setBackground(Color.WHITE);

        // Display the frame
        frame.setVisible(true);
    }
}
