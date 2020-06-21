package lipidios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class telaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnJogar;
	private JLabel image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaPrincipal() throws SQLException{
		setTitle("tela principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// instanciando a classe Pergunta
		pergunta pergunta = new pergunta();
				
		
		btnJogar = new JButton("JOGAR");
		btnJogar.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnJogar.setForeground(Color.DARK_GRAY);
		btnJogar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 33));
		btnJogar.setBounds(355, 468, 270, 77);
		contentPane.add(btnJogar);
		
		image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\laisv\\Desktop\\lipidios\\LIP\u00CDDIOS.jpg"));
		image.setBounds(0, 0, 929, 630);
		contentPane.add(image);
		
		//****************************************************************************************************
	
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet perguntas = null;
				telaPergunta frame;
				telaPrincipal frame1;
				try {
					perguntas = pergunta.trazerPergunta();
					frame = new telaPergunta();
					frame.setVisible(true);
					frame1 = new telaPrincipal();
					frame1.setVisible(false);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}
}
