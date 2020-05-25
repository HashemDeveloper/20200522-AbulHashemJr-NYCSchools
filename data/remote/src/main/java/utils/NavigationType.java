package utils;

public enum NavigationType {
    GOOGLE("google.navigation:q="),
    WAZE("waze://?navigate=yes&q=");

    private String urlString;
    NavigationType(String urlString) {
        this.urlString = urlString;
    }
    public String getUrlString() {
        return urlString;
    }
}
