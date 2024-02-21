import java.util.LinkedList;
//    >>>>>>>>>>>>>>>>>>>>>>>***<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q4.   Use a queue to solve the Josephus Problem.
public class JosephusProblem {

    public static int solve(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            count = queue.pollFirst();
        }

        return queue.pollFirst();
    }

    public static void main(String[] args) {
        int n = 5; // عدد الأشخاص
        int k = 2; // عدد القفزات

        int survivor = solve(n, k);
        System.out.println("The survivor is: " + survivor);
    }
}
