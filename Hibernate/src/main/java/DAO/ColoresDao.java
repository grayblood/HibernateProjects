package DAO;

import Monopoly.Colores;
import Monopoly.Jugadores;
import Monopoly.Propiedades;
import Monopoly.Ferrocarriles;

public class ColoresDao extends GenericDao<Monopoly.Colores, Integer> implements IColoresDao{

	@Override
	public boolean ComprovarColor(Propiedades p) {
		Colores c = p.getColor();
		Jugadores j = p.getPropietario();
		boolean flag = true;
		for (Propiedades propi : c.getPropiedades()) {
			if(!propi.getPropietario().equals(j)) {
				flag=false;
		}
}
		return flag;
	}

	


}
