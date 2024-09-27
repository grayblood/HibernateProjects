package DAO;

import java.util.List;

import Monopoly.Colores;
import Monopoly.Jugadores;
import Monopoly.Propiedades;
import Monopoly.Ferrocarriles;
import Monopoly.Main;

public class PropiedadesDao extends GenericDao<Monopoly.Propiedades, Integer> implements IPropiedadesDao {

	
	@Override
	public Jugadores ComprovarPropietari(Propiedades p) {

		return p.getPropietario();

	}
	
	@Override
	public boolean Comprar(Jugadores j, Propiedades p){
		
		if(j.getDinero() >= p.getPrecio()){
			
		p.setPropietario(j);
		//
		return true;
		}else{
		return false;
		}
	}

	  
		
	@Override
	public void Reassignar(Jugadores j, Propiedades p) {
		p.setPropietario(j);
	}

	@Override
	public int Edificar(Jugadores j, Propiedades p){

		if(j.getDinero() >= p.getPrecio_casa()){
			p.setN_casas(p.getN_casas()+1);
			return p.getN_casas();
		}else{
		return p.getN_casas();
		}
	}
	/*
	 * public String getSaborFromID(Integer id) { return
	 * this.get(id).getPropietario(); }
	 */
	@Override
	public boolean Hipotecar(Jugadores j, Propiedades p) {
		if(!p.isHipotecado()){
			p.setHipotecado(true);
			j.setDinero(j.getDinero()+p.getPrecio_hipoteca());
			return true;
		}else{
		return false;
		}
	}
	@Override
	public boolean DesHipotecar(Jugadores j, Propiedades p) {
		if(p.isHipotecado() && j.getDinero() >= p.getPrecio_hipoteca()){
			p.setHipotecado(false);
			j.setDinero(j.getDinero()-p.getPrecio_hipoteca());
			return true;
		}else{
		return false;
		}
	}
		

}
