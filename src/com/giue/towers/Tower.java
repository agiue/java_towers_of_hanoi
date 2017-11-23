package com.giue.towers;

import java.util.Stack;

public class Tower {
    private Stack<Disk> disks;
    private int id;

    public Tower(int id) {
        disks = new Stack<>();
        this.id = id;
    }

    public boolean stack(Disk disk) {
        if (diskAllowed(disk)) {
            System.out.printf("Adding disk size %d to Tower %d\n", disk.getSize(), this.id);
            disks.push(disk);
            return true;
        }
        else
            return false;
    }

    public Disk unstack() {
        if (!disks.empty()) {
            Disk disk = disks.pop();
            System.out.printf("Removing disk size %d from Tower %d\n", disk.getSize(), this.id);
            return disk;
        }
        return null;
    }

    public boolean diskAllowed(Disk disk) {
        return (disks.isEmpty() || disks.peek().getSize() > disk.getSize());
    }

    protected void setDisks(int numberOfDisks) {
        for (int i = numberOfDisks; i > 0; --i) {
            System.out.printf("Adding disk size %d to Tower %d \n", i, this.id);
            disks.push(new Disk(i));
        }
    }

    public int getNumberOfDisks() {
        return disks.size();
    }

    public int getId() {
        return this.id;
    }
}
