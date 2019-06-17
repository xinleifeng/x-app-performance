package sap.crun.performance.api.util;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JwtGenerator {
	
	public static final String USER_NAME = "LogonName";
	
	private static final String IDENTITY_ZONE = "uaa";
	private static final String CLIENT_ID = "testClient";
	
	// return the JWT for the given scopes
	private String getToken(String... scopes) {
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root = mapper.createObjectNode();
		root.put("client_id", CLIENT_ID);
		root.put("exp", Integer.MAX_VALUE);
		root.set("scope", getScopesJSON(scopes));
		root.put("user_name", USER_NAME);
		root.put("user_id", "D012345");
		root.put("email", "testUser@testOrg");
		root.put("zid", IDENTITY_ZONE);
		root.put("grant_type", "");
		root.put("cid", "appName!t123");

		return getTokenForClaims(root.toString());
	}

	// return a value suitable for the HTTP "Authorization" header containing the
	// JWT with the given scopes
	public String getTokenForAuthorizationHeader(String... scopes) {
		return "Bearer " + getToken(scopes);
	}

	// convert Java array into JSON array
	private ArrayNode getScopesJSON(String[] scopes) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode scopesArray = mapper.createArrayNode();
		for (String scope : scopes) {
			scopesArray.add(scope);
		}
		return scopesArray;
	}

	// sign the claims and return the resulting JWT
	private String getTokenForClaims(String claims) {
		RsaSigner signer = new RsaSigner(readFromFile("/privateKey.txt"));
		return JwtHelper.encode(claims, signer).getEncoded();
	}

	public String getPublicKey() {
		String publicKey = readFromFile("/publicKey.txt");
		return removeLinebreaks(publicKey);
	}

	private String removeLinebreaks(String input) {
		return input.replace("\n", "").replace("\r", "");
	}

	private String readFromFile(String path) {
		try (InputStream is = getClass().getResourceAsStream(path)) {
			return IOUtils.toString(is, Charset.defaultCharset());
		} catch (Exception exception) {
			if(path.endsWith("publicKey.txt")) {
				return "-----BEGIN PUBLIC KEY-----\n" + 
						"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn5dYHyD/nn/Pl+/W8jNG\n" + 
						"WHDaNItXqPuEk/hiozcPF+9l3qEgpRZrMx5ya7UjGdvihidGFQ9+efgaaqCLbk+b\n" + 
						"BsbU5L4WoJK+/t1mgWCiKI0koaAGDsztZsd3Anz4LEi2+NVNdupRq0ScHzweEKzq\n" + 
						"aa/LgtBi5WwyA5DaD33gbytG9hdFJvggzIN9+DSverHSAtqGUHhwHSU4/mL36xSR\n" + 
						"eyqiKDiVyhf/y6V6eiE0USubTEGaWVUANIteiC+8Ags5UF22QoqMo3ttKnEyFTHp\n" + 
						"GCXSn+AEO0WMLK1pPavAjPaOyf4cVX8b/PzHsfBPDMK/kNKNEaU5lAXo8dLUbRYq\n" + 
						"uQIDAQAB\n" + 
						"-----END PUBLIC KEY-----";
			}
			return "-----BEGIN RSA PRIVATE KEY-----\n" + 
					"MIIEpAIBAAKCAQEAn5dYHyD/nn/Pl+/W8jNGWHDaNItXqPuEk/hiozcPF+9l3qEg\n" + 
					"pRZrMx5ya7UjGdvihidGFQ9+efgaaqCLbk+bBsbU5L4WoJK+/t1mgWCiKI0koaAG\n" + 
					"DsztZsd3Anz4LEi2+NVNdupRq0ScHzweEKzqaa/LgtBi5WwyA5DaD33gbytG9hdF\n" + 
					"JvggzIN9+DSverHSAtqGUHhwHSU4/mL36xSReyqiKDiVyhf/y6V6eiE0USubTEGa\n" + 
					"WVUANIteiC+8Ags5UF22QoqMo3ttKnEyFTHpGCXSn+AEO0WMLK1pPavAjPaOyf4c\n" + 
					"VX8b/PzHsfBPDMK/kNKNEaU5lAXo8dLUbRYquQIDAQABAoIBAEYNyUDg21RYBmhL\n" + 
					"f68Rku9/mkk2YWRsA+ZwQdwjbxyymaUAVbQiAyyNUOy2tpHDU8xPsRPNmVcw8Wec\n" + 
					"0Ze6mfJ/lTRTvNr/j5eQ2E4yfPwP+OR5ui8FBbD4HeWZtda6lJbmCvsIIJFtrJqJ\n" + 
					"aSkovj1mTY8+qirLM6kdDJuAReSGCUUZGIJPKW65wEBfstZbIRlSulVXCb5SKawh\n" + 
					"kvaG0PKp7LtSLelK/32juSaUnyK7amoN7GFTkwQ6o7mWkVYNvbOxk8TQ4E6ATL8z\n" + 
					"Um8zqbLrpuSPV7YsIEiM65fbjFz72tRR8ANCyw01jR/LHXLSPLtqFPKOEpJeW/tn\n" + 
					"dAVKbYECgYEAzbqcXGWurd6bojD/VFqJ9hd37C2a0uOxB8Wk+xZpflyw8tEuMwYb\n" + 
					"UDZlq7MkMNvF1snqGgAW1kpr4FYvGAH/WiSwZynlD8gRgjzcx/VadQ47MeSSHiWD\n" + 
					"2Kexej/oU3hmlx1esf6lAwgLXCmU8fVIp/MnBqJWKQuP6xsf85coUxMCgYEAxpaV\n" + 
					"IOTQUjNb6Fwjh6MFeqJPWSOQvKSPdUtvr7sYWzi4DYyV1iJOVYWPDZ4lHSn8AR1R\n" + 
					"5Cn5EhFMahUB95uItLp9sAAdnHiYqScZz3oOeazk/NmTaeFTlW+Ccjk3AF4+B3ob\n" + 
					"P2++WSucnJs4XNNHjRnD3nSxQu6KFPW1BOMKuIMCgYBj/Mp57cGUJ5kknwO5j7d1\n" + 
					"r7pNQ2z4CknEKT8h+aaUD6DAowH9Mn6b4ZRQeuSgCnCBD+mDcX+n7su3YKvK0020\n" + 
					"FhjWSvpVTTuVPNdhJ9IrChujCCAsHreR2Q7dB6p2xxG1aETZ5ZV1f7dlt5/4aOpD\n" + 
					"Fl5lTwjpMgFklu5UiabDmQKBgQCFPuI+2OhiTy2awb/hMWPqvd8puzBRMsVC+WOt\n" + 
					"8IZOJsdv5+VdcVVIEr5Cb9sNL290O/0Hb5Y8Jjk0cHYKcmSOhxbwMZOsukoMLT0n\n" + 
					"NgliYLygX0iG4XZYrSJEi9k4uQM7txVzQgHhCN8jQQ7XUbgPl7sRlxCdDTq/B4H3\n" + 
					"DnPSCwKBgQCc3WbxdpifnZtc6Ve0tywZPQTeceby26WwMK3BrTbtmnp2QjWji/u6\n" + 
					"91PhI0f6z/ICOQWaQ9q3SKhMzMqLM92q4UOlX4TLgnLwZqbrN3E0G6BHz4bv8xRc\n" + 
					"h8HblXMLnv2MKGTpArKdx3gtrOHfyxWyLrjwqmxx94Fvnkg+YKNFWA==\n" + 
					"-----END RSA PRIVATE KEY-----";
		}
	}

	public String getClientId() {
		return CLIENT_ID;
	}

	public String getIdentityZone() {
		return IDENTITY_ZONE;
	}
}