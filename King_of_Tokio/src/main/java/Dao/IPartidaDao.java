package Dao;

import java.util.List;

import Model.Jugador;
import Model.Partida;

public interface IPartidaDao extends IGenericDao<Model.Partida, Integer> {

		public List<Integer> roll();
		public void SolveRoll(MonstreDao mDao, Jugador jugador, List<Integer> roll, Partida partida);
}