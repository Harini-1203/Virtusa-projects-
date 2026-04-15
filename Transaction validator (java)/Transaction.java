public class Transaction {
    private int transaction_id;
    private String type;
    private double amount;
    private double prev;

    public Transaction(double amount,double prev, String type, int transaction_id) {
        this.amount = amount;
        this.type = type;
        this.transaction_id = transaction_id;
        this.prev=prev;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "transaction_id=" + transaction_id +
                ", type='" + type + '\'' +
                ", Amount before: "+ prev +
                ", amount=" + amount +
                '}';
    }
}
