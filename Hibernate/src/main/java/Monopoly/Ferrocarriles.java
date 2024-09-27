package Monopoly;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Ferrocarriles extends Propiedades {
	public Ferrocarriles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ferrocarriles(String nom, int precio, int precio_hipoteca) {
		super(nom, precio, precio_hipoteca);
		// Vecinos = veins;
	}

	public Ferrocarriles(String nom, int precio, int alquiler, int alquiler1, int alquiler2, int alquiler3,
			int alquiler4, int alquilerHotel, int precio_casa, int n_casas, int precio_hipoteca, boolean hipotecado,
			int posicion, Jugadores propietario, Colores color) {
		super(nom, precio, alquiler, alquiler1, alquiler2, alquiler3, alquiler4, alquilerHotel, precio_casa, n_casas,
				precio_hipoteca, hipotecado, posicion, propietario, color);

	}

	@ManyToMany
	@JoinTable(name = "Vecinos", joinColumns = @JoinColumn(name = "Vecino"), inverseJoinColumns = @JoinColumn(name = "Ferrocarril"))
	private Set<Ferrocarriles> Ferrocarril = new HashSet<Ferrocarriles>();

	

	@ManyToMany
	@JoinTable(name = "Vecinos", joinColumns = @JoinColumn(name = "Ferrocarril"), inverseJoinColumns = @JoinColumn(name = "Vecino"))
	private Set<Ferrocarriles> Vecinode = new HashSet<Ferrocarriles>();

	public Set<Ferrocarriles> getVecinos() {
		return Ferrocarril;
	}

	public void setVecinos(Set<Ferrocarriles> vecinos) {
		Ferrocarril = vecinos;
	}

	public Set<Ferrocarriles> getVecinode() {
		return Vecinode;
	}

	public void setVecinode(Set<Ferrocarriles> vecinosde) {
		Vecinode = vecinosde;
	}

	@Override
	public String toString() {
		return "Ferrocarriles [Vecinos=" + Ferrocarril + ", Vecinosde=" + Vecinode + "]";
	}

}
