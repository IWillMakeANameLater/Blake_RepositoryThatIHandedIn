public class Time {
    // Fields
    private int hour;
    private int minute;
    private int second;

    // Methods

    // full constructor
    // takes hour, minute and second
    // it uses the object's setters
    // instead of setting it directly
    // so that out of bound inputs can be handled by those methods
    public Time(int hour, int minute, int second){
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    // Getters and Setters

    public int getHour() {
        return hour;
    }


    // sets hour of time object
    // also handles out of bounds inputs
    public void setHour(int hour) {
        this.hour = hour;
        if (this.hour < 0){
            this.hour = 0;
        } else if (this.hour > 23){
            this.hour = 23;
        }
    }

    public int getMinute() {
        return minute;
    }

    // same thing as setHour but for the minutes of the time object
    public void setMinute(int minute) {
        this.minute = minute;
        if (this.minute < 0){
            this.minute = 0;
        } else if (this.minute > 59){
            this.minute = 59;
        }
    }

    public int getSecond() {
        return second;
    }

    // same as setMinute and setHour but for seconds
    public void setSecond(int second) {
        this.second = second;
        if (this.second < 0){
            this.second = 0;
        } else if (this.second > 59){
            this.second = 59;
        }
    }

    // a method that lets you directly change all 3 time components of the object
    // sets them through the existing setters to
    // handle out of bounds inputs
    public void setTime(int hour, int minute, int second){
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    // handles increasing/decreasing the hours of the object
    // as well as making sure it doesn't go out of bounds
    private void shiftHour(int shiftAmount){
        this.hour += shiftAmount;
        if (this.hour >= 24){
            this.hour = 0;
        } else if (this.hour < 0){
            this.hour = 23;
        }
    }

    // handles increasing/decreasing minutes of the object
    // and like the shiftHour method, makes sure it won't go out of bounds
    // if it would go out of bounds, puts it back in index
    // and shifts the hours accordingly
    private void shiftMinute(int shiftAmount){
        this.minute += shiftAmount;
        if (this.minute >= 60){
            this.minute = 0;
            this.shiftHour(1);
        } else if (this.minute < 0){
            this.minute = 59;
            this.shiftHour(-1);
        }
    }

    // increments seconds
    // if it would go out of bounds put it back in to bounds and shift minutes forwards
    public Time nextSecond(){
        this.second++;
        if (this.second >= 60){
            this.second = 0;
            this.shiftMinute(1);
        }
        return this;
    }


    // decrements seconds
    // if it would go below 0 it would put it back to 59 ( of the previous minute) and shifts minutes backwards
    public Time previousSecond(){
        this.second--;
        if (this.second < 0){
            this.second = 59;
            this.shiftMinute(-1);
        }
        return this;
    }

    @Override

    // Prints the hours, minutes and seconds in the format of
    // HH:MM:SS
    // if the hours, minutes or seconds has only 1 decimal place
    // it will put a leading zero in front of it
    public String toString(){

        String timeString = "";

        int[] timeComponents = {this.hour, this.minute, this.second};

        for(int i = 0; i<3; i++){
            int componentValue = timeComponents[i];
            String componentString = String.valueOf(componentValue);
            if (componentValue < 10){
                componentString = "0" + componentString;
            }
            if (i != 2) {
                componentString += ":";
            }
            timeString += componentString;
        }

        return timeString;
    }
}
