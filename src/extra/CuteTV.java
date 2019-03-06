package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CuteTV implements ActionListener {
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel();

	JButton Duck = new JButton();
	JButton Frog = new JButton();
	JButton Pony = new JButton();

	void showDucks() {
		playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
		playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
		playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {
		try {
			URI uri = new URI(videoID);
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void createUI() {
		// 1. Add the panel to the frame
		Frame.add(Panel);
		// 2. Make the frame visible
		Frame.setVisible(true);
		// 3. Set the text of the leftButton to "Click me!"
		Duck.setText("Duck");
		// 4. Set the text of the rightButton to "Click me!"
		Pony.setText("Pony");
		Frog.setText("Frog");
		// 5. Add an action listener to the leftButton
		Duck.addActionListener(this);
		Pony.addActionListener(this);
		// 6. Add an action listener to the rightButton
		Frog.addActionListener(this);
		// 7. Add the leftButton to the panel
		Panel.add(Duck);
		// 8. Add the rightButton to the panel
		Panel.add(Frog);
		Panel.add(Pony);
		// 9. Pack the frame
		Frame.pack();
		// 10. Set the title of the frame to "Demanding Buttons"
		Frame.setTitle("Demanding buttons");
	}

	public static void main(String[] args) {
		new CuteTV().createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Duck) {
			System.out.println("Duk");
			showDucks();
		} else if (e.getSource() == Frog) {
			System.out.println("Frok");
			showFrog();
		} else if (e.getSource() == Pony) {
			System.out.println("ponk");
			showFluffyUnicorns();
		}
	}
}