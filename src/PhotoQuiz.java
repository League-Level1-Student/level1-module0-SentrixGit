/*
 *    Copyright (c) The League of Amazing Programmers 2013-2017
 *    Level 1
 */


import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public static void main(String[] args) throws Exception {
		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
                quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // This will make sure the program exits when you close the window

		// 1. find an image on the internet, and put its URL in a String variable (from your browser, right click on the image, and select “Copy Image Address”)
        String Url = "https://vignette.wikia.nocookie.net/central/images/a/a6/Dab.gif/revision/latest?cb=20160915153442";
        String Url2 = "https://66.media.tumblr.com/ae070465f8161455c19a3241a3bf51be/tumblr_inline_obr2tnumPB1upru0n_500.gif";
		// 2. create a variable of type "Component" that will hold your image
        Component thing = createImage(Url); 
        Component SecondThing = createImage(Url2);
       
		// 4. add the image to the quiz window
       quizWindow.add(thing); 
		// 5. call the pack() method on the quiz window
       quizWindow.pack();
		// 6. ask a question that relates to the image
       String Ans = JOptionPane.showInputDialog("Is patrick dabbing?");
		// 7. print "CORRECT" if the user gave the right answer
       if (Ans.toLowerCase().equals("no")) {
    	   	JOptionPane.showMessageDialog(null, "Great! You acomplished nothing!");
       } else if (Ans.toLowerCase().equals("yes")) {
    	   	JOptionPane.showMessageDialog(null, "Who's patrick?");
       }
		// 8. print "INCORRECT" if the answer is wrong

		// 9. remove the component from the quiz window (you may not see the effect of this until step 12)
       quizWindow.remove(thing);
		// 10. find another image and create it (might take more than one line of code)
       quizWindow.add(SecondThing);
		// 11. add the second image to the quiz window
       quizWindow.pack();
		// 12. pack the quiz window

		// 13. ask another question
       String Ans1 = JOptionPane.showInputDialog("What color is pentagons colors blue number green a through z?");
		// 7. print "CORRECT" if the user gave the right answer
      if (Ans1.toLowerCase().equals("yes")) {
   	   	JOptionPane.showMessageDialog(null, "Great! You acomplished nothing!");
      } else if (Ans1.toLowerCase().equals("no")) {
   	   	JOptionPane.showMessageDialog(null, "IT'S YES IT'S SO EASY!!! NOOOB XDDDDD");
      }
		// 14+ check answer, say if correct or incorrect, etc.

	}

	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image (imageComponent.addMouseMotionListener()) 
}





