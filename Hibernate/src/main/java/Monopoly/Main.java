package Monopoly;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

//aa
public class Main {

	static Propiedades propiedad;
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// exception handling omitted for brevityaa

			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		/// abrimos sesion. Eso se hace siempre
		try {

			session = getSessionFactory().openSession();

			// abrimos PRIMERA transaccion. Eso se hace siempre.
			session.beginTransaction();
			Jugadores uno = new Jugadores("Morshu1", 1, 0, 420, 0, 0, null);
			Jugadores dos = new Jugadores("Morshu2", 1, 0, 420, 0, 0, null);
			Jugadores tres = new Jugadores("Morshu3", 1, 0, 420, 0, 0, null);
			Jugadores quatro = new Jugadores("Morshu4", 1, 0, 420, 0, 0, null);
			uno.setPropiedad(new HashSet<Propiedades>());
			dos.setPropiedad(new HashSet<Propiedades>());
			tres.setPropiedad(new HashSet<Propiedades>());
			quatro.setPropiedad(new HashSet<Propiedades>());
			session.saveOrUpdate(uno);
			session.saveOrUpdate(dos);
			session.saveOrUpdate(tres);
			session.saveOrUpdate(quatro);

			session.getTransaction().commit();

			session.beginTransaction();

			Colores R = new Colores("Rojo");
			session.saveOrUpdate(R);
			Colores A = new Colores("Azul");
			session.saveOrUpdate(A);
			Colores V = new Colores("Verde");
			session.saveOrUpdate(V);
			Colores AM = new Colores("Amarillo");
			session.saveOrUpdate(AM);
			Colores Blanco = new Colores("Blanco");
			session.saveOrUpdate(Blanco);

			session.getTransaction().commit();

			session.beginTransaction();

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
			a.setHipotecado(false);
			a.setPosicion(1);
			a.setColor(R);
			session.saveOrUpdate(a);

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
			b.setHipotecado(false);
			b.setPosicion(2);
			b.setColor(A);
			session.saveOrUpdate(b);

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
			c.setHipotecado(false);
			c.setPosicion(3);
			c.setColor(V);
			session.saveOrUpdate(c);

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
			d.setHipotecado(false);
			d.setPosicion(4);
			d.setColor(AM);
			session.saveOrUpdate(d);

			// pruebas

			Propiedades P = new Propiedades();
			P.setNom("PlazaPrueba");
			P.setPrecio(200);
			P.setAlquiler(200);
			P.setAlquiler1(250);
			P.setAlquiler2(300);
			P.setAlquiler3(500);
			P.setAlquiler4(750);
			P.setAlquilerHotel(1000);
			P.setN_casas(0);
			P.setPrecio_hipoteca(200);
			P.setHipotecado(false);
			P.setPosicion(6);
			P.setColor(R);
			session.saveOrUpdate(P);

			session.getTransaction().commit();

			session.beginTransaction();

			// ferrocarriles

			Ferrocarriles f1 = new Ferrocarriles();
			f1.setNom("Via1");
			f1.setPrecio(100);
			f1.setColor(Blanco);
			f1.setPosicion(5);
			session.saveOrUpdate(f1);

			Ferrocarriles f2 = new Ferrocarriles();
			f2.setNom("via2");
			f2.setPrecio(100);
			f2.setColor(Blanco);
			f2.setPosicion(15);
			session.saveOrUpdate(f2);

			Ferrocarriles f3 = new Ferrocarriles();
			f3.setNom("Via3");
			f3.setPrecio(100);
			f3.setColor(Blanco);
			f3.setPosicion(25);
			session.saveOrUpdate(f3);

			Ferrocarriles f4 = new Ferrocarriles();

			f4.setNom("Via4");
			f4.setPrecio(100);
			f4.setColor(Blanco);
			f4.setPosicion(35);
			session.saveOrUpdate(f4);

			f1.setVecinos(new HashSet<Ferrocarriles>());
			f2.setVecinos(new HashSet<Ferrocarriles>());
			f3.setVecinos(new HashSet<Ferrocarriles>());
			f4.setVecinos(new HashSet<Ferrocarriles>());

			session.saveOrUpdate(f1);
			session.saveOrUpdate(f3);
			Set<Ferrocarriles> B = f2.getVecinos();
			B.add(f1);
			B.add(f3);
			f2.setVecinode(B);

			Set<Ferrocarriles> D = f4.getVecinos();
			D.add(f1);
			D.add(f3);
			f4.setVecinode(D);

			session.saveOrUpdate(f2);

			session.saveOrUpdate(f4);
			
			session.getTransaction().commit();

			session.beginTransaction();

			comprarpropiedad(uno, a);
			session.getTransaction().commit();

			System.out.println("todo ha salido a pedir de Milhouse");
		} catch (

		Exception sqlException) {
			sqlException.printStackTrace();
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public static void comprarpropiedad(Jugadores juga, Propiedades propi) {

		if (juga.getDinero() >= propi.getPrecio()) {
			juga.setDinero(juga.getDinero() - propi.getPrecio());
			juga.setNumPropiedades(juga.getNumPropiedades() + 1);

			Set<Propiedades> D = juga.getPropiedad();
			D.add(propi);

			juga.setPropiedad(D);

			session.saveOrUpdate(juga);
			propi.setPropietario(juga);
			session.saveOrUpdate(propi);
		}

	}

}
