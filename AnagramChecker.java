public class AnagramChecker {

    // method to remove non-letter characters and convert to lowercase
    private String cleanText(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    // to check if two texts are anagrams
    public boolean areAnagrams(String text1, String text2) {
        // Clean the input texts by removing non-letter characters and converting to
        // lowercase
        String cleanText1 = cleanText(text1);
        String cleanText2 = cleanText(text2);

        // If the cleaned texts have different lengths, they cannot be anagrams
        if (cleanText1.length() != cleanText2.length()) {
            return false;
        }

        // Assuming English alphabet of 26 letters
        int[] charFrequency = new int[26];

        // Increment character count for text1
        for (char c : cleanText1.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        // Decrement character count for text2
        for (char c : cleanText2.toCharArray()) {
            int count = charFrequency[c - 'a'];
            if (count == 0) {
                // If a character is not found or its count becomes zero, the texts are not
                // anagrams
                return false;
            }
            charFrequency[c - 'a']--;
        }

        return true; // If all characters in text2 are accounted for, they are anagrams.
    }
}