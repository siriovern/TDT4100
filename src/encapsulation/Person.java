package encapsulation;

import java.util.Date;

public class Person {

	private String name;
	private String email;
	private Date birthday;
	private char sex;

	public boolean isAlpha(String name) {
		char[] chars = name.toCharArray();
		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}

	public void setName(String name) {
		String[] nameSplit = name.split(" ");
		String firstname = nameSplit[0];
		String surname = nameSplit[1];

		if (firstname.length() < 2 || surname.length() < 2) {
			throw new IllegalArgumentException(
					"Fornavn og/eller etternavn inneholder mindre enn 2 bokstaver");
		} else if (!(isAlpha(firstname) && isAlpha(surname))) {
			throw new IllegalArgumentException("navnet må inneholde bokstaver");
		} else if (nameSplit.length != 2) {
			throw new IllegalArgumentException("må inneholde både fornavn og etternavn");
		}else {
			this.name = name;
		}

	}

	public void setEmail(String email) {
		
		String mailName = getName();

		String[] nameSplit = mailName.split(" ");
		String firstname = nameSplit[0].toLowerCase();
		String surname = nameSplit[1].toLowerCase();

		String[] emailSplit = email.split("@");
		String emailName = emailSplit[0];
		String emailDomain = emailSplit[1];

		String[] emailNameSplit = emailName.split("\\.");
		String emailFirstname = emailNameSplit[0];
		String emailSurname = emailNameSplit[1];

		String[] emailDomainSplit = emailDomain.split("\\.");
		String emailCountry = emailDomainSplit[1];

		if (!(emailFirstname.equals(firstname))) {
			throw new IllegalStateException("Feil fornavn");
		} else if (!(emailSurname.equals(surname))) {
			throw new IllegalStateException("Feil etternavn");
		}else if (emailSplit.length != 2 || emailNameSplit.length != 2 || emailDomainSplit.length != 2){
			throw new IllegalArgumentException("Skriv mail-adresse på formen fornavn.etternavn@domene.landskode");
		}else if (emailCountry.length() != 2 || emailCountry.length() != 3) {
			throw new IllegalArgumentException("Ugyldig landskode");

		} else {
			this.email = email;
		}
	}

	public void setBirthday(Date birthday) {
		Date today = new Date();
		if (birthday.before(today)) {
			this.birthday = birthday;
		}
		else{
			throw new IllegalArgumentException("Feil dato");
		}
	}

	public void setGender(char sex) {
		if (!(sex == 'F' || sex == 'M' || sex == '\0')) {
			throw new IllegalArgumentException("Ugyldig");
		} else {
			this.sex = sex;
		}
	}

	public String getName() {
		return name;

	}

	public String getEmail() {
		return email;

	}

	public Date getBirthday() {
		return birthday;
	}

	public char getGender() {
		return sex;
	}
}
