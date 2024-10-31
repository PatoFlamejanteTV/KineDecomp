package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.InterfaceC2579c;

/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class q extends InterfaceC2579c.a {

    /* renamed from: a */
    final Executor f29509a;

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements InterfaceC2578b<T> {

        /* renamed from: a */
        final Executor f29510a;

        /* renamed from: b */
        final InterfaceC2578b<T> f29511b;

        public a(Executor executor, InterfaceC2578b<T> interfaceC2578b) {
            this.f29510a = executor;
            this.f29511b = interfaceC2578b;
        }

        @Override // retrofit2.InterfaceC2578b
        public boolean S() {
            return this.f29511b.S();
        }

        @Override // retrofit2.InterfaceC2578b
        public void a(InterfaceC2580d<T> interfaceC2580d) {
            H.a(interfaceC2580d, "callback == null");
            this.f29511b.a(new p(this, interfaceC2580d));
        }

        @Override // retrofit2.InterfaceC2578b
        public void cancel() {
            this.f29511b.cancel();
        }

        @Override // retrofit2.InterfaceC2578b
        public D<T> execute() throws IOException {
            return this.f29511b.execute();
        }

        @Override // retrofit2.InterfaceC2578b
        public InterfaceC2578b<T> clone() {
            return new a(this.f29510a, this.f29511b.clone());
        }
    }

    public q(Executor executor) {
        this.f29509a = executor;
    }

    @Override // retrofit2.InterfaceC2579c.a
    @Nullable
    public InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr, F f2) {
        if (InterfaceC2579c.a.a(type) != InterfaceC2578b.class) {
            return null;
        }
        return new m(this, H.b(type));
    }
}
