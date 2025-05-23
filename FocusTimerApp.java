import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class FocusTimerApp {

    public static void main(String[] args) {

        // Ask the user for input using a JOptionPane input dialog
        String input = JOptionPane.showInputDialog("Minutes to focus: ");

        // Convert the user input (a String) to an integer
        int totalMinutes;
        totalMinutes = Integer.parseInt(input);

        // Convert minutes to seconds for the countdown
        int totalSeconds = totalMinutes * 60;

        // Create the main window (JFrame)
        JFrame frame = new JFrame("Focus!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 80);

        // Create a label to display the remaining time
        JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 30));  // Set a large font size
        frame.add(timeLabel);

        // Show the window
        frame.setVisible(true);

        // Use a final array to store the countdown value (because it needs to be mutable inside the Timer)
        while (totalSeconds > 0) {

            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;

            //this doesn't work
            int hours = (totalSeconds / 60) / 60;

            //update the label to show the remaining time in "minutes:seconds" format
            timeLabel.setText(String.format("%02d:%02d", minutes, seconds));

            totalSeconds--;

            try {
                Thread.sleep(1);  //sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace(); //exception handling
            }

        }

        if (totalSeconds == 0){

            frame.setSize(1080, 1080);
            timeLabel.setText("Done!");
        }
    }
}
