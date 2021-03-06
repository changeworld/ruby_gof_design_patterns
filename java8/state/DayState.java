public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    public void doClock(Context context, int hour) {
        if (context.isNoon(hour)) {
            context.changeState(NoonState.getInstance());
        } else if (context.isNight(hour)) {
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordLog("Use of safe(daytime)");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("Emergency call(daytime)");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("Normal call(daytime)");
    }

    public String toString() {
        return "[daytime]";
    }
}