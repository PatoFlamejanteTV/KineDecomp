package io.grpc.b;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.umeng.commonsdk.proguard.e;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: ClientCalls.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27163a = Logger.getLogger(b.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientCalls.java */
    /* loaded from: classes3.dex */
    public static final class a<RespT> extends AbstractFuture<RespT> {

        /* renamed from: h, reason: collision with root package name */
        private final AbstractC2408g<?, RespT> f27164h;

        a(AbstractC2408g<?, RespT> abstractC2408g) {
            this.f27164h = abstractC2408g;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean a(@Nullable RespT respt) {
            return super.a((a<RespT>) respt);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void d() {
            this.f27164h.a("GrpcFuture was cancelled", (Throwable) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean a(Throwable th) {
            return super.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientCalls.java */
    /* renamed from: io.grpc.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class ExecutorC0154b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private static final Logger f27165a = Logger.getLogger(ExecutorC0154b.class.getName());

        /* renamed from: b, reason: collision with root package name */
        private final BlockingQueue<Runnable> f27166b = new LinkedBlockingQueue();

        ExecutorC0154b() {
        }

        public void a() throws InterruptedException {
            Runnable take = this.f27166b.take();
            while (take != null) {
                try {
                    take.run();
                } catch (Throwable th) {
                    f27165a.log(Level.WARNING, "Runnable threw exception", th);
                }
                take = this.f27166b.poll();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f27166b.add(runnable);
        }
    }

    private b() {
    }

    public static <ReqT, RespT> RespT a(AbstractC2407f abstractC2407f, MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, ReqT reqt) {
        ExecutorC0154b executorC0154b = new ExecutorC0154b();
        AbstractC2408g a2 = abstractC2407f.a(methodDescriptor, c2406e.a(executorC0154b));
        try {
            ListenableFuture a3 = a(a2, reqt);
            while (!a3.isDone()) {
                try {
                    executorC0154b.a();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw Status.f27130c.b("Call was interrupted").b(e2).c();
                }
            }
            return (RespT) a(a3);
        } catch (Error e3) {
            a((AbstractC2408g<?, ?>) a2, (Throwable) e3);
            throw null;
        } catch (RuntimeException e4) {
            a((AbstractC2408g<?, ?>) a2, (Throwable) e4);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClientCalls.java */
    /* loaded from: classes3.dex */
    public static final class c<RespT> extends AbstractC2408g.a<RespT> {

        /* renamed from: a, reason: collision with root package name */
        private final a<RespT> f27167a;

        /* renamed from: b, reason: collision with root package name */
        private RespT f27168b;

        c(a<RespT> aVar) {
            this.f27167a = aVar;
        }

        @Override // io.grpc.AbstractC2408g.a
        public void a(P p) {
        }

        @Override // io.grpc.AbstractC2408g.a
        public void a(RespT respt) {
            if (this.f27168b == null) {
                this.f27168b = respt;
                return;
            }
            throw Status.p.b("More than one value received for unary call").c();
        }

        @Override // io.grpc.AbstractC2408g.a
        public void a(Status status, P p) {
            if (status.g()) {
                if (this.f27168b == null) {
                    this.f27167a.a((Throwable) Status.p.b("No value received for unary call").a(p));
                }
                this.f27167a.a((a<RespT>) this.f27168b);
                return;
            }
            this.f27167a.a((Throwable) status.a(p));
        }
    }

    public static <ReqT, RespT> ListenableFuture<RespT> a(AbstractC2408g<ReqT, RespT> abstractC2408g, ReqT reqt) {
        a aVar = new a(abstractC2408g);
        a((AbstractC2408g) abstractC2408g, (Object) reqt, (AbstractC2408g.a) new c(aVar), false);
        return aVar;
    }

    private static <V> V a(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw Status.f27130c.b("Call was interrupted").b(e2).c();
        } catch (ExecutionException e3) {
            throw a(e3.getCause());
        }
    }

    private static StatusRuntimeException a(Throwable th) {
        Preconditions.a(th, e.ar);
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                StatusException statusException = (StatusException) th2;
                return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
            }
            if (th2 instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) th2;
                return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return Status.f27131d.b("unexpected exception").b(th).c();
    }

    private static RuntimeException a(AbstractC2408g<?, ?> abstractC2408g, Throwable th) {
        try {
            abstractC2408g.a((String) null, th);
        } catch (Throwable th2) {
            f27163a.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new AssertionError(th);
        }
        throw ((RuntimeException) th);
    }

    private static <ReqT, RespT> void a(AbstractC2408g<ReqT, RespT> abstractC2408g, ReqT reqt, AbstractC2408g.a<RespT> aVar, boolean z) {
        a(abstractC2408g, aVar, z);
        try {
            abstractC2408g.a((AbstractC2408g<ReqT, RespT>) reqt);
            abstractC2408g.a();
        } catch (Error e2) {
            a((AbstractC2408g<?, ?>) abstractC2408g, (Throwable) e2);
            throw null;
        } catch (RuntimeException e3) {
            a((AbstractC2408g<?, ?>) abstractC2408g, (Throwable) e3);
            throw null;
        }
    }

    private static <ReqT, RespT> void a(AbstractC2408g<ReqT, RespT> abstractC2408g, AbstractC2408g.a<RespT> aVar, boolean z) {
        abstractC2408g.a(aVar, new P());
        if (z) {
            abstractC2408g.a(1);
        } else {
            abstractC2408g.a(2);
        }
    }
}
