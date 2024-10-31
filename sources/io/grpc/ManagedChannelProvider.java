package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class ManagedChannelProvider {

    /* renamed from: a */
    @VisibleForTesting
    static final Iterable<Class<?>> f27098a = new a(null);

    /* renamed from: b */
    private static final ManagedChannelProvider f27099b = (ManagedChannelProvider) ca.a(ManagedChannelProvider.class, f27098a, ManagedChannelProvider.class.getClassLoader(), new M());

    /* loaded from: classes3.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    private static final class a implements Iterable<Class<?>> {
        private a() {
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("io.grpc.okhttp.r"));
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
            } catch (ClassNotFoundException unused2) {
            }
            return arrayList.iterator();
        }

        /* synthetic */ a(M m) {
            this();
        }
    }

    public static ManagedChannelProvider c() {
        ManagedChannelProvider managedChannelProvider = f27099b;
        if (managedChannelProvider != null) {
            return managedChannelProvider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp or grpc-netty artifact");
    }

    public abstract L<?> a(String str);

    public abstract boolean a();

    public abstract int b();
}
