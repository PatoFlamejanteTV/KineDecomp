package a;

import a.g;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [TResult] */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class i<TResult> implements f<TResult, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g.a f9a;
    final /* synthetic */ f b;
    final /* synthetic */ Executor c;
    final /* synthetic */ e d;
    final /* synthetic */ g e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, g.a aVar, f fVar, Executor executor, e eVar) {
        this.e = gVar;
        this.f9a = aVar;
        this.b = fVar;
        this.c = executor;
        this.d = eVar;
    }

    @Override // a.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void a(g<TResult> gVar) {
        g.d(this.f9a, this.b, gVar, this.c, this.d);
        return null;
    }
}
