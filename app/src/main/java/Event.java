import android.content.Context;

public class Event {


    private String eventName;
    private String descrip;
    private int year = -1;
    private int month = -1;
    private int day = -1;
    private boolean hasDate = false;

    //Constructor Specifying date
    public Event(Context context, String eventName, int year, int month, int day) {
        this.eventName = eventName;
        this.year = year;
        this.month = year;
        this.day = day;
        hasDate = true;
    }

    public boolean hasDate() {
        if (!hasDate) {
            if (year != -1 && month != -1 && day != -1) {
                hasDate = true;
            }
        }
        return hasDate;
    }

    //Constructor without date
    public Event(Context context, String eventName) {
        this.eventName = eventName;
        this.descrip = descrip;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public void setEventName(String input) {
        this.eventName = input;
    }

    public void setDescrip(String input) {
        this.descrip = input;
    }

    public void setDay(int day) {
        this.day = day;
        hasDate();
    }

    public void setMonth(int month) {
        this.month = month;
        hasDate();
    }

    public void setYear(int year) {
        this.year = year;
        hasDate();
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        hasDate();
    }

    @Override
    public String toString() {
        if (hasDate()) {
            return eventName + ", " + month + ", " + day + ", " + year;
        }
        return eventName;
    }


}
