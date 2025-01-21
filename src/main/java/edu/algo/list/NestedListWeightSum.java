package edu.algo.list;

import java.util.List;

/**
 * 339. Nested List Weight Sum
 *
 * <pre>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 * </pre>
 */
public class NestedListWeightSum {

  public interface NestedInteger {

    boolean isInteger();

    int getInteger();

    List<NestedInteger> getList();
  }

  public static void main(final String[] args) {}

  /**
   * Time Complexity: The time complexity of the function is O(N), where N is the total number of
   * integers and lists within all levels of the nested list. Specifically, the function dfs visits
   * each element exactly once. For each integer it encounters, it performs a constant time
   * operation of multiplication and addition. For each list, it makes a recursive call to process
   * its elements. However, since every element is only visited once, the overall time to visit all
   * elements is proportional to their count.
   *
   * <p>Space Complexity: The space complexity of the function is O(D), where D is the maximum depth
   * of the nested list. This complexity arises from the call stack used for recursion. In the worst
   * case, the recursion will go as deep as the deepest nested list. Therefore, the maximum number
   * of nested calls will equal the maximum depth D. Furthermore, there is only a constant amount of
   * space used at each level for variables such as depth_sum.
   */
  public static int depthSum(final List<NestedInteger> nestedList) {
    return dfs(1, nestedList);
  }

  // [1, 2, 3]
  // [[1,1],2,[1,1]]
  private static int dfs(int depth, List<NestedInteger> nestedList) {
    int sum = 0;
    for (final NestedInteger nested : nestedList) {
      if (nested.isInteger()) {
        sum += depth * nested.getInteger();
      } else {
        sum += dfs(depth + 1, nested.getList());
      }
    }

    return sum;
  }
}
