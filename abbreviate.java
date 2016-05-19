public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(result, word, 0, "", 0);
        return result;
    }
    public void helper(List<String> result, String word, int pos, String current, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                current = current + count;
            }
            result.add(current);
        } else {
            helper(result, word, pos + 1, current, count + 1);
            helper(result, word, pos + 1, current + (count > 0 ? count + "" : "") + word.charAt(pos), 0);
        }
        
    }
