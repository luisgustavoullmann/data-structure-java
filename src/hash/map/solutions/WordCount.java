package hash.map.solutions;


import java.text.Collator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Rank {
    public  String word;
    public Integer count;

    public Rank(String word, Integer count) {
        this.word = word;
        this.count = count;
    }
}

public class WordCount {

    public static String normalize(String text) {
        Pattern pattern = Pattern.compile("[^\\p{L}\\p{N}\\s]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        String words = matcher.replaceAll(" ");
        return words.replaceAll("\\s+", " ").trim().toLowerCase();
    }

    public static List<Rank> wordCount(String text) {
        Map<String, Integer> map = new HashMap<>();

        String[] words = normalize(text).split(" ");

        for (String word : words) {
            if (!map.containsKey(word)) map.put(word, 1);
            else map.put(word, 1 + map.get(word));
        }

        List<Rank> ranks = new ArrayList<>();
        for (String word : map.keySet()) {
            ranks.add(new Rank(word, map.get(word)));
        }

        ranks.sort((a,b) -> {
            Collator collator = Collator.getInstance(Locale.getDefault());
            int countComparison = b.count.compareTo(a.count);
            if (countComparison != 0) return countComparison;
            return collator.compare(a.word, b.word);
        });

        return ranks;
    }

    public static void main(String[] args) {
        String inputText = """
				O vento sussurra sons entre as árvores, sons que fazem animais
				correrem. A floresta e a natureza vibram com segredos e sons.
				""";

        List<Rank> result = wordCount(inputText);
        for (Rank obj : result) {
            System.out.println(obj.word + ": " + obj.count);
        }
    }
}
