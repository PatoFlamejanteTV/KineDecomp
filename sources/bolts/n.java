package bolts;

/* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
/* compiled from: Task.java */
/* loaded from: classes.dex */
class n<TContinuationResult> implements i<TContinuationResult, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f3401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        this.f3401a = oVar;
    }

    @Override // bolts.i
    public Void a(p<TContinuationResult> pVar) {
        h hVar = this.f3401a.f3402a;
        if (hVar == null) {
            if (pVar.f()) {
                this.f3401a.f3403b.b();
            } else if (pVar.h()) {
                this.f3401a.f3403b.a(pVar.c());
            } else {
                this.f3401a.f3403b.a((q) pVar.d());
            }
            return null;
        }
        hVar.a();
        throw null;
    }
}
