package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class GmsClientEventManager implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final GmsClientEventState f11094a;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f11101h;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f11095b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f11096c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f11097d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f11098e = false;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f11099f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private boolean f11100g = false;
    private final Object i = new Object();

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        this.f11094a = gmsClientEventState;
        this.f11101h = new zap(looper, this);
    }

    public final void a() {
        this.f11098e = false;
        this.f11099f.incrementAndGet();
    }

    public final void b() {
        this.f11098e = true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.i) {
                if (this.f11098e && this.f11094a.isConnected() && this.f11095b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f11094a.getConnectionHint());
                }
            }
            return true;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }

    public final void b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.a(onConnectionFailedListener);
        synchronized (this.i) {
            if (!this.f11097d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    @VisibleForTesting
    public final void a(Bundle bundle) {
        Preconditions.a(this.f11101h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            boolean z = true;
            Preconditions.b(!this.f11100g);
            this.f11101h.removeMessages(1);
            this.f11100g = true;
            if (this.f11096c.size() != 0) {
                z = false;
            }
            Preconditions.b(z);
            ArrayList arrayList = new ArrayList(this.f11095b);
            int i = this.f11099f.get();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f11098e || !this.f11094a.isConnected() || this.f11099f.get() != i) {
                    break;
                } else if (!this.f11096c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f11096c.clear();
            this.f11100g = false;
        }
    }

    @VisibleForTesting
    public final void a(int i) {
        Preconditions.a(this.f11101h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f11101h.removeMessages(1);
        synchronized (this.i) {
            this.f11100g = true;
            ArrayList arrayList = new ArrayList(this.f11095b);
            int i2 = this.f11099f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f11098e || this.f11099f.get() != i2) {
                    break;
                } else if (this.f11095b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f11096c.clear();
            this.f11100g = false;
        }
    }

    @VisibleForTesting
    public final void a(ConnectionResult connectionResult) {
        Preconditions.a(this.f11101h, "onConnectionFailure must only be called on the Handler thread");
        this.f11101h.removeMessages(1);
        synchronized (this.i) {
            ArrayList arrayList = new ArrayList(this.f11097d);
            int i = this.f11099f.get();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                if (this.f11098e && this.f11099f.get() == i) {
                    if (this.f11097d.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    public final void a(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.a(connectionCallbacks);
        synchronized (this.i) {
            if (this.f11095b.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11095b.add(connectionCallbacks);
            }
        }
        if (this.f11094a.isConnected()) {
            Handler handler = this.f11101h;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.a(onConnectionFailedListener);
        synchronized (this.i) {
            if (this.f11097d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11097d.add(onConnectionFailedListener);
            }
        }
    }
}
