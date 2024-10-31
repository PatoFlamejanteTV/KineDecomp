package c.e.a.a;

import java.io.Writer;
import java.util.concurrent.Callable;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public class a implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ b f3861a;

    public a(b bVar) {
        this.f3861a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Writer writer;
        boolean c2;
        synchronized (this.f3861a) {
            writer = this.f3861a.i;
            if (writer == null) {
                return null;
            }
            this.f3861a.v();
            c2 = this.f3861a.c();
            if (c2) {
                this.f3861a.u();
                this.f3861a.k = 0;
            }
            return null;
        }
    }
}
