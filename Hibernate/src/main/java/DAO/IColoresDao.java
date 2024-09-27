package DAO;

import Monopoly.Propiedades;

public interface IColoresDao extends IGenericDao<Monopoly.Colores,Integer>{

public boolean ComprovarColor(Propiedades p);

}