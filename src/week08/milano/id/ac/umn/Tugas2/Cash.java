package week08.milano.id.ac.umn.Tugas2;

public class Cash extends Payment {
    public Cash(Item item) {
        super(item);
    }

    @Override
    public int pay() {
        if (isPaidOff) return 0;
        isPaidOff = true;
        return item.getPrice();
    }

    @Override
    public int getRemainingAmount() {
        return isPaidOff ? 0 : item.getPrice();
    }
}
