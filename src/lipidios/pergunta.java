package lipidios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class pergunta {
	
	private int CodPergunta; // codigo da pergunta na tabela
	private String questao; // pergunta
	private String respostaCorreta; // resposta correta da pergunta
	private String justificativa; //explica��o para a resposta
	private String respostaRecebida; // o que o usuario respondeu
	private String url = "jdbc:postgresql://localhost:5432/lipidios"; // url do banco de dados
	private String usuario = "postgres"; // usuario do banco de dados
	private String senha = "postgres"; // senha do banco de dados
	private Connection conexao = null;//faz a conex�o com o banco de dados
	private double valorAleatorio; // pergunta sorteada


	//METODO CONSTRUTOR
	public pergunta() throws SQLException {
		 this.conexao = DriverManager.getConnection(this.getUrl(),this.getUsuario(),this.getSenha());
		 }


	public int getCodPergunta() {
		return CodPergunta;
	}


	public void setCodPergunta(int codPergunta) {
		CodPergunta = codPergunta;
	}


	public String getQuestao() {
		return questao;
	}


	public void setQuestao(String questao) {
		this.questao = questao;
	}


	public String getRespostaCorreta() {
		return respostaCorreta;
	}


	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}


	public String getJustificativa() {
		return justificativa;
	}


	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}


	public String getRespostaRecebida() {
		return respostaRecebida;
	}


	public void setRespostaRecebida(String respostaRecebida) {
		this.respostaRecebida = respostaRecebida;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Connection getConexao() {
		return conexao;
	}


	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public double getValorAleatorio() {
		return valorAleatorio;
	}


	public void setValorAleatorio(double valorAleatorio) {
		this.valorAleatorio = valorAleatorio;
	}
	

	//************************************METODOS************************************************
	
	// METODO TRAZER PERGUNTA
	
	public ResultSet trazerPergunta() throws SQLException {
		valorAleatorio = Math.random() * 6;
		CodPergunta = (int) Math.round(valorAleatorio);
		String sql;
		ResultSet dados = null;
		Statement statement = this.conexao.createStatement();
		sql = String.format("SELECT pergunta FROM Pergunta WHERE CodPergunta = %d;",this.getCodPergunta()); // descubra como trazer apenas uma coluna
		dados = statement.executeQuery(sql);
		return dados;
	}
	
	//METODO COMPARAR RESPOSTA
	public ResultSet compararResposta() throws SQLException {
		String sql;
		ResultSet dados = null;
		Statement statement = this.conexao.createStatement();
		sql = String.format("SELECT resposta FROM Pergunta WHERE CodPergunta = %d;",this.getCodPergunta()); // descubra como trazer apenas uma coluna
		dados = statement.executeQuery(sql);
		return dados;
	}
}
