package enums;

public enum Validade {
	A("Ativo"), D("Desativado");
	String titulo;
	Validade(String titulo){
		this.titulo = titulo;
	}
}
