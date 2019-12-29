package peluqueria.cuentas.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS_T")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String mail;
	private int number;
	
	protected User () {
		this.name = "";
		this.mail = "";
		this.number = 0;
	}
	public User(final String name) {
		this.name = name;
		this.mail = "";
		this.number = 0;
	}
	public User(final String name, final int number) {
		this.name = name;
		this.number = number;
		this.mail = "";
	}
	
	public User(final String name, final String mail) {
		this.name = name;
		this.mail = mail;
		this.number = -1;
	}
	
	public User(final String name, final String mail, final int number) {
		this.name = name;
		this.mail = mail;
		this.number = number;
	}
	
	public void changeName(final String name) {
		assert name != null;
		this.name = name;
	}
	public void changeMail(final String mail) {
		assert mail != null;
		this.mail = mail;
	}
	public void changeNumber(final int number) {
		verifyNumber(number);
		this.number = number;
	}
	
	public String getName() {
		return this.name;
	}
	public String getMail() {
		return this.mail;
	}
	public int getNumber() {
		return this.number;
	}
	
	protected boolean verifyNumber(int number) {
		final int PHONE_NUMBER_SIZE = 9;
		return (numberSize(number) == PHONE_NUMBER_SIZE && numberValidStart(number));
	}
	
	private int numberSize(int number) {
		if(number < 10)
			return 1;
		else 
			return 1 + numberSize(number/10);
	}
	
	private boolean numberValidStart(int number) {
		if(number < 10) 
			return (number == 6 || number == 7);	
		else 
			return numberValidStart(number/10);
	}
	
	protected boolean verifyMail(String mail) {
		//pattern matching <any_string>@<anyString>
		String mailRegExp = "^(.+)@(.+)$";
		
		Pattern pattern = Pattern.compile(mailRegExp);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}
}

