package DAO;


import java.util.Set;

import Monopoly.Ferrocarriles;

public class FerrocarrilesDao extends GenericDao<Monopoly.Ferrocarriles, Integer> implements IFerrocarrilesDao{

	@Override
	public Set<Ferrocarriles> ferrocarrilsVeins(Ferrocarriles f) {

		return f.getVecinos();
	}

    @Override
    public boolean isFerrocarrilVei(Ferrocarriles f,Ferrocarriles f2){
        for (Ferrocarriles ferro : f.getVecinos()) {
            if(ferro.equals(f2)){
                return true;
            }
        }

        return false;
    }

}
