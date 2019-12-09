package frogger.constant;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.junit.Test;
import frogger.Main;

public class FileNameTest {

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
