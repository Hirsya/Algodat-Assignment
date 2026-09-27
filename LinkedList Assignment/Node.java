class Node {
    //link to the next node
    private int data;
    Node nextNode = null;
    //data
    Node (int dataInput){
        data = dataInput;
    }

    void checkData(){
        System.out.println(data);
    }

    void setNextNode(Node next){
        nextNode = next;
    }

    Node getNextNode(){
        return nextNode;
    }

    int getData(){
        return data;
    }
}