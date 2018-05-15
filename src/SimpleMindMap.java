import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class SimpleMindMap {

	public static void main(String[] args) {
		JFrame window = new JFrame("SimpleMindMap");
		JMenuBar menu = new JMenuBar();

		window.setJMenuBar(menu);
		window.setSize(400, 400);
		window.setVisible(true);
	}

}
