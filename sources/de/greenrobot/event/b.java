package de.greenrobot.event;

import android.util.Log;

/* compiled from: BackgroundPoster.java */
/* loaded from: classes3.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f26670a = new j();

    /* renamed from: b, reason: collision with root package name */
    private final e f26671b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f26672c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar) {
        this.f26671b = eVar;
    }

    public void a(n nVar, Object obj) {
        i a2 = i.a(nVar, obj);
        synchronized (this) {
            this.f26670a.a(a2);
            if (!this.f26672c) {
                this.f26672c = true;
                this.f26671b.b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                i a2 = this.f26670a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f26670a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.f26671b.a(a2);
            } catch (InterruptedException e2) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f26672c = false;
            }
        }
    }
}
