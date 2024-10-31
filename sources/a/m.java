package a;

import a.g;

/* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
/* compiled from: Task.java */
/* loaded from: classes.dex */
class m<TContinuationResult> implements f<TContinuationResult, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f13a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f13a = lVar;
    }

    @Override // a.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void a(g<TContinuationResult> gVar) {
        if (this.f13a.f12a != null && this.f13a.f12a.a()) {
            this.f13a.b.c();
        } else if (gVar.c()) {
            this.f13a.b.c();
        } else if (gVar.d()) {
            this.f13a.b.b(gVar.f());
        } else {
            this.f13a.b.b((g.a) gVar.e());
        }
        return null;
    }
}
