package android.src.main.java.com.example.flutter_rsa;



import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * RSA签名验签类
 */
public class RSASignature {

	/**
	 * 签名算法
	 */
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	public static String sign(String content, PrivateKey privateKey, String encode) {
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initSign(privateKey);
			signature.update(content.getBytes(encode));
			byte[] signed = signature.sign();
			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * RSA签名
	 * 
	 * @param content    待签名数据
	 * @param privateKey 商户私钥
	 * @return 签名值
	 */
	public static String sign(String content, PrivateKey privateKey) {
		return sign(content, privateKey, "utf-8");
	}

	public static boolean doCheck(String content, String sign, PublicKey publicKey, String encode) {
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initVerify(publicKey);
			signature.update(content.getBytes(encode));
			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * RSA验签名检查
	 * 
	 * @param content   待签名数据
	 * @param sign      签名值
	 * @param publicKey 分配给开发商公钥
	 * @return 布尔值
	 */
	public static boolean doCheck(String content, String sign, PublicKey publicKey) {
		return doCheck(content, sign, publicKey, "utf-8");
	}

}
