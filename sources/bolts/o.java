package bolts;

import java.util.concurrent.CancellationException;

/* compiled from: Task.java */
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3402a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f3403b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f3404c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f3405d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar, q qVar, i iVar, p pVar) {
        this.f3402a = hVar;
        this.f3403b = qVar;
        this.f3404c = iVar;
        this.f3405d = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.f3402a;
        if (hVar == null) {
            try {
                p pVar = (p) this.f3404c.a(this.f3405d);
                if (pVar == null) {
                    this.f3403b.a((q) null);
                } else {
                    pVar.a((i) new n(this));
                }
                return;
            } catch (CancellationException unused) {
                this.f3403b.b();
                return;
            } catch (Exception e2) {
                this.f3403b.a(e2);
                return;
            }
        }
        hVar.a();
        throw null;
    }
}
