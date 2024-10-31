package bolts;

import java.util.concurrent.Executor;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class k<TResult> implements i<TResult, Void> {

    /* renamed from: a */
    final /* synthetic */ q f3389a;

    /* renamed from: b */
    final /* synthetic */ i f3390b;

    /* renamed from: c */
    final /* synthetic */ Executor f3391c;

    /* renamed from: d */
    final /* synthetic */ h f3392d;

    /* renamed from: e */
    final /* synthetic */ p f3393e;

    public k(p pVar, q qVar, i iVar, Executor executor, h hVar) {
        this.f3393e = pVar;
        this.f3389a = qVar;
        this.f3390b = iVar;
        this.f3391c = executor;
        this.f3392d = hVar;
    }

    @Override // bolts.i
    public Void a(p<TResult> pVar) {
        p.c(this.f3389a, this.f3390b, pVar, this.f3391c, this.f3392d);
        return null;
    }
}
