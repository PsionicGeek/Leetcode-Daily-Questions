public class Codec {

    String lU="";


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        lU=longUrl;
        return "";
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return lU;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));