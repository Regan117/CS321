package org.openjfx;
import java.util.ArrayList;

public class WorkFlow {
public int tasknum = 1;

public int uniqueID = 0;
ArrayList<Integer> approvalList = new ArrayList<>();
ArrayList<Integer> reviewList = new ArrayList<>();
ArrayList<Integer> DoneList = new ArrayList<>();

public static void main(String[] args){
    WorkFlow test = new WorkFlow();
    test.StoreFinishedTasks(1, "DataEntry");
    test.StoreFinishedTasks(2, "DataEntry");

}
public WorkFlow(){

}
public int getUniqueID(){
    uniqueID ++;
    return uniqueID -1;
}

public WorkFlow(int tasknum){

}
public int SendTasks(int tasknum){
    return -1;
}

public int StoreFinishedTasks(int tasknum, String from){
    if(from.equals("DataEntry")){
        reviewList.add(tasknum);
        if(reviewList.contains(tasknum)){
            return 0;
        }
    }
    if(from.equals("Review")){
        approvalList.add(tasknum);
        if(approvalList.contains(tasknum)){
            return 0;
        }
    }
    if(from.equals("approver")){
        DoneList.add(tasknum);
        if(DoneList.contains(tasknum)){
            return 0;
        }
    }
    return -1;
}

public int getApproverNext(){
    if(!approvalList.isEmpty()){
        return approvalList.remove(0);
    }
    else{

        return 1;
    }
}

}