package Monopoly;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//anotacions

@Entity
@Table(name = "Propiedades")
public class Propiedades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_propiedad")
	private int id_propiedad;

	@Column(name = "nom")
	private String nom;

	@Column(name = "precio")
	private int precio;

	@Column(name = "alquiler")
	private int alquiler;

	@Column(name = "alquiler1")
	private int alquiler1;

	@Column(name = "alquiler2")
	private int alquiler2;

	@Column(name = "alquiler3")
	private int alquiler3;

	@Column(name = "alquiler4")
	private int alquiler4;

	@Column(name = "alquiler_hotel")
	private int alquilerHotel;

	@Column(name = "precio_casa")
	private int precio_casa;

	@Column(name = "numero_casas")
	private int n_casas;

	@Column(name = "precio_hipoteca")
	private int precio_hipoteca;

	@Column(name = "hipotecado")
	private Boolean hipotecado;

	@Column(name = "posicion")
	private int posicion;

	@ManyToOne
	@JoinColumn(name = "id_jugador", nullable = true)
	private Jugadores id_jugador;

	
	@ManyToOne
	@JoinColumn(name = "id_color", nullable = false) //NO NULLABLE
	private Colores color;
	
	public Propiedades() {
		super();
		this.setHipotecado(false);
	}
	

	public Propiedades(String nom, int precio, int alquiler, int alquiler1, int alquiler2, int alquiler3, int alquiler4,
			int alquilerHotel, int precio_casa, int n_casas, int precio_hipoteca, Boolean hipotecado, int posicion,
			Jugadores propietario, Colores color) {
		super();
		this.nom = nom;
		this.precio = precio;
		this.alquiler = alquiler;
		this.alquiler1 = alquiler1;
		this.alquiler2 = alquiler2;
		this.alquiler3 = alquiler3;
		this.alquiler4 = alquiler4;
		this.alquilerHotel = alquilerHotel;
		this.precio_casa = precio_casa;
		this.n_casas = n_casas;
		this.precio_hipoteca = precio_hipoteca;
		this.hipotecado = hipotecado;
		this.posicion = posicion;
		this.id_jugador = propietario;
		this.color = color;
	}

	public Propiedades(String nom, int precio, int precio_hipoteca) {
		this.nom = nom;
		this.precio = precio;
		this.precio_hipoteca = precio_hipoteca;
	}

	public int getId() {
		return id_propiedad;
	}

	public void setId(int id) {
		this.id_propiedad = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

	public int getAlquiler1() {
		return alquiler1;
	}

	public void setAlquiler1(int alquiler1) {
		this.alquiler1 = alquiler1;
	}

	public int getAlquiler2() {
		return alquiler2;
	}

	public void setAlquiler2(int alquiler2) {
		this.alquiler2 = alquiler2;
	}

	public int getAlquiler3() {
		return alquiler3;
	}

	public void setAlquiler3(int alquiler3) {
		this.alquiler3 = alquiler3;
	}

	public int getAlquiler4() {
		return alquiler4;
	}

	public void setAlquiler4(int alquiler4) {
		this.alquiler4 = alquiler4;
	}

	public int getAlquilerHotel() {
		return alquilerHotel;
	}

	public void setAlquilerHotel(int alquilerHotel) {
		this.alquilerHotel = alquilerHotel;
	}

	public int getPrecio_casa() {
		return precio_casa;
	}

	public void setPrecio_casa(int precio_casa) {
		this.precio_casa = precio_casa;
	}

	public int getN_casas() {
		return n_casas;
	}

	public void setN_casas(int n_casas) {
		this.n_casas = n_casas;
	}

	public int getPrecio_hipoteca() {
		return precio_hipoteca;
	}

	public void setPrecio_hipoteca(int precio_hipoteca) {
		this.precio_hipoteca = precio_hipoteca;
	}

	public boolean isHipotecado() {
		return hipotecado;
	}

	public void setHipotecado(Boolean hipotecado) {
		this.hipotecado = hipotecado;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Jugadores getPropietario() {
		return id_jugador;
	}

	public void setPropietario(Jugadores propietario) {
		this.id_jugador = propietario;
	}

		public Colores getColor() {
		return this.color;
	}

	public void setColor(Colores Color) {
		this.color = Color;
	}

	/*	public Colores getColor() {
		return color;
	}

	public void setColor(Colores color) {
		this.color = color;
	}
*/
	@Override
	public String toString() {
		return "Propiedad [id=" + id_propiedad + ", nom=" + nom + ", precio=" + precio + ", alquiler=" + alquiler
				+ ", alquiler1=" + alquiler1 + ", alquiler2=" + alquiler2 + ", alquiler3=" + alquiler3 + ", alquiler4="
				+ alquiler4 + ", alquilerHotel=" + alquilerHotel + ", precio_casa=" + precio_casa + ", n_casas="
				+ n_casas + ", precio_hipoteca=" + precio_hipoteca + ", hipotecado=" + hipotecado + ", posicion="
				+ posicion + ", propietario=" + id_jugador + "]";
	}

}
