package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.C2403b;
import io.grpc.S;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NameResolverProvider.java */
/* loaded from: classes3.dex */
public abstract class U extends S.a {

    /* renamed from: b */
    public static final C2403b.C0153b<Integer> f27137b = S.a.f27127a;

    /* renamed from: c */
    @VisibleForTesting
    static final Iterable<Class<?>> f27138c = new a();

    /* renamed from: d */
    private static final List<U> f27139d = ca.b(U.class, f27138c, U.class.getClassLoader(), new T());

    /* renamed from: e */
    private static final S.a f27140e = new b(f27139d);

    /* compiled from: NameResolverProvider.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class a implements Iterable<Class<?>> {
        a() {
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("io.grpc.internal.Ha"));
            } catch (ClassNotFoundException unused) {
            }
            return arrayList.iterator();
        }
    }

    public static S.a b() {
        return f27140e;
    }

    public abstract boolean c();

    public abstract int d();

    /* compiled from: NameResolverProvider.java */
    /* loaded from: classes3.dex */
    private static class b extends S.a {

        /* renamed from: b */
        private final List<U> f27141b;

        public b(List<U> list) {
            this.f27141b = list;
        }

        private void b() {
            Preconditions.b(!this.f27141b.isEmpty(), "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
        }

        @Override // io.grpc.S.a
        public S a(URI uri, C2403b c2403b) {
            b();
            Iterator<U> it = this.f27141b.iterator();
            while (it.hasNext()) {
                S a2 = it.next().a(uri, c2403b);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }

        @Override // io.grpc.S.a
        public String a() {
            b();
            return this.f27141b.get(0).a();
        }
    }
}
