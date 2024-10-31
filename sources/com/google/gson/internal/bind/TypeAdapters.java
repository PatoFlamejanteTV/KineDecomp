package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter<Class> CLASS = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            if (cls == null) {
                jsonWriter.nullValue();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Class read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final TypeAdapterFactory CLASS_FACTORY = newFactory(Class.class, CLASS);
    public static final TypeAdapter<BitSet> BIT_SET = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        AnonymousClass2() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BitSet read2(JsonReader jsonReader) throws IOException {
            boolean z;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i = 0;
            while (peek != JsonToken.END_ARRAY) {
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
                    case 1:
                        if (jsonReader.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = jsonReader.nextBoolean();
                        break;
                    case 3:
                        String nextString = jsonReader.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + peek);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (int i = 0; i < bitSet.length(); i++) {
                jsonWriter.value(bitSet.get(i) ? 1 : 0);
            }
            jsonWriter.endArray();
        }
    };
    public static final TypeAdapterFactory BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
    public static final TypeAdapter<Boolean> BOOLEAN = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        AnonymousClass3() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonReader.peek() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            }
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            if (bool == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(bool.booleanValue());
            }
        }
    };
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        AnonymousClass4() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    };
    public static final TypeAdapterFactory BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    public static final TypeAdapter<Number> BYTE = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        AnonymousClass5() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapterFactory BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
    public static final TypeAdapter<Number> SHORT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        AnonymousClass6() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapterFactory SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
    public static final TypeAdapter<Number> INTEGER = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        AnonymousClass7() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapterFactory INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
    public static final TypeAdapter<Number> LONG = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        AnonymousClass8() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapter<Number> FLOAT = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        AnonymousClass9() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapter<Number> DOUBLE = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        AnonymousClass10() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapter<Number> NUMBER = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        AnonymousClass11() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
                case 1:
                    return new LazilyParsedNumber(jsonReader.nextString());
                case 2:
                case 3:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + peek);
                case 4:
                    jsonReader.nextNull();
                    return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    };
    public static final TypeAdapterFactory NUMBER_FACTORY = newFactory(Number.class, NUMBER);
    public static final TypeAdapter<Character> CHARACTER = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        AnonymousClass12() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Character read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + nextString);
            }
            return Character.valueOf(nextString.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final TypeAdapterFactory CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
    public static final TypeAdapter<String> STRING = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        AnonymousClass13() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public String read2(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    };
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        AnonymousClass14() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigDecimal read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    };
    public static final TypeAdapter<BigInteger> BIG_INTEGER = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        AnonymousClass15() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigInteger read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    };
    public static final TypeAdapterFactory STRING_FACTORY = newFactory(String.class, STRING);
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        AnonymousClass16() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuilder read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    };
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        AnonymousClass17() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuffer read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
    public static final TypeAdapter<URL> URL = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        AnonymousClass18() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URL read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    };
    public static final TypeAdapterFactory URL_FACTORY = newFactory(URL.class, URL);
    public static final TypeAdapter<URI> URI = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        AnonymousClass19() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URI read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final TypeAdapterFactory URI_FACTORY = newFactory(URI.class, URI);
    public static final TypeAdapter<InetAddress> INET_ADDRESS = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        AnonymousClass20() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public InetAddress read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
    public static final TypeAdapter<UUID> UUID = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        AnonymousClass21() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public UUID read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    };
    public static final TypeAdapterFactory UUID_FACTORY = newFactory(UUID.class, UUID);
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        AnonymousClass22() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.22.1
                final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(TypeAdapter typeAdapter) {
                    r2 = typeAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public Timestamp read2(JsonReader jsonReader) throws IOException {
                    Date date = (Date) r2.read2(jsonReader);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                    r2.write(jsonWriter, timestamp);
                }
            };
        }

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$22$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends TypeAdapter<Timestamp> {
            final /* synthetic */ TypeAdapter val$dateTypeAdapter;

            AnonymousClass1(TypeAdapter typeAdapter) {
                r2 = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Timestamp read2(JsonReader jsonReader) throws IOException {
                Date date = (Date) r2.read2(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                r2.write(jsonWriter, timestamp);
            }
        }
    };
    public static final TypeAdapter<Calendar> CALENDAR = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        AnonymousClass23() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Calendar read2(JsonReader jsonReader) throws IOException {
            int i = 0;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if (YEAR.equals(nextName)) {
                    i6 = nextInt;
                } else if (MONTH.equals(nextName)) {
                    i5 = nextInt;
                } else if (DAY_OF_MONTH.equals(nextName)) {
                    i4 = nextInt;
                } else if (HOUR_OF_DAY.equals(nextName)) {
                    i3 = nextInt;
                } else if (MINUTE.equals(nextName)) {
                    i2 = nextInt;
                } else if (SECOND.equals(nextName)) {
                    i = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(12));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    };
    public static final TypeAdapterFactory CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
    public static final TypeAdapter<Locale> LOCALE = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        AnonymousClass24() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Locale read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
    public static final TypeAdapter<JsonElement> JSON_ELEMENT = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        AnonymousClass25() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public JsonElement read2(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read2(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read2(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    };
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();

    private TypeAdapters() {
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1 */
    /* loaded from: classes.dex */
    final class AnonymousClass1 extends TypeAdapter<Class> {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            if (cls == null) {
                jsonWriter.nullValue();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Class read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2 */
    /* loaded from: classes.dex */
    final class AnonymousClass2 extends TypeAdapter<BitSet> {
        AnonymousClass2() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BitSet read2(JsonReader jsonReader) throws IOException {
            boolean z;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i = 0;
            while (peek != JsonToken.END_ARRAY) {
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
                    case 1:
                        if (jsonReader.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = jsonReader.nextBoolean();
                        break;
                    case 3:
                        String nextString = jsonReader.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + peek);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (int i = 0; i < bitSet.length(); i++) {
                jsonWriter.value(bitSet.get(i) ? 1 : 0);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass32 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3 */
    /* loaded from: classes.dex */
    final class AnonymousClass3 extends TypeAdapter<Boolean> {
        AnonymousClass3() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonReader.peek() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            }
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            if (bool == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(bool.booleanValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4 */
    /* loaded from: classes.dex */
    final class AnonymousClass4 extends TypeAdapter<Boolean> {
        AnonymousClass4() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Boolean read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5 */
    /* loaded from: classes.dex */
    final class AnonymousClass5 extends TypeAdapter<Number> {
        AnonymousClass5() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6 */
    /* loaded from: classes.dex */
    final class AnonymousClass6 extends TypeAdapter<Number> {
        AnonymousClass6() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7 */
    /* loaded from: classes.dex */
    final class AnonymousClass7 extends TypeAdapter<Number> {
        AnonymousClass7() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8 */
    /* loaded from: classes.dex */
    final class AnonymousClass8 extends TypeAdapter<Number> {
        AnonymousClass8() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9 */
    /* loaded from: classes.dex */
    final class AnonymousClass9 extends TypeAdapter<Number> {
        AnonymousClass9() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10 */
    /* loaded from: classes.dex */
    final class AnonymousClass10 extends TypeAdapter<Number> {
        AnonymousClass10() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11 */
    /* loaded from: classes.dex */
    final class AnonymousClass11 extends TypeAdapter<Number> {
        AnonymousClass11() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
                case 1:
                    return new LazilyParsedNumber(jsonReader.nextString());
                case 2:
                case 3:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + peek);
                case 4:
                    jsonReader.nextNull();
                    return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12 */
    /* loaded from: classes.dex */
    final class AnonymousClass12 extends TypeAdapter<Character> {
        AnonymousClass12() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Character read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + nextString);
            }
            return Character.valueOf(nextString.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13 */
    /* loaded from: classes.dex */
    final class AnonymousClass13 extends TypeAdapter<String> {
        AnonymousClass13() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public String read2(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14 */
    /* loaded from: classes.dex */
    final class AnonymousClass14 extends TypeAdapter<BigDecimal> {
        AnonymousClass14() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigDecimal read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15 */
    /* loaded from: classes.dex */
    final class AnonymousClass15 extends TypeAdapter<BigInteger> {
        AnonymousClass15() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BigInteger read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16 */
    /* loaded from: classes.dex */
    final class AnonymousClass16 extends TypeAdapter<StringBuilder> {
        AnonymousClass16() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuilder read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17 */
    /* loaded from: classes.dex */
    final class AnonymousClass17 extends TypeAdapter<StringBuffer> {
        AnonymousClass17() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public StringBuffer read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18 */
    /* loaded from: classes.dex */
    final class AnonymousClass18 extends TypeAdapter<URL> {
        AnonymousClass18() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URL read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19 */
    /* loaded from: classes.dex */
    final class AnonymousClass19 extends TypeAdapter<URI> {
        AnonymousClass19() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public URI read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20 */
    /* loaded from: classes.dex */
    final class AnonymousClass20 extends TypeAdapter<InetAddress> {
        AnonymousClass20() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public InetAddress read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21 */
    /* loaded from: classes.dex */
    final class AnonymousClass21 extends TypeAdapter<UUID> {
        AnonymousClass21() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public UUID read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22 */
    /* loaded from: classes.dex */
    public final class AnonymousClass22 implements TypeAdapterFactory {
        AnonymousClass22() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.22.1
                final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(TypeAdapter typeAdapter) {
                    r2 = typeAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public Timestamp read2(JsonReader jsonReader) throws IOException {
                    Date date = (Date) r2.read2(jsonReader);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                    r2.write(jsonWriter, timestamp);
                }
            };
        }

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$22$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends TypeAdapter<Timestamp> {
            final /* synthetic */ TypeAdapter val$dateTypeAdapter;

            AnonymousClass1(TypeAdapter typeAdapter) {
                r2 = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Timestamp read2(JsonReader jsonReader) throws IOException {
                Date date = (Date) r2.read2(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                r2.write(jsonWriter, timestamp);
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23 */
    /* loaded from: classes.dex */
    final class AnonymousClass23 extends TypeAdapter<Calendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        AnonymousClass23() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Calendar read2(JsonReader jsonReader) throws IOException {
            int i = 0;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if (YEAR.equals(nextName)) {
                    i6 = nextInt;
                } else if (MONTH.equals(nextName)) {
                    i5 = nextInt;
                } else if (DAY_OF_MONTH.equals(nextName)) {
                    i4 = nextInt;
                } else if (HOUR_OF_DAY.equals(nextName)) {
                    i3 = nextInt;
                } else if (MINUTE.equals(nextName)) {
                    i2 = nextInt;
                } else if (SECOND.equals(nextName)) {
                    i = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(12));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24 */
    /* loaded from: classes.dex */
    final class AnonymousClass24 extends TypeAdapter<Locale> {
        AnonymousClass24() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Locale read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25 */
    /* loaded from: classes.dex */
    final class AnonymousClass25 extends TypeAdapter<JsonElement> {
        AnonymousClass25() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public JsonElement read2(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read2(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read2(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    }

    /* loaded from: classes.dex */
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap();
        private final Map<T, String> constantToName = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    SerializedName serializedName = (SerializedName) cls.getField(name).getAnnotation(SerializedName.class);
                    String value = serializedName != null ? serializedName.value() : name;
                    this.nameToConstant.put(value, t);
                    this.constantToName.put(t, value);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return this.nameToConstant.get(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(t == null ? null : this.constantToName.get(t));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26 */
    /* loaded from: classes.dex */
    public final class AnonymousClass26 implements TypeAdapterFactory {
        AnonymousClass26() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory() {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            AnonymousClass26() {
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27 */
    /* loaded from: classes.dex */
    public final class AnonymousClass27 implements TypeAdapterFactory {
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass27(TypeAdapter typeAdapter) {
            r2 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(TypeToken.this)) {
                return r2;
            }
            return null;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            final /* synthetic */ TypeAdapter val$typeAdapter;

            AnonymousClass27(TypeAdapter typeAdapter2) {
                r2 = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
                if (typeToken2.equals(TypeToken.this)) {
                    return r2;
                }
                return null;
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    /* loaded from: classes.dex */
    public final class AnonymousClass28 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass28(Class cls, TypeAdapter typeAdapter) {
            r1 = cls;
            r2 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == r1) {
                return r2;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + r1.getName() + ",adapter=" + r2 + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            final /* synthetic */ Class val$type;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            AnonymousClass28(Class cls2, TypeAdapter typeAdapter2) {
                r1 = cls2;
                r2 = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == r1) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + r1.getName() + ",adapter=" + r2 + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    /* loaded from: classes.dex */
    public final class AnonymousClass29 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        AnonymousClass29(Class cls, Class cls2, TypeAdapter typeAdapter) {
            r1 = cls;
            r2 = cls2;
            r3 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == r1 || rawType == r2) {
                return r3;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + r2.getName() + "+" + r1.getName() + ",adapter=" + r3 + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            final /* synthetic */ Class val$boxed;
            final /* synthetic */ TypeAdapter val$typeAdapter;
            final /* synthetic */ Class val$unboxed;

            AnonymousClass29(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                r1 = cls3;
                r2 = cls22;
                r3 = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == r1 || rawType == r2) {
                    return r3;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + r2.getName() + "+" + r1.getName() + ",adapter=" + r3 + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    /* loaded from: classes.dex */
    public final class AnonymousClass30 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass30(Class cls, Class cls2, TypeAdapter typeAdapter) {
            r1 = cls;
            r2 = cls2;
            r3 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == r1 || rawType == r2) {
                return r3;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + r1.getName() + "+" + r2.getName() + ",adapter=" + r3 + "]";
        }
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            final /* synthetic */ Class val$base;
            final /* synthetic */ Class val$sub;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            AnonymousClass30(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                r1 = cls3;
                r2 = cls22;
                r3 = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == r1 || rawType == r2) {
                    return r3;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + r1.getName() + "+" + r2.getName() + ",adapter=" + r3 + "]";
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    /* loaded from: classes.dex */
    public final class AnonymousClass31 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            r1 = cls;
            r2 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (r1.isAssignableFrom(typeToken.getRawType())) {
                return r2;
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + r1.getName() + ",adapter=" + r2 + "]";
        }
    }

    public static <TT> TypeAdapterFactory newTypeHierarchyFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            final /* synthetic */ Class val$clazz;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            AnonymousClass31(Class cls2, TypeAdapter typeAdapter2) {
                r1 = cls2;
                r2 = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (r1.isAssignableFrom(typeToken.getRawType())) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + r1.getName() + ",adapter=" + r2 + "]";
            }
        };
    }
}
