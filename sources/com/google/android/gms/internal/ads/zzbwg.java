package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzbwg {
    public static zzbwg zzk(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzbwb(cls.getSimpleName());
        }
        return new zzbwd(cls.getSimpleName());
    }

    public abstract void zzge(String str);
}
