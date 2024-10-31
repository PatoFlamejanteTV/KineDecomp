package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: BuilderAdapter.java */
/* loaded from: classes.dex */
public final class b<B extends Message.a> {

    /* renamed from: a */
    private static final int f25703a = 8;

    /* renamed from: b */
    private static final Comparator<Field> f25704b = new a();

    /* renamed from: c */
    private final List<Field> f25705c = new ArrayList();

    public b(Class<B> cls) {
        String name = cls.getName();
        try {
            for (Field field : Class.forName(name.substring(0, name.length() - f25703a)).getDeclaredFields()) {
                n nVar = (n) field.getAnnotation(n.class);
                if (nVar != null && nVar.label() == Message.Label.REQUIRED) {
                    try {
                        this.f25705c.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.f25705c, f25704b);
        } catch (ClassNotFoundException unused2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Message.a> void a(B b2) {
        try {
            int size = this.f25705c.size();
            StringBuilder sb = null;
            String str = "";
            for (int i = 0; i < size; i++) {
                Field field = this.f25705c.get(i);
                if (field.get(b2) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = com.umeng.commonsdk.proguard.e.ap;
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
            }
            if (sb == null) {
                return;
            }
            throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
        } catch (IllegalAccessException unused) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
