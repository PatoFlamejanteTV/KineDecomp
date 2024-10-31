package a;

/* JADX INFO: Add missing generic type declarations: [TContinuationResult, TResult] */
/* compiled from: Task.java */
/* loaded from: classes.dex */
class j<TContinuationResult, TResult> implements f<TResult, g<TContinuationResult>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f10a;
    final /* synthetic */ f b;
    final /* synthetic */ g c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, e eVar, f fVar) {
        this.c = gVar;
        this.f10a = eVar;
        this.b = fVar;
    }

    @Override // a.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<TContinuationResult> a(g<TResult> gVar) {
        if (this.f10a != null && this.f10a.a()) {
            return g.g();
        }
        if (gVar.d()) {
            return g.a(gVar.f());
        }
        if (gVar.c()) {
            return g.g();
        }
        return gVar.a((f) this.b);
    }
}
