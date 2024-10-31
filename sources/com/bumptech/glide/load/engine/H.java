package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class H {

    /* renamed from: a */
    private boolean f8782a;

    /* renamed from: b */
    private final Handler f8783b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    public static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((E) message.obj).b();
            return true;
        }
    }

    public synchronized void a(E<?> e2) {
        if (this.f8782a) {
            this.f8783b.obtainMessage(1, e2).sendToTarget();
        } else {
            this.f8782a = true;
            e2.b();
            this.f8782a = false;
        }
    }
}
