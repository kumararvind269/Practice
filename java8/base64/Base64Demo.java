package java8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Demo {
	public static void main(String args[]) {

		try {

			String name = "Arvind";

			String base64SimpleEncode = Base64.getEncoder().encodeToString(name.getBytes("utf-8"));
			System.out.println("Base64 Encoded String-Basic :" + base64SimpleEncode);
			byte[] base64decodedBytes = Base64.getDecoder().decode(base64SimpleEncode);
			System.out.println("Original String: " + new String(base64decodedBytes,"utf-8"));

			String  base64UrlEncode = Base64.getUrlEncoder().encodeToString(name.getBytes("utf-8"));
			System.out.println("Base64 Encoded String (URL) :" + base64UrlEncode);


			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);

		} catch(UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}



}
