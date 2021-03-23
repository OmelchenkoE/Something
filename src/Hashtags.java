import java.util.*;
import java.util.stream.Collectors;

public class Hashtags {
    public void countHashTags() {
        String tweet1 = "Hello my #dear #friends and go #home =)";
        String tweet2 = "My #friends like watching #movies at #home and in a #theatre";
        String tweet3 = "#home #home #home #home #friends #friends #movies #movies #theatre";

        ArrayList<String> sentences = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        sentences.add(tweet1);
        sentences.add(tweet2);
        sentences.add(tweet3);

        for (String s : sentences) {
            s = s.toLowerCase();
            String[] splitS = s.split("\\s+"); //or just whitespace
            words.addAll(Arrays.stream(splitS).filter(word -> word.startsWith("#")).collect(Collectors.toList()));
        }

        for (String s : words) {
            int i = 1;
            if (hashMap.containsKey(s)) {
                i = hashMap.get(s);
                i++;
            }
            hashMap.put(s, i);
        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        hashMap.forEach((s, i) -> map.put(i, s));
        map.forEach((integer, s) -> stringArrayList.add(s)); //{6=#home, 4=#friends, 3=#movies, 2=#theatre, 1=#dear}
        System.out.println(stringArrayList);
    }
}
