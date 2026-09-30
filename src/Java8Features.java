import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8Features {

    public static void main(String[] args) {
        System.out.println("Java 8 Features : ");
        List<Integer> numbers = Arrays.asList(12, 44, 66, 35, 78, 99, 109, 12);
        Collections.sort(numbers, (a, b) -> a.compareTo(b));
        // numbers.sort(Integer::compareTo);
        System.out.println(numbers);

        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        List<Integer> oddNums = numbers.stream().filter(n -> n % 2 >= 1).collect(Collectors.toList());
        System.out.println(oddNums);

        List<String> techNames =
                Arrays.asList("Java", "Spring", "Docker");
        String results = techNames.stream().collect(Collectors.joining(" $ "));
        System.out.println(results);
        Function<String, String> upperCase = x -> x.toUpperCase();
        List<String> uppercaseNames = techNames.stream().map(upperCase).limit(2).collect(Collectors.toList());
        System.out.println(uppercaseNames);

        List<String> sortedNames = techNames.stream().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toUnmodifiableList());
        System.out.println(sortedNames);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(29));

        Function<String, Integer> length = name -> name.length();
        System.out.println(length.apply("KOtesh"));

        Consumer<String> name = name1 -> System.out.println(name1);
        name.accept("Java");

        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());
        Consumer<Integer> num = num1 -> System.out.println(num1);
        List<Integer> numbers2 =
                Arrays.asList(10, 20, 10, 30, 20, 40);

        numbers2.stream().distinct().forEach(num);
        Integer sum = numbers2.stream().reduce(0, Integer::sum);

        System.out.println(sum);

        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", Arrays.asList("current", "office"), 80000),
                new Employee("David", "HR", Arrays.asList("shipping"), 500000),
                new Employee("Mike", "IT1", Arrays.asList("office"), 5000),
                new Employee("Sara", "HR", Arrays.asList("home", "office"), 64000)
        );

        Map<String, List<Employee>> groupByDep = employees.stream().collect(Collectors.groupingBy(Employee::dep));
        System.out.println(groupByDep);
        groupByDep.entrySet().stream().limit(1).forEach(emp -> System.out.println(" $$$$ " + emp.getValue()));
        Map<String, Long> groupbyAndCount = employees.stream().collect(Collectors.groupingBy(Employee::dep, Collectors.counting()));
        System.out.println(groupbyAndCount);
        Map<Boolean, List<Integer>> numPartitioning = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(numPartitioning);

        Calculator add = (a, b) -> a + b;
        Calculator mult = (a, b) -> a * b;
        System.out.println(add.calculate(3, 6));
        System.out.println(mult.calculate(3, 6));
        Calculator.mes();

        List<String> address = employees.stream().flatMap(employee -> employee.address().stream()).peek(n -> System.out.println(" after flatMp() " + n)).distinct().collect(Collectors.toList());
        System.out.println(address);

        employees.stream().filter(employee -> employee.salary() > 5555).forEach(System.out::println);

        List<String> getNames = employees.stream().map(Employee::name).collect(Collectors.toList());
        System.out.println(getNames);

        List<Employee> sortBySalary = employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()).limit(1).collect(Collectors.toList());
        System.out.println(sortBySalary);

        Optional<Employee> highest = employees.stream().max(Comparator.comparing(Employee::salary));
        System.out.println(highest);

        Map<String, List<Employee>> top3highestSalary = employees.stream().collect(Collectors.groupingBy(Employee::dep, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(Employee::salary).reversed()).limit(3).toList())));
        System.out.println(" top3highestSalary :: " + top3highestSalary);
        List<Integer> duplicateNumbers = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().filter(n -> n.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(duplicateNumbers);

        Set<Integer> set = new HashSet<>();

        Set<Integer> duplicateNumbersSet = numbers.stream().filter(n -> !set.add(n)).collect(Collectors.toSet());
        System.out.println("SET :: " + duplicateNumbersSet);


    }
}
