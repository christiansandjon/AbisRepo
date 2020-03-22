package be.abis.ex.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

@Named
public class AgeList {

	private List<Integer> ages;

	
	
	public AgeList() {
		this.ages = new ArrayList<>();
		for (int i = 18; i<=85; i++){
			ages.add(i);
		}
		System.out.println(ages);
	}

	public List<Integer> getAges() {
		
		return ages;
	}

	public void setAges(List<Integer> ages) {
		this.ages = ages;
	}

}
