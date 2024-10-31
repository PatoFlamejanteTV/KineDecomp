package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpi;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes2.dex */
public final class Pl<T extends zzpi> extends Handler implements Runnable {

    /* renamed from: a */
    private final T f11771a;

    /* renamed from: b */
    private final zzpg<T> f11772b;

    /* renamed from: c */
    public final int f11773c;

    /* renamed from: d */
    private final long f11774d;

    /* renamed from: e */
    private IOException f11775e;

    /* renamed from: f */
    private int f11776f;

    /* renamed from: g */
    private volatile Thread f11777g;

    /* renamed from: h */
    private volatile boolean f11778h;
    private final /* synthetic */ zzpf i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pl(zzpf zzpfVar, Looper looper, T t, zzpg<T> zzpgVar, int i, long j) {
        super(looper);
        this.i = zzpfVar;
        this.f11771a = t;
        this.f11772b = zzpgVar;
        this.f11773c = i;
        this.f11774d = j;
    }

    private final void b() {
        ExecutorService executorService;
        Pl pl;
        this.f11775e = null;
        executorService = this.i.zzbgv;
        pl = this.i.zzbgw;
        executorService.execute(pl);
    }

    private final void c() {
        this.i.zzbgw = null;
    }

    public final void a(int i) throws IOException {
        IOException iOException = this.f11775e;
        if (iOException != null && this.f11776f > i) {
            throw iOException;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f11778h) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            b();
            return;
        }
        if (i != 4) {
            c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.f11774d;
            if (this.f11771a.zzfe()) {
                this.f11772b.zza((zzpg<T>) this.f11771a, elapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.f11772b.zza((zzpg<T>) this.f11771a, elapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                this.f11772b.zza(this.f11771a, elapsedRealtime, j);
                return;
            }
            if (i2 != 3) {
                return;
            }
            this.f11775e = (IOException) message.obj;
            int zza = this.f11772b.zza((zzpg<T>) this.f11771a, elapsedRealtime, j, this.f11775e);
            if (zza == 3) {
                this.i.zzbci = this.f11775e;
                return;
            } else {
                if (zza != 2) {
                    this.f11776f = zza == 1 ? 1 : this.f11776f + 1;
                    a(Math.min((this.f11776f - 1) * 1000, 5000));
                    return;
                }
                return;
            }
        }
        throw ((Error) message.obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f11777g = Thread.currentThread();
            if (!this.f11771a.zzfe()) {
                String valueOf = String.valueOf(this.f11771a.getClass().getSimpleName());
                zzqc.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.f11771a.zzff();
                    zzqc.endSection();
                } catch (Throwable th) {
                    zzqc.endSection();
                    throw th;
                }
            }
            if (this.f11778h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e2) {
            if (this.f11778h) {
                return;
            }
            obtainMessage(3, e2).sendToTarget();
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.f11778h) {
                return;
            }
            obtainMessage(3, new zzpj(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.f11778h) {
                return;
            }
            obtainMessage(3, new zzpj(e4)).sendToTarget();
        } catch (Error e5) {
            Log.e("LoadTask", "Unexpected error loading stream", e5);
            if (!this.f11778h) {
                obtainMessage(4, e5).sendToTarget();
            }
            throw e5;
        } catch (InterruptedException unused) {
            zzpo.checkState(this.f11771a.zzfe());
            if (this.f11778h) {
                return;
            }
            sendEmptyMessage(2);
        }
    }

    public final void a(long j) {
        Pl pl;
        pl = this.i.zzbgw;
        zzpo.checkState(pl == null);
        this.i.zzbgw = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            b();
        }
    }

    public final void a(boolean z) {
        this.f11778h = z;
        this.f11775e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f11771a.cancelLoad();
            if (this.f11777g != null) {
                this.f11777g.interrupt();
            }
        }
        if (z) {
            c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f11772b.zza((zzpg<T>) this.f11771a, elapsedRealtime, elapsedRealtime - this.f11774d, true);
        }
    }
}
