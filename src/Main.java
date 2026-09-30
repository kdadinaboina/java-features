import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Optional<String> result = Optional.of("KOtesh");
        System.out.println(result);
        Optional<Integer> count = result.map(name -> name.length());
        System.out.println(count);

    }
}