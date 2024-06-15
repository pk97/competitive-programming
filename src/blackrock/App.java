package blackrock;

import java.util.LinkedList;
import java.util.List;

class ListNode {
    ListNode next;
}
public class App {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);

        list.add(12);
        list.add(5);
        list.add(5);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void reorderList(ListNode head) {
        List<ListNode> dq = new LinkedList<>();
        List<ListNode> ans = new LinkedList<>();
        ListNode start = head;
        while(start!=null) {
            dq.add(start);
            start=start.next;
        }
        while (true) {
            start = dq.removeFirst();
            ListNode end =  dq.removeLast()
            if (start == end) break;
            ans.add(start);
            ans.add(end);
        }
        return ans;
    }
}
