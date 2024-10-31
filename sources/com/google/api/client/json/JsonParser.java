package com.google.api.client.json;

import com.google.api.client.json.JsonPolymorphicTypeMap;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class JsonParser {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<Class<?>, Field> f2491a = new WeakHashMap<>();
    private static final Lock b = new ReentrantLock();

    public abstract void a() throws IOException;

    public abstract String b() throws IOException;

    public abstract JsonToken c();

    public abstract JsonFactory d();

    public abstract byte e() throws IOException;

    public abstract short f() throws IOException;

    public abstract int g() throws IOException;

    public abstract float h() throws IOException;

    public abstract BigInteger i() throws IOException;

    public abstract BigDecimal j() throws IOException;

    public abstract double k() throws IOException;

    public abstract long l() throws IOException;

    public abstract String m() throws IOException;

    public abstract JsonToken n() throws IOException;

    public abstract JsonParser o() throws IOException;

    public final <T> T a(Class<T> cls) throws IOException {
        return (T) a(cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> T a(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return (T) b(cls, customizeJsonParser);
        } finally {
            a();
        }
    }

    public final void a(String str) throws IOException {
        a(Collections.singleton(str));
    }

    public final String a(Set<String> set) throws IOException {
        JsonToken q = q();
        while (q == JsonToken.FIELD_NAME) {
            String m = m();
            n();
            if (!set.contains(m)) {
                o();
                q = n();
            } else {
                return m;
            }
        }
        return null;
    }

    private JsonToken p() throws IOException {
        JsonToken c = c();
        JsonToken n = c == null ? n() : c;
        Preconditions.a(n != null, "no JSON input found");
        return n;
    }

    private JsonToken q() throws IOException {
        JsonToken p = p();
        switch (p) {
            case START_OBJECT:
                JsonToken n = n();
                Preconditions.a(n == JsonToken.FIELD_NAME || n == JsonToken.END_OBJECT, n);
                return n;
            case START_ARRAY:
                return n();
            default:
                return p;
        }
    }

    @Beta
    public final <T> T b(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        return (T) a((Type) cls, false, customizeJsonParser);
    }

    public Object a(Type type, boolean z) throws IOException {
        return a(type, z, (CustomizeJsonParser) null);
    }

    @Beta
    public Object a(Type type, boolean z, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                p();
            }
            return a(null, type, new ArrayList<>(), null, customizeJsonParser, true);
        } finally {
            if (z) {
                a();
            }
        }
    }

    private void a(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(d());
        }
        JsonToken q = q();
        Class<?> cls = obj.getClass();
        ClassInfo a2 = ClassInfo.a(cls);
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
            a((Field) null, (Map<String, Object>) obj, Types.d(cls), arrayList, customizeJsonParser);
            return;
        }
        while (q == JsonToken.FIELD_NAME) {
            String m = m();
            n();
            if (customizeJsonParser == null || !customizeJsonParser.a(obj, m)) {
                FieldInfo a3 = a2.a(m);
                if (a3 != null) {
                    if (a3.e() && !a3.f()) {
                        throw new IllegalArgumentException("final array/object fields are not supported");
                    }
                    Field a4 = a3.a();
                    int size = arrayList.size();
                    arrayList.add(a4.getGenericType());
                    Object a5 = a(a4, a3.d(), arrayList, obj, customizeJsonParser, true);
                    arrayList.remove(size);
                    a3.a(obj, a5);
                } else if (isAssignableFrom) {
                    ((GenericData) obj).set(m, a(null, null, arrayList, obj, customizeJsonParser, true));
                } else {
                    if (customizeJsonParser != null) {
                        customizeJsonParser.b(obj, m);
                    }
                    o();
                }
                q = n();
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void a(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken q = q();
        while (q != JsonToken.END_ARRAY) {
            collection.add(a(field, type, arrayList, collection, customizeJsonParser, true));
            q = n();
        }
    }

    private void a(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken q = q();
        while (q == JsonToken.FIELD_NAME) {
            String m = m();
            n();
            if (customizeJsonParser == null || !customizeJsonParser.a(map, m)) {
                map.put(m, a(field, type, arrayList, map, customizeJsonParser, true));
                q = n();
            } else {
                return;
            }
        }
    }

    private final Object a(Field field, Type type, ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser, boolean z) throws IOException {
        Type type2;
        Type a2 = Data.a((List<Type>) arrayList, type);
        Class<?> cls = a2 instanceof Class ? (Class) a2 : null;
        if (a2 instanceof ParameterizedType) {
            cls = Types.a((ParameterizedType) a2);
        }
        if (cls == Void.class) {
            o();
            return null;
        }
        JsonToken c = c();
        try {
            switch (c()) {
                case START_OBJECT:
                case FIELD_NAME:
                case END_OBJECT:
                    Preconditions.a(!Types.a(a2), "expected object or map type but got %s", a2);
                    Field b2 = z ? b(cls) : null;
                    Object obj2 = null;
                    if (cls != null && customizeJsonParser != null) {
                        obj2 = customizeJsonParser.a(obj, cls);
                    }
                    boolean z2 = cls != null && Types.a(cls, (Class<?>) Map.class);
                    if (b2 != null) {
                        obj2 = new GenericJson();
                    } else if (obj2 == null) {
                        if (z2 || cls == null) {
                            obj2 = Data.b(cls);
                        } else {
                            obj2 = Types.a((Class<Object>) cls);
                        }
                    }
                    int size = arrayList.size();
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                    if (z2 && !GenericData.class.isAssignableFrom(cls)) {
                        Type d = Map.class.isAssignableFrom(cls) ? Types.d(a2) : null;
                        if (d != null) {
                            a(field, (Map<String, Object>) obj2, d, arrayList, customizeJsonParser);
                            return obj2;
                        }
                    }
                    a(arrayList, obj2, customizeJsonParser);
                    if (a2 != null) {
                        arrayList.remove(size);
                    }
                    if (b2 != null) {
                        Object obj3 = ((GenericJson) obj2).get(b2.getName());
                        Preconditions.a(obj3 != null, "No value specified for @JsonPolymorphicTypeMap field");
                        String obj4 = obj3.toString();
                        Class<?> cls2 = null;
                        JsonPolymorphicTypeMap.TypeDef[] a3 = ((JsonPolymorphicTypeMap) b2.getAnnotation(JsonPolymorphicTypeMap.class)).a();
                        int length = a3.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                JsonPolymorphicTypeMap.TypeDef typeDef = a3[i];
                                if (!typeDef.a().equals(obj4)) {
                                    i++;
                                } else {
                                    cls2 = typeDef.b();
                                }
                            }
                        }
                        boolean z3 = cls2 != null;
                        String valueOf = String.valueOf(obj4);
                        Preconditions.a(z3, valueOf.length() != 0 ? "No TypeDef annotation found with key: ".concat(valueOf) : new String("No TypeDef annotation found with key: "));
                        JsonFactory d2 = d();
                        JsonParser a4 = d2.a(d2.a(obj2));
                        a4.p();
                        return a4.a(field, cls2, arrayList, null, null, false);
                    }
                    return obj2;
                case START_ARRAY:
                case END_ARRAY:
                    boolean a5 = Types.a(a2);
                    Preconditions.a(a2 == null || a5 || (cls != null && Types.a(cls, (Class<?>) Collection.class)), "expected collection or array type but got %s", a2);
                    Collection<Object> collection = null;
                    if (customizeJsonParser != null && field != null) {
                        collection = customizeJsonParser.a(obj, field);
                    }
                    if (collection == null) {
                        collection = Data.b(a2);
                    }
                    if (a5) {
                        type2 = Types.b(a2);
                    } else if (cls == null || !Iterable.class.isAssignableFrom(cls)) {
                        type2 = null;
                    } else {
                        type2 = Types.c(a2);
                    }
                    Type a6 = Data.a((List<Type>) arrayList, type2);
                    a(field, collection, a6, arrayList, customizeJsonParser);
                    return a5 ? Types.a((Collection<?>) collection, Types.a(arrayList, a6)) : collection;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    Preconditions.a(a2 == null || cls == Boolean.TYPE || (cls != null && cls.isAssignableFrom(Boolean.class)), "expected type Boolean or boolean but got %s", a2);
                    return c == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
                case VALUE_NUMBER_FLOAT:
                case VALUE_NUMBER_INT:
                    Preconditions.a(field == null || field.getAnnotation(JsonString.class) == null, "number type formatted as a JSON number cannot use @JsonString annotation");
                    if (cls == null || cls.isAssignableFrom(BigDecimal.class)) {
                        return j();
                    }
                    if (cls == BigInteger.class) {
                        return i();
                    }
                    if (cls == Double.class || cls == Double.TYPE) {
                        return Double.valueOf(k());
                    }
                    if (cls == Long.class || cls == Long.TYPE) {
                        return Long.valueOf(l());
                    }
                    if (cls == Float.class || cls == Float.TYPE) {
                        return Float.valueOf(h());
                    }
                    if (cls == Integer.class || cls == Integer.TYPE) {
                        return Integer.valueOf(g());
                    }
                    if (cls == Short.class || cls == Short.TYPE) {
                        return Short.valueOf(f());
                    }
                    if (cls == Byte.class || cls == Byte.TYPE) {
                        return Byte.valueOf(e());
                    }
                    String valueOf2 = String.valueOf(String.valueOf(a2));
                    throw new IllegalArgumentException(new StringBuilder(valueOf2.length() + 30).append("expected numeric type but got ").append(valueOf2).toString());
                case VALUE_STRING:
                    Preconditions.a((cls != null && Number.class.isAssignableFrom(cls) && (field == null || field.getAnnotation(JsonString.class) == null)) ? false : true, "number field formatted as a JSON string must use the @JsonString annotation");
                    return Data.a(a2, m());
                case VALUE_NULL:
                    Preconditions.a(cls == null || !cls.isPrimitive(), "primitive number field but found a JSON null");
                    if (cls != null && (cls.getModifiers() & 1536) != 0) {
                        if (Types.a(cls, (Class<?>) Collection.class)) {
                            return Data.a(Data.b(a2).getClass());
                        }
                        if (Types.a(cls, (Class<?>) Map.class)) {
                            return Data.a(Data.b(cls).getClass());
                        }
                    }
                    return Data.a(Types.a(arrayList, a2));
                default:
                    String valueOf3 = String.valueOf(String.valueOf(c));
                    throw new IllegalArgumentException(new StringBuilder(valueOf3.length() + 27).append("unexpected JSON node type: ").append(valueOf3).toString());
            }
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            String b3 = b();
            if (b3 != null) {
                sb.append("key ").append(b3);
            }
            if (field != null) {
                if (b3 != null) {
                    sb.append(", ");
                }
                sb.append("field ").append(field);
            }
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    private static Field b(Class<?> cls) {
        Field field;
        if (cls == null) {
            return null;
        }
        b.lock();
        try {
            if (f2491a.containsKey(cls)) {
                return f2491a.get(cls);
            }
            Iterator<FieldInfo> it = ClassInfo.a(cls).c().iterator();
            Field field2 = null;
            while (it.hasNext()) {
                Field a2 = it.next().a();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) a2.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    Preconditions.a(field2 == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.a(Data.a((Type) a2.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, a2.getType());
                    JsonPolymorphicTypeMap.TypeDef[] a3 = jsonPolymorphicTypeMap.a();
                    HashSet a4 = Sets.a();
                    Preconditions.a(a3.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (JsonPolymorphicTypeMap.TypeDef typeDef : a3) {
                        Preconditions.a(a4.add(typeDef.a()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.a());
                    }
                    field = a2;
                } else {
                    field = field2;
                }
                field2 = field;
            }
            f2491a.put(cls, field2);
            b.unlock();
            return field2;
        } finally {
            b.unlock();
        }
    }
}
