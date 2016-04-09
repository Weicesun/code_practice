public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        
        helper(result, word, 0, 0, "");
        return result;
    }
    public void helper(List<String> result,String word, int pos, int count, String s) {
        if (pos == word.length()) {
            if (count > 0) {
                s = s + count;
            }
            result.add(s);
            return;
        }
        
        helper(result, word, pos + 1, 0 , s + (count > 0 ? count + "": "") + word.charAt(pos));
        helper(result, word, pos + 1, count + 1, s);
    }
// hard ...
