package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortCustomer implements Comparator<Customer> {
    public SortCustomer() {
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getName().equals(o2.getName())){
            SimpleDateFormat f =new SimpleDateFormat("dd/MM/yyyy");
            Date date1=null;
            Date date2=null;
            try {
                date1= f.parse(o1.getDateOfBirth());
                date2= f.parse(o2.getDateOfBirth());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1.compareTo(date2)==0){
                return o1.getName().compareTo(o2.getName());
            }else {
                return date1.compareTo(date2);
            }
        }
        return o1.getName().compareTo(o2.getName());

    }
}
