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
@Table(name = "Colores")
public class Colores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_color")
	private int id_color;

	@Column(name = "nom")
	private String nom;
	
	@OneToMany(mappedBy = "color")
	private Set<Propiedades> propiedades;

	public Colores() {
		super();
	}

	public Colores(String nom) {
		super();

		this.nom = nom;
	}

	public int getId_color() {
		return id_color;
	}

	public void setId_color(int id_color) {
		this.id_color = id_color;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Propiedades> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Set<Propiedades> propiedades) {
		this.propiedades = propiedades;
	}

	@Override
	public String toString() {
		return "Colores [id_color=" + id_color + ", propiedades=" + propiedades + ", nom=" + nom + "]";
	}

}
