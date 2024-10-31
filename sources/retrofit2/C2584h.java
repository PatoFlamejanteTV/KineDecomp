package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.C2583g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompletableFutureCallAdapterFactory.java */
/* renamed from: retrofit2.h */
/* loaded from: classes3.dex */
public class C2584h<R> extends CompletableFuture<D<R>> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2578b f29494a;

    /* renamed from: b */
    final /* synthetic */ C2583g.b f29495b;

    public C2584h(C2583g.b bVar, InterfaceC2578b interfaceC2578b) {
        this.f29495b = bVar;
        this.f29494a = interfaceC2578b;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (z) {
            this.f29494a.cancel();
        }
        return super.cancel(z);
    }
}
