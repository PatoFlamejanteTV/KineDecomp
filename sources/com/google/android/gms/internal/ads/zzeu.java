package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class zzeu implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzdl zzqo;
    protected final zzbl zzun;
    private final String zzuu;
    protected Method zzuw;
    private final int zzva;
    private final int zzvb;

    public zzeu(zzdl zzdlVar, String str, String str2, zzbl zzblVar, int i, int i2) {
        this.zzqo = zzdlVar;
        this.className = str;
        this.zzuu = str2;
        this.zzun = zzblVar;
        this.zzva = i;
        this.zzvb = i2;
    }

    protected abstract void zzas() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: zzau, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        long nanoTime;
        try {
            nanoTime = System.nanoTime();
            this.zzuw = this.zzqo.zza(this.className, this.zzuu);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (this.zzuw == null) {
            return null;
        }
        zzas();
        zzco zzah = this.zzqo.zzah();
        if (zzah != null && this.zzva != Integer.MIN_VALUE) {
            zzah.zza(this.zzvb, this.zzva, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
