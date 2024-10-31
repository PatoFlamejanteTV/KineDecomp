package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* loaded from: classes2.dex */
final class Wl implements Handler.Callback, Choreographer.FrameCallback {

    /* renamed from: a */
    private static final Wl f11946a = new Wl();

    /* renamed from: b */
    public volatile long f11947b;

    /* renamed from: c */
    private final Handler f11948c;

    /* renamed from: d */
    private final HandlerThread f11949d = new HandlerThread("ChoreographerOwner:Handler");

    /* renamed from: e */
    private Choreographer f11950e;

    /* renamed from: f */
    private int f11951f;

    private Wl() {
        this.f11949d.start();
        this.f11948c = new Handler(this.f11949d.getLooper(), this);
        this.f11948c.sendEmptyMessage(0);
    }

    public static Wl a() {
        return f11946a;
    }

    public final void b() {
        this.f11948c.sendEmptyMessage(1);
    }

    public final void c() {
        this.f11948c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f11947b = j;
        this.f11950e.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f11950e = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            this.f11951f++;
            if (this.f11951f == 1) {
                this.f11950e.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.f11951f--;
        if (this.f11951f == 0) {
            this.f11950e.removeFrameCallback(this);
            this.f11947b = 0L;
        }
        return true;
    }
}
