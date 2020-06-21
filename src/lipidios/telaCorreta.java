package lipidios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class telaCorreta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCorreta frame = new telaCorreta();
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
	public telaCorreta() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// instanciando a classe Pergunta
		pergunta pergunta = new pergunta();
		
		JLabel lblCorreto = new JLabel("Parab\u00E9ns!");
		lblCorreto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblCorreto.setBounds(249, 37, 228, 41);
		contentPane.add(lblCorreto);
		
		JButton btnVoltarAoJogo = new JButton("Voltar ao jogo");
		btnVoltarAoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPergunta frame;
				telaCorreta frame1;
				try {
					frame = new telaPergunta();
					frame.setVisible(true);
					frame1 = new telaCorreta();
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
		btnVoltarAoJogo.setBounds(233, 425, 270, 61);
		contentPane.add(btnVoltarAoJogo);
		
		JLabel lblVocAcertouContinue = new JLabel("Voc\u00EA acertou, continue jogando!");
		lblVocAcertouContinue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblVocAcertouContinue.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocAcertouContinue.setBounds(216, 105, 302, 21);
		contentPane.add(lblVocAcertouContinue);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\laisv\\Desktop\\lipidios\\comemoracao.png"));
		label.setBounds(264, 172, 239, 197);
		contentPane.add(label);
	}
}
