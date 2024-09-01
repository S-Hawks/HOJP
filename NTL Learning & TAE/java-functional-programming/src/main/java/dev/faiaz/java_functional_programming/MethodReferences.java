package dev.faiaz.java_functional_programming;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
    Supplier<Double> random = Math::random;

    Function<Person,String> getName = Person::getName;

    Person p1 = new Person("foo", "24");
    Person p2 = new Person("bar", "26");

    BiPredicate<Person,Person> isEqual = Person::equals;

    //Passing a collection to a lambda
    Function<List<String>, Integer> getCount = List::size;

    //Things to remember -> A constructor is a special kind of method.
    Function<List<String>, Collection<String>> dedupe = list -> new HashSet<>(list);
    //TODO:This can be write as
    Function<List<String>, Collection<String>> dedupeMethodReference = HashSet::new; //This is a method reference call to a constructor -> here new is a method
}

class Person {
    private String name;

    private String age;

    //Things to remember -> A constructor is also a special kind of method..
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
