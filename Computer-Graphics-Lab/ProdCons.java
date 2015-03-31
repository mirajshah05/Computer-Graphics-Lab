//import java.io.*;
//import java.util.*;
//package prod.cons;

/**
 *
 * @author djsce.student
 */
class ProdCons {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        queue q =new queue();
        Thread t=null;
        
        consumer c = new consumer(q);
        //static int que[]=new int[10];
        producer p=new producer(q);
        
        // TODO code application logic here
    }
    
    
}
class consumer implements Runnable{
    int i=0;
    Thread ct=new Thread(this);
    queue q;
    consumer(queue b){
         q=b;
        ct.start();
       
        
    
    }
    int j;
    
    
    @Override
    public void run()
    {
        System.out.println("The consumer started");
        while(true){
           if(q.empty()==0)
        {
        j=q.delete();
        
        System.out.println("The consumed data is"+j);
         try{
            ct.sleep(800);
            }
            catch(Exception e){}
        
        }
        else{
            try{
             ct.sleep(200);   
            }
            catch(Exception e){}
            
        } 
        }
        
    }
}
class producer implements Runnable{
    Thread pt=new Thread(this);
    queue q;
    producer(queue b)
    {
        pt.start();
        q=b;
        
    }
    int i=0;
    @Override
    public void run()
    {
        while(true){
           if(q.full()==0)
        {
            i++;
            q.add(i);
            System.out.println("The producer has produced "+i);
            try{
            pt.sleep(500);
            }
            catch(Exception e){}
        }
        else{
            try{
               pt.sleep(100); 
            }
            catch(Exception e){}
            
        } 
        }
        
    }
}
class queue{
    int front=-1;
    int rear=-1;
    int max=10;
    int a[]=new int[10];
     void add(int ele){
         if(rear==front&&rear==-1)
             front=0;
         a[++rear]=ele;
     }
     int delete(){
        int temp;
        
            
        temp=a[front++];
        if(front==rear+1){
            front=-1;
            rear=-1;
        }
        return temp;
     }

     int full(){
         if(rear==max-1){
             return 1;//1 is full
         }
         else
             return 0;
     }
     int empty(){
         if(rear==front&&rear==-1)
             return 1; //1 is empty
         else 
             return 0;
     }
}
