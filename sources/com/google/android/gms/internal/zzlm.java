package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public final class zzlm<L> {
    private volatile L mListener;
    private final zzlm<L>.a zzacG;

    /* loaded from: classes.dex */
    private final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.google.android.gms.common.internal.zzx.b(message.what == 1);
            zzlm.this.zzb((zzb) message.obj);
        }
    }

    /* loaded from: classes.dex */
    public interface zzb<L> {
        void zznN();

        void zzq(L l);
    }

    public zzlm(Looper looper, L l) {
        this.zzacG = new a(looper);
        this.mListener = (L) com.google.android.gms.common.internal.zzx.a(l, "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzbVar) {
        com.google.android.gms.common.internal.zzx.a(zzbVar, "Notifier must not be null");
        this.zzacG.sendMessage(this.zzacG.obtainMessage(1, zzbVar));
    }

    void zzb(zzb<? super L> zzbVar) {
        L l = this.mListener;
        if (l == null) {
            zzbVar.zznN();
            return;
        }
        try {
            zzbVar.zzq(l);
        } catch (RuntimeException e) {
            zzbVar.zznN();
            throw e;
        }
    }
}
