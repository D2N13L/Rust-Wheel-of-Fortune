package wheeloffortune;

import java.util.Random;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author D2N13L
 */
public class WheelOfFortune {

    public static void main(String[] args) {

        Random rnd = new Random();
        final JFrame frame = new JFrame();
        final JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2, 6));
        final JTextField one = new JTextField(5);
        final JTextField three = new JTextField(5);
        final JTextField five = new JTextField(5);
        final JTextField ten = new JTextField(5);
        final JTextField twenty = new JTextField(5);
        final JTextField rolls = new JTextField(5);
        final JLabel label = new JLabel("Write your bets below the numbers \n and the amount of rolls you'd like to simulate below ↓");
        label.setFont(new Font("Arial", 1, 15));
        pane.add(label);
        pane.add(new JLabel(new ImageIcon("src/wheeloffortune/1img.png")));
        pane.add(new JLabel(new ImageIcon("src/wheeloffortune/3img.png")));
        pane.add(new JLabel(new ImageIcon("src/wheeloffortune/5img.png")));
        pane.add(new JLabel(new ImageIcon("src/wheeloffortune/10img.png")));
        pane.add(new JLabel(new ImageIcon("src/wheeloffortune/20img.png")));
        pane.add(rolls);
        pane.add(one);
        pane.add(three);
        pane.add(five);
        pane.add(ten);
        pane.add(twenty);

        final int option = JOptionPane.showConfirmDialog(frame, pane, "Rust Wheel of Fortune simulator", 0, 1);
        if (option == 0) {
            int totalwager = 0;
            if (!one.getText().isEmpty()) {
                totalwager += Integer.parseInt(one.getText());
            }
            if (!three.getText().isEmpty()) {
                totalwager += Integer.parseInt(three.getText());
            }
            if (!five.getText().isEmpty()) {
                totalwager += Integer.parseInt(five.getText());
            }
            if (!ten.getText().isEmpty()) {
                totalwager += Integer.parseInt(ten.getText());
            }
            if (!twenty.getText().isEmpty()) {
                totalwager += Integer.parseInt(twenty.getText());
            }
            int winnings = 0, rollsint = Integer.parseInt(rolls.getText());
            int amount1 = 0, amount3 = 0, amount5 = 0, amount10 = 0, amount20 = 0;
            for (int i = 0; i < rollsint; i++) {
                int randomGenerated = rnd.nextInt(25) + 1;
                switch (randomGenerated) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        if (!one.getText().isEmpty()) {
                            winnings += ((Integer.parseInt(one.getText()) * 2) - totalwager);
                        }
                        amount1++;
                        break;
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        if (!three.getText().isEmpty()) {
                            winnings += ((Integer.parseInt(three.getText()) * 4) - totalwager);
                        }
                        amount3++;
                        break;

                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!five.getText().isEmpty()) {
                            winnings += ((Integer.parseInt(five.getText()) * 6) - totalwager);
                        }
                        amount5++;
                        break;
                    case 23:
                    case 24:
                        if (!ten.getText().isEmpty()) {
                            winnings += ((Integer.parseInt(ten.getText()) * 11) - totalwager);
                        }
                        amount10++;
                        break;
                    case 25:
                        if (!twenty.getText().isEmpty()) {
                            winnings += ((Integer.parseInt(twenty.getText()) * 21) - totalwager);
                        }
                        amount20++;
                        break;
                }
            }
            JOptionPane.showMessageDialog(pane, "total winnings:" + winnings + "\n times rolled 1: " + amount1 + "\n times rolled 3: " + amount3 + "\n times rolled 5: " + amount5 + "\n times rolled 10: " + amount10 + "\n times rolled 20: " + amount20);
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

}
