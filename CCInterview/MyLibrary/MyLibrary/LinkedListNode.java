package MyLibrary;

public class LinkedListNode {
    public int data;
    public LinkedListNode prev = null;
    public LinkedListNode next = null;

    public LinkedListNode () { }

    public LinkedListNode (int d) {
        data = d;
    }

    public LinkedListNode (int d, LinkedListNode next, LinkedListNode prev) {
        data = d;
        setPrevious (prev);
        setNext (next);
    }

    public void setNext (LinkedListNode n) {
        next = n;
        if (n != null) n.setPrevious (this);
    }

    public void setPrevious (LinkedListNode p) {
        prev = p;
        if ((p != null) && (this != p.next)) 
          p.setNext (this);
    }


/*
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNode(int d) {
		data = d;
	}	
	
	public LinkedListNode() { }

	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
*/




    public LinkedListNode clone () {
        LinkedListNode cl = new LinkedListNode (data, null, null);
        LinkedListNode current = cl;

        LinkedListNode origin = this;

        while (origin.next != null) {
            origin = origin.next;
          
            LinkedListNode node = new LinkedListNode (origin.data, null, current);
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
        LinkedListNode node = new LinkedListNode (d, null, current);
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


    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;

		second = new LinkedListNode(1, null, null);
        first.setNext(second);
        second.setPrevious(first);
		System.out.println(head.printForward());

/*
        for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}

head.add (10); 
head.add (20);
head.add (30);
head.add (40);
head.add (10);
head.add (40); 
head.add (30);
head.add (20);
head.add (50);
head.add (10);
head.add (60);
head.add (0);
head.add (1);
head.add (1);
head.add (1);
head.add (0);


		LinkedListNode cloneA = head.clone();
		deleteDupsC(cloneA);
		System.out.println(cloneA.printForward());

        head.add (99);
		System.out.println(head.printForward());

//        System.out.print ("hash-set: ");
//		for (Integer h : hashNodes) {
//          System.out.print (h.toString() + " ");
//        }
*/
		
	}

}
