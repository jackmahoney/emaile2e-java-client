/*
 * Emaile2e API Documentation
 * [Emaile2e](http://www.emaile2e.com) provides a simple REST API that lets you create randomized email addresses and fetch the emails sent to them.  ## Why? If your application uses emails at any point, Emaile2e makes testing your app's email integration easier.  Say your app sign-up process sends a verification email. During e2e tests you can create a new random email  address for a test user, sign-up, and then fetch the verification email and use the verification code in the next steps of your test.  ## Getting started Every API request requires a valid API Key appended as a query parameter. **To obtain an API Key** [visit your account dashboard](http://www.emaile2e.com/dashboard).    The general flow is as follows:  1. Create a new inbox during a test. The email address will be returned in the response.  2. Send an email to that address or trigger an action in your test that does so. 3. Fetch the email for your new inbox and check if their content is what you expected.  ## SDK - There is an official [Javascript SDK](https://www.npmjs.com/package/emaile2e-client) available on npm. - You can also use the [swagger JSON definition](https://api.emaile2e.com/v2/api-docs) and [swagger-codegen](https://github.com/swagger-api/swagger-codegen) to generate a swagger client in a language of your choice.  ## Legal The Emaile2e API code is owned by [PettmanUG](http://pettmanug.site) and uses a proprietary [software licence](http://www.binpress.com/license/view/l/c8376a01eca7465027a978d3fde5a1e2). The SDKs are free to use in any project and have an ISC licence.  ## Bugs, features, support To report bugs or request features please see the [contact page](http://www.emaile2e.com/contact). For help see [support](http://www.emaile2e.com/support).
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JSON {
    private ApiClient apiClient;
    private Gson gson;

    /**
     * JSON constructor.
     *
     * @param apiClient An instance of ApiClient
     */
    public JSON(ApiClient apiClient) {
        this.apiClient = apiClient;
        gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateAdapter(apiClient))
            .registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T> Type
     * @param body The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Type returnType) {
        try {
            if (apiClient.isLenientOnJson()) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            //   return the response body string directly for the String return type;
            //   parse response body into date or datetime for the Date return type.
            if (returnType.equals(String.class))
                return (T) body;
            else if (returnType.equals(Date.class))
                return (T) apiClient.parseDateOrDatetime(body);
            else throw(e);
        }
    }
}

class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final ApiClient apiClient;

    /**
     * Constructor for DateAdapter
     *
     * @param apiClient Api client
     */
    public DateAdapter(ApiClient apiClient) {
        super();
        this.apiClient = apiClient;
    }

    /**
     * Serialize
     *
     * @param src Date
     * @param typeOfSrc Type
     * @param context Json Serialization Context
     * @return Json Element
     */
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(apiClient.formatDatetime(src));
        }
    }

    /**
     * Deserialize
     *
     * @param json Json element
     * @param date Type
     * @param context Json Serialization Context
     * @return Date
     * @throws JsonParseException if fail to parse
     */
    @Override
    public Date deserialize(JsonElement json, Type date, JsonDeserializationContext context) throws JsonParseException {
        String str = json.getAsJsonPrimitive().getAsString();
        try {
            return apiClient.parseDateOrDatetime(str);
        } catch (RuntimeException e) {
            throw new JsonParseException(e);
        }
    }
}

/**
 * Gson TypeAdapter for Joda DateTime type
 */
class DateTimeTypeAdapter extends TypeAdapter<DateTime> {

    private final DateTimeFormatter parseFormatter = ISODateTimeFormat.dateOptionalTimeParser();
    private final DateTimeFormatter printFormatter = ISODateTimeFormat.dateTime();

    @Override
    public void write(JsonWriter out, DateTime date) throws IOException {
        if (date == null) {
            out.nullValue();
        } else {
            out.value(printFormatter.print(date));
        }
    }

    @Override
    public DateTime read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NULL:
                in.nextNull();
                return null;
            default:
                String date = in.nextString();
                return parseFormatter.parseDateTime(date);
        }
    }
}

/**
 * Gson TypeAdapter for Joda LocalDate type
 */
class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

    private final DateTimeFormatter formatter = ISODateTimeFormat.date();

    @Override
    public void write(JsonWriter out, LocalDate date) throws IOException {
        if (date == null) {
            out.nullValue();
        } else {
            out.value(formatter.print(date));
        }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NULL:
                in.nextNull();
                return null;
            default:
                String date = in.nextString();
                return formatter.parseLocalDate(date);
        }
    }
}
