package io.grpc;

import io.grpc.C2403b;
import java.net.URI;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: NameResolver.java */
@ThreadSafe
/* loaded from: classes3.dex */
public abstract class S {

    /* compiled from: NameResolver.java */
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a */
        public static final C2403b.C0153b<Integer> f27127a = C2403b.C0153b.a("params-default-port");

        @Nullable
        public abstract S a(URI uri, C2403b c2403b);

        public abstract String a();
    }

    /* compiled from: NameResolver.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public interface b {
        void a(Status status);

        void a(List<C2530z> list, C2403b c2403b);
    }

    public abstract String a();

    public abstract void a(b bVar);

    public void b() {
    }

    public abstract void c();
}
