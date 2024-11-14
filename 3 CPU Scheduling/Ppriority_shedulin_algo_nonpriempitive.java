import java.util.Scanner;
class Ppriority_shedulin_algo_nonpriempitive
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a no of process");
        int n=sc.nextInt();
        int process[]=new int[n];
        int priority[]=new int[n];
        int ArrivalTime[]=new int[n];
        int BurstTime[]=new int[n];
        int remBurstTime[]=new int[n];
        int complitionTime[]=new int[n];
        int TurnAroundTime[]=new int[n];
        int waitingTime[]=new int[n];
        float avgTAT,avgWAT,avgTAT1=0,avgWt1=0;
        int visit[]=new int[n];
        int temp=0;
        for(int i=0;i<n;i++)
        {
            process[i]=(i+1);
            System.out.println("enter a arrival time for process"+(i+1)+":");
            ArrivalTime[i]=sc.nextInt();
            System.out.println("enter a burst time for process"+(i+1)+":");
            BurstTime[i]=sc.nextInt();
            System.out.println("enter a priority time for process"+(i+1)+":");
            priority[i]=sc.nextInt();
            remBurstTime[i]=BurstTime[i];
            visit[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(ArrivalTime[i]<ArrivalTime[j])
                {
                    temp=process[j];
                    process[j]=process[i];
                    process[i]=temp;
                    temp=priority[j];
                    priority[j]=priority[i];
                    priority[i]=temp;
                    temp=ArrivalTime[j];
                    ArrivalTime[j]=ArrivalTime[i];
                    ArrivalTime[i]=temp;
                    temp=BurstTime[j];
                    BurstTime[j]=BurstTime[i];
                    BurstTime[i]=temp;
                    temp=remBurstTime[j];
                    remBurstTime[j]=remBurstTime[i];
                    remBurstTime[i]=temp;

                }
               else if(ArrivalTime[i]==ArrivalTime[j]&&priority[i]<priority[j])
               {
                temp=process[j];
                process[j]=process[i];
                process[i]=temp;
                temp=priority[j];
                priority[j]=priority[i];
                priority[i]=temp;
                temp=ArrivalTime[j];
                ArrivalTime[j]=ArrivalTime[i];
                ArrivalTime[i]=temp;
                temp=BurstTime[j];
                BurstTime[j]=BurstTime[i];
                BurstTime[i]=temp; 
                temp=remBurstTime[j];
                remBurstTime[j]=remBurstTime[i];
                remBurstTime[i]=temp;
                

               }
            }
        }
      int   total=0,start=0;
       while(true){
         int c=n, min=0;
         if(total==n)
        {
            break;
        }
        for(int i=0;i<n;i++)
        {
           if(ArrivalTime[i]<=start && visit[i]==0)
           {
             if(min<priority[i])
             {
                min=priority[i];
                c=i;
             }
           }
       
    }
    if(c==n)
    {
        start++;
    }
    else{
        
       
       if(c==0)
        {
            complitionTime[c]=ArrivalTime[c]+BurstTime[c];
            visit[c]=1;
            total++;
            temp=complitionTime[c];
            start=complitionTime[c]; 
        }
        else{
                complitionTime[c]=temp+BurstTime[c];
                visit[c]=1;
                total++;
                temp=complitionTime[c]; 
                start=complitionTime[c]; 
            }
    
            
        
    }
}
for(int i=0;i<n;i++)
{
    TurnAroundTime[i]=complitionTime[i]-ArrivalTime[i];
    waitingTime[i]=TurnAroundTime[i]-remBurstTime[i];
    avgTAT1=avgTAT1+TurnAroundTime[i];
    avgWt1=avgWt1+waitingTime[i];
}
System.out.println("priority sheduling algorithm");
System.out.println("procees\tArrivalTime\tBurstTime\tpriority\tcomplitiontime\tTurnAroundTime\tWatingTime");
    for(int i=0;i<n;i++)
    {
        System.out.println("P"+process[i]+"\t\t"+ArrivalTime[i]+"\t\t"+remBurstTime[i]+"\t\t"+priority[i]+"\t\t"+complitionTime[i]+"\t\t"+TurnAroundTime[i]+"\t\t"+waitingTime[i]);
    }
    avgTAT=avgTAT1/n;
    avgWAT=avgWt1/n;
    System.out.println("\nAverage turn around time is " + avgTAT);
    System.out.println("Average waiting time is " + avgWAT);
}
}