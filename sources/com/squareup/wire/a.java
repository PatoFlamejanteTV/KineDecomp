package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BuilderAdapter.java */
/* loaded from: classes.dex */
public final class a<B extends Message.a> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4855a = "$Builder".length();
    private static final Comparator<Field> b = new b();
    private final List<Field> c = new ArrayList();

    public a(Class<B> cls) {
        String name = cls.getName();
        try {
            Field[] declaredFields = Class.forName(name.substring(0, name.length() - f4855a)).getDeclaredFields();
            for (Field field : declaredFields) {
                n nVar = (n) field.getAnnotation(n.class);
                if (nVar != null && nVar.c() == Message.Label.REQUIRED) {
                    try {
                        this.c.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException e) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.c, b);
        } catch (ClassNotFoundException e2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Message.a> void a(B b2) {
        StringBuilder sb = null;
        String str = "";
        try {
            int size = this.c.size();
            int i = 0;
            while (i < size) {
                Field field = this.c.get(i);
                if (field.get(b2) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
                i++;
                sb = sb;
                str = str;
            }
            if (sb != null) {
                throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
