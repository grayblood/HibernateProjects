package Model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Partida")
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id_Partida;

	@Column(name = "torn")
	private int torn;

	@Column(name = "quantitat_Jugadors")
	private int Jugadors;

	public Partida(int numJ) {
		this.torn = 0;
		this.Jugadors = numJ;
	}

	public Partida() {
		super();
	}

	@Override
	public String toString() {
		return "Partida [id_Partida=" + id_Partida + ", torn=" + torn + ", Jugadors=" + Jugadors + "]";
	}

	public int getId_Partida() {
		return id_Partida;
	}

	
	public int getTorn() {
		return torn;
	}

	public void setTorn(int torn) {
		this.torn = torn;
	}

	public int getJugadors() {
		return Jugadors;
	}

	public void setJugadors(int jugadors) {
		Jugadors = jugadors;
	}
	
	
}
