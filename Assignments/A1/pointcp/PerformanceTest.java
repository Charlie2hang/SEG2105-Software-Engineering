import design5.PointCP5;


import java.util.*;

public class PerformanceTest {

    private static double max(double[] list){
        double max= list[0];
        for (int i=1; i<list.length;i++){
            if (list[i]>max){
                max=list[i];
            }
        }
        return max;
    }
    private static double min(double[] list){
        double min= list[0];
        for (int i=1; i<list.length;i++){
            if (list[i]<min){
                min=list[i];
            }
        }
        return min;
    }

    private  static double median(double[] list){
        for (int i=0;i<list.length;i++){
            for (int j=i+1;j<list.length;j++){
                if (list[i]>list[j]){
                    double temp= list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
        double median;
        if (list.length%2==0){
            median=(list[list.length/2-1]+list[list.length/2])/2;

        }else{
            median=list[((list.length+1)/2)-1];
        }
        return median;
    }

    private static double randomGenerator(){
        Random rand=new Random();
        double largeOutput=rand.nextDouble(1000000.2524458,2000000.2524458);

        return largeOutput;
    }
    private static char randomTypeGenerator(){
        Random rand=new Random();
        int randType=rand.nextInt(2);

        return (randType==0?'C':'P');
    }
    private static ArrayList<Double>[] testForLargeInput(char type, double xOrR, double yOrT){
        ArrayList<Double> timeStudyDesign1=new ArrayList<Double>();
        ArrayList<Double> timeStudyDesign5=new ArrayList<Double>();
        PointCP point1 = new PointCP(type,xOrR,yOrT);
        PointCP5 point5;
        if (type=='C'){
            point5=new design5.PointCP3(xOrR,yOrT);
        }else{
            point5=new design5.PointCP2(xOrR,yOrT);
        }
        long start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point1.getX();
        }
        long end=System.nanoTime();
        double timeused=(double)(end-start)/1_000_000;
        timeStudyDesign1.add(timeused);

        for (int i=0;i<10000000;i++) {
            point1.getY();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign1.add(timeused);

        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point1.getRho();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign1.add(timeused);

        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point1.getTheta();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign1.add(timeused);

        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point5.getX();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign5.add(timeused);
        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point5.getY();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign5.add(timeused);

        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point5.getRho();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign5.add(timeused);

        start=System.nanoTime();
        for (int i=0;i<10000000;i++) {
            point5.getTheta();
        }
        end=System.nanoTime();
        timeused=(double)(end-start)/1_000_000;
        timeStudyDesign5.add(timeused);

        return new ArrayList[]{timeStudyDesign1, timeStudyDesign5};
    }
    public static void main(String[] args){
        System.out.println("Performance test for Design 1&5");
        System.out.println("Please choose which type of test you want to run (C)artesian/(P)olar/(R)andom:");
        Scanner scanner=new Scanner(System.in);
        String in=scanner.next().toUpperCase();
        if (in.equals("C")){
            differenceTestType(0);
        } else if (in.equals("P")) {
            differenceTestType(1);
        }else if(in.equals("R")){
            differenceTestType(2);
        }else{
            System.out.println("Please choose valid type (C)artesian/(P)olar/(R)andom:");
        }
    }

    public static void differenceTestType(int type){
        double[] d1GetX=new double[100];
        double[] d1GetY=new double[100];
        double[] d1GetRho=new double[100];
        double[] d1GetTheta=new double[100];
        double[] d5GetX=new double[100];
        double[] d5GetY=new double[100];
        double[] d5GetRho=new double[100];
        double[] d5GetTheta=new double[100];
        if (type==0){
            System.out.println("Performance test for Design 1&5 with only Cartesian coordinates");

            for(int i=0;i<100;i++){
                ArrayList[] statsList;
                statsList = testForLargeInput('C',randomGenerator(),randomGenerator());
                d1GetX[i]=(double)statsList[0].get(0);
                d1GetY[i]=(double)statsList[0].get(1);
                d1GetRho[i]=(double)statsList[0].get(2);
                d1GetTheta[i]=(double)statsList[0].get(3);
                d5GetX[i]=(double)statsList[1].get(0);
                d5GetY[i]=(double)statsList[1].get(1);
                d5GetRho[i]=(double)statsList[1].get(2);
                d5GetTheta[i]=(double)statsList[1].get(3);
            }
        }else if(type==1){
            System.out.println("Performance test for Design 1&5 with only Polar coordinates");

            for(int i=0;i<100;i++){
                ArrayList[] statsList;
                statsList = testForLargeInput('P',randomGenerator(),randomGenerator());
                d1GetX[i]=(double)statsList[0].get(0);
                d1GetY[i]=(double)statsList[0].get(1);
                d1GetRho[i]=(double)statsList[0].get(2);
                d1GetTheta[i]=(double)statsList[0].get(3);
                d5GetX[i]=(double)statsList[1].get(0);
                d5GetY[i]=(double)statsList[1].get(1);
                d5GetRho[i]=(double)statsList[1].get(2);
                d5GetTheta[i]=(double)statsList[1].get(3);
             }

        }else{
            System.out.println("Performance test for Design 1&5 with random coordinates");

            for(int i=0;i<100;i++){
                ArrayList[] statsList;
                statsList = testForLargeInput('P',randomGenerator(),randomGenerator());
                d1GetX[i]=(double)statsList[0].get(0);
                d1GetY[i]=(double)statsList[0].get(1);
                d1GetRho[i]=(double)statsList[0].get(2);
                d1GetTheta[i]=(double)statsList[0].get(3);
                d5GetX[i]=(double)statsList[1].get(0);
                d5GetY[i]=(double)statsList[1].get(1);
                d5GetRho[i]=(double)statsList[1].get(2);
                d5GetTheta[i]=(double)statsList[1].get(3);
            }

        }

        System.out.println("The max time take of design1 getX()= "+max(d1GetX));
        System.out.println("The min time take of design1 getX()= "+min(d1GetX));
        System.out.println("The median time take of design1 getX()= "+median(d1GetX));
        System.out.println("The max time take of design1 getY()= "+max(d1GetY));
        System.out.println("The min time take of design1 getY()= "+min(d1GetY));
        System.out.println("The median time take of design1 getY()= "+median(d1GetY));
        System.out.println("The max time take of design1 getRho()= "+max(d1GetRho));
        System.out.println("The min time take of design1 getRho()= "+min(d1GetRho));
        System.out.println("The median time take of design1 getRho()= "+median(d1GetRho));
        System.out.println("The max time take of design1 getTheta()= "+max(d1GetTheta));
        System.out.println("The min time take of design1 getTheta()= "+min(d1GetTheta));
        System.out.println("The median time take of design1 getTheta()= "+median(d1GetTheta));

        System.out.println("The max time take of design5 getX()= "+max(d5GetX));
        System.out.println("The min time take of design5 getX()= "+min(d5GetX));
        System.out.println("The median time take of design5 getX()= "+median(d5GetX));
        System.out.println("The max time take of design5 getY()= "+max(d5GetY));
        System.out.println("The min time take of design5 getY()= "+min(d5GetY));
        System.out.println("The median time take of design5 getY()= "+median(d5GetY));
        System.out.println("The max time take of design5 getRho()= "+max(d5GetRho));
        System.out.println("The min time take of design5 getRho()= "+min(d5GetRho));
        System.out.println("The median time take of design5 getRho()= "+median(d5GetRho));
        System.out.println("The max time take of design5 getTheta()= "+max(d5GetTheta));
        System.out.println("The min time take of design5 getTheta()= "+min(d5GetTheta));
        System.out.println("The median time take of design5 getTheta()= "+median(d5GetTheta));
    }


}
