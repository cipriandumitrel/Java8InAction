package net.java8.part4.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsOfAList {

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(1, 4, 9);
        List<List<Integer>> listSubsets = subsets(inputList);
        listSubsets.forEach(System.out::println);
    }

    private static List<List<Integer>> subsets(List<Integer> inputList) {

        if(inputList.size() == 0){
           List<List<Integer>> answer = new ArrayList<>();
           answer.add(Collections.emptyList());
           return answer;
        }

        Integer first = inputList.get(0);
        System.out.println("first is: " + first);
        List<Integer> rest = inputList.subList(1, inputList.size());
        System.out.println("rest is: " + rest);
        List<List<Integer>> subsetsOfRest = subsets(rest);
        System.out.println("subsetsOfRest: " + subsetsOfRest);
        List<List<Integer>> subans = insertAll(first, subsetsOfRest);
        System.out.println("subans: " + subans);
        return concatenate(subsetsOfRest, subans);
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subsetsOfRest) {

        List<List<Integer>> resultList = new ArrayList<>();

        for (List<Integer> subsetOfRest : subsetsOfRest) {
            List<Integer> result = new ArrayList<>();
            result.add(first);
            result.addAll(subsetOfRest);
            resultList.add(result);
        }

        return resultList;
    }

    private static List<List<Integer>> concatenate(List<List<Integer>> subsetsOfRest, List<List<Integer>> subans) {
        List<List<Integer>> result = new ArrayList<>(subsetsOfRest);
        result.addAll(subans);
        return result;
    }
}
