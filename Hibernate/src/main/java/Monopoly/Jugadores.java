package Monopoly;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jugadores")
public class Jugadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_jugador")
	private int id_jugador;

	@Column(name = "nom")
	private String nom;

	@Column(name = "bancarota")
	private boolean Bancarrota;

	@Column(name = "turno")
	private int turno;

	@Column(name = "dinero")
	private int dinero;
	@Column(name = "num_propiedades")
	private int numpropiedades;

	@Column(name = "Victorias")
	private int Victorias;

	@Column(name = "casilla_actual")
	private int casilla;
	

	@OneToMany(mappedBy = "id_propiedad")
	private Set<Propiedades> propiedad;


	public Jugadores() {
		Bancarrota = false;
	}
	
	public Jugadores(String nom, int orden, int numPropiedades, int dinero, int wins,int casilla,
			Set<Propiedades> propiedad) {
		super();
		this.nom = nom;
		this.Bancarrota = false;
		this.turno = orden;
		this.numpropiedades = numPropiedades;
		this.dinero = dinero;
		this.Victorias = wins;
		this.casilla = casilla;
		this.propiedad = propiedad;
	}

	public int getId() {
		return id_jugador;
	}

	public void setId(int id) {
		this.id_jugador = id;
	}

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public Set<Propiedades> getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Set<Propiedades> propiedad) {
		this.propiedad = propiedad;
	}

	public boolean isBancarrota() {
		return Bancarrota;
	}

	public void setBancarrota(boolean vivo) {
		this.Bancarrota = vivo;
	}

	public int getTurn() {
		return turno;
	}

	public void setTurn(int Turn) {
		this.turno = Turn;
	}

	public int getNumPropiedades() {
		return numpropiedades;
	}

	public void setNumPropiedades(int numPropiedades) {
		this.numpropiedades = numPropiedades;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getWins() {
		return Victorias;
	}

	public void setWins(int wins) {
		Victorias = wins;
	}

		public int getCasilla() {
		return casilla;
	}

	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}



	@Override
	public String toString() {
		return "Jugador [id=" + id_jugador + ", nom=" + nom + ", Bancarrota=" + Bancarrota + ", Torn=" + turno
				+ ", numPropiedades=" + numpropiedades + ", dinero=" + dinero + ", Wins=" + Victorias + ", propiedad="
				+ propiedad + "]";
	}

}
