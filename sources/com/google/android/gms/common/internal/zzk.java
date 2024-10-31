package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzk implements Handler.Callback {
    private final zza b;
    private final Handler h;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> c = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<GoogleApiClient.ConnectionCallbacks> f1014a = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> d = new ArrayList<>();
    private volatile boolean e = false;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g = false;
    private final Object i = new Object();

    /* loaded from: classes.dex */
    public interface zza {
        boolean isConnected();

        Bundle zzmS();
    }

    public zzk(Looper looper, zza zzaVar) {
        this.b = zzaVar;
        this.h = new Handler(looper, this);
    }

    public void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    public void a(int i) {
        zzx.a(Looper.myLooper() == this.h.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            this.g = true;
            ArrayList arrayList = new ArrayList(this.c);
            int i2 = this.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.e || this.f.get() != i2) {
                    break;
                } else if (this.c.contains(connectionCallbacks)) {
                    connectionCallbacks.a_(i);
                }
            }
            this.f1014a.clear();
            this.g = false;
        }
    }

    public void a(Bundle bundle) {
        zzx.a(Looper.myLooper() == this.h.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            zzx.a(!this.g);
            this.h.removeMessages(1);
            this.g = true;
            zzx.a(this.f1014a.size() == 0);
            ArrayList arrayList = new ArrayList(this.c);
            int i = this.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.e || !this.b.isConnected() || this.f.get() != i) {
                    break;
                } else if (!this.f1014a.contains(connectionCallbacks)) {
                    connectionCallbacks.a(bundle);
                }
            }
            this.f1014a.clear();
            this.g = false;
        }
    }

    public void a(ConnectionResult connectionResult) {
        zzx.a(Looper.myLooper() == this.h.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            ArrayList arrayList = new ArrayList(this.d);
            int i = this.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (!this.e || this.f.get() != i) {
                    return;
                }
                if (this.d.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.a(connectionResult);
                }
            }
        }
    }

    public void a(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.a(connectionCallbacks);
        synchronized (this.i) {
            if (this.c.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.c.add(connectionCallbacks);
            }
        }
        if (this.b.isConnected()) {
            this.h.sendMessage(this.h.obtainMessage(1, connectionCallbacks));
        }
    }

    public void a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.a(onConnectionFailedListener);
        synchronized (this.i) {
            if (this.d.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.d.add(onConnectionFailedListener);
            }
        }
    }

    public void b() {
        this.e = true;
    }

    public boolean b(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzx.a(connectionCallbacks);
        synchronized (this.i) {
            contains = this.c.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzx.a(onConnectionFailedListener);
        synchronized (this.i) {
            contains = this.d.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void c(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.a(connectionCallbacks);
        synchronized (this.i) {
            if (!this.c.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.g) {
                this.f1014a.add(connectionCallbacks);
            }
        }
    }

    public void c(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.a(onConnectionFailedListener);
        synchronized (this.i) {
            if (!this.d.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.i) {
            if (this.e && this.b.isConnected() && this.c.contains(connectionCallbacks)) {
                connectionCallbacks.a(this.b.zzmS());
            }
        }
        return true;
    }
}
