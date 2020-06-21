package lipidios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaErrado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaErrado frame = new telaErrado();
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
	public telaErrado() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// instanciando a classe Pergunta
		pergunta pergunta = new pergunta();
		
		JLabel lblErrado = new JLabel("Errado!");
		lblErrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblErrado.setBounds(258, 33, 228, 41);
		contentPane.add(lblErrado);
		
		JButton btnVoltarAoJogo = new JButton("Voltar ao jogo");
		btnVoltarAoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPergunta frame;
				telaErrado frame1;
				try {
					frame = new telaPergunta();
					frame.setVisible(true);
					frame1 = new telaErrado();
					frame1.setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnVoltarAoJogo.setForeground(Color.DARK_GRAY);
		btnVoltarAoJogo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnVoltarAoJogo.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnVoltarAoJogo.setBounds(237, 427, 270, 61);
		contentPane.add(btnVoltarAoJogo);
		
		JLabel lblVocErrouTente = new JLabel("Voc\u00EA errou, tente novamente!");
		lblVocErrouTente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocErrouTente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblVocErrouTente.setBounds(220, 87, 302, 21);
		contentPane.add(lblVocErrouTente);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\laisv\\Desktop\\lipidios\\x.png"));
		label.setBounds(167, 121, 370, 295);
		contentPane.add(label);
	}

}
