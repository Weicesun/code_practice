public class TinyUrl2 {
    /**
     * @param long_url a long url
     * @param a short key
     * @return a short url starts with http://tiny.url/
     */
     private HashMap<Long, String> id2url = new HashMap<Long, String>();
     private HashMap<String, Long> url2id = new HashMap<String, Long>();
     private HashMap<String, String> custom_l2s = new HashMap<String, String>();
     private HashMap<String, String> custom_s2l = new HashMap<String, String>();
     private static long GLOBAL_ID = -1;
     private final String tiny = "http://tiny.url/";
    String createCustom(String long_url, String short_key) {
        // Write your code here
        if ((custom_l2s.containsKey(long_url) && !custom_l2s.get(long_url).equals(tiny + short_key))
        || (custom_s2l.containsKey(tiny + short_key) && !custom_s2l.get(tiny + short_key).equals(long_url))) {
            return "error";
        }
        String customUrl = "http://tiny.url/" + short_key;
        custom_l2s.put(long_url, customUrl);
        custom_s2l.put(customUrl, long_url);
        return customUrl;
    }
    public String id2short(long id) {
        String c = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = new String();
        while (id > 0) {
            long index = id % 62;
            result += c.charAt((int)index);
            id = id / 62;
        }
        while (result.length() < 6) {
            result += "0";
        }
        return  result;
    }
    public long short2id(String url) {
        String s = url.substring(tiny.length());
        long i = 1;
        long result = 0;
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            if (c >= '0' && c <= '9') {
                result += (c - '0') * i;
            } else if (c >= 'a' && c <= 'z') {
                result += (c - 'a' + 10) * i;
            } else {
                result += (c - 'A' + 36) * i;
            }
            i = i * 62;
        }
        return result;
    }
    /**
     * @param long_url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // Write your code here
        if (custom_l2s.containsKey(long_url)) {
            return custom_l2s.get(long_url);
        }
        if (url2id.containsKey(long_url)) {
            long temp = url2id.get(long_url);
            return tiny + id2short(temp);
        } 
            GLOBAL_ID++;
            url2id.put(long_url, GLOBAL_ID);
            id2url.put(GLOBAL_ID, long_url);
            
            return tiny+id2short(GLOBAL_ID);
        
        
        
    }

    /**
     * @param short_url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String short_url) {
        // Write your code here
        if (custom_s2l.containsKey(short_url)) {
            return custom_s2l.get(short_url);
        }
        long temp = short2id(short_url);
        if (!id2url.containsKey(temp)) {
            return "error";
        } 
            return id2url.get(temp);
        
    }
}
