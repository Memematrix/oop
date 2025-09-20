package HW1;

public class RollLoadedDice {
    public static void main(String[] args) {
        double chance = Math.random();
        int roll;
        if (chance < 1.0/8.0) {
            roll = 1;
        } else if (chance < 2.0/8.0) {
            roll = 2;
        } else if (chance < 3.0/8.0) {
            roll = 3;
        } else if (chance < 4.0/8.0) {
            roll = 4;
        } else if (chance < 5.0/8.0) {
            roll = 5;
        } else {
            roll = 6;
        }
        System.out.println(roll);
    }
}
