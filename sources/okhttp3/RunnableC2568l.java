package okhttp3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectionPool.java */
/* renamed from: okhttp3.l */
/* loaded from: classes3.dex */
public class RunnableC2568l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2569m f29174a;

    public RunnableC2568l(C2569m c2569m) {
        this.f29174a = c2569m;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            long a2 = this.f29174a.a(System.nanoTime());
            if (a2 == -1) {
                return;
            }
            if (a2 > 0) {
                long j = a2 / 1000000;
                long j2 = a2 - (1000000 * j);
                synchronized (this.f29174a) {
                    try {
                        this.f29174a.wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
