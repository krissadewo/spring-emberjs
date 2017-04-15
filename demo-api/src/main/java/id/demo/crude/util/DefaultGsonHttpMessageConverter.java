package id.demo.crude.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultGsonHttpMessageConverter extends GsonHttpMessageConverter {

    public DefaultGsonHttpMessageConverter() {
        super();
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .registerTypeAdapter(Date.class, dateJsonDeserializer)
                .create();

        setGson(gson);
    }

    /**
     * Some time the date from the android send different format.
     * Try to create default format and if fail try to another one
     */
    private JsonDeserializer<Date> dateJsonDeserializer = (json, typeOfT, context) -> {
        String date = json.getAsString();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
            try {
                return formatter.parse(date);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        return null;
    };

}
