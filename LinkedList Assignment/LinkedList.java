public abstract class LinkedList {
    Node head = null;
    Node tail = null;

    void add(Node newNode){
        if (head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.nextNode = newNode;
            tail = newNode;
        }
    }

    Node getHead (){
        return head;
    }

    Entity getAt(int index){
        if (index < 0 || index >= count()){
            System.out.println("Index out of range");
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.nextNode;
        }
        return current.getData();
    }

    void displayLinkedList (){
        if(head == null){
            System.out.println("No LinkedList has been stored.");   
        }else{
            Node current = head;
            while (current!=null){
                current.checkData();
                current = current.nextNode;
            }
        }
    }

    void searchLinkedList(Entity key){
        boolean exist = false;
        if(head != null){
            Node current = head;
            while (current!=null){
                if(current.getData().equals(key)){exist = true;}
                current = current.nextNode;
            }
        }
        if (exist == true){
            System.out.println(key + " Is found");
        }else{
            System.out.println(key + " Not found");
            
        }
    }
    
    int count(){
        int x = 0;
        if(head == null){
            return x;   
        }else{
            Node current = head;
            while (current!=null){
                x++;
                current = current.nextNode;
            }
        }
        return x;
    }
    
    void insertAt(int index, Node newNode){
        if (index < 0 || index > count()) {  
        System.out.println("Index out of range");
        return;
        }
        if(index == 0){
            newNode.nextNode = head;
            head = newNode;
            if (tail == null){tail = newNode;}
        }else if(index == count()){
            add(newNode);
        }else{
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
            current = current.nextNode;  
            }
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode; 
        }
    }
    
    void delete(Entity key){
        if (head == null){
            System.out.println("No LinkedList has been stored.");
            return;
        }

        if (head.getData().equals(key)){
            head = head.nextNode;
            if (head == null){
                tail = null;
            }
            System.out.println(key + " deleted");
            return;
        }
        Node prev = head;
        Node current = head.nextNode;
        while (current != null){
            if (current.getData().equals(key)){
                prev.nextNode = current.nextNode; 
                if (current == tail){            
                    tail = prev;                  
                }
                System.out.println(key + " deleted");
                return;
            }
            prev = current;              
            current = current.nextNode;  
        }
        System.out.println(key + " not found");
    }
}
