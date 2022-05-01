package game;

public class ClockSettings {
    private int mode;
    private int basic_time;
    private int additional_time;
    private int time_to_countdown;
    final public int NO_CLOCK = 1;

    final public int SIMPLE_DELAY = 1;
    final public int INCREMENT = 2;

    public ClockSettings(int mode, int basic_time, int additional_time, int time_to_countdown) {

        this.mode = mode;
        if (mode == SIMPLE_DELAY) {
            this.additional_time = 0;
            this.time_to_countdown = time_to_countdown;
            this.basic_time = basic_time;
        } else if (this.mode == INCREMENT) {

            this.additional_time = additional_time;
            this.time_to_countdown = 0;
            this.basic_time = basic_time;
        } else if (mode == NO_CLOCK) {
            this.additional_time = 0;
            this.time_to_countdown = 0;
            this.basic_time = 0;
        }

    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setBasic_time(int basic_time) {
        this.basic_time = basic_time;
    }

    public void setAdditional_time(int additional_time) {
        this.additional_time = additional_time;
    }

    public void setTime_to_countdown(int time_to_countdown) {
        this.time_to_countdown = time_to_countdown;
    }
}
