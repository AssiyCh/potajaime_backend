package fr.potajaime.core.authentication;


public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Potajaime ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/signup";
    public static final String SIG_FOX_URL = "/sigfox/**";
    public static final String ADMIN_URL = "/*/**";
}