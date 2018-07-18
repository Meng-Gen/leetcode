class Solution {
    public Solution() {
        this.phoneNumberLetterMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if (digits.length() > 0) {
            List<String> subLetterCombinations = letterCombinations(digits.substring(1));
            if (subLetterCombinations.size() == 0) {
                subLetterCombinations.add("");
            }
            String letter = phoneNumberLetterMap.get(digits.substring(0, 1));
            for (int i = 0; i < letter.length(); i++) {
                for (String subLetterCombination : subLetterCombinations) {
                    output.add(letter.substring(i, i + 1) + subLetterCombination);
                }
            }
        }
        return output;
    }
    
    private Map<String, String> phoneNumberLetterMap;
}