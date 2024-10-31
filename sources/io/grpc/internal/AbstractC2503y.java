package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.C2512m;
import io.grpc.Context;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.aa;
import io.opencensus.trace.Span;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: BinaryLogProvider.java */
/* renamed from: io.grpc.internal.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2503y implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final Context.d<c> f27788a = Context.e("binarylog-context-key");

    /* renamed from: b, reason: collision with root package name */
    public static final C2406e.a<c> f27789b = C2406e.a.a("binarylog-calloptions-key", null);

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    public static final MethodDescriptor.b<byte[]> f27790c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Logger f27791d = Logger.getLogger(AbstractC2503y.class.getName());

    /* renamed from: e, reason: collision with root package name */
    private static final AbstractC2503y f27792e = (AbstractC2503y) io.grpc.G.a(AbstractC2503y.class, Collections.emptyList(), AbstractC2503y.class.getClassLoader(), new C2490u());

    /* renamed from: f, reason: collision with root package name */
    private static final io.grpc.aa f27793f = new C2494v();

    /* renamed from: g, reason: collision with root package name */
    private static final aa.a f27794g = new C2497w();

    /* renamed from: h, reason: collision with root package name */
    private static final InterfaceC2409h f27795h = new C2500x();
    private final InterfaceC2409h i = new a(this, null);

    /* compiled from: BinaryLogProvider.java */
    /* renamed from: io.grpc.internal.y$a */
    /* loaded from: classes3.dex */
    private final class a implements InterfaceC2409h {
        private a() {
        }

        @Override // io.grpc.InterfaceC2409h
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
            InterfaceC2409h e2 = AbstractC2503y.this.e(methodDescriptor.a());
            if (e2 == null) {
                return abstractC2407f.a(methodDescriptor, c2406e);
            }
            MethodDescriptor.b<byte[]> bVar = AbstractC2503y.f27790c;
            return io.grpc.D.a(e2, bVar, bVar).a(methodDescriptor, c2406e, abstractC2407f);
        }

        /* synthetic */ a(AbstractC2503y abstractC2503y, C2490u c2490u) {
            this();
        }
    }

    /* compiled from: BinaryLogProvider.java */
    /* renamed from: io.grpc.internal.y$b */
    /* loaded from: classes3.dex */
    private static final class b implements MethodDescriptor.b<byte[]> {
        private b() {
        }

        private byte[] b(InputStream inputStream) throws IOException {
            try {
                return C2465nb.a(inputStream);
            } finally {
                inputStream.close();
            }
        }

        /* synthetic */ b(C2490u c2490u) {
            this();
        }

        @Override // io.grpc.MethodDescriptor.b
        public InputStream a(byte[] bArr) {
            return new ByteArrayInputStream(bArr);
        }

        @Override // io.grpc.MethodDescriptor.b
        public byte[] a(InputStream inputStream) {
            try {
                return b(inputStream);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: BinaryLogProvider.java */
    /* renamed from: io.grpc.internal.y$c */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f27797a;

        /* renamed from: b, reason: collision with root package name */
        public final long f27798b;

        public c(long j, long j2) {
            this.f27797a = j;
            this.f27798b = j2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static c a(Span span) {
            return new c(0L, ByteBuffer.wrap(span.a().a().a()).getLong());
        }
    }

    @Nullable
    public static AbstractC2503y r() {
        return f27792e;
    }

    public final AbstractC2407f a(AbstractC2407f abstractC2407f) {
        return C2512m.a(abstractC2407f, this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Nullable
    protected abstract InterfaceC2409h e(String str);

    public InterfaceC2409h a() {
        return f27795h;
    }
}
