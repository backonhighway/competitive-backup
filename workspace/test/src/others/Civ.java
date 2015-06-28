package others;

import java.util.ArrayList;
import java.util.List;

public class Civ {
	
	public enum Civlist {
		America(true),
		Arabia(false),
		Aztec(true),
		China(true),
		Egypt(true),
		Britain(false),
		France(false),
		Germany(true),
		Greece(false),
		India(false),
		Iroquois(true),
		Japan(false),
		Turks(true),
		Persia(false),
		Rome(false),
		Russia(false),
		Siam(true),
		Songhai(true),
		Babylon(false),
		Mongol(true),
		Inca(true),
		Polynesia(true),
		Denmark(true),
		Austria(true),
		Byzantine(true),
		Carthage(true),
		Celt(true),
		Ethiopia(true),
		Huns(false),
		Maya(false),
		Holland(true),
		Spain(false),
		Sweden(false);
		
		private Civlist(boolean played){
			this.played = played;
		}
		
		private boolean played;
		
	}
	
	public static void main(String[] args){
		int sum = 0;
		int notplayed = 0;
		List<Civlist> list = new ArrayList<>();
		for(Civlist civ : Civlist.values()){
			sum++;
			if(!civ.played){
				notplayed++;
				list.add(civ);
			}
		}
		
		System.out.println(notplayed + "/" + sum);
		

		int rand = (int) (Math.random() * notplayed) + 1;
		
		System.out.println(list.get(rand).name());
		
		
	}
	


}
