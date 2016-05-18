package qyp.common.utils;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

/**
 * @author luqing.zz
 */
public class GsonUtils {

    private static Gson gson = null;
    static {
        gson = new GsonBuilder() //
        .registerTypeAdapter(Date.class, new LongDateJsonSerializer()) //
        .registerTypeAdapter(Date.class, new LongDateJsonDeserializer()) //
        .setLongSerializationPolicy(LongSerializationPolicy.STRING)
        .registerTypeAdapter(Map.class, new MapJsonDeserializer()) //
        .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC) //
        .create();
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return gson.toJson(obj);
    }

    public static <T> T fromJson(JsonElement jsonElement, Class<T> clazz) {
        return gson.fromJson(jsonElement, clazz);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> List<T> toList(String json, Class<T> c) {
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    @SuppressWarnings("rawtypes")
    static class MapJsonDeserializer implements JsonDeserializer<Map> {

        public Map deserialize(JsonElement json, Type typeOfT, //
                               JsonDeserializationContext context) throws JsonParseException {
            if (!json.isJsonObject()) {
                throw new JsonParseException("Target json is not a json object.");
            }
            return (Map) deserialize(json);
        }

        private Object deserialize(JsonElement json) {
            if (json.isJsonArray()) {
                return arrayValue(json.getAsJsonArray());
            } else if (json.isJsonNull()) {
                return null;
            } else if (json.isJsonPrimitive()) {
                return primitiveValue(json.getAsJsonPrimitive());
            }
            Map<String, Object> map = new TreeMap<String, Object>();
            for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
                Object obj = deserialize(entry.getValue());
                if (obj == null) continue;
                map.put(entry.getKey(), obj);
            }
            return map;
        }

        private List<Object> arrayValue(JsonArray array) {
            List<Object> list = new ArrayList<Object>(array.size());
            for (int i = 0; i < array.size(); ++i) {
                list.add(deserialize(array.get(i)));
            }
            return list;
        }

        private Object primitiveValue(JsonPrimitive primitive) {
            if (primitive.isBoolean()) {
                return primitive.getAsBoolean();
            }
            if (primitive.isNumber()) {
                Number number = primitive.getAsNumber();
                if (number.doubleValue() - number.longValue() > 0.0) {
                    return number.doubleValue();
                }
                return number.longValue();
            }
            return primitive.getAsString();
        }

    }

    static class LongDateJsonSerializer implements JsonSerializer<Date> {

        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }

    }

    static class LongDateJsonDeserializer implements JsonDeserializer<Date> {

        public Date deserialize(JsonElement json, Type typeOfT, //
                                JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }

    }
}
