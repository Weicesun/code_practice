     ArrayList<String> db = new ArrayList<String>();
     String dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String longToShort(String url) {
        // Write your code here
        db.add(url);
        int index = db.size() - 1;
        String tiny = new String();
        while(index > 0) {
            tiny += dict.charAt(index % 62);
            index = index / 62;
        }
        while (tiny.length() < 6) {
            tiny = "0" + tiny;
        }
        return "http://tiny.url/" + tiny;
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        // Write your code here
        String tiny = url.substring(url.length() - 6, url.length());
        int index = 0;
        for (int i = 0; i < tiny.length(); i++) {
            index = index*62 + toBase62(tiny.charAt(i));
        }
        return db.get(index);
    }
    private int toBase62(char c) {
        if (c <= '9') {
            return c - '0';
        } else if (c <= 'z') {
            return c - 'a' + 10;
        } else {
            return c-'A'+36;
        }
    }
