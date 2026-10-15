package main.java.week_3.assigment_problems;

public class TrafficSignalSimulator {
    
    void simulateTrafficSignal(int cycles) {
        int state = 0;
        
        for (int i = 0; i < cycles; i++) {
            switch (state) {
                case 0:
                    System.out.print("Red - Stop ");
                    break;
                case 1:
                    System.out.print("Green - Go ");
                    break;
                case 2:
                    System.out.print("Yellow - Prepare to stop ");
                    break;
            }
            state = (state + 1) % 3;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TrafficSignalSimulator simulator = new TrafficSignalSimulator();
        simulator.simulateTrafficSignal(3);
    }
}
