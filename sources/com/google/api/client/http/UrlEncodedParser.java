package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UrlEncodedParser implements ObjectParser {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14801a = new HttpMediaType("application/x-www-form-urlencoded").a(Charsets.f14915a).a();

    public static void a(String str, Object obj) {
        if (str == null) {
            return;
        }
        try {
            a(new StringReader(str), obj);
        } catch (IOException e2) {
            Throwables.a(e2);
            throw null;
        }
    }

    public static void a(Reader reader, Object obj) throws IOException {
        int read;
        Class<?> cls = obj.getClass();
        ClassInfo a2 = ClassInfo.a(cls);
        List asList = Arrays.asList(cls);
        GenericData genericData = GenericData.class.isAssignableFrom(cls) ? (GenericData) obj : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj : null;
        ArrayValueMap arrayValueMap = new ArrayValueMap(obj);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            StringWriter stringWriter3 = stringWriter2;
            StringWriter stringWriter4 = stringWriter;
            boolean z = true;
            while (true) {
                read = reader.read();
                if (read == -1 || read == 38) {
                    break;
                }
                if (read != 61) {
                    if (z) {
                        stringWriter4.write(read);
                    } else {
                        stringWriter3.write(read);
                    }
                } else if (z) {
                    z = false;
                } else {
                    stringWriter3.write(read);
                }
            }
            String a3 = CharEscapers.a(stringWriter4.toString());
            if (a3.length() != 0) {
                String a4 = CharEscapers.a(stringWriter3.toString());
                FieldInfo b2 = a2.b(a3);
                if (b2 != null) {
                    Type a5 = Data.a((List<Type>) asList, b2.c());
                    if (Types.d(a5)) {
                        Class<?> a6 = Types.a((List<Type>) asList, Types.a(a5));
                        arrayValueMap.a(b2.b(), a6, a(a6, (List<Type>) asList, a4));
                    } else if (Types.a(Types.a((List<Type>) asList, a5), (Class<?>) Iterable.class)) {
                        Collection<Object> collection = (Collection) b2.a(obj);
                        if (collection == null) {
                            collection = Data.b(a5);
                            b2.a(obj, collection);
                        }
                        collection.add(a(a5 == Object.class ? null : Types.b(a5), (List<Type>) asList, a4));
                    } else {
                        b2.a(obj, a(a5, (List<Type>) asList, a4));
                    }
                } else if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(a3);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        if (genericData != null) {
                            genericData.set(a3, arrayList);
                        } else {
                            map.put(a3, arrayList);
                        }
                    }
                    arrayList.add(a4);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (read != -1);
        arrayValueMap.a();
    }

    private static Object a(Type type, List<Type> list, String str) {
        return Data.a(Data.a(list, type), str);
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) a((Reader) new InputStreamReader(inputStream, charset), (Class) cls);
    }

    public <T> T a(Reader reader, Class<T> cls) throws IOException {
        return (T) a(reader, (Type) cls);
    }

    public Object a(Reader reader, Type type) throws IOException {
        Preconditions.a(type instanceof Class, "dataType has to be of type Class<?>");
        Object a2 = Types.a((Class<Object>) type);
        a(new BufferedReader(reader), a2);
        return a2;
    }
}
