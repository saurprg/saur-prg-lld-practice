abstract class GymSession {

    void startGymSession() {
        this.doWarmUp();
        this.doWorkOut1();
        this.doWorkOut2();
        this.doStreching();
    }

    void doWarmUp() {
        System.out.println("Doing Commonn Everyday warmup");
    }

    abstract void doWorkOut1();
    abstract void doWorkOut2();

    void doStreching() {
        System.out.println("Doing Everyday Streching..");
    }
}

class PushDay extends GymSession {

    @Override
    void doWorkOut1() {
        System.out.println("Doing Chest Workout");
    }

    @Override
    void doWorkOut2() {
        System.out.println("Doing Tricep and Shoulder");
    }
    
}

class LegDay extends GymSession {

    @Override
    void doWorkOut1() {
        System.out.println("Doing Leg workout");
    }

    @Override
    void doWorkOut2() {
        System.out.println("Doing Abs");
    }
    
}

public class TemplateMethodDemo {

    public static void main(String[] args) {
        PushDay pday = new PushDay();
        pday.startGymSession();
        LegDay lDay = new LegDay();
        lDay.startGymSession();
    }
    
}
