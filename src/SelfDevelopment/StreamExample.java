package SelfDevelopment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Scala", "Groovy","Go","Python");
         list.stream()
                .sorted().forEach(s-> System.out.println(s));

       List<String> sList =  list.stream().filter(s->s.startsWith("G")).collect(Collectors.toList());
        System.out.println(sList);

        boolean anyMatch = list.stream().anyMatch(language->language.contains("P"));
        System.out.println(anyMatch);


    }

}
