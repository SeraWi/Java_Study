package work0601_Collection;

import java.util.*;

public class FootballPlayer implements Comparable<FootballPlayer> {
	
	String name;
	int number;
	String team;
	int age;
	
	FootballPlayer(String name, int number, String team, int age){
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}


	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer p = (FootballPlayer) obj;
			if(this.team.equals(p.team)&&
					this.name.equals(p.name)&&
						this.age == p.age) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		return age % 10;
	}
	
	@Override
	public int compareTo(FootballPlayer o) {
		int result = this.team.compareTo(o.team);
		if(result == 0) {
			result = this.name.compareTo(o.name);
			if(result == 0) {
				result = this.number - o.number;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		List<FootballPlayer> players = new ArrayList<>();
		players.add(new FootballPlayer("Son1", 1 ,"Tot", 27));
		players.add(new FootballPlayer("Son2", 8 ,"Tot", 20));
		players.add(new FootballPlayer("Son1", 9 ,"Tot", 27));
		players.add(new FootballPlayer("Park1", 7 ,"Man", 25));
		players.add(new FootballPlayer("Park2", 11 ,"Man", 30));
		System.out.println("저장 데이터 개수: "+ players.size());
		Iterator<FootballPlayer> itr = players.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("--------------------------------------");
		
		Set<FootballPlayer> players2 = new HashSet<>();
		
		players2.add(new FootballPlayer("Son1", 1 ,"Tot", 27));
		players2.add(new FootballPlayer("Son1", 9 ,"Tot", 27));
		players2.add(new FootballPlayer("Son2", 8 ,"Tot", 20));
		players2.add(new FootballPlayer("Son2", 9 ,"Tot", 20));
		
		players2.add(new FootballPlayer("Park1", 7 ,"Man", 25));
		players2.add(new FootballPlayer("Park2", 11 ,"Man", 30));
		System.out.println("저장 데이터 개수: "+ players2.size());
		Iterator<FootballPlayer> itr2 = players2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		System.out.println("--------------------------------------");
		
		TreeSet<FootballPlayer> players3 = new TreeSet<>();
		players3.add(new FootballPlayer("A1", 1 ,"Tot", 27));
		players3.add(new FootballPlayer("A1", 9 ,"Tot", 27));
		players3.add(new FootballPlayer("F2", 9 ,"Tot", 20));
		players3.add(new FootballPlayer("C2", 8 ,"Tot", 20));
		
		players3.add(new FootballPlayer("Park1", 7 ,"Man", 25));
		players3.add(new FootballPlayer("Park2", 11 ,"Man", 30));
		
		
		Iterator<FootballPlayer> itr3 = players3.iterator();
		while(itr3.hasNext()) {
			System.out.println(itr3.next());
		}
		System.out.println("---------------------------------------------");
		
		Map<Integer, FootballPlayer> players4 = new HashMap<>();
		
		players4.put( 20, new FootballPlayer("A1", 1 ,"Tot", 27));
		players4.put( 15, new FootballPlayer("A1", 1 ,"Tot", 27));
		players4.put( 1, new FootballPlayer("A1", 1 ,"Tot", 27));
		players4.put( 7, new FootballPlayer("A1", 1 ,"Tot", 27));
		
		Set<Integer> set = players4.keySet();
		Iterator<Integer> itr4 = set.iterator();
		
		while(itr4.hasNext()) {
			System.out.println(players4.get(itr4.next()));
		}
		
		

	}

	

}
