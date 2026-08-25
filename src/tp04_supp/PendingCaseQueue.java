package tp04_supp;

import java.util.Arrays;

import tpOO.tp04.PendingCase;
//  javac -d bin -cp bin:lib/tp04-res.jar src/tp04_supp/*.java
//  java -cp bin:lib/tp04-res.jar tp04_supp.UsePendingCaseQueue

public class PendingCaseQueue {

    public static int CAPACITY = 10;
    private int idx;
    private PendingCase[] queue;

    public PendingCaseQueue() {
        this.queue = new PendingCase[CAPACITY];
        this.idx = 0;
    }
    
    public void clear() {
        for(int i = 0; i < CAPACITY; i++) {
            this.queue[i] = null;
        }
        this.idx = 0;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public boolean isFull() {
        return idx == this.queue.length;
    }

    public int size() {
        return idx;
    }

    public void addOne(PendingCase other) {
        if (this.isFull()) return;
        this.queue[idx] = other;
        idx++;
    }

    public PendingCase removeOne() {
        PendingCase output = this.queue[0];
        this.popLeft();
        return output;
    }
    
    private void popLeft() {
        PendingCase tab[] = new PendingCase[CAPACITY];
        for(int i = 0; i < CAPACITY-1; i++) {
            tab[i] = this.queue[i+1];
        }
        this.queue = tab;
        this.idx--;
    }

    public String toString() {
        return Arrays.toString(this.queue);
    }

    public double getTotalAmount() {
        double total = 0;
        for(PendingCase pc : this.queue) {
            total += pc.getAmount();
        }
        return total;
    }

    public void cheating(PendingCase another, int position) {
        if(this.isFull()) return;
        if (position < 0 || position > this.idx) return;
        for (int i = this.idx; i > position; i--) {
            this.queue[i] = this.queue[i - 1];
        }
        this.queue[position] = another;
        this.idx++;
    }

}
