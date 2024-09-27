package DAO;

import java.util.Set;

import Monopoly.Ferrocarriles;

public interface IFerrocarrilesDao extends IGenericDao<Monopoly.Ferrocarriles,Integer>{

public Set<Ferrocarriles> ferrocarrilsVeins(Ferrocarriles f);
public boolean isFerrocarrilVei(Ferrocarriles f, Ferrocarriles f2);
}
