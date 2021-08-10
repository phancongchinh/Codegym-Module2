public class StopWatch {
    private float startTime;
    private float endTime;

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = sort.initArray();
        StopWatch stw = new StopWatch();

        stw.start();
        System.out.println("Stop Watch: Start Time = " + stw.getStartTime() + "s");

        sort.selectionSort(array);

        stw.end();
        System.out.println("Stop Watch: End Time = " + stw.getEndTime() + "s");

        System.out.println("The elapsed time is " + stw.getElapsedTime() + "s");
    }

    public StopWatch() {
        this.startTime = java.time.LocalTime.now().getNano();
    }

    public float getStartTime() {
        return this.startTime / 1000000000;
    }

    public float getEndTime() {
        return this.endTime / 1000000000;
    }

    public void start() {
        this.startTime = java.time.LocalTime.now().getNano();
    }

    public void end() {
        this.endTime = java.time.LocalTime.now().getNano();
    }

    public float getElapsedTime() {
        return this.getEndTime() - this.getStartTime();
    }
}
