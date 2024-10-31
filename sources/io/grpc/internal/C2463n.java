package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.InterfaceC2527w;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.Oc;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

/* compiled from: ApplicationThreadDeframer.java */
/* renamed from: io.grpc.internal.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2463n implements InterfaceC2436ga, MessageDeframer.a {

    /* renamed from: a, reason: collision with root package name */
    private final MessageDeframer.a f27696a;

    /* renamed from: b, reason: collision with root package name */
    private final MessageDeframer f27697b;

    /* renamed from: c, reason: collision with root package name */
    private final b f27698c;

    /* renamed from: d, reason: collision with root package name */
    private final Queue<InputStream> f27699d = new ArrayDeque();

    /* compiled from: ApplicationThreadDeframer.java */
    /* renamed from: io.grpc.internal.n$a */
    /* loaded from: classes3.dex */
    private class a implements Oc.a {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f27700a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f27701b;

        /* synthetic */ a(C2463n c2463n, Runnable runnable, RunnableC2435g runnableC2435g) {
            this(runnable);
        }

        private void a() {
            if (this.f27701b) {
                return;
            }
            this.f27700a.run();
            this.f27701b = true;
        }

        @Override // io.grpc.internal.Oc.a
        @Nullable
        public InputStream next() {
            a();
            return (InputStream) C2463n.this.f27699d.poll();
        }

        private a(Runnable runnable) {
            this.f27701b = false;
            this.f27700a = runnable;
        }
    }

    /* compiled from: ApplicationThreadDeframer.java */
    /* renamed from: io.grpc.internal.n$b */
    /* loaded from: classes3.dex */
    interface b {
        void a(Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2463n(MessageDeframer.a aVar, b bVar, MessageDeframer messageDeframer) {
        Preconditions.a(aVar, "listener");
        this.f27696a = aVar;
        Preconditions.a(bVar, "transportExecutor");
        this.f27698c = bVar;
        messageDeframer.a(this);
        this.f27697b = messageDeframer;
    }

    @Override // io.grpc.internal.InterfaceC2436ga, java.lang.AutoCloseable
    public void close() {
        this.f27697b.b();
        this.f27696a.a(new a(this, new RunnableC2447j(this), null));
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(InterfaceC2527w interfaceC2527w) {
        this.f27697b.a(interfaceC2527w);
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void b(int i) {
        this.f27697b.b(i);
    }

    @Override // io.grpc.internal.MessageDeframer.a
    public void c(int i) {
        this.f27698c.a(new RunnableC2451k(this, i));
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(GzipInflatingBuffer gzipInflatingBuffer) {
        this.f27697b.a(gzipInflatingBuffer);
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(int i) {
        this.f27696a.a(new a(this, new RunnableC2435g(this, i), null));
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a(InterfaceC2426dc interfaceC2426dc) {
        this.f27696a.a(new a(this, new RunnableC2439h(this, interfaceC2426dc), null));
    }

    @Override // io.grpc.internal.InterfaceC2436ga
    public void a() {
        this.f27696a.a(new a(this, new RunnableC2443i(this), null));
    }

    @Override // io.grpc.internal.MessageDeframer.a
    public void a(Oc.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f27699d.add(next);
            }
        }
    }

    @Override // io.grpc.internal.MessageDeframer.a
    public void a(boolean z) {
        this.f27698c.a(new RunnableC2455l(this, z));
    }

    @Override // io.grpc.internal.MessageDeframer.a
    public void a(Throwable th) {
        this.f27698c.a(new RunnableC2459m(this, th));
    }
}
