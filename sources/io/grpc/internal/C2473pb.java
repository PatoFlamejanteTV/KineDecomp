package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JsonParser.java */
/* renamed from: io.grpc.internal.pb */
/* loaded from: classes3.dex */
public final class C2473pb {

    /* renamed from: a */
    private static final Logger f27718a = Logger.getLogger(C2473pb.class.getName());

    private C2473pb() {
    }

    public static Object a(String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            return d(jsonReader);
        } finally {
            try {
                jsonReader.close();
            } catch (IOException e2) {
                f27718a.log(Level.WARNING, "Failed to close", (Throwable) e2);
            }
        }
    }

    private static Void b(JsonReader jsonReader) throws IOException {
        jsonReader.nextNull();
        return null;
    }

    private static Map<String, Object> c(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), d(jsonReader));
        }
        Preconditions.b(jsonReader.peek() == JsonToken.END_OBJECT, "Bad token: " + jsonReader.getPath());
        jsonReader.endObject();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Object d(JsonReader jsonReader) throws IOException {
        Preconditions.b(jsonReader.hasNext(), "unexpected end of JSON");
        switch (C2469ob.f27709a[jsonReader.peek().ordinal()]) {
            case 1:
                return a(jsonReader);
            case 2:
                return c(jsonReader);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                return b(jsonReader);
            default:
                throw new IllegalStateException("Bad token: " + jsonReader.getPath());
        }
    }

    private static List<Object> a(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(d(jsonReader));
        }
        Preconditions.b(jsonReader.peek() == JsonToken.END_ARRAY, "Bad token: " + jsonReader.getPath());
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }
}
