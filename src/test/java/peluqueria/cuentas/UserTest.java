package peluqueria.cuentas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UserTest { 

	private UserMock user;
	
	@Before
	public void createUser() {
		this.user = new UserMock();
	}
	
	@Test
	public void verifyPhoneNumber() {
		
		//valid Number
		user.number(600000000);
		assertTrue("Number " + user.getNumber() + " is not valid", user.verifyNumber());
		user.number(700000000);
		assertTrue("Number " + user.getNumber() + " is not valid", user.verifyNumber());
		
		//Wrong start
		user.number(800000000);
		assertFalse("Number " + user.getNumber() + " is valid and should be not!", user.verifyNumber());
		user.number(000000000);
		assertFalse("Number " + user.getNumber() + " is valid and should be not!", user.verifyNumber());
		
		//Negative number
		user.number(-600000000);
		assertFalse("Number " + user.getNumber() + " is valid and should be not!", user.verifyNumber());
		
		//Short number
		user.number(60000000);
		assertFalse("Number " + user.getNumber() + " is valid and should be not!", user.verifyNumber());
	
	}
	
	@Test
	public void verifyMail() {
		UserMock user = new UserMock();
		
		//Valid mail
		user.mail("aaaa@b.com");
		assertTrue("Mail " + user.getMail() + " is not valid", user.verifyMail());
		user.mail("a_a.a1*@b_b.b.com");
		assertTrue("Mail " + user.getMail() + " is not valid", user.verifyMail());
		
		//Invalid mail
		user.mail("a_a.a1*b_b.b.com");
		assertFalse("Mail " + user.getMail() + " is not valid", user.verifyMail());
		user.mail("a_a.a1*b_b.b");
		assertFalse("Mail " + user.getMail() + " is not valid", user.verifyMail());
		user.mail("a_a.a1*b_b.b@");
		assertFalse("Mail " + user.getMail() + " is not valid", user.verifyMail());
		user.mail("@a_a.a1*b_b.b");
		assertFalse("Mail " + user.getMail() + " is not valid", user.verifyMail());
	}
}
