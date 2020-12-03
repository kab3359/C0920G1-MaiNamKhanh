import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestKab {
    public static void daysBetween2Dates() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date1=null;
        Date date2=null;

        // Định nghĩa 2 mốc thời gian ban đầu
        try {
            date1 = dateFormat.parse("15-07-2000");
            date2 = dateFormat.parse("15-08-2000");
        }catch (ParseException e){
            e.printStackTrace();
        }

        c1.setTime(date1);
        c2.setTime(date2);


        // Công thức tính số ngày giữa 2 mốc thời gian:
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

        System.out.print("Số ngày giữa " + dateFormat.format(c1.getTime())

                + " và " + dateFormat.format(c2.getTime()) + ": ");

        System.out.println(noDay);

    }

    public static void main(String args[]) {
        daysBetween2Dates();


    }
}
// 3. So sánh 2 mốc thời gian (So sánh 2 ngày)
//    public static void compareDate(){
//
//        // Định nghĩa 2 mốc thời gian ban đầu
//        Date date1 = Date.valueOf("2011-06-15");
//        Date date2 = Date.valueOf("2011-07-30");
//
//        String relation;
//        if (date1.equals(date2))
//          relation = "Hai ngày trùng nhau";
//        else if (date1.before(date2)) // Hoặc  else if (date1.after(date2)== false)
//          relation = " Trước";
//        else
//          relation = " Sau";
//        System.out.println(date1 + relation + ' ' + date2);
//
//    }
//4. Kiểm tra một chuỗi có phải là một ngày hay không
// public boolean isValidDate(String inDate) {
//
//        if (inDate == null)
//          return false;
//
//        //set the format to use as a constructor argument
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        if (inDate.trim().length() != dateFormat.toPattern().length())
//          return false;
//
//        dateFormat.setLenient(false);
//
//        try {
//          //parse the inDate parameter
//          dateFormat.parse(inDate.trim());
//        }
//
//        catch (ParseException pe) {
//          return false;
//        }
//
//        return true;
//
//      }
// 5. Kiểm tra có phải năm nhuận hay không?
//    public static boolean isLeapYear(int year) {
//        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
//
//            return true;
//
//        }
//
//        return false;
//
//    }
// 6. Đếm số ngày trong một tháng.
//    public static void daysInMonth() {
//
//        TimeInJava tij = new TimeInJava();
//
//        Calendar c1 = Calendar.getInstance();
//        c1.set(2008, 6 , 20);
//
//        int year = c1.get(Calendar.YEAR);
//        int month = c1.get(Calendar.MONTH);
//
////      int days = c1.get(Calendar.DATE);
//
//        int [] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
//
//        daysInMonths[1] += tij.isLeapYear(year) ? 1 : 0;  // Sử dụng phương thức kiểm tra năm nhuần ở trên
//
//        System.out.println("Số ngày trong tháng "+month+" năm "+year+" : "+ daysInMonths[c1.get(Calendar.MONTH)]);
//    }
//7. So sánh giờ hiện tại có nằm trong khoảng giờ nào đó trong này hay không .
// Ví dụ : 10:20 có nằm trong khoảng 10:00 đến 10:40 hay không? :
//
////Phương thức xác định xem giờ hiện tại có thuộc vào một khoảng giờ nào đó hay không
//
//public static boolean isInHappyHour(String startHour, String endHour) throws ParseException {
//
//    boolean result = false;
//
//    SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
//
//    Date start = hourFormat.parse(startHour);
//    Date end = hourFormat.parse(endHour);
//    Date now = new Date(System.currentTimeMillis());
//
//    String nowHourStr = hourFormat.format(now.getTime());
//
//    try {
//        Date nowHour = hourFormat.parse(nowHourStr);
//        if (nowHour.after(start) && nowHour.before(end) || (nowHour.equals(start) || (nowHour.equals(end)))) {
//            result = true;
//        }
//
//    } catch (ParseException e) {
//        result = false;
//    }
//
//    return result;
//
//}
//
//8. Xác định giữa 2 khoảng thời gian có bao nhiêu giờ, bao nhiêu phút, bao nhiêu giây:
//
//    public static void main(String[] args) {
//
//        String dateStart = "2012-03-14 09:33:58";
//
//        String dateStop = "2012-03-14 10:34:59";
//
//        // Custom date format
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Date d1 = null;
//
//        Date d2 = null;
//
//        try {
//
//            d1 = format.parse(dateStart);
//
//            d2 = format.parse(dateStop);
//
//        } catch (ParseException e) {
//
//        }
//
//        // Get msec from each, and subtract.
//
//        long diff = d2.getTime() - d1.getTime();
//
//        long diffSeconds = diff / 1000;
//
//        long diffMinutes = diff / (60 * 1000);
//
//        long diffHours = diff / (60 * 60 * 1000);
//
//        System.out.println("Số giây : " + diffSeconds + " seconds.");
//
//        System.out.println("Số phút: " + diffMinutes + " minutes.");
//
//        System.out.println("Số giờ: " + diffHours + " hours.");
//
//    }