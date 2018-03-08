package GuestList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestList implements ActionListener {
	String name;
	String food;
	String line;
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton guest = new JButton();
	JButton list = new JButton();

	HashMap<String, String> HM = new HashMap<String, String>();

	public static void main(String[] args) {
		GuestList GL = new GuestList();
		GL.Create();
		GL.Action();
	}

	public void Create() {
		f.setSize(200, 60);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		p.add(guest);
		p.add(list);
		f.setVisible(true);
		guest.setText("Guest");
		list.setText("View List");
	}

	public void Action() {
		guest.addActionListener(this);
		list.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(guest)) {
			name = JOptionPane.showInputDialog("Enter Name!");
			food = JOptionPane.showInputDialog("Enter Food!");
			HM.put(name, food);
			try {
				FileWriter FW = new FileWriter("src/GuestList/GuestList2.txt", true);
				for (String t : HM.keySet()) {
					String s = HM.get(t);
					FW.write(t + " is bringing " + s + "!\n");
				}

				FW.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(list)) {
			String compile = new String();
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/GuestList/GuestList2.txt"));

				String line = br.readLine();
				while (line != null) {
					compile += line + "\n";

					line = br.readLine();
				}
				JOptionPane.showMessageDialog(null, compile);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} else {

		}
	}
}
