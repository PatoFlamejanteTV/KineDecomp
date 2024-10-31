package a;

import a.g;
import java.util.concurrent.CancellationException;

/* compiled from: Task.java */
/* loaded from: classes.dex */
final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f11a;
    final /* synthetic */ g.a b;
    final /* synthetic */ f c;
    final /* synthetic */ g d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, g.a aVar, f fVar, g gVar) {
        this.f11a = eVar;
        this.b = aVar;
        this.c = fVar;
        this.d = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f11a != null && this.f11a.a()) {
            this.b.c();
            return;
        }
        try {
            this.b.b((g.a) this.c.a(this.d));
        } catch (CancellationException e) {
            this.b.c();
        } catch (Exception e2) {
            this.b.b(e2);
        }
    }
}
