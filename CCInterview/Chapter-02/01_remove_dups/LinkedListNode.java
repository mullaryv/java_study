public class LinkedListNode {
        public int data;
        public LinkedListNode prev = null;
        public LinkedListNode next = null;

        public LinkedListNode (int d, LinkedListNode prev, LinkedListNode next) {
          data = d;
          this.prev = prev;
          this.next = next;
        }

        public void setNext (LinkedListNode node) {
            next = node;
        }
        public void setPrevious (LinkedListNode node) {
            prev = node;
        }

        public LinkedListNode clone () {
          LinkedListNode cl = new LinkedListNode (data, null, null);
          LinkedListNode current = cl;

          LinkedListNode origin = this;

          while (origin.next != null) {
            origin = origin.next;
              
            LinkedListNode node = new LinkedListNode (origin.data, current, null);
            current.next = node;
            current = node;
          }
          return cl; 
        }

        public void add (int d) {
          LinkedListNode current = this;
          while (current.next != null) {
            current = current.next;
          } 
          LinkedListNode node = new LinkedListNode (d, current, null);
          current.next = node;
        }

        public String printForward () {
          StringBuffer sb = new StringBuffer ();
          LinkedListNode current = this;
          while (current != null) {
            sb.append (current.data);
            current = current.next;
            if (current != null)
              sb.append("->");  
          }
          return sb.toString();
        }
}
