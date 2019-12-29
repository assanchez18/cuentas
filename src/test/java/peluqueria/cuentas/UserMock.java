package peluqueria.cuentas;
import peluqueria.cuentas.Data.User;

public class UserMock extends User {
	
	public UserMock() {
		super();
	}
	
	public UserMock mail(String mail) {
		changeMail(mail);
		return this;
	}
	
	public UserMock number(int number) {
		changeNumber(number);
		return this;
	}
	
	public boolean verifyNumber() {
		return this.verifyNumber(getNumber());
	}
	
	public boolean verifyMail() {
		return this.verifyMail(getMail());
	}
}
