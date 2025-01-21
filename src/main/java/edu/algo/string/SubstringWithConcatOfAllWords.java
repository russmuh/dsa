package edu.algo.string;

import java.util.*;

/**
 * <pre>
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab"
 * are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of
 * any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 *
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
 * There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
 * We return an empty array.
 *
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * s and words[i] consist of lowercase English letters.
 * </pre>
 */
public class SubstringWithConcatOfAllWords {

  public static void main(final String[] args) {
    System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo", "bar"})); // [0, 9]
    System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"})); // []
    System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"})); // [6, 9, 12]
    System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] {"fooo","barr","wing","ding","wing"})); // [13]
  }

  public static List<Integer> findSubstring(final String s, final String[] words) {
    if (s == null || s.length() == 0 || s.length() >10_000) {
      return List.of();
    }

    if (words == null || words.length == 0 || words.length > 5000) {
      return List.of();
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      final Integer index = find(i, s, words);
      if (index != null) {
        result.add(index);
      }
    }

    return result;
  }

  public static Integer find(final int index, final String s, final String[] words) {
    // barfoofoobarthefoobarman - ["bar","foo","the"]

    List<Integer> visitedIndices = new LinkedList<>();

    int size = words[0].length();
    int matchesCount = 0;
    int potentialIndex = -1;

    for (int i = index; i < s.length(); i += size) {
      if (s.length() < i + size) {
        return null;
      }

      String substring = s.substring(i, i + size);
      boolean foundMatch = false;

      for (final String word : words) {
        if (!contains(visitedIndices, words, word)) {
          continue;
        }

        if (substring.equals(word)) {
          if (matchesCount == 0) {
            potentialIndex = i;
          }

          matchesCount++;
          foundMatch = true;

          visit(visitedIndices, words, word);
          break;
        }
      }

      if (!foundMatch) {
        return null;
      } else if (matchesCount == words.length) {
        return potentialIndex;
      }
    }

    return null;
  }

  static boolean contains(List<Integer> visitedIndices, String[] words, final String word) {
    for (int i = 0; i < words.length; i++) {
      if (!visitedIndices.contains(i) && words[i].equals(word)) {
        return true;
      }
    }

    return false;
  }

  static void visit(List<Integer> visitedIndices, String[] words, final String word) {
    for (int i = 0; i < words.length; i++) {
      if (!visitedIndices.contains(i) && words[i].equals(word)) {
        visitedIndices.add(i);
        break;
      }
    }
  }
}
