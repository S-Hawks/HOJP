package org.example;

public class Exercise1 {
    public static void main(String[] args) {
        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumberStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumberStream().filter(number -> number <=  5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumberStream().filter(number -> number > 5 )
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        //TODO:First Solution
        System.out.println(StreamSources.intNumberStream().filter(number -> number > 5).findFirst().orElse(-1));
        //TODO:Second Solution
        Integer value = StreamSources.intNumberStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        //TODO: First Solution
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstname()));
        //TODO: Second Solution
        StreamSources.userStream()
                .map(user -> user.getFirstname())
                .forEach(userName -> System.out.println(userName));

        // Print first names in userStream for users that have IDs from number stream
        //TODO: First Solution
        StreamSources.userStream().filter(u -> StreamSources.intNumberStream().anyMatch(i -> i == u.getId()));
        //TODO: Second Solution
        StreamSources.intNumberStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstname()).forEach(userName -> System.out.println(userName));

    }
}
