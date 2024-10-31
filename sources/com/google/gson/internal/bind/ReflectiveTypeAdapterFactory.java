package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
    }

    public boolean excludeField(Field field, boolean z) {
        return (this.excluder.excludeClass(field.getType(), z) || this.excluder.excludeField(field, z)) ? false : true;
    }

    private String getFieldName(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        return serializedName == null ? this.fieldNamingPolicy.translateName(field) : serializedName.value();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final TypeAdapter<?> typeAdapter;
            final /* synthetic */ Gson val$context;
            final /* synthetic */ Field val$field;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str2, boolean z3, boolean z22, Gson gson2, Field field2, TypeToken typeToken2, boolean z4) {
                super(str2, z3, z22);
                r9 = gson2;
                r10 = field2;
                r11 = typeToken2;
                r12 = z4;
                this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(r9, r10, r11);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                new TypeAdapterRuntimeTypeWrapper(r9, this.typeAdapter, r11.getType()).write(jsonWriter, r10.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read2 = this.typeAdapter.read2(jsonReader);
                if (read2 != null || !r12) {
                    r10.set(obj, read2);
                }
            }
        };
    }

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends BoundField {
        final TypeAdapter<?> typeAdapter;
        final /* synthetic */ Gson val$context;
        final /* synthetic */ Field val$field;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str2, boolean z3, boolean z22, Gson gson2, Field field2, TypeToken typeToken2, boolean z4) {
            super(str2, z3, z22);
            r9 = gson2;
            r10 = field2;
            r11 = typeToken2;
            r12 = z4;
            this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(r9, r10, r11);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
            new TypeAdapterRuntimeTypeWrapper(r9, this.typeAdapter, r11.getType()).write(jsonWriter, r10.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            Object read2 = this.typeAdapter.read2(jsonReader);
            if (read2 != null || !r12) {
                r10.set(obj, read2);
            }
        }
    }

    public TypeAdapter<?> getFieldAdapter(Gson gson, Field field, TypeToken<?> typeToken) {
        TypeAdapter<?> typeAdapter;
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        return (jsonAdapter == null || (typeAdapter = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter)) == null) ? gson.getAdapter(typeToken) : typeAdapter;
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, false);
                if (excludeField || excludeField2) {
                    field.setAccessible(true);
                    BoundField createBoundField = createBoundField(gson, field, getFieldName(field), TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, field.getGenericType())), excludeField, excludeField2);
                    BoundField boundField = (BoundField) linkedHashMap.put(createBoundField.name, createBoundField);
                    if (boundField != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                    }
                }
            }
            typeToken = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, cls.getGenericSuperclass()));
            cls = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    /* loaded from: classes.dex */
    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    /* loaded from: classes.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        /* synthetic */ Adapter(ObjectConstructor objectConstructor, Map map, AnonymousClass1 anonymousClass1) {
            this(objectConstructor, map);
        }

        private Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.serialized) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
