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
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public abstract class JsonParser {

    /* renamed from: a */
    private static WeakHashMap<Class<?>, Field> f14831a = new WeakHashMap<>();

    /* renamed from: b */
    private static final Lock f14832b = new ReentrantLock();

    private JsonToken p() throws IOException {
        JsonToken e2 = e();
        if (e2 == null) {
            e2 = n();
        }
        Preconditions.a(e2 != null, "no JSON input found");
        return e2;
    }

    private JsonToken q() throws IOException {
        JsonToken p = p();
        int i = a.f14833a[p.ordinal()];
        boolean z = true;
        if (i != 1) {
            return i != 2 ? p : n();
        }
        JsonToken n = n();
        if (n != JsonToken.FIELD_NAME && n != JsonToken.END_OBJECT) {
            z = false;
        }
        Preconditions.a(z, n);
        return n;
    }

    public final <T> T a(Class<T> cls) throws IOException {
        return (T) b(cls, null);
    }

    public abstract void a() throws IOException;

    @Beta
    public final <T> T b(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return (T) a(cls, customizeJsonParser);
        } finally {
            a();
        }
    }

    public abstract BigInteger b() throws IOException;

    public abstract byte c() throws IOException;

    public abstract String d() throws IOException;

    public abstract JsonToken e();

    public abstract BigDecimal f() throws IOException;

    public abstract double g() throws IOException;

    public abstract JsonFactory h();

    public abstract float i() throws IOException;

    public abstract int j() throws IOException;

    public abstract long k() throws IOException;

    public abstract short l() throws IOException;

    public abstract String m() throws IOException;

    public abstract JsonToken n() throws IOException;

    public abstract JsonParser o() throws IOException;

    public final void a(String str) throws IOException {
        a(Collections.singleton(str));
    }

    public final String a(Set<String> set) throws IOException {
        JsonToken q = q();
        while (q == JsonToken.FIELD_NAME) {
            String m = m();
            n();
            if (set.contains(m)) {
                return m;
            }
            o();
            q = n();
        }
        return null;
    }

    private static Field b(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        f14832b.lock();
        try {
            if (f14831a.containsKey(cls)) {
                return f14831a.get(cls);
            }
            Iterator<FieldInfo> it = ClassInfo.a(cls).a().iterator();
            while (it.hasNext()) {
                Field b2 = it.next().b();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) b2.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    Preconditions.a(field == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.a(Data.a((Type) b2.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, b2.getType());
                    JsonPolymorphicTypeMap.TypeDef[] typeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet a2 = Sets.a();
                    Preconditions.a(typeDefinitions.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (JsonPolymorphicTypeMap.TypeDef typeDef : typeDefinitions) {
                        Preconditions.a(a2.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                    }
                    field = b2;
                }
            }
            f14831a.put(cls, field);
            return field;
        } finally {
            f14832b.unlock();
        }
    }

    @Beta
    public final <T> T a(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
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
            ((GenericJson) obj).setFactory(h());
        }
        JsonToken q = q();
        Class<?> cls = obj.getClass();
        ClassInfo a2 = ClassInfo.a(cls);
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
            a((Field) null, (Map<String, Object>) obj, Types.c(cls), arrayList, customizeJsonParser);
            return;
        }
        while (q == JsonToken.FIELD_NAME) {
            String m = m();
            n();
            if (customizeJsonParser != null && customizeJsonParser.b(obj, m)) {
                return;
            }
            FieldInfo b2 = a2.b(m);
            if (b2 != null) {
                if (b2.f() && !b2.g()) {
                    throw new IllegalArgumentException("final array/object fields are not supported");
                }
                Field b3 = b2.b();
                int size = arrayList.size();
                arrayList.add(b3.getGenericType());
                Object a3 = a(b3, b2.c(), arrayList, obj, customizeJsonParser, true);
                arrayList.remove(size);
                b2.a(obj, a3);
            } else if (isAssignableFrom) {
                ((GenericData) obj).set(m, a(null, null, arrayList, obj, customizeJsonParser, true));
            } else {
                if (customizeJsonParser != null) {
                    customizeJsonParser.a(obj, m);
                }
                o();
            }
            q = n();
        }
    }

    public final <T> Collection<T> a(Class<?> cls, Class<T> cls2) throws IOException {
        return a(cls, cls2, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> Collection<T> a(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        Collection<T> collection = (Collection<T>) Data.b((Type) cls);
        a(collection, cls2, customizeJsonParser);
        return collection;
    }

    @Beta
    public final <T> void a(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        a((Field) null, collection, cls, new ArrayList<>(), customizeJsonParser);
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
            if (customizeJsonParser != null && customizeJsonParser.b(map, m)) {
                return;
            }
            map.put(m, a(field, type, arrayList, map, customizeJsonParser, true));
            q = n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01ad A[Catch: IllegalArgumentException -> 0x0317, TryCatch #0 {IllegalArgumentException -> 0x0317, blocks: (B:14:0x0025, B:15:0x0033, B:16:0x0036, B:17:0x0302, B:18:0x0316, B:20:0x003c, B:22:0x0043, B:24:0x004a, B:26:0x0052, B:28:0x005a, B:30:0x0067, B:32:0x006f, B:34:0x007c, B:37:0x0085, B:41:0x009b, B:46:0x00bd, B:49:0x00c7, B:51:0x00d0, B:52:0x00d5, B:55:0x00a3, B:57:0x00ab, B:59:0x00b3, B:62:0x00e0, B:64:0x00e9, B:66:0x00f0, B:71:0x00fe, B:75:0x0107, B:80:0x0111, B:85:0x011a, B:90:0x0123, B:95:0x012c, B:100:0x0135, B:103:0x013a, B:104:0x0150, B:105:0x0151, B:107:0x015a, B:109:0x0163, B:111:0x016c, B:113:0x0175, B:115:0x017e, B:117:0x0187, B:121:0x018e, B:124:0x0194, B:128:0x01a0, B:130:0x01ad, B:132:0x01b0, B:135:0x01b3, B:139:0x01bd, B:143:0x01c9, B:146:0x01d6, B:148:0x01de, B:150:0x01e4, B:151:0x01f7, B:153:0x0206, B:157:0x01eb, B:159:0x01f3, B:162:0x0210, B:165:0x0219, B:167:0x0224, B:170:0x022e, B:172:0x0236, B:176:0x0243, B:177:0x0259, B:179:0x025f, B:181:0x0264, B:183:0x026c, B:185:0x0274, B:187:0x027d, B:190:0x0289, B:192:0x028e, B:195:0x0294, B:198:0x02a4, B:200:0x02bd, B:204:0x02c9, B:202:0x02ce, B:208:0x02d5, B:216:0x0250, B:217:0x0255), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b0 A[Catch: IllegalArgumentException -> 0x0317, TryCatch #0 {IllegalArgumentException -> 0x0317, blocks: (B:14:0x0025, B:15:0x0033, B:16:0x0036, B:17:0x0302, B:18:0x0316, B:20:0x003c, B:22:0x0043, B:24:0x004a, B:26:0x0052, B:28:0x005a, B:30:0x0067, B:32:0x006f, B:34:0x007c, B:37:0x0085, B:41:0x009b, B:46:0x00bd, B:49:0x00c7, B:51:0x00d0, B:52:0x00d5, B:55:0x00a3, B:57:0x00ab, B:59:0x00b3, B:62:0x00e0, B:64:0x00e9, B:66:0x00f0, B:71:0x00fe, B:75:0x0107, B:80:0x0111, B:85:0x011a, B:90:0x0123, B:95:0x012c, B:100:0x0135, B:103:0x013a, B:104:0x0150, B:105:0x0151, B:107:0x015a, B:109:0x0163, B:111:0x016c, B:113:0x0175, B:115:0x017e, B:117:0x0187, B:121:0x018e, B:124:0x0194, B:128:0x01a0, B:130:0x01ad, B:132:0x01b0, B:135:0x01b3, B:139:0x01bd, B:143:0x01c9, B:146:0x01d6, B:148:0x01de, B:150:0x01e4, B:151:0x01f7, B:153:0x0206, B:157:0x01eb, B:159:0x01f3, B:162:0x0210, B:165:0x0219, B:167:0x0224, B:170:0x022e, B:172:0x0236, B:176:0x0243, B:177:0x0259, B:179:0x025f, B:181:0x0264, B:183:0x026c, B:185:0x0274, B:187:0x027d, B:190:0x0289, B:192:0x028e, B:195:0x0294, B:198:0x02a4, B:200:0x02bd, B:204:0x02c9, B:202:0x02ce, B:208:0x02d5, B:216:0x0250, B:217:0x0255), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01de A[Catch: IllegalArgumentException -> 0x0317, TryCatch #0 {IllegalArgumentException -> 0x0317, blocks: (B:14:0x0025, B:15:0x0033, B:16:0x0036, B:17:0x0302, B:18:0x0316, B:20:0x003c, B:22:0x0043, B:24:0x004a, B:26:0x0052, B:28:0x005a, B:30:0x0067, B:32:0x006f, B:34:0x007c, B:37:0x0085, B:41:0x009b, B:46:0x00bd, B:49:0x00c7, B:51:0x00d0, B:52:0x00d5, B:55:0x00a3, B:57:0x00ab, B:59:0x00b3, B:62:0x00e0, B:64:0x00e9, B:66:0x00f0, B:71:0x00fe, B:75:0x0107, B:80:0x0111, B:85:0x011a, B:90:0x0123, B:95:0x012c, B:100:0x0135, B:103:0x013a, B:104:0x0150, B:105:0x0151, B:107:0x015a, B:109:0x0163, B:111:0x016c, B:113:0x0175, B:115:0x017e, B:117:0x0187, B:121:0x018e, B:124:0x0194, B:128:0x01a0, B:130:0x01ad, B:132:0x01b0, B:135:0x01b3, B:139:0x01bd, B:143:0x01c9, B:146:0x01d6, B:148:0x01de, B:150:0x01e4, B:151:0x01f7, B:153:0x0206, B:157:0x01eb, B:159:0x01f3, B:162:0x0210, B:165:0x0219, B:167:0x0224, B:170:0x022e, B:172:0x0236, B:176:0x0243, B:177:0x0259, B:179:0x025f, B:181:0x0264, B:183:0x026c, B:185:0x0274, B:187:0x027d, B:190:0x0289, B:192:0x028e, B:195:0x0294, B:198:0x02a4, B:200:0x02bd, B:204:0x02c9, B:202:0x02ce, B:208:0x02d5, B:216:0x0250, B:217:0x0255), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e4 A[Catch: IllegalArgumentException -> 0x0317, TryCatch #0 {IllegalArgumentException -> 0x0317, blocks: (B:14:0x0025, B:15:0x0033, B:16:0x0036, B:17:0x0302, B:18:0x0316, B:20:0x003c, B:22:0x0043, B:24:0x004a, B:26:0x0052, B:28:0x005a, B:30:0x0067, B:32:0x006f, B:34:0x007c, B:37:0x0085, B:41:0x009b, B:46:0x00bd, B:49:0x00c7, B:51:0x00d0, B:52:0x00d5, B:55:0x00a3, B:57:0x00ab, B:59:0x00b3, B:62:0x00e0, B:64:0x00e9, B:66:0x00f0, B:71:0x00fe, B:75:0x0107, B:80:0x0111, B:85:0x011a, B:90:0x0123, B:95:0x012c, B:100:0x0135, B:103:0x013a, B:104:0x0150, B:105:0x0151, B:107:0x015a, B:109:0x0163, B:111:0x016c, B:113:0x0175, B:115:0x017e, B:117:0x0187, B:121:0x018e, B:124:0x0194, B:128:0x01a0, B:130:0x01ad, B:132:0x01b0, B:135:0x01b3, B:139:0x01bd, B:143:0x01c9, B:146:0x01d6, B:148:0x01de, B:150:0x01e4, B:151:0x01f7, B:153:0x0206, B:157:0x01eb, B:159:0x01f3, B:162:0x0210, B:165:0x0219, B:167:0x0224, B:170:0x022e, B:172:0x0236, B:176:0x0243, B:177:0x0259, B:179:0x025f, B:181:0x0264, B:183:0x026c, B:185:0x0274, B:187:0x027d, B:190:0x0289, B:192:0x028e, B:195:0x0294, B:198:0x02a4, B:200:0x02bd, B:204:0x02c9, B:202:0x02ce, B:208:0x02d5, B:216:0x0250, B:217:0x0255), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0206 A[Catch: IllegalArgumentException -> 0x0317, TryCatch #0 {IllegalArgumentException -> 0x0317, blocks: (B:14:0x0025, B:15:0x0033, B:16:0x0036, B:17:0x0302, B:18:0x0316, B:20:0x003c, B:22:0x0043, B:24:0x004a, B:26:0x0052, B:28:0x005a, B:30:0x0067, B:32:0x006f, B:34:0x007c, B:37:0x0085, B:41:0x009b, B:46:0x00bd, B:49:0x00c7, B:51:0x00d0, B:52:0x00d5, B:55:0x00a3, B:57:0x00ab, B:59:0x00b3, B:62:0x00e0, B:64:0x00e9, B:66:0x00f0, B:71:0x00fe, B:75:0x0107, B:80:0x0111, B:85:0x011a, B:90:0x0123, B:95:0x012c, B:100:0x0135, B:103:0x013a, B:104:0x0150, B:105:0x0151, B:107:0x015a, B:109:0x0163, B:111:0x016c, B:113:0x0175, B:115:0x017e, B:117:0x0187, B:121:0x018e, B:124:0x0194, B:128:0x01a0, B:130:0x01ad, B:132:0x01b0, B:135:0x01b3, B:139:0x01bd, B:143:0x01c9, B:146:0x01d6, B:148:0x01de, B:150:0x01e4, B:151:0x01f7, B:153:0x0206, B:157:0x01eb, B:159:0x01f3, B:162:0x0210, B:165:0x0219, B:167:0x0224, B:170:0x022e, B:172:0x0236, B:176:0x0243, B:177:0x0259, B:179:0x025f, B:181:0x0264, B:183:0x026c, B:185:0x0274, B:187:0x027d, B:190:0x0289, B:192:0x028e, B:195:0x0294, B:198:0x02a4, B:200:0x02bd, B:204:0x02c9, B:202:0x02ce, B:208:0x02d5, B:216:0x0250, B:217:0x0255), top: B:13:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object a(java.lang.reflect.Field r8, java.lang.reflect.Type r9, java.util.ArrayList<java.lang.reflect.Type> r10, java.lang.Object r11, com.google.api.client.json.CustomizeJsonParser r12, boolean r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.json.JsonParser.a(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.api.client.json.CustomizeJsonParser, boolean):java.lang.Object");
    }
}
