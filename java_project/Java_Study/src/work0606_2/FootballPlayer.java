package work0606_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FootballPlayer implements Comparable <FootballPlayer> {
	String name;
	int number;
	String team;
	int age;
	
	//생성자
	public FootballPlayer(String name, int number, String team, int age) {
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
	public int hashCode() {
		return age%10;
	}

	@Override
	public boolean equals(Object obj) {
		//팀과 이름 나이가 같으면 같은 선수
		boolean chk = false;
		if( obj != null && obj instanceof FootballPlayer) {
			FootballPlayer p = (FootballPlayer) obj;
			if(this.team.equals(p.team) && this.name.equals(p.name)
					&& this.age == p.age) {
				chk = true;
			}
		}
		return chk;
	}
	
	
	@Override
	public int compareTo(FootballPlayer o) {
		//팀이름으로 정렬, 같은팀으면 이름순으로 , 그다음은 번호순으로 정렬
		int result = this.team.compareTo(o.team);
		
		if(result == 0) {
			result = this.name.compareTo(o.name);
			if(result == 0) {
				return this.number - o.number;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		List<FootballPlayer> players = new ArrayList<>();
		

		players.add(new FootballPlayer("Son1",1,"tot",27));
		players.add(new FootballPlayer("Son2",24,"tot",30));
		players.add(new FootballPlayer("Park1",31,"tot",34));
		players.add(new FootballPlayer("Park1",11,"tot",19));
		players.add(new FootballPlayer("Kim",10,"tot",21));
		System.out.println("입력데이터"+ players.size());
		Iterator<FootballPlayer> itr = players.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("---------------------------");
		
		Set<FootballPlayer> players2 = new HashSet<>();
	
		players2.add(new FootballPlayer("Son1",1,"tot",27));
		players2.add(new FootballPlayer("Son1",2,"tot",28));
		
		players2.add(new FootballPlayer("Son2",24,"tot",30));
		
		players2.add(new FootballPlayer("Park1",31,"tot",34));
		players2.add(new FootballPlayer("Park1",4,"tot",34));
		players2.add(new FootballPlayer("Park1",11,"tot",19));
		
		players2.add(new FootballPlayer("Kim",10,"tot",21));
		
		System.out.println("입력 데이터:"+ players.size());
		Iterator<FootballPlayer> itr2 = players2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		System.out.println("---------------------------------");
		
		Set<FootballPlayer> players3 = new TreeSet<>();
		
		players3.add(new FootballPlayer("Son1",1,"tot",27));
		players3.add(new FootballPlayer("Son1",2,"tot",27));
		players3.add(new FootballPlayer("Son1",11,"tot",27));
		
		players3.add(new FootballPlayer("Son2",24,"man",30));
		
		players3.add(new FootballPlayer("Park1",31,"man",34));
		players3.add(new FootballPlayer("Park1",4,"tot",34));
		players3.add(new FootballPlayer("Park1",11,"man",19));
		
		players3.add(new FootballPlayer("Kim",10,"tot",21));
		players3.add(new FootballPlayer("Kim",9,"man",25));
		
		Iterator<FootballPlayer> itr3 = players3.iterator();
		
		while(itr3.hasNext()) {
			System.out.println(itr3.next());
		}
		System.out.println("-----------------------------");
		
		HashMap<Integer, FootballPlayer> players4 = new HashMap<>();
		
		players4.put(10,new FootballPlayer("Tim", 7, "BBB" ,20));
		players4.put(1,new FootballPlayer("Lea", 1, "AAA" ,27));
		players4.put(7,new FootballPlayer("Tim", 7, "BBB" ,20));
		players4.put(3,new FootballPlayer("Smith", 15, "CCC" ,18));
		
		Set<Integer> set = players4.keySet();
		Iterator<Integer> itr4 = set.iterator();
		
		while(itr4.hasNext()) {
			System.out.println(players4.get(itr4.next()));
		}
		
	}

	
}
