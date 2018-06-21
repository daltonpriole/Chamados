package enums;

public enum Estado {
	EE("Em Espera"), EA("Em análise"), A("Atendido");
	
	public String titulo;
	Estado(String titulo){
		this.titulo = titulo;
	}
}
