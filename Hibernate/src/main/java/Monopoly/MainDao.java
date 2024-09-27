package Monopoly;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Random;

import DAO.ColoresDao;
import DAO.FerrocarrilesDao;
import DAO.JugadoresDao;
import DAO.PropiedadesDao;

public class MainDao {
	public static void main(String[] args) {

		PropiedadesDao PropiedadDao = new PropiedadesDao();
		ColoresDao ColorDao = new ColoresDao();
		JugadoresDao JugadorDao = new JugadoresDao();
		FerrocarrilesDao FerrocarrilDao = new FerrocarrilesDao();

		// jugadores
		Jugadores uno = new Jugadores("Morshu1", 1, 0, 420, 0, 0, null);
		Jugadores dos = new Jugadores("Morshu2", 1, 0, 420, 0, 0, null);
		Jugadores tres = new Jugadores("Morshu3", 1, 0, 420, 0, 0, null);
		Jugadores quatro = new Jugadores("Morshu4", 1, 0, 420, 0, 0, null);
		uno.setPropiedad(new HashSet<Propiedades>());
		dos.setPropiedad(new HashSet<Propiedades>());
		tres.setPropiedad(new HashSet<Propiedades>());
		quatro.setPropiedad(new HashSet<Propiedades>());
		JugadorDao.saveOrUpdate(uno);
		JugadorDao.saveOrUpdate(dos);
		JugadorDao.saveOrUpdate(tres);
		JugadorDao.saveOrUpdate(quatro);

		// colores

		Colores R = new Colores("Rojo");
		ColorDao.saveOrUpdate(R);
		Colores A = new Colores("Azul");
		ColorDao.saveOrUpdate(A);
		Colores V = new Colores("Verde");
		ColorDao.saveOrUpdate(V);
		Colores AM = new Colores("Amarillo");
		ColorDao.saveOrUpdate(AM);
		Colores Blanco = new Colores("Blanco");
		ColorDao.saveOrUpdate(Blanco);

		// propiedades

		Propiedades a = new Propiedades();
		a.setNom("Plaza1");
		a.setPrecio(200);
		a.setAlquiler(200);
		a.setAlquiler1(250);
		a.setAlquiler2(300);
		a.setAlquiler3(500);
		a.setAlquiler4(750);
		a.setAlquilerHotel(1000);
		a.setN_casas(0);
		a.setPrecio_hipoteca(200);
		a.setPosicion(1);
		a.setColor(R);

		PropiedadDao.saveOrUpdate(a);

		Propiedades b = new Propiedades();
		b.setNom("Plaza2");
		b.setPrecio(200);
		b.setAlquiler(200);
		b.setAlquiler1(250);
		b.setAlquiler2(300);
		b.setAlquiler3(500);
		b.setAlquiler4(750);
		b.setAlquilerHotel(1000);
		b.setN_casas(0);
		b.setPrecio_hipoteca(200);
		b.setPosicion(2);
		b.setColor(R);
		PropiedadDao.saveOrUpdate(b);

		Propiedades c = new Propiedades();
		c.setNom("Plaza3");
		c.setPrecio(200);
		c.setAlquiler(200);
		c.setAlquiler1(250);
		c.setAlquiler2(300);
		c.setAlquiler3(500);
		c.setAlquiler4(750);
		c.setAlquilerHotel(1000);
		c.setN_casas(0);
		c.setPrecio_hipoteca(200);
		c.setPosicion(3);
		c.setColor(V);
		PropiedadDao.saveOrUpdate(c);

		Propiedades d = new Propiedades();
		d.setNom("Plaza4");
		d.setPrecio(200);
		d.setAlquiler(200);
		d.setAlquiler1(250);
		d.setAlquiler2(300);
		d.setAlquiler3(500);
		d.setAlquiler4(750);
		d.setAlquilerHotel(1000);
		d.setN_casas(0);
		d.setPrecio_hipoteca(200);
		d.setPosicion(4);
		d.setColor(AM);
		PropiedadDao.saveOrUpdate(d);

		// pruebas

		Propiedades P = new Propiedades();
		P.setNom("Plazaprueba");
		P.setPrecio(200);
		P.setAlquiler(200);
		P.setAlquiler1(250);
		P.setAlquiler2(300);
		P.setAlquiler3(500);
		P.setAlquiler4(750);
		P.setAlquilerHotel(1000);
		P.setN_casas(0);
		P.setPrecio_hipoteca(200);
		P.setPosicion(6);
		P.setColor(A);

		PropiedadDao.saveOrUpdate(P);

		// ferrocarriles

		Ferrocarriles f1 = new Ferrocarriles();
		f1.setNom("Via1");
		f1.setPrecio(100);
		f1.setColor(Blanco);
		f1.setPosicion(5);
		FerrocarrilDao.saveOrUpdate(f1);

		Ferrocarriles f2 = new Ferrocarriles();
		f2.setNom("via2");
		f2.setPrecio(100);
		f2.setColor(Blanco);
		f2.setPosicion(15);
		FerrocarrilDao.saveOrUpdate(f2);

		Ferrocarriles f3 = new Ferrocarriles();
		f3.setNom("Via3");
		f3.setPrecio(100);
		f3.setColor(Blanco);
		f3.setPosicion(25);
		FerrocarrilDao.saveOrUpdate(f3);

		Ferrocarriles f4 = new Ferrocarriles();

		f4.setNom("Via4");
		f4.setPrecio(100);
		f4.setColor(Blanco);
		f4.setPosicion(35);
		FerrocarrilDao.saveOrUpdate(f4);

		f1.setVecinos(new HashSet<Ferrocarriles>());
		f2.setVecinos(new HashSet<Ferrocarriles>());
		f3.setVecinos(new HashSet<Ferrocarriles>());
		f4.setVecinos(new HashSet<Ferrocarriles>());

		FerrocarrilDao.saveOrUpdate(f1);
		FerrocarrilDao.saveOrUpdate(f3);
		Set<Ferrocarriles> B = f2.getVecinos();
		B.add(f1);
		B.add(f3);
		f2.setVecinode(B);

		Set<Ferrocarriles> D = f4.getVecinos();
		D.add(f1);
		D.add(f3);
		f4.setVecinode(D);

		FerrocarrilDao.saveOrUpdate(f2);

		FerrocarrilDao.saveOrUpdate(f4);

		// Boolean pagat = JugadorDao.PagarLloguer(dos, P);

		// System.out.println(pagat);

		// -_______-______________-__________

		R.setPropiedades(new HashSet<Propiedades>());

		V.setPropiedades(new HashSet<Propiedades>());

		AM.setPropiedades(new HashSet<Propiedades>());

		A.setPropiedades(new HashSet<Propiedades>());

		Blanco.setPropiedades(new HashSet<Propiedades>());

		Set<Propiedades> R1 = R.getPropiedades();
		R1.add(a);
		R1.add(b);
		R.setPropiedades(R1);

		Set<Propiedades> V1 = V.getPropiedades();
		V1.add(c);
		V.setPropiedades(V1);

		Set<Propiedades> A1 = A.getPropiedades();
		A1.add(P);
		A.setPropiedades(A1);

		Set<Propiedades> AM1 = AM.getPropiedades();
		AM1.add(d);
		AM.setPropiedades(AM1);

		Set<Propiedades> B1 = Blanco.getPropiedades();
		B1.add(f1);
		B1.add(f1);
		Blanco.setPropiedades(B1);

		ColorDao.saveOrUpdate(R);
		ColorDao.saveOrUpdate(V);
		ColorDao.saveOrUpdate(AM);
		ColorDao.saveOrUpdate(A);
		ColorDao.saveOrUpdate(Blanco);
		System.out.println(R);

		comprarpropiedad(uno, a, JugadorDao, PropiedadDao);
	}

	public int Roll() {
		Random rnd = new Random();

		int DiceRoll = rnd.nextInt(6) + 1;

		return DiceRoll;
	}

	public static void comprarpropiedad(Jugadores juga, Propiedades propi, JugadoresDao JugadorDao,
			PropiedadesDao propiedadDao) {
		if (juga.getDinero() >= propi.getPrecio()) {
			juga.setDinero(juga.getDinero() - propi.getPrecio());
			juga.setNumPropiedades(juga.getNumPropiedades() + 1);

			Set<Propiedades> D = juga.getPropiedad();
			D.add(propi);

			juga.setPropiedad(D);

			JugadorDao.saveOrUpdate(juga);
			propi.setPropietario(juga);
			propiedadDao.saveOrUpdate(propi);
		}

	}

}
