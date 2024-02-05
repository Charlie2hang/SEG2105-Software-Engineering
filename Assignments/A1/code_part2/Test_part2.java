import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Test_part2 {


    public static void main (String[] args){
        int size= 400000000;
        Random rand=new Random();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        Vector<Integer> vectorList=new Vector<Integer>();
        int[] originalArray=new int[size];
        double timeV=0;
        for (int i=0; i<size;i++){
            int input=rand.nextInt(10);
            long start=System.nanoTime();
            vectorList.add(input);
            long end=System.nanoTime();
            timeV +=(double) (end-start)/1000000000;
        }
        double timeA=0;
        for (int i=0; i<size;i++){
            int input=rand.nextInt(10);
            long start=System.nanoTime();
            arrayList.add(input);
            long end=System.nanoTime();
            timeA +=(double) (end-start)/1000000000;
        }

        double timeO=0;
        for (int i=0; i<size;i++){
            int input=rand.nextInt(10);
            long start=System.nanoTime();
            originalArray[i]=input;
            long end=System.nanoTime();
            timeO +=(double) (end-start)/1000000000;
        }

        System.out.println("Time use for testing Arraylist: "+ timeA + " seconds");
        System.out.println("Time use for testing Vectorlist: "+ timeV + " seconds");
        System.out.println("Time use for testing Originarray: "+ timeO + " seconds");
        System.out.println("");
        System.out.println("");
        System.out.println("");


        int sumA=0;
        Iterator itA= arrayList.iterator();
        long startA=System.nanoTime();
        while (itA.hasNext()){
            sumA += (int)itA.next();
        }
        long endA=System.nanoTime();
        double addTimeA=(double)(endA-startA)/1000_000_000;

        int sumV=0;
        Iterator itV= vectorList.iterator();
        long startV=System.nanoTime();
        while (itV.hasNext()){
            sumA +=(int)itV.next();
        }
        long endV=System.nanoTime();
        double addTimeV=(double)(endV-startV)/1000_000_000;

        int sumO=0;
        long startO=System.nanoTime();
        for (int i=0;i<originalArray.length;i++){
            sumO+=originalArray[i];
        }
        long endO=System.nanoTime();
        double addTimeO=(double)(endO-startO)/1000_000_000;

        System.out.println("Time use for testing Sum element in Arraylist: "+ addTimeA + " seconds");
        System.out.println("Time use for testing Sum element in Vectorlist: "+ addTimeV + " seconds");
        System.out.println("Time use for testing Sum element in Originarray: "+ addTimeO + " seconds");
    }




}
