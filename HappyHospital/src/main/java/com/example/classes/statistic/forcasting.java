package com.example.classes.statistic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Phaser;

import org.w3c.dom.Text;

import com.example.classes.Constant;

public class forcasting {
    public Map<Integer,Set<waiting>> waitingAutoAgv;
    private Set<Integer> doneAutoAgv;
    private int doNothing = 0;
    public int averageAverageWaitingTime =0 ;
    
    public void rememberDoneAutoAgv(int id){
        if(!this.doneAutoAgv.contains(id)){
            this.doneAutoAgv.add(id);
        }
    }
    public void removeAutoAgv(int id){
        if(this.waitingAutoAgv == null) {
            return;
        }
        if(this.waitingAutoAgv.size() == 0) {
            return;
        }
        if(this.waitingAutoAgv.containsKey(id)) {
            this.waitingAutoAgv.remove(id);
        }
    }
    // public void removeDuration(int id) {
    //     if(this.waitingAutoAgv == null) {
    //         return;
    //     }
    //     if(this.waitingAutoAgv.containsKey(id)) {
    //         int now = Math.floor(performance.now()/1000);
    //         let arr: Array<waiting> = new Array<waiting>();
    //         this.waitingAutoAgv.get(id)?.forEach(
    //             (item) => {
    //                 if(item.end != -1 && item.end < now - Constant.DELTA_T) {
    //                     // console.log("Va cham luc " + item.end + " < " + (now - Constant.DELTA_T));
    //                     arr.push(item);
    //                 }
    //             }
    //         );
    //         arr.forEach(
    //             (item) => {
    //                 this.waitingAutoAgv?.get(id)?.delete(item);
    //             }
    //         );
    //         if(this.waitingAutoAgv.get(id)?.size == 0) {
    //         //Nếu tất cả quá khứ của autoAgv (có định danh id) đã xoá hết
    //         //và nếu autoAgv này đã đến đích
    //             if(this.doneAutoAgv?.has(id)) {
    //                 //Thì xoá nó khỏi các danh sách của forcasting
    //                 this.waitingAutoAgv.delete(id);
    //                 this.doneAutoAgv.delete(id);
    //             }
    //         }
    //         arr = [];
    //     }
    // }

    public void addDuration(int id, waiting duration) {
      
        if(!this.waitingAutoAgv.containsKey(id)) {
            Set<waiting> s = new HashSet<>();
            this.waitingAutoAgv.put(id,s);
        }
        Set<waiting> m = this.waitingAutoAgv.get(id); //.add(duration);
        m.add(duration);
        this.waitingAutoAgv.put(id, m);
    }

    public void updateDuration(int id, int begin, int end) {
        if(this.waitingAutoAgv == null) {
            return;
        }
        if(this.waitingAutoAgv.containsKey(id)) {
            this.waitingAutoAgv.keySet().forEach(v ->{
                
            });
        }
    }

    public double totalAverageWaitingTime (){
        double result = 0;
        if(this.waitingAutoAgv == null) {
            //this.waitingAutoAgv = new Map<number, Set<waiting>>();
            return 0.0;
        }
        if(this.waitingAutoAgv.size() == 0) {
            return 0;
        }
        
        // let now = Math.floor(performance.now()/1000);
        // this.waitingAutoAgv.forEach(
        //     (value: Set<waiting>, key: number) =>
        //         {
        //             let average : number = 0;
        //             let count : number = 0;
        //             this.removeDuration(key);//Gỡ đi các duration quá trễ rồi
        //             value.forEach(
        //                 (item) => {
        //                     count++;
        //                     if(item.end == -1) {
        //                         average += now - item.begin;
        //                     }
        //                     else{
        //                         average += item.duration;
        //                     }
        //                 }
        //             );
        //             if(count == 0) {
        //                 average = 0;
        //             }
        //             else{
        //                 average = average / count;
        //             }
        //             result += average;
        //         }
        // );
        // result = Math.floor(result*100)/100;
        return result;
    }

    public String log() {
        double total = this.totalAverageWaitingTime();
        int numAutoAgv = this.waitingAutoAgv.size();
        double result = 0;
        if(numAutoAgv != 0) result = total/numAutoAgv;
        result = Math.floor(result*100)/100;
        return "Tu giay: ";
    }

    public void calculate(){
        double total  = this.totalAverageWaitingTime();
        int numAutoAgv  = this.waitingAutoAgv.size();
        //let result : number = 0;
        if(numAutoAgv != 0) this.averageAverageWaitingTime = (int)total/numAutoAgv;
        this.averageAverageWaitingTime = (int)Math.floor(this.averageAverageWaitingTime*100)/100;
    }
}
