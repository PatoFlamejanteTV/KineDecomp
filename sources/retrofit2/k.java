package retrofit2;

import java.lang.reflect.Type;

/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes3.dex */
class k implements InterfaceC2579c<Object, InterfaceC2578b<?>> {

    /* renamed from: a */
    final /* synthetic */ Type f29498a;

    /* renamed from: b */
    final /* synthetic */ l f29499b;

    public k(l lVar, Type type) {
        this.f29499b = lVar;
        this.f29498a = type;
    }

    @Override // retrofit2.InterfaceC2579c
    public /* bridge */ /* synthetic */ InterfaceC2578b<?> a(InterfaceC2578b<Object> interfaceC2578b) {
        a(interfaceC2578b);
        return interfaceC2578b;
    }

    @Override // retrofit2.InterfaceC2579c
    public InterfaceC2578b<?> a(InterfaceC2578b<Object> interfaceC2578b) {
        return interfaceC2578b;
    }

    @Override // retrofit2.InterfaceC2579c
    public Type a() {
        return this.f29498a;
    }
}
