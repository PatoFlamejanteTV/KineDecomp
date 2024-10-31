package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbrn {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzbpu.class, zzbpu.class, zzbpu.zzfli),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzfrf;
    private final Class<?> zzfrg;
    private final Object zzfrh;

    zzbrn(Class cls, Class cls2, Object obj) {
        this.zzfrf = cls;
        this.zzfrg = cls2;
        this.zzfrh = obj;
    }

    public final Class<?> zzanl() {
        return this.zzfrg;
    }
}
