package retrofit2;

import java.lang.reflect.Type;
import retrofit2.q;

/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes3.dex */
class m implements InterfaceC2579c<Object, InterfaceC2578b<?>> {

    /* renamed from: a */
    final /* synthetic */ Type f29501a;

    /* renamed from: b */
    final /* synthetic */ q f29502b;

    public m(q qVar, Type type) {
        this.f29502b = qVar;
        this.f29501a = type;
    }

    @Override // retrofit2.InterfaceC2579c
    public Type a() {
        return this.f29501a;
    }

    @Override // retrofit2.InterfaceC2579c
    public InterfaceC2578b<?> a(InterfaceC2578b<Object> interfaceC2578b) {
        return new q.a(this.f29502b.f29509a, interfaceC2578b);
    }
}
