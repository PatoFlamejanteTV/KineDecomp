package a;

import a.g;
import java.util.concurrent.CancellationException;

/* compiled from: Task.java */
/* loaded from: classes.dex */
final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f12a;
    final /* synthetic */ g.a b;
    final /* synthetic */ f c;
    final /* synthetic */ g d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar, g.a aVar, f fVar, g gVar) {
        this.f12a = eVar;
        this.b = aVar;
        this.c = fVar;
        this.d = gVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0026 -> B:12:0x0011). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0036 -> B:12:0x0011). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        if (this.f12a != null && this.f12a.a()) {
            this.b.c();
            return;
        }
        try {
            g gVar = (g) this.c.a(this.d);
            if (gVar == null) {
                this.b.b((g.a) null);
            } else {
                gVar.a((f) new m(this));
            }
        } catch (CancellationException e) {
            this.b.c();
        } catch (Exception e2) {
            this.b.b(e2);
        }
    }
}
