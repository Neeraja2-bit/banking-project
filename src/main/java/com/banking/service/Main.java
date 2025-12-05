
package com.banking.service;//package com.banking.service;
//public class practice {
//    public static void main(String[] args) {
//        String[] array = {"apple", "banana", "apple", "orange", "banana", "apple"};
//        String frequent = Arrays.stream(array)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse("nothing");
//        System.out.println(frequent);
//    }
//    List<Integer> numbers = Arrays.asList(1,2,4,7,7,8);
//    Optional<Integer> secondHigh = numbers.stream().
//            distinct().sorted(Comparator.reverseOrder())
//            .skip(1).findFirst();
//    System.out.println("Second Highest" + secondHigh.orElse(null));
//******
//    String input = "arrays,rrat";
//    Map<Character,Long> secondRepeating = input.chars().mapToObj(c->(char)c)
//            .collect(Collectors.groupingBy(
//                    c->c,
//                    LinkedHashMap::new
//                    ,Collectors.counting()));
//    Character nonRepeating = charCount.entrySet.stream().filter(e->e.getValue>1).skip(1).map(Map.Entry::getValue).
//            findFirst().orElse(null);
//
//

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

////************************************
//
//}
//
//
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class RepeatedItems {
//    public static void main(String[] args) {
//
//        List<String> items = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
//        Set<String> repeatedItems = items.stream()
//                .collect(Collectors.groupingBy(item -> item, Collectors.counting()))
//                .entrySet().stream()
//                .filter(e -> e.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toSet());
//    }
//
//    String input = "Programming";
//    List<Character> nonrepeatedItems = input.chars()
//            .mapToObj(c -> (char) c)
//            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//            .entrySet().stream()
//            .filter(e -> e.getValue() > 1)
//            .map(Map.Entry::getKey)
//            .collect(Collectors.toList());
//}
//    public class Employee{
//        String name;
//        String department;
//
//}
//public void Employee(String empName, String empDepartment){
//        name = empName;
//        department = empDepartment;
//}
//public void display(){
//        System.out.println("Name" +name);
//        System.out.println("Department" + department);
//    }
//    public static void main (String[] args){
//        Employee emp=new Employee("Neeraja","consulting");
//        emp.display();

//abstract class Car{
//    abstract void startEngine();
//    abstract void accelerate();
//    abstract void brake();
//}
//class SUV extends Car{
//
//    @Override
//    void startEngine() {
//System.out.println("Starting SUV");
//    }
//
//    @Override
//    void accelerate() {
//System.out.println("Accelerating SUV");
//    }
//
//    @Override
//    void brake() {
//System.out.println("Braking SUV");
//    }
//}
//public class Main{
//    public static void main(String[] args) {
//        Car car = new SUV();
//        car.startEngine();
//        car.accelerate();
//        car.brake();
//        System.out.println("SUV started");
//    }
//}

//sort a list using Lambda expressions:
/*List<String> names = Arrays.asList("NEeraja","Debarati","NAveen");
names.sort((a,b)->a.compareTo(b));
names.forEach(System.out::println);*/

//find even numbers from a list using Streams API:
/*List<Integer> even = Arrays.asList(1,2,,3,4);
List<Integer> evennumber = even.stream().filter(n->n%2 ==0).collect(Collectors.toList());
forEach(System.out::println());*/

/*ocunt occurrences of each word
List<string> count =Arrays.asList("apple","banab","vcat","apple");
List<String> countacc = count.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/
/*
find the sum of the largest two numbers in a list using Streams:
List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> largest = numbers.stream().sort(Comparator.reverseOrder()).limit(2).maptOInt(Integer:intValue).sum();*/


//first non-repeated character in a string using Streams:
/*List<String> input ="List of bank";
List<String> nonrepeated = input.chars().mapToObj(c->(char)c).collect(collectors.grouping(Function.identity(), LinkedHashMap::newHashMap,collectors.counting)))
        .stream().entrySet().filter(e->e.getValue==1).map(Map.Entry::getValue).findFirst();*/
