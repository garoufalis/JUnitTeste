package model;
import java.io.Serializable;

public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nomePais;
	private long populacao;
	private double area;
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nomePais;
	}
	public long getPopulacao() {
		return populacao;
	}
	public double getArea() {
		return area;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nomePais) {
		this.nomePais = nomePais;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	@Override
    public String toString() {
        return "pais [id=" + id + ", nome=" + nomePais + ", populacao=" + populacao
                + ", area=" + area + "]";
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pais other = (Pais) obj;
        if (area == -1) {
            if (other.area != -1)
                return false;
        } else if (area != other.area)
            return false;
        if (populacao == -1) {
            if (other.populacao != -1)
                return false;
        } else if (populacao != other.populacao)
            return false;
        if (id != other.id)
            return false;
        if (nomePais == null) {
            if (other.nomePais != null)
                return false;
        } else if (!nomePais.equals(other.nomePais))
            return false;
        return true;
    }
}
