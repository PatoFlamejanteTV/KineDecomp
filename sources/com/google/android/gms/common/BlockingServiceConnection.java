package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a */
    private boolean f10645a = false;

    /* renamed from: b */
    private final BlockingQueue<IBinder> f10646b = new LinkedBlockingQueue();

    @KeepForSdk
    public IBinder a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f10645a) {
            this.f10645a = true;
            IBinder poll = this.f10646b.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10646b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @KeepForSdk
    public IBinder a() throws InterruptedException {
        Preconditions.c("BlockingServiceConnection.getService() called on main thread");
        if (!this.f10645a) {
            this.f10645a = true;
            return this.f10646b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }
}
