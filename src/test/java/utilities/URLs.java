package utilities;

public enum URLs {
    BASE_URL("https://main.dxghm77sk8xwx.amplifyapp.com/"),
    LOGIN_URL(BASE_URL.url + "giris"),
    EGITMENLER_URL(BASE_URL.url+"egitimler");



    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
} 