package Model;

import Util.MonstresNames;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Monstre")
public class Monstre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id")
	private int id_Monstre;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_Partida", referencedColumnName = "id")
	private Partida id_Partida;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_Jugador")
	private Jugador id_Jugador;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	@Column(name = "vida")
	private int vida;

	@Column(name = "punts_Victoria")
	private int punts_Victoria;

	@Column(name = "energia")
	private int energia;

	@Column(name = "on_tokio")
	private Boolean on_Tokio;

	@Column(name = "eliminat")
	private Boolean eliminat;


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poderasociat")
	private Monstre poderasociat;


	public Monstre() {
		super();
	}
	public Monstre(MonstresNames nom) {
		this.nom = nom.toString();
		this.vida = 50;
		this.punts_Victoria = 0;
		this.energia = 0;
		this.eliminat = false;
		this.on_Tokio = false;
	}

	public Partida getId_Partida() {
		return id_Partida;
	}

	public void setId_Partida(Partida id_Partida) {
		this.id_Partida = id_Partida;
	}

	public Jugador getId_Jugador() {
		return id_Jugador;
	}

	public void setId_Jugador(Jugador id_Jugador) {
		this.id_Jugador = id_Jugador;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(MonstresNames nom) {
		this.nom = nom.toString();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPunts_Victoria() {
		return punts_Victoria;
	}

	public void setPunts_Victoria(int punts_Victoria) {
		this.punts_Victoria = punts_Victoria;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public Boolean getOn_Tokio() {
		return on_Tokio;
	}

	public void setOn_Tokio(Boolean on_Tokio) {
		this.on_Tokio = on_Tokio;
	}

	public Boolean getEliminat() {
		return eliminat;
	}

	public void setEliminat(Boolean eliminat) {
		this.eliminat = eliminat;
	}

	public Monstre getPoderasociat() {
		return poderasociat;
	}

	public void setPoderasociat(Monstre poderasociat) {
		this.poderasociat = poderasociat;
	}

	public int getId_Monstre() {
		return id_Monstre;
	}

	/*
	 * @Override public String toString() { return "Monstre [id_Monstre=" +
	 * id_Monstre + ", id_Partida=" + id_Partida + ", nom=" + nom + ", id_Jugador="
	 * + id_Jugador + ", vida=" + vida + ", punts_Victoria=" + punts_Victoria +
	 * ", energia=" + energia + ", on_Tokio=" + on_Tokio + ", eliminat=" + eliminat
	 * + ", poderasociat=" + poderasociat + "]\n"; }
	 */
	@Override
	public String toString() {
		return "Monstre [id_Monstre=" + id_Monstre + ", id_Partida=" + id_Partida + ", nom=" + nom + ", id_Jugador="
				+ id_Jugador + ", vida=" + vida + ", punts_Victoria=" + punts_Victoria + ", energia=" + energia
				+ ", on_Tokio=" + on_Tokio + ", eliminat=" + eliminat + "]\n";
	}

}
