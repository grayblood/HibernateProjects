package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Model.Jugador;
import Model.Monstre;
import Model.Partida;
import Util.MonstresNames;

public class PartidaDao extends GenericDao<Model.Partida, Integer> implements IPartidaDao {

	// Es tiren els daus de manera aleat�ria. El resultat de les diverses tirades es
	// retorna amb una llista.

	public List<Integer> roll() {
		List<Integer> rolls = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int r = random.nextInt(6 + 1 - 1) + 1;
			rolls.add(r);
		}
		System.out.println(rolls);
		return rolls;
	}

	// Resolt la tirada de daus. Afegeix energia, punts de vida i punts de victoria
	// al jugador. I tamb� resta als altres jugadors s�elimina vida. En el cas que
	// s�elimini vida al monstre que est� a Tokio aquest pot decidir de manera
	// aleat�ria si sortir de Tokio i posar el monstre actual.
	public void SolveRoll(MonstreDao mDao, Jugador jugador, List<Integer> roll, Partida partida) {
		int uno = 0;
		int dos = 0;
		int tres = 0;
		int cuatro = 0;
		int cinco = 0;
		int seis = 0;
		for (Integer result : roll) {
			switch (result) {
			case 1:
				uno++;
				break;
			case 2:
				dos++;
				break;
			case 3:
				tres++;
				break;
			case 4:
				cuatro++;
				break;
			case 5:
				cinco++;
				break;
			case 6:
				seis++;
				break;
			default:
				System.out.println("ERROOOOOOOOOOOOOR");
			}
		}
		Monstre monstre = mDao.MonstreJugador(jugador, partida);
		System.out.println(monstre);
		if (monstre != null) {
			monstre.setEnergia(monstre.getEnergia() + cuatro);
			// Assignar vida si no esta en tokio
			if (!monstre.getOn_Tokio()) {
				int vida = monstre.getVida() + seis;
				if (vida <= 50) {
					monstre.setVida(vida);
				} else if (vida > 50) {
					monstre.setVida(50);
				}

				if (cinco != 0) {
					if (mDao.HiHaMonstreTokio(partida)) {
						Monstre ontoki = mDao.GetMonstreTokio(partida);
						ontoki.setVida(mDao.GetMonstreTokio(partida).getVida() - cinco);
						System.out.println("MAking damage to " + ontoki.getNom() + " with " + cinco);
						mDao.Update(ontoki);
						Random rand = new Random();
						Boolean res = rand.nextBoolean();
						if (res) {
							ontoki.setOn_Tokio(false);
							mDao.Update(ontoki);
							monstre.setOn_Tokio(true);
						}
					}

				}

				mDao.Update(monstre);
			} else if (monstre.getOn_Tokio()) {
				for (Monstre m : mDao.ListMostresVius(partida)) {
					if (m.getId_Jugador() != jugador) {
						m.setVida(m.getVida() - cinco);
						mDao.Update(m);
					}

				}
			}

			// Assignar punts de victoria
			uno -= 3;
			dos -= 3;
			tres -= 3;
			if (uno >= 0) {
				monstre.setPunts_Victoria(monstre.getPunts_Victoria() + uno + 1);
			}
			if (dos >= 0) {
				monstre.setPunts_Victoria(monstre.getPunts_Victoria() + dos + 2);
			}
			if (dos >= 0) {
				monstre.setPunts_Victoria(monstre.getPunts_Victoria() + tres + 3);
			}
			mDao.Update(monstre);
		}
	}

	public int assignarTorn(Partida partida, int torn, int maxplayers) {
		if (torn >= maxplayers) {
			torn = 0;
		}
		partida.setTorn(torn);
		Update(partida);
		return torn;
	}

	public Monstre getRandomMonstrePoder(Monstre m, Partida partida) {
		Random rand = new Random();
		int a = rand.nextInt(4) + 1;
		if (a == 1) {
			m.setNom(MonstresNames.AlientoFlamigero);
			return m;
		} else if (a == 2) {
			m.setNom(MonstresNames.Mimetismo);
			return m;

		} else if (a == 3) {
			m.setNom(MonstresNames.MonstruoConRayoReductor);
			return m;
		} else if (a == 4) {
			m.setNom(MonstresNames.MonstruoEscupidosDeVeneno);
			return m;
		} else {
			return null;
		}
	}

}
