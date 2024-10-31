package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster.java */
/* loaded from: classes3.dex */
final class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final j f26697a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26698b;

    /* renamed from: c, reason: collision with root package name */
    private final e f26699c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f26700d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Looper looper, int i) {
        super(looper);
        this.f26699c = eVar;
        this.f26698b = i;
        this.f26697a = new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar, Object obj) {
        i a2 = i.a(nVar, obj);
        synchronized (this) {
            this.f26697a.a(a2);
            if (!this.f26700d) {
                this.f26700d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                i a2 = this.f26697a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f26697a.a();
                        if (a2 == null) {
                            this.f26700d = false;
                            return;
                        }
                    }
                }
                this.f26699c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f26698b);
            if (sendMessage(obtainMessage())) {
                this.f26700d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f26700d = false;
        }
    }
}
