package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public enum zzux {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzte.class, zzte.class, zzte.zzbtq),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzbzo;
    private final Class<?> zzbzp;
    private final Object zzbzq;

    zzux(Class cls, Class cls2, Object obj) {
        this.zzbzo = cls;
        this.zzbzp = cls2;
        this.zzbzq = obj;
    }

    public final Class<?> zzwy() {
        return this.zzbzp;
    }
}
