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

/* loaded from: classes2.dex */
public abstract class JsonGenerator {
    public void a() throws IOException {
    }

    public abstract void a(double d2) throws IOException;

    public abstract void a(float f2) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(long j) throws IOException;

    public final void a(Object obj) throws IOException {
        a(false, obj);
    }

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

    public abstract void g() throws IOException;

    private void a(boolean z, Object obj) throws IOException {
        boolean z2;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (Data.b(obj)) {
            e();
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
                if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                    double doubleValue = ((Number) obj).doubleValue();
                    Preconditions.a((Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) ? false : true);
                    a(doubleValue);
                    return;
                }
                a(((Number) obj).intValue());
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
        if (!(obj instanceof Iterable) && !cls.isArray()) {
            if (cls.isEnum()) {
                String d2 = FieldInfo.a((Enum<?>) obj).d();
                if (d2 == null) {
                    e();
                    return;
                } else {
                    b(d2);
                    return;
                }
            }
            g();
            boolean z3 = (obj instanceof Map) && !(obj instanceof GenericData);
            ClassInfo a2 = z3 ? null : ClassInfo.a(cls);
            for (Map.Entry<String, Object> entry : Data.d(obj).entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    String key = entry.getKey();
                    if (z3) {
                        z2 = z;
                    } else {
                        Field a3 = a2.a(key);
                        z2 = (a3 == null || a3.getAnnotation(JsonString.class) == null) ? false : true;
                    }
                    a(key);
                    a(z2, value);
                }
            }
            d();
            return;
        }
        f();
        Iterator it = Types.a(obj).iterator();
        while (it.hasNext()) {
            a(z, it.next());
        }
        c();
    }
}
