package DAO;

import Monopoly.Colores;
import Monopoly.Jugadores;
import Monopoly.Propiedades;
import Monopoly.Ferrocarriles;

public interface IPropiedadesDao extends IGenericDao<Propiedades,Integer>{


public Jugadores ComprovarPropietari(Propiedades p);
public boolean Comprar(Jugadores j, Propiedades p);
public void Reassignar(Jugadores j, Propiedades p);
public int Edificar(Jugadores j, Propiedades p);
public boolean Hipotecar(Jugadores j, Propiedades p);
public boolean DesHipotecar(Jugadores j, Propiedades p);
}
