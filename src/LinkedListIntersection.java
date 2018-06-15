import java.util.*;

class LinkedListIntersection
{
	int intersectPoint(Node headA, Node headB)
	{    int result = -1;
         HashMap<Node, Integer> map = new HashMap<>();
         Node temp = headA;
         while(temp != null){
             map.put(temp, 0);
             temp = temp.next;
         }
         Node temp2 = headB;
         while(temp2 != null){
             if(map.containsKey(temp2)){
                 result = temp2.data;
                 break;
             }
             temp2 = temp2.next;
         }
         return result;
	}
}
class Node{
	int data;
	Node next = null;
}