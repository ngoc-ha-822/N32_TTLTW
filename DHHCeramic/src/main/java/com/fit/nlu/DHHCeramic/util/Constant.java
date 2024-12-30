package com.fit.nlu.DHHCeramic.util;

public class Constant {
    public static final String SESSION_USERNAME = "username";
    public static final String COOKIE_REMEMBER = "username";

    public static class Path {
        public static final String LOGIN = "/view/client/view/login.jsp";
        public static final String LOGIN_ADMIN = "/view/admin/view/login.jsp";
        public static final String REGISTER = "/view/client/view/register.jsp";
        public static final String HOME = "/view/client/view/index.jsp";
        public static final String DASHBOARD = "/view/admin/view/login.jsp";

    }

    public static String GOOGLE_CLIENT_ID = "474718330255-ip6b590c85jul6if27u8hvcu7fkrttoc.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/DHHCeramic/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";


    public static String FACEBOOK_APP_ID = "615535650697352";
    public static String FACEBOOK_APP_SECRET = "443cda6c26181754e98583e13f69ae71";
    public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/DHHCeramic/login-facebook";
    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
