package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class zza implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    boolean f1047a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    public IBinder a() throws InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        }
        if (this.f1047a) {
            throw new IllegalStateException();
        }
        this.f1047a = true;
        return this.b.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
