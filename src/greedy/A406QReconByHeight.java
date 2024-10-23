package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A406QReconByHeight {
  public int[][] reconstructQueue(int[][] people) {
    List<int[]> queue = new LinkedList<>();
    Arrays.sort(people, (a, b) -> {
      if(b[0] == a[0]) return b[0] - a[0];
      return a[1] - b[0];
    });

    for (int[] individual : people) {
      // Invariant for queue
      // H: forall i: nat, item[i][1] = #{ item[j] | j < i /\ item[j][0] >= item[i][0] }
      // proof: 
      // - if len(queue) = 0, the result is immediate
      // - if len(queue) = 0 and H holds. Let H1: People is sorted by height and then .
      //    By H1, all elements e in queue satisfy e[0] > individual[0] 
      //    so inserting in e[1] will guarantee H. 
      queue.add(individual[1], individual);
    }
    return queue.toArray(new int[0][0]);
  }
}