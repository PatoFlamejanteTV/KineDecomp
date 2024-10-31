package de.greenrobot.event;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PendingPostQueue.java */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a */
    private i f26707a;

    /* renamed from: b */
    private i f26708b;

    public synchronized void a(i iVar) {
        try {
            if (iVar != null) {
                if (this.f26708b != null) {
                    this.f26708b.f26706d = iVar;
                    this.f26708b = iVar;
                } else if (this.f26707a == null) {
                    this.f26708b = iVar;
                    this.f26707a = iVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized i a() {
        i iVar;
        iVar = this.f26707a;
        if (this.f26707a != null) {
            this.f26707a = this.f26707a.f26706d;
            if (this.f26707a == null) {
                this.f26708b = null;
            }
        }
        return iVar;
    }

    public synchronized i a(int i) throws InterruptedException {
        if (this.f26707a == null) {
            wait(i);
        }
        return a();
    }
}
