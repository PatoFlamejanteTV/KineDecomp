package com.nexstreaming.app.general.norm;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.norm.c;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public class NormColumnInfo {

    /* renamed from: a */
    final String f19641a;

    /* renamed from: b */
    final Field f19642b;

    /* renamed from: c */
    final ColumnType f19643c;

    /* renamed from: d */
    final boolean f19644d;

    /* renamed from: e */
    final boolean f19645e;

    /* renamed from: f */
    final boolean f19646f;

    /* renamed from: g */
    final boolean f19647g;

    /* renamed from: h */
    final boolean f19648h;
    final int i;
    final Class<? extends c> j;

    /* loaded from: classes2.dex */
    public enum ColumnType {
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        TEXT,
        BOOL,
        JSON,
        ENUM,
        BLOB,
        JPEG,
        PNG
    }

    public NormColumnInfo(Field field) {
        ColumnType columnType;
        Class type = field.getType();
        this.f19646f = field.isAnnotationPresent(c.InterfaceC0098c.class) || c.class.isAssignableFrom(type);
        if (this.f19646f && c.class.isAssignableFrom(type)) {
            this.j = type;
        } else {
            this.j = null;
        }
        this.f19647g = field.getName().equals("_id") || field.isAnnotationPresent(c.f.class);
        if (this.f19646f) {
            columnType = ColumnType.LONG;
        } else if (type != Integer.class && type != Integer.TYPE) {
            if (type != Long.class && type != Long.TYPE) {
                if (type != Float.class && type != Float.TYPE) {
                    if (type != Double.class && type != Double.TYPE) {
                        if (type == String.class) {
                            columnType = ColumnType.TEXT;
                        } else if (type != Boolean.class && type != Boolean.TYPE) {
                            if (Collection.class.isAssignableFrom(type)) {
                                columnType = ColumnType.JSON;
                            } else if (Map.class.isAssignableFrom(type)) {
                                columnType = ColumnType.JSON;
                            } else if (type == byte[].class) {
                                columnType = ColumnType.BLOB;
                            } else if (type == Bitmap.class) {
                                if (field.isAnnotationPresent(c.b.class)) {
                                    columnType = ColumnType.JPEG;
                                } else {
                                    columnType = ColumnType.PNG;
                                }
                            } else if (Enum.class.isAssignableFrom(type)) {
                                columnType = ColumnType.ENUM;
                            } else {
                                throw new UnsupportedOperationException("Unrecognized column type: " + type.getSimpleName() + " (for column '" + field.getName() + "')");
                            }
                        } else {
                            columnType = ColumnType.BOOL;
                        }
                    } else {
                        columnType = ColumnType.DOUBLE;
                    }
                } else {
                    columnType = ColumnType.FLOAT;
                }
            } else {
                columnType = ColumnType.LONG;
            }
        } else {
            columnType = ColumnType.INT;
        }
        if (this.f19647g && columnType != ColumnType.LONG) {
            throw new IllegalArgumentException("Primary key must be 'long' type.");
        }
        this.f19644d = field.isAnnotationPresent(c.g.class);
        this.f19648h = field.isAnnotationPresent(c.d.class);
        this.f19645e = field.isAnnotationPresent(c.e.class);
        this.f19641a = b.a(field.getName());
        this.f19642b = field;
        this.f19643c = columnType;
        if (field.isAnnotationPresent(c.a.class)) {
            this.i = ((c.a) field.getAnnotation(c.a.class)).value();
        } else {
            this.i = 11;
        }
    }

    public String toString() {
        return this.f19641a;
    }
}
