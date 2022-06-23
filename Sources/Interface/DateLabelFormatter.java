package Interface;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    
    /** 
     * @param text
     * @return Object
     * @throws ParseException
     * 
     * On affiche la date choisie sur le calendrier
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    
    /** 
     * @param value
     * @return String
     * @throws ParseException
     * 
     * Si la valeur de la date choisie n'est pas null alors on affiche le calendrier
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}
