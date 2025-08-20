package org.example;

public class Tank {
    static final String MODEL = "T34";
    static int cntTank;

    private int x, y;
    private int dir;
    private int fuel;
    private int n;
    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        n = ++cntTank;
    }
    public void goForward(int direction) {
        if(fuel-direction<0){
            if(dir==1 || dir==3){
                y+=fuel;
                fuel=0;
            }else{
                x+=fuel;
                fuel=0;
            }
        }else{
            if(dir==1 || dir==3){
                y+=direction;
                fuel-=direction;
            }else{
                x+=direction;
                fuel-=direction;
            }
        }
    }
    public void goBackward(int direction) {
        goForward(-direction);
    }
    public void printPosition() {
        System.out.println("The Tank "+MODEL+"-"+cntTank+" at " + x +", " + y + " now.");
    }
    public void turnRight() {
        dir++;
        if(dir==4) dir=0;
    }
    public void turnLeft() {
        dir--;
        if(dir==-1) dir=3;
    }
}
