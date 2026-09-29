class Node {
    //link to the next node
    private Entity data;
    Node nextNode;
    //data
    Node (Entity dataInput){
        data = dataInput;
        this.nextNode = null;
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

    Entity getData(){
        return data;
    }
}
