package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzdz extends zzeu {
    private static zzev<String> zzui = new zzev<>();
    private final Context zzuj;

    public zzdz(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2, Context context) {
        super(zzdlVar, str, str2, zzblVar, i, 29);
        this.zzuj = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzer = "E";
        AtomicReference<String> zzp = zzui.zzp(this.zzuj.getPackageName());
        if (zzp.get() == null) {
            synchronized (zzp) {
                if (zzp.get() == null) {
                    zzp.set((String) this.zzuw.invoke(null, this.zzuj));
                }
            }
        }
        String str = zzp.get();
        synchronized (this.zzun) {
            this.zzun.zzer = zzbu.zza(str.getBytes(), true);
        }
    }
}
