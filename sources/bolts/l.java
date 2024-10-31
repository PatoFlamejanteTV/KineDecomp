package bolts;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class l<TContinuationResult, TResult> implements i<TResult, p<TContinuationResult>> {

    /* renamed from: a */
    final /* synthetic */ h f3394a;

    /* renamed from: b */
    final /* synthetic */ i f3395b;

    /* renamed from: c */
    final /* synthetic */ p f3396c;

    public l(p pVar, h hVar, i iVar) {
        this.f3396c = pVar;
        this.f3394a = hVar;
        this.f3395b = iVar;
    }

    @Override // bolts.i
    public p<TContinuationResult> a(p<TResult> pVar) {
        h hVar = this.f3394a;
        if (hVar == null) {
            if (pVar.h()) {
                return p.a(pVar.c());
            }
            if (pVar.f()) {
                return p.a();
            }
            return pVar.a((i) this.f3395b);
        }
        hVar.a();
        throw null;
    }
}
