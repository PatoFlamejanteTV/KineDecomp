package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.C2583g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompletableFutureCallAdapterFactory.java */
/* loaded from: classes3.dex */
public class i<R> implements InterfaceC2580d<R> {

    /* renamed from: a */
    final /* synthetic */ CompletableFuture f29496a;

    /* renamed from: b */
    final /* synthetic */ C2583g.b f29497b;

    public i(C2583g.b bVar, CompletableFuture completableFuture) {
        this.f29497b = bVar;
        this.f29496a = completableFuture;
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<R> interfaceC2578b, D<R> d2) {
        this.f29496a.complete(d2);
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<R> interfaceC2578b, Throwable th) {
        this.f29496a.completeExceptionally(th);
    }
}
