package com.google.api.client.json;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class JsonGenerator {
    public abstract void a() throws IOException;

    public abstract void a(double d) throws IOException;

    public abstract void a(float f) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(String str) throws IOException;

    public abstract void a(BigDecimal bigDecimal) throws IOException;

    public abstract void a(BigInteger bigInteger) throws IOException;

    public abstract void a(boolean z) throws IOException;

    public abstract void b() throws IOException;

    public abstract void b(String str) throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final void a(Object obj) throws IOException {
        a(false, obj);
    }

    private void a(boolean z, Object obj) throws IOException {
        boolean z2;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (Data.a(obj)) {
                d();
                return;
            }
            if (obj instanceof String) {
                b((String) obj);
                return;
            }
            if (obj instanceof Number) {
                if (z) {
                    b(obj.toString());
                    return;
                }
                if (obj instanceof BigDecimal) {
                    a((BigDecimal) obj);
                    return;
                }
                if (obj instanceof BigInteger) {
                    a((BigInteger) obj);
                    return;
                }
                if (obj instanceof Long) {
                    a(((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Float) {
                    float floatValue = ((Number) obj).floatValue();
                    Preconditions.a((Float.isInfinite(floatValue) || Float.isNaN(floatValue)) ? false : true);
                    a(floatValue);
                    return;
                } else {
                    if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                        a(((Number) obj).intValue());
                        return;
                    }
                    double doubleValue = ((Number) obj).doubleValue();
                    Preconditions.a((Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) ? false : true);
                    a(doubleValue);
                    return;
                }
            }
            if (obj instanceof Boolean) {
                a(((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof DateTime) {
                b(((DateTime) obj).toStringRfc3339());
                return;
            }
            if ((obj instanceof Iterable) || cls.isArray()) {
                e();
                Iterator it = Types.a(obj).iterator();
                while (it.hasNext()) {
                    a(z, it.next());
                }
                b();
                return;
            }
            if (cls.isEnum()) {
                String b = FieldInfo.a((Enum<?>) obj).b();
                if (b == null) {
                    d();
                    return;
                } else {
                    b(b);
                    return;
                }
            }
            f();
            boolean z3 = (obj instanceof Map) && !(obj instanceof GenericData);
            ClassInfo a2 = z3 ? null : ClassInfo.a(cls);
            for (Map.Entry<String, Object> entry : Data.b(obj).entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    String key = entry.getKey();
                    if (z3) {
                        z2 = z;
                    } else {
                        Field b2 = a2.b(key);
                        z2 = (b2 == null || b2.getAnnotation(JsonString.class) == null) ? false : true;
                    }
                    a(key);
                    a(z2, value);
                }
            }
            c();
        }
    }

    public void g() throws IOException {
    }
}
