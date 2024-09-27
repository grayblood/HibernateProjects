package DAO;

import Monopoly.Jugadores;
import Monopoly.Propiedades;
import Monopoly.Ferrocarriles;

public class JugadoresDao extends GenericDao<Monopoly.Jugadores, Integer> implements IJugadoresDao{



	@Override
	public Boolean PagarLloguer(Jugadores a, Propiedades b) {
		int apagar = b.getAlquiler();
		if (a.getDinero() >= apagar) {
			System.out.print(a.getDinero() + " - ");
			modificarDiners(a,-apagar);
			System.out.print(apagar + " = ");
			System.out.println(a.getDinero());	
			modificarDiners(b.getPropietario(),apagar);
			return true;
		}
		else {
			return false;
		}
		
		
	}


    @Override
	public void modificarDiners(Jugadores j, int i) {
		j.setDinero(j.getDinero() + i);
		this.saveOrUpdate(j);
	}
	
	@Override
	public void transportFerrocarril(Jugadores j, Ferrocarriles f){
		
		for (Propiedades propiedad : j.getPropiedad()) {
			if(j.getCasilla() == propiedad.getId()){
				if(f.getPropietario().equals(j)){
					j.setCasilla(f.getId());
				}
			}
		}
			System.out.println("ERROR - No estas en una casilla de ferrocarril o no eres el propietario de esta estación.");
		
	}
	

}
