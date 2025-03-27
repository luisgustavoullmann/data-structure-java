package strings;

public class Data1 {
    public  static DateData extractDateData(String date) {

        String[] parts = date.split("/");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return new DateData(day, month, year);
    }

    public static void main(String[] args) {
        DateData obj = extractDateData("05/04/2015");
        System.out.println("Day: " + obj.day);
        System.out.println("Month: " + obj.month);
        System.out.println("Year: " + obj.year);
    }
}

class DateData {
    int day, month, year;

    public DateData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
