package com.giue.towers;

import java.util.Arrays;
import java.util.List;

public class TowersOfHanoi {
    private int numberOfTowers = 3;

    private Tower[] towers;

    public TowersOfHanoi(int numberOfDisks) {
       towers = new Tower[numberOfTowers];

       for (int i = 0; i < numberOfTowers; ++i)
           towers[i] = new Tower(i+1);

       towers[0].setDisks(numberOfDisks);
    }

    protected void moveDisks(int numberOfDisks, Tower source, Tower destination, Tower buffer) {
        if (numberOfDisks > 0) {
            // move the top numberOfDisks - 1 from source to buffer
            moveDisks(numberOfDisks - 1 , source, buffer, destination);

            // Move the last disk on source to destination
            destination.stack(source.unstack());

            // Move the remaining disks from the buffer to the destination using the source as the buffer
            moveDisks(numberOfDisks - 1, buffer, destination, source);
        }
    }

    public void solve() {
        moveDisks(towers[0].getNumberOfDisks(), towers[0], towers[2], towers[1]);
        printTowerStates();
    }

    public void printTowerStates() {
        Arrays.stream(towers).forEach( tower -> System.out.printf("Tower %d has number of disks %d\n", tower.getId(), tower.getNumberOfDisks()));
    }
}
