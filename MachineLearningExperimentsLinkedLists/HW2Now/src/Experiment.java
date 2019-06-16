public class Experiment {
    private int day;
    private String setup;
    private String time;
    private boolean completed;
    private float accuracy;

    Experiment()
    {
        setSetup("CSE222");
        setTime("Relative Time");
        setCompleted(true);
        setDay(28);
        setAccuracy((float)0.01);
    }
    public Experiment(String theSetup, int theDay, String theTime, boolean theCompleted, float theAccuracy)
    {
        setSetup(theSetup);
        setTime(theTime);
        setCompleted(theCompleted);
        setDay(theDay);
        setAccuracy(theAccuracy);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    Experiment(int theDay, String theSetup)
    {
        completed = false;
        day = theDay;
        setup = theSetup;
    }

    @Override
    public String toString() {
        String s = "Setup: " + this.getSetup() +
                " Day: " + this.getDay() + " Time: "
                + this.getTime() + " Completed Status: "
                + this.isCompleted() + " Accuracy: "
                + this.getAccuracy() + "\n";
        return s;

    }

}
