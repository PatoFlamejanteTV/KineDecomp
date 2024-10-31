package bolts;

import bolts.p;

/* compiled from: UnobservedErrorNotifier.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    private p<?> f3416a;

    public r(p<?> pVar) {
        this.f3416a = pVar;
    }

    public void a() {
        this.f3416a = null;
    }

    protected void finalize() throws Throwable {
        p.b e2;
        try {
            p<?> pVar = this.f3416a;
            if (pVar != null && (e2 = p.e()) != null) {
                e2.a(pVar, new UnobservedTaskException(pVar.c()));
            }
        } finally {
            super.finalize();
        }
    }
}
