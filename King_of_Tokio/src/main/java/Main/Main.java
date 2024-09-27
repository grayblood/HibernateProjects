package Main;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Session;

import Dao.JugadorDao;
import Dao.MonstreDao;
import Dao.PartidaDao;
import Model.Jugador;
import Model.Monstre;
import Model.Partida;
import Util.MonstresNames;
import Util.Utils;

public class Main {
	static Session session;

	public static void main(String[] args) {
		session = Utils.getSessionFactory().openSession();

		JugadorDao jugadorDao = new JugadorDao();
		PartidaDao partidaDao = new PartidaDao();
		MonstreDao monstreDao = new MonstreDao();
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		Boolean end = true;
		controller.StartSimulationAuto();
		while (!end) {
			System.out.println("BENVINGUT A KING OF TOKIO");
			System.out.println("POSA EL NUMERO DE LA OPCIÓ DESITJADA");
			System.out.println("-------------------------------");
			System.out.println("1.- SetMonstreTokioAleatori");
			System.out.println("2.- ListMonstresVius");
			System.out.println("3.- ActualitzarMonstresVius");
			System.out.println("4.- INICIAR otra vez una partida");
			System.out.println("0.- Salir");
			int i = sc.nextInt();
			switch (i) {

			case 1:
				controller.asterisco1();
				break;
			case 2:
				controller.asterisco2();
				break;
			case 3:
				controller.asterisco3();
				break;
			case 4:
				controller.StartSimulationAuto();
				break;
			case 0:
				end = true;
				break;
			default:
				System.out.println("NO HAS SELECCIONAT CAP OPCIÓ VALIDA");
				break;
			}
			System.out.println("Salio a pedir de milhouse");
		}
		System.out.println("Adios");

	}
}
