class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head,tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new Node(-1,-1);
        tail=new Node(-1,-1);
        tail.prev = head;
        head.next=tail;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node= map.get(key);
        deleteNode(node);
        insertNode(node);
        return node.value;        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            node.value=value;
            insertNode(node);
            return;
        }

        if(map.keySet().size()==capacity){
            deleteLast();
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insertNode(newNode);
        
    }

    public void insertNode(Node node){
        Node nextNode = head.next;
        head.next=node;
        node.prev = head;
        node.next=nextNode;
        nextNode.prev = node;
    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    public void deleteLast(){
        Node lastNode = tail.prev;
    if (lastNode == head) return; 

    deleteNode(lastNode);        
    map.remove(lastNode.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */