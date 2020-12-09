package triLazy;


import java.security.Key;


import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


 


public class MiCrypto {

	private static final String ALGO = "AES";
	private byte[] keyValue;
	
	
	
	public MiCrypto(String key) {
		this.keyValue = key.getBytes();
	}
	
	
	
	public String encriptar(String data) throws Exception {
	    
		Key clave = generateKey();
	    Cipher ci = Cipher.getInstance(ALGO);
	    ci.init(Cipher.ENCRYPT_MODE, clave);
	    byte[] encryptedBytes = ci.doFinal(data.getBytes());	//este comando es el que encripta 
	    
	    Encoder encoder = Base64.getEncoder();
	    String encryptedString = encoder.encodeToString(encryptedBytes);
	    return encryptedString;
	}
	

	
	
	public String desencriptar(String data) throws Exception {
	    

		Key key = generateKey();
		Cipher ci = Cipher.getInstance(ALGO);
		ci.init(Cipher.DECRYPT_MODE, key);

		 Decoder decoder = Base64.getDecoder();

		
		byte[] encryptedBytes = decoder.decode(data);	//pasa el string codificado a bytes
		byte[] decryptedBytes = ci.doFinal(encryptedBytes);
		String decryptedString = new String(decryptedBytes);
			
		return decryptedString;
	}
	
	
	
	private Key generateKey() throws Exception {
		
		Key key = new SecretKeySpec( this.keyValue, ALGO); //he Algor lo pongo sin this. porque es static, pero he visto que keyValue tambien puedo, por no salirme del tono del codigo seguire usando this.algo en esta practica
		return key;
		
		
		
	}
	
}
