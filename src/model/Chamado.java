package model;

public class Chamado {
	private int id;
	private String titulo;
	private String conteudo;
	private String data_abertura; // = "GETDATE(),103";
	private String data_retorno;
	private String retorno;
	private String estado;


	public Chamado(String titulo, String conteudo){
		this.setTitulo(titulo);
		this.setConteudo(conteudo);
	}

	public Chamado(int id, String titulo, String conteudo){
		this.setId(id);
		this.setTitulo(titulo);
		this.setConteudo(conteudo);
	}

	
	public Chamado(int id, String titulo, String conteudo, String data_abertura, String Retorno, String data_retorno, String estado) {
		this.setId(id);
		this.setTitulo(titulo);
		this.setConteudo(conteudo);
		this.setConteudo(data_abertura);
		this.setConteudo(Retorno);
		this.setConteudo(data_retorno);
		this.setConteudo(estado);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

//--------------------------------------------------
	public String getData_abertura() {
		return data_abertura;
	}
	public void setData_abertura(String data_abertura) {
		this.data_abertura = data_abertura;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(String data_retorno) {
		this.data_retorno = data_retorno;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
//-------------------------------------------


}
