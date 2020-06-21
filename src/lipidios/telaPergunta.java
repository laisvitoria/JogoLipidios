package lipidios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class telaPergunta extends JFrame {

	private JPanel contentPane;
	private JButton btnNovaPergunta;
	private JButton btnVerdadeiro;
	private JTextField txtPergunta;
	private JButton btnFalso;
	private String resposta = "naoRespondido";

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPergunta frame = new telaPergunta();
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
	public telaPergunta() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 127));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// instanciando a classe Pergunta
		pergunta pergunta = new pergunta();
		
		btnNovaPergunta = new JButton("NOVA PERGUNTA");
		btnNovaPergunta.setForeground(Color.DARK_GRAY);
		btnNovaPergunta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNovaPergunta.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnNovaPergunta.setBounds(307, 463, 270, 61);
		contentPane.add(btnNovaPergunta);
		
		btnVerdadeiro = new JButton("VERDADEIRO");
		btnVerdadeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet respostas = null;
				telaCorreta frame;
				telaErrado frame1;
				resposta = "verdadeiro";
				pergunta.setRespostaRecebida(resposta);
				/*try {
					while (respostas.next()) {
					resposta = respostas.getObject(1).toString();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} */
				try {
					frame = new telaCorreta();
					frame1 = new telaErrado();
					respostas = pergunta.compararResposta();
					if (resposta  == "verdadeiro") {
						frame.setVisible(true);
					}
					else {
						frame1.setVisible(true);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnVerdadeiro.setForeground(Color.DARK_GRAY);
		btnVerdadeiro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnVerdadeiro.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnVerdadeiro.setBounds(127, 289, 270, 61);
		contentPane.add(btnVerdadeiro);
		
		txtPergunta = new JTextField();
		txtPergunta.setEditable(false);
		txtPergunta.setBorder(null);
		txtPergunta.setHorizontalAlignment(SwingConstants.CENTER);
		txtPergunta.setText("Clique em Nova Pergunta para come\u00E7ar");
		txtPergunta.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		txtPergunta.setBackground(new Color(0, 255, 127));
		txtPergunta.setBounds(88, 64, 721, 126);
		contentPane.add(txtPergunta);
		txtPergunta.setColumns(10);
		
		btnFalso = new JButton("FALSO");
		btnFalso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						ResultSet perguntas = null;
						telaCorreta frame;
						telaErrado frame1;
						resposta = "falso";
						/*try {
							resposta = perguntas.getObject(1).toString();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						try {
							frame = new telaCorreta();
							frame1 = new telaErrado();
							perguntas = pergunta.compararResposta();
							if (resposta  == "falso") {
								frame1.setVisible(true);
							}
							else {
								frame.setVisible(true);
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
				});
		btnFalso.setForeground(Color.DARK_GRAY);
		btnFalso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnFalso.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnFalso.setBounds(479, 289, 270, 61);
		contentPane.add(btnFalso);
	
	//********************************************************************************************************
	btnNovaPergunta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ResultSet perguntas = null;
			telaPergunta frame;
			telaPrincipal frame1;
			try {
				frame1 = new telaPrincipal();
				frame1.setVisible(false);
				perguntas = pergunta.trazerPergunta();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				while (perguntas.next()) {
			
				txtPergunta.setText(perguntas.getObject(1).toString());
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
}
}