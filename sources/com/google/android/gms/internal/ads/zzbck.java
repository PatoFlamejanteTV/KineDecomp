package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzbck<T> extends zzbcl<T> {
    private final T zzepu;

    private zzbck(T t) {
        this.zzepu = t;
    }

    public static <T> zzbck<T> zzn(T t) {
        return new zzbck<>(t);
    }

    public final void zzaax() {
        set(this.zzepu);
    }
}
