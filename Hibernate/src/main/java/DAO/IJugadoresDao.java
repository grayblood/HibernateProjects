package DAO;

import Monopoly.Jugadores;
import Monopoly.Propiedades;
import Monopoly.Ferrocarriles;

public interface IJugadoresDao extends IGenericDao<Monopoly.Jugadores, Integer> {

	Boolean PagarLloguer(Jugadores a, Propiedades b);
	public void modificarDiners(Jugadores j, int i);
	public void transportFerrocarril(Jugadores j, Ferrocarriles f);
}
