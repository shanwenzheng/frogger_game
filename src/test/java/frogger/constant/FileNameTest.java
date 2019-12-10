package frogger.constant;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.junit.Test;
import frogger.Main;

/**
 * <h2> FileNameTest </h2>
 * 
 * <p> The {@link FileNameTest} function is used to test whether the constant in {@link FileName} can be read successfully.
 * 
 * @author Wenzheng Shan
 * @version 1.0
 * @since 1.0
 * @see FileName
 */
public class FileNameTest {

	/**
	 * <p>This is the test method that tests whether the constants in {@link FileName} can be read successfully.
	 * <p>This test will pass if the file one from {@link FileName} and another from correct path have the same value of "SHA-1"
	 */
	@Test
	public void readFileNameTest() {
		assertEquals(FileName.IMAGE_CAR_RIGHT, "images/obstacle/car1Right.png");
		File f1 = new File(Main.class.getResource(FileName.IMAGE_CAR_RIGHT).toString());
		File f2 = new File(Main.class.getResource("images/obstacle/car1Right.png").toString());
		assertEquals(getFileSha(f1), getFileSha(f2));
		
		f1 = new File(Main.class.getResource(FileName.IMAGE_DIGIT.get(2)).toString());
		f2 = new File(Main.class.getResource("images/digit/1.png").toString());
		assertEquals(getFileSha(f1), getFileSha(f2));
	}

	/**
	 * <p> This method get the value of "SHA-1" with the input {@code link}.
	 * 
	 * @param file	A file that needed to get its value of "SHA-1"
	 * @return		Return the corresponding value of "SHA-1" with the given {@code link}
	 */
    public String getFileSha(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest =MessageDigest.getInstance("SHA-1");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
