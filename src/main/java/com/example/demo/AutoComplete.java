package com.example.demo;

import java.util.*;

/**
 * Created by santoss on 24/10/2017.
 */
public class AutoComplete {

    // Trie node class
    private class Node {
        String prefix;
        HashMap<Character, Node> children;

        // Does this node represent the last character in a word?
        boolean isWord;

        private Node(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<Character, Node>();
        }
    }

    // The trie
    private Node trie;

    // Construct the trie from the dictionary
    public AutoComplete(String[] dict) {
        trie = new Node("");
        for (String s : dict) insertWord(s);
    }

    // Insert a word into the trie
    private void insertWord(String s) {
        // Iterate through each character in the string. If the character is not
        // already in the trie then add it
        Node curr = trie;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
            }
            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1) curr.isWord = true;
        }
    }

    // Find all words in trie that start with prefix
    public List<String> getWordsForPrefix(String pre) {
        List<String> results = new LinkedList<String>();

        // Iterate to the end of the prefix
        Node curr = trie;
        for (char c : pre.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }

        // At the end of the prefix, find all child words
        findAllChildWords(curr, results);
        return results;
    }

    // Recursively find every child word
    private void findAllChildWords(Node n, List<String> results) {
        if (n.isWord) results.add(n.prefix);
        for (Character c : n.children.keySet()) {
            findAllChildWords(n.children.get(c), results);
        }
    }

    static String findNumber(int[] arr, int k) {
        if (arr == null) {
            return "NO";
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return "YES";
            }
        }
        return "NO";
    }

    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 == 1) {
                list.add(i);
            }
        }
        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;
    }










    public static void main(String[] args) {

        //int[] quantities = {10, 6, 4};
        //int[] costs = {24, 20, 6};

        //int i = budgetShopping(50, quantities, costs);
        //System.out.println("Max shopping "+i);

        //String[] sentences = {"jim likes mary", "kate likes tom", "tom does not like jim"};
        //String[] queries = {"jim tom", "likes"};

        //String[] sentences = {"jim likes mary","kate likes tom","tom does not like jim"};
        //String[] queries = {"jim tom","likes"};


        // String[] words = {"abc", "acd", "bcd", "def", "a", "aba"};

        // AutoComplete c = new AutoComplete(words);
        //System.out.println(c.getWordsForPrefix("a"));
        //System.out.println(c.getWordsForPrefix("b"));
        //System.out.println(c.getWordsForPrefix("ab"));
    }
}
