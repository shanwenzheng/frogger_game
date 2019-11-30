package frogger.util;

import java.util.ArrayList;
import frogger.model.actor.staticActor.End;

public enum EndDetecter {
	INSTANCE;
	
    public boolean checkEndActivited(ArrayList<End> ends) {
  	  for(int i = 0; i < ends.size(); i++) {
  		  if (!ends.get(i).isActivated()) {return false;}
  	  }
  	  return true;
    }
}
