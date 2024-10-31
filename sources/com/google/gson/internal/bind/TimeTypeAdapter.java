package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: com.google.gson.internal.bind.TimeTypeAdapter$1 */
    /* loaded from: classes.dex */
    final class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public synchronized Time read2(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.format.parse(jsonReader.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    @Override // com.google.gson.TypeAdapter
    public synchronized void write(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.format.format((Date) time));
    }
}
