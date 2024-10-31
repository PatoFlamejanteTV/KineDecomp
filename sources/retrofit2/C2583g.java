package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.InterfaceC2579c;

/* compiled from: CompletableFutureCallAdapterFactory.java */
/* renamed from: retrofit2.g */
/* loaded from: classes3.dex */
final class C2583g extends InterfaceC2579c.a {

    /* renamed from: a */
    static final InterfaceC2579c.a f29491a = new C2583g();

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* renamed from: retrofit2.g$a */
    /* loaded from: classes3.dex */
    public static final class a<R> implements InterfaceC2579c<R, CompletableFuture<R>> {

        /* renamed from: a */
        private final Type f29492a;

        a(Type type) {
            this.f29492a = type;
        }

        @Override // retrofit2.InterfaceC2579c
        public Type a() {
            return this.f29492a;
        }

        @Override // retrofit2.InterfaceC2579c
        public CompletableFuture<R> a(InterfaceC2578b<R> interfaceC2578b) {
            C2581e c2581e = new C2581e(this, interfaceC2578b);
            interfaceC2578b.a(new C2582f(this, c2581e));
            return c2581e;
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* renamed from: retrofit2.g$b */
    /* loaded from: classes3.dex */
    public static final class b<R> implements InterfaceC2579c<R, CompletableFuture<D<R>>> {

        /* renamed from: a */
        private final Type f29493a;

        b(Type type) {
            this.f29493a = type;
        }

        @Override // retrofit2.InterfaceC2579c
        public Type a() {
            return this.f29493a;
        }

        @Override // retrofit2.InterfaceC2579c
        public CompletableFuture<D<R>> a(InterfaceC2578b<R> interfaceC2578b) {
            C2584h c2584h = new C2584h(this, interfaceC2578b);
            interfaceC2578b.a(new i(this, c2584h));
            return c2584h;
        }
    }

    C2583g() {
    }

    @Override // retrofit2.InterfaceC2579c.a
    @Nullable
    public InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr, F f2) {
        if (InterfaceC2579c.a.a(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type a2 = InterfaceC2579c.a.a(0, (ParameterizedType) type);
            if (InterfaceC2579c.a.a(a2) != D.class) {
                return new a(a2);
            }
            if (a2 instanceof ParameterizedType) {
                return new b(InterfaceC2579c.a.a(0, (ParameterizedType) a2));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
