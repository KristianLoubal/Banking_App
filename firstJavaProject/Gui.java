package firstJavaProject;
import javax.swing.*;

public class Gui extends JFrame{
    Gui(){
        this.setTitle("Banking 42069");
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setResizable(true);
	    this.setVisible(true);
	    this.setSize(1600,900);

		ImageIcon image = new ImageIcon("money.png");
	    this.setIconImage(image.getImage());
    }
}
