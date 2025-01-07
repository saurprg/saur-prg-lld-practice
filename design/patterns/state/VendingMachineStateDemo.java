package design.patterns.state;
import java.util.ArrayList;

class VendingMachine {
    public State state;
    public int money = 0;
    public ArrayList<Integer> products = new ArrayList<>();

    VendingMachine() {
        this.state = new IdleState();
        for(int i=0; i< 100; i++) {
            products.add(i+10);
        }
    }

    public void setState(State s) {
        this.state = s;
    }
    
    public int dispence(int i) {
        return this.state.dispence(this, i);
    }

    public int addMoney(int money) {
        return this.state.addMoney(this, money);
    }

    public int stopTransaction() {
        return this.state.stopTransaction(this);
    }

}

abstract class State {
    abstract int dispence(VendingMachine machine, int i);
    abstract int addMoney(VendingMachine machine, int money);
    abstract int stopTransaction(VendingMachine machine);
}

class IdleState extends State {

    @Override
    int dispence(VendingMachine machine, int i) {
        return -1;
    }

    @Override
    int addMoney(VendingMachine machine, int money) {
        machine.money += money;
        machine.setState(new TransctionInProgressState());
        return machine.money;
    }

    @Override
    int stopTransaction(VendingMachine machine) {
        machine.setState(new IdleState());
        return 0;
    }

}

class TransctionInProgressState extends State{

    @Override
    int dispence(VendingMachine machine, int i) {
        if(i < machine.products.size()) {
            int price = machine.products.get(i);
            if(machine.money <= price) {
                machine.money -= price;
                return machine.products.remove(i);
            }
            return -1;
        }
        return -1;
    }

    @Override
    int addMoney(VendingMachine machine, int money) {
        machine.money += money;
        return machine.money;
    }

    @Override
    int stopTransaction(VendingMachine machine) {
        int balance = machine.money;
        machine.money = 0;
        machine.setState(new IdleState());
        return balance;
    }

}

public class VendingMachineStateDemo {

    public static void main(String[] args) {
        VendingMachine v = new VendingMachine();
        System.out.println(v.dispence(0));
        System.out.println(v.addMoney(1000));
        System.out.println(v.dispence(10));
        System.out.println(v.dispence(11));
        System.out.println(v.dispence(90));
        System.out.println(v.stopTransaction());
    }    
}
