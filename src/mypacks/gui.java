package mypacks;
import java.awt.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui {


	private JFrame frame;
	private JTextField Username;
	private JTextField Password;
	private JLabel eyeiconclose;

	/**
	 * Launch the application.
	 */
	
	public static ImageIcon imgscale (String path ,int width, int height) {
		ImageIcon image = new ImageIcon(path);
		Image img = image.getImage();
		Image scl_user = img.getScaledInstance( width,height, Image.SCALE_REPLICATE);
		ImageIcon Iconscl = new ImageIcon(scl_user);
		
		return Iconscl;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    
    // width will store the width of the screen
        int width = (int)size.getWidth();
        int framewidth = (int) ((width/100)*60);
        int panelwidth = framewidth-16;
    
    // height will store the height of the screen
        int height = (int)size.getHeight();
        int frameheight =(int) ((height/100)*75);
        int panelheight = frameheight-39;
        
        
        
		frame.setBounds(((width/100)*20),((height/100)*15),framewidth,frameheight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFocusable(true);
		
		
		
		panel.setBounds(0, 0,panelwidth,panelheight);
		panel.setPreferredSize(new Dimension(panelwidth,panelheight));
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = Username.getText();
				String password = Password.getText();
				if(authenticate(Username,password)) {
					JOptionPane.showMessageDialog(null, "Login Successful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBounds((panelwidth/100)*43,(panelheight/100)*73, (panelwidth/100)*17,(panelheight/100)*5);
		panel.add(btnNewButton);
		
		JLabel eyeiconopen = new JLabel();
		eyeiconopen.setIcon(gui.imgscale("C:\\Users\\asus\\eclipse-workspace\\en -de crypter\\src\\mypacks\\image\\pngfind.com-eyes-png-593921.png", (panelwidth/100)*2,(panelheight/100)*3));
		eyeiconopen.setBackground(Color.BLACK);
		eyeiconopen.setBounds((panelwidth/100)*60,(panelheight/100)*66, (panelwidth/100)*2,(panelheight/100)*3);
		panel.add(eyeiconopen);
		
		
		eyeiconclose = new JLabel();
		eyeiconclose.setIcon(gui.imgscale("C:\\Users\\asus\\eclipse-workspace\\en -de crypter\\src\\mypacks\\image\\pngfind.com-password-icon-png-2683291.png",(panelwidth/100)*2,(panelheight/100)*3));
		eyeiconclose.setBackground(Color.BLACK);
		eyeiconclose.setBounds((panelwidth/100)*60,(panelheight/100)*66, (panelwidth/100)*2,(panelheight/100)*3);
		panel.add(eyeiconclose);
		
		Username = new JTextField("Username");
		Username.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Username.getText().equals("Username")) {
					Username.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (Username.getText().equals("")){
					Username.setText("Username");
				}
			}
		});
		Username.setBounds((panelwidth/100)*40,(panelheight/100)*58, (panelwidth/100)*23,(panelheight/100)*5);
		panel.add(Username);
		Username.setColumns(10);
		
		Password = new JPasswordField("Password");
		Password.setFont(new Font("Times New Roman", Font.BOLD, 17));
//		Password.
		Password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Password.getText().equals("Password")) {
					Password.setText("");
				}				
			}
			public void focusLost(FocusEvent e) {
				if (Password.getText().equals("")){
					Password.setText("Password");
				}
			}
		});
		Password.setColumns(10);
		Password.setBounds((panelwidth/100)*40, (panelheight/100)*65,(panelwidth/100)*23,(panelheight/100)*5);
		panel.add(Password);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Cypher Encrypter");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds((width/100)*23,(height/100)*4, 290, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(gui.imgscale("C:\\Users\\asus\\eclipse-workspace\\en -de crypter\\src\\mypacks\\image\\pngfind.com-profile-icon-png-1102927.png", (width/100)*10, (height/100)*18));
		lblNewLabel_1.setBounds((panelwidth/100)*42,(panelheight/100)*20,(width/100)*10, (height/100)*18);
		panel.add(lblNewLabel_1);
		
		
		JLabel bgimage = new JLabel("");

		bgimage.setIcon(gui.imgscale("C:\\Users\\asus\\eclipse-workspace\\en -de crypter\\src\\mypacks\\image\\4884273.jpg", panelwidth, panelheight));
		bgimage.setBackground(Color.WHITE);
		bgimage.setBounds(0, 0, 1124, 711);
		panel.add(bgimage);
		
		
		
		
		
		
		
		
		
		
	}
}
