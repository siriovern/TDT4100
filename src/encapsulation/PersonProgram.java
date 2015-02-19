package encapsulation;

import java.util.Date;

public class PersonProgram {
	
	public static void main (String[] args) {
		Person person = new Person();
		Date birthday = new Date(90, 12, 1);
		
		person.setName("Siri Overn");
		person.setEmail("siri.overn@gmail.com");
		person.setBirthday(birthday);
		person.setGender('F');
		
		System.out.println("Name: " +person.getName());
		System.out.println("Mail: " +person.getEmail());
		System.out.println("Birthday: " +person.getBirthday());
		System.out.println("Gender: " +person.getGender());
		
	}

}
