package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzem extends zzeu {
    private final StackTraceElement[] zzus;

    public zzem(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdlVar, str, str2, zzblVar, i, 45);
        this.zzus = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    protected final void zzas() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzus;
        if (stackTraceElementArr != null) {
            zzdj zzdjVar = new zzdj((String) this.zzuw.invoke(null, stackTraceElementArr));
            synchronized (this.zzun) {
                this.zzun.zzfe = zzdjVar.zzsk;
                if (zzdjVar.zzsl.booleanValue()) {
                    this.zzun.zzfm = Integer.valueOf(zzdjVar.zzsm.booleanValue() ? 0 : 1);
                } else {
                    this.zzun.zzfm = 2;
                }
            }
        }
    }
}
