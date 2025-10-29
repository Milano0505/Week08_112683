package week08.milano.id.ac.umn.Tugas2;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;
    }

    @Override
    public int pay() {
        if (isPaidOff) return 0;

        int installmentAmount = item.getPrice() / maxInstallmentAmount;
        installment++;

        if (installment >= maxInstallmentAmount) {
            isPaidOff = true;
        }

        return installmentAmount;
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) return 0;
        int remaining = maxInstallmentAmount - installment;
        return remaining * (item.getPrice() / maxInstallmentAmount);
    }

    public int getInstallment() {
        return installment;
    }
    public int getMaxInstallmentAmount() {
        return maxInstallmentAmount;
    }
}
