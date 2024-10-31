package bolts;

import java.util.concurrent.Executor;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class j<TResult> implements i<TResult, Void> {

    /* renamed from: a */
    final /* synthetic */ q f3384a;

    /* renamed from: b */
    final /* synthetic */ i f3385b;

    /* renamed from: c */
    final /* synthetic */ Executor f3386c;

    /* renamed from: d */
    final /* synthetic */ h f3387d;

    /* renamed from: e */
    final /* synthetic */ p f3388e;

    public j(p pVar, q qVar, i iVar, Executor executor, h hVar) {
        this.f3388e = pVar;
        this.f3384a = qVar;
        this.f3385b = iVar;
        this.f3386c = executor;
        this.f3387d = hVar;
    }

    @Override // bolts.i
    public Void a(p<TResult> pVar) {
        p.d(this.f3384a, this.f3385b, pVar, this.f3386c, this.f3387d);
        return null;
    }
}
