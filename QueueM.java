import java.util.*;
public class QueueM {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void add(int data){
            Node newNode= new Node(data);
            if(tail==null){
                tail=head=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front =head.data;
            if(head==tail){
                tail=null;
            }
            head=head.next;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    /* queue using array
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1;

        Queue(int n){
            arr=new int[n];
            this.size=n;
        }

        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public static boolean isFull(){
            return (rear+1)%size==front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("full queue");
                return ;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            int result=arr[front];

            if(rear==front){
                rear=front=-1;

            }else{
                front=(front+1)%size;
            }
            return result;
        }
        public static int peak(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return arr[front];
        }
    }*/
    static class QueueUsingStack{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }
    }
    public static void main(String[] args) {
        
    }
}
