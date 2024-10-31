package bolts;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ h f3397a;

    /* renamed from: b */
    final /* synthetic */ q f3398b;

    /* renamed from: c */
    final /* synthetic */ i f3399c;

    /* renamed from: d */
    final /* synthetic */ p f3400d;

    public m(h hVar, q qVar, i iVar, p pVar) {
        this.f3397a = hVar;
        this.f3398b = qVar;
        this.f3399c = iVar;
        this.f3400d = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.f3397a;
        if (hVar == null) {
            try {
                this.f3398b.a((q) this.f3399c.a(this.f3400d));
                return;
            } catch (CancellationException unused) {
                this.f3398b.b();
                return;
            } catch (Exception e2) {
                this.f3398b.a(e2);
                return;
            }
        }
        hVar.a();
        throw null;
    }
}
