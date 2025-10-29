package week08.milano.id.ac.umn.Tugas2;

public abstract class Payment {
    protected boolean isPaidOff;
    protected Item item;

    public Payment(Item item) {
        this.item = item;
        this.isPaidOff = false;
    }

    public abstract int pay();

    public boolean isPaidOff() {
        return isPaidOff;
    }

    public Item getItem() {
        return item;
    }

    public String getStatus() {
        return isPaidOff ? "FINISHED" : "ON PROGRESS";
    }

    public abstract int getRemainingAmount();
}
