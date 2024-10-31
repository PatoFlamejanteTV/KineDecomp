package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.C2583g;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: CompletableFutureCallAdapterFactory.java */
/* renamed from: retrofit2.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2582f<R> implements InterfaceC2580d<R> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CompletableFuture f29489a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2583g.a f29490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2582f(C2583g.a aVar, CompletableFuture completableFuture) {
        this.f29490b = aVar;
        this.f29489a = completableFuture;
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<R> interfaceC2578b, D<R> d2) {
        if (d2.c()) {
            this.f29489a.complete(d2.a());
        } else {
            this.f29489a.completeExceptionally(new HttpException(d2));
        }
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<R> interfaceC2578b, Throwable th) {
        this.f29489a.completeExceptionally(th);
    }
}
