import java.util.ArrayList;
import java.util.Iterator;

class Node{
    int data;
    int priority;

    public Node(int priority,int data) {
        this.data = data;
        this.priority = priority;
    }
    public Node() {}

}

class Heap{
    ArrayList<Node> node;

    int size;

    public Heap(){
        this.node= new ArrayList<Node>();
        //this.node.add(new Node(0,0));
        this.size = 0;
    }

    // case : size % 2 == 0 : right is empty
    // case : size % 2 == 1 : full bin tree

    public void insert(Heap ph,int priority,int data){
        if(ph.size == 0){
            System.out.println("최초 삽입");
            //ph.size++;
            ph.node.add(ph.size++,new Node(data,priority));
        }
        else{
            System.out.println("after Insert");
            Node newNode = new Node(data,priority);
            int parentIdx = ph.size-1;
            int currIdx = ph.size;
            ph.node.add(ph.size,new Node());
            while(currIdx > 0){ // 해당 위치의 조건식이 달라져야 할 것... currIdx > 0
                if(ph.node.get(parentIdx).priority<priority) {
                    ph.node.set(currIdx, ph.node.get(parentIdx)); // 1depth 내림처리
                    currIdx = parentIdx;
                    parentIdx = getParentIdx(parentIdx);
                }else break;
            }
            ph.node.set(currIdx,newNode);
            ph.size++;
        }
    }

    public int getParentIdx(int size){
        if (size == 0) return 0;
        else if (size == 1) return 0;
        else return (size-1)/2;
    }

    public int getLeftChildIdx(int size){
        return size*2;
    }

    public int getRightChildIdx(int size){
        return size*2+1;
    }

    public boolean isEmptyH(Heap ph){
        if(ph.node == null){
            System.out.println("Heap is Empty! ");
            return true;
        }
        return false;
    }

    // outPut Heap
    public void printHeap(Heap ph){
        if(!isEmptyH(ph)){
            Iterator<Node> iter = ph.node.iterator();
            while(iter.hasNext()){
                Node node = iter.next();
                System.out.println(node.data);
            }
        }
    }

}



public class PriorityQueue {
    public static void main(String[] args) throws Exception {
        Heap heap = new Heap();
        heap.insert(heap,1,5);
        heap.insert(heap,4,2);
        heap.insert(heap,5,1);
        heap.insert(heap,2,4);
        heap.insert(heap,3,3);
        heap.printHeap(heap);

//        ArrayList <Node> ah = new ArrayList<Node>();
//        Node t1   = new Node(1,2);
//        ah.add(0,t1);
//        System.out.println(ah.get(1));
    }
}
