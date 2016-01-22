package po.craig.spring;

import java.security.SecureRandom;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by wuxf on 15-7-28.
 */
public class Test {
    private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
    private final Log logger = LogFactory.getLog(getClass());

    private final int strength;

    private final SecureRandom random;

    public Test() {
        this(-1);
    }

    /**
     * @param strength the log rounds to use
     */
    public Test(int strength) {
        this(strength, null);
    }

    /**
     * @param strength the log rounds to use
     * @param random the secure random instance to use
     *
     */
    public Test(int strength, SecureRandom random) {
        this.strength = strength;
        this.random = random;
    }

    public String encode(CharSequence rawPassword) {
        String salt;
        if (strength > 0) {
            if (random != null) {
                salt = BCrypt.gensalt(strength, random);
            }
            else {
                salt = BCrypt.gensalt(strength);
            }
        }
        else {
            salt = BCrypt.gensalt();
        }
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            logger.warn("Empty encoded password");
            return false;
        }

        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            logger.warn("Encoded password does not look like BCrypt");
            return false;
        }

        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }

//    public static void main(String[] args) {
//        Test test = new Test(10);
//        System.out.println(test.encode("d2js@english"));
//    }

//    public static void main(String[] args) {
//        Test test = new Test(10);
//        System.out.println(test.encode("root@d2js$123!"));
//    }
//        public static void main(String[] args) {
//        Test test = new Test(10);
//        System.out.println(test.encode("root$123"));
//    }
}
