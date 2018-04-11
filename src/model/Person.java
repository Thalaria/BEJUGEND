package model;

public class Person {

	private String vorname;
	private String nachname;
	
	// Constructors
	
	public Person() {
	}
	
	public Person(String vorname, String nachname) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		
	}	
	
	// Getter & setter

	public String getNachname() {
		
		return nachname;
		
	}
	
	public String getVorname() {
		
		return vorname;
		
	}
	
	public void setNachname(String nachname) {
		
		this.nachname = nachname;
		
	}
	
	public void setVorname(String vorname) {
		
		this.vorname = vorname;
		
	}
	
	// Methods
	
	@Override
	public String toString() {
		
		return "Person: " + vorname + " " + nachname;
		
	}
	
	@Override
	public boolean equals(Object o1) {
		
		if (o1 instanceof Person) {
			
			Person p2 = (Person) o1;
			
			if (this.getNachname().equals(p2.getNachname()) && this.getVorname().equals(p2.getVorname())) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
}
