package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.ag */
/* loaded from: classes2.dex */
public final class C0829ag implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    @VisibleForTesting
    private zzbjf f12059a;

    /* renamed from: b */
    private final String f12060b;

    /* renamed from: c */
    private final String f12061c;

    /* renamed from: d */
    private final LinkedBlockingQueue<zzbl> f12062d;

    /* renamed from: e */
    private final HandlerThread f12063e = new HandlerThread("GassClient");

    public C0829ag(Context context, String str, String str2) {
        this.f12060b = str;
        this.f12061c = str2;
        this.f12063e.start();
        this.f12059a = new zzbjf(context, this.f12063e.getLooper(), this, this);
        this.f12062d = new LinkedBlockingQueue<>();
        this.f12059a.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    private static zzbl b() {
        zzbl zzblVar = new zzbl();
        zzblVar.zzeo = Long.valueOf(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return zzblVar;
    }

    private final void c() {
        zzbjf zzbjfVar = this.f12059a;
        if (zzbjfVar != null) {
            if (zzbjfVar.isConnected() || this.f12059a.isConnecting()) {
                this.f12059a.disconnect();
            }
        }
    }

    public final zzbl a(int i) {
        zzbl zzblVar;
        try {
            zzblVar = this.f12062d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzblVar = null;
        }
        return zzblVar == null ? b() : zzblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbjk a2 = a();
        try {
            if (a2 != null) {
                try {
                    try {
                        this.f12062d.put(a2.zza(new zzbjg(this.f12060b, this.f12061c)).zzafn());
                    } catch (Throwable unused) {
                        this.f12062d.put(b());
                    }
                } catch (InterruptedException unused2) {
                }
            }
        } finally {
            c();
            this.f12063e.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.f12062d.put(b());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.f12062d.put(b());
        } catch (InterruptedException unused) {
        }
    }

    private final zzbjk a() {
        try {
            return this.f12059a.zzafm();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
