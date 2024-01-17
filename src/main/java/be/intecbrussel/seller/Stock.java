package be.intecbrussel.seller;

public class Stock {
    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    public Stock() {
        this.iceRockets = 0;
        this.cones = 0;
        this.balls = 0;
        this.magni = 0;
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "iceRockets=" + iceRockets +
                ", cones=" + cones +
                ", balls=" + balls +
                ", magni=" + magni +
                '}';
    }
}
