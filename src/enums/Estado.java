package enums;

public enum Estado {
	EE("Em Espera"), EA("Em an�lise"), A("Atendido");
	
	public String titulo;
	Estado(String titulo){
		this.titulo = titulo;
	}
}
