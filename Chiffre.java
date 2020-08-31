class Chiffre {
    private char[][] alphabets;

    public String encode(String textString, String keyString) {
        char[] key = keyString.toCharArray();
        char[] text = textString.toCharArray();

        char[] encoded = new char[text.length];

        int keyIndexGlobal = 0;
        for (int i = 0; i < text.length; i++) {
            int keyIndex = keyIndexGlobal % key.length;
            char textChar = text[i];
            char keyChar = key[keyIndex % key.length];

            int[] textAlphabetPos = this.getAlphabetPosition(textChar);
            int[] keyAlphabetPos = this.getAlphabetPosition(keyChar);

            if (textAlphabetPos[0] == -1 || textAlphabetPos[1] == -1) {
                encoded[i] = textChar;
                continue;
            }

            char[] alphabet = this.alphabets[textAlphabetPos[0]];

            int finalPosition = (textAlphabetPos[1] + keyAlphabetPos[1]) % alphabet.length;
            
            encoded[i] = alphabet[finalPosition];
            keyIndexGlobal++;
        }

        String result = String.valueOf(encoded);
        return result;
    }

    public Chiffre(String[] alphabets) {
        this.alphabets = this.alphabetsToCharArrays(alphabets);
    }

    private char[][] alphabetsToCharArrays(String[] alphabets) {
        char[][] result = new char[alphabets.length][];
        for (int i = 0; i < alphabets.length; i++) {
            String a = alphabets[i];
            result[i] = a.toCharArray();
        }
        return result;
    }

    private int[] getAlphabetPosition(char value) {
        for (int alphabetIndex = 0; alphabetIndex < this.alphabets.length; alphabetIndex++) {
            char[] alphabet = this.alphabets[alphabetIndex];
            for (int position = 0; position < alphabet.length; position++) {
                if (alphabet[position] == value) {
                    int[] result = { alphabetIndex, position };
                    return result;
                }
            }
        }
        int[] result = {-1,-1};
        return result;
    }
}