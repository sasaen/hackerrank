package com.sasaen.hackerrank;

import java.util.*;

/**
 * Given an array of sentences and another array of queries, prints out the sentence index where all the query terms match in the sentence.
 * Example:
 *
 *   String[] sentences = {"jim likes mary", "kate likes tom", "tom does not like jim"};
 *   String[] queries = {"jim tom", "likes"};
 *
 * Result:
 * 2
 * 0 1
 *
 * Explanation: the first query matches with the sentence in index 2 and the second query matches with the sentences
 * with index 0 and 1.
 *
 */
public class TextQueries {

    static void textQueries2(String[] sentences, String[] queries) {
        // Split the sentences into terms and map them by index
        Map<Integer, Set<String>> sentencesSplit = new HashMap<>();
        for (int j = 0; j < sentences.length; j++) {
            String[] splitSentence = sentences[j].split(" ");
            Set<String> sentenceSet = new HashSet<>();
            sentencesSplit.put(j, sentenceSet);
            for (int i = 0; i < splitSentence.length; i++) {
                sentenceSet.add(splitSentence[i]);
            }
        }

        // Split the query into terms and map them by index
        Map<Integer, String[]> queriesSplit = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            queriesSplit.put(i, queries[i].split(" "));
        }

        for (int i = 0; i < queries.length; i++) {
            String found = null;
            for (int j = 0; j < sentences.length; j++) {
                String[] splitQuery = queriesSplit.get(i);
                Set<String> sentenceStringList = sentencesSplit.get(j);
                boolean notFound = false;
                for (int k = 0; k < splitQuery.length; k++) {
                    if (!sentenceStringList.contains(splitQuery[k])) {
                        notFound = true;
                        break;
                    }
                }
                if (!notFound) {
                    if (found == null) {
                        found = "" + j;
                    } else {
                        found += " " + j;
                    }
                }
            }
            if (found == null) {
                found = "-1";
            }
            System.out.println(found);
        }
    }


    public static void main(String[] args) {
        String[] sentences = {"jim likes mary", "kate likes tom", "tom does not like jim"};
        String[] queries = {"jim tom", "likes"};

        textQueries2(sentences, queries);
    }
}
