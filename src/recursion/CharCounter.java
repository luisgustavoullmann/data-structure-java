package recursion;

public class CharCounter {

    public static int charCounter(char ch, String text) {
        return charCounterTailRecursive(Character.toLowerCase(ch), text.toLowerCase(), 0, 0);
    }

    private static int charCounterTailRecursive(char ch, String text, int index, int count) {
        if (index >= text.length()) return count; // base case

        int newCount = (text.charAt(index) == ch) ? count + 1 : count;
        return charCounterTailRecursive(ch, text, index + 1, newCount);
    }

    public static void main(String[] args) {
        System.out.println(charCounter('b', "Batata para o bebê"));
        System.out.println(charCounter('a', "Batata para o bebê"));
    }
}
