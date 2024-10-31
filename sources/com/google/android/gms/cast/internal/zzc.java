package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes.dex */
public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected boolean zzYA;
    protected final long zzYy;
    protected final Runnable zzYz;

    /* loaded from: classes.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzc.this.zzYA = false;
            zzc.this.zzV(zzc.this.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000L);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzYz = new a();
        this.zzYy = j;
        zzV(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzV(boolean z) {
        if (this.zzYA != z) {
            this.zzYA = z;
            if (z) {
                this.mHandler.postDelayed(this.zzYz, this.zzYy);
            } else {
                this.mHandler.removeCallbacks(this.zzYz);
            }
        }
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzmP() {
        zzV(false);
    }

    protected abstract boolean zzz(long j);
}
