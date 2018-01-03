package test;

public class Address {
	
	private String name;
	private int score;
	
	public Address(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", score=" + score + "]";
	}
	
}
