package io.grpc.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Preconditions;
import io.grpc.C2528x;
import io.grpc.InterfaceC2521p;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Oc;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DelayedStream.java */
/* loaded from: classes3.dex */
class Ea implements X {

    /* renamed from: a */
    private volatile boolean f27262a;

    /* renamed from: b */
    private ClientStreamListener f27263b;

    /* renamed from: c */
    private X f27264c;

    /* renamed from: d */
    private Status f27265d;

    /* renamed from: e */
    private List<Runnable> f27266e = new ArrayList();

    /* renamed from: f */
    private a f27267f;

    /* compiled from: DelayedStream.java */
    /* loaded from: classes3.dex */
    public static class a implements ClientStreamListener {

        /* renamed from: a */
        private final ClientStreamListener f27268a;

        /* renamed from: b */
        private volatile boolean f27269b;

        /* renamed from: c */
        private List<Runnable> f27270c = new ArrayList();

        public a(ClientStreamListener clientStreamListener) {
            this.f27268a = clientStreamListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.f27270c.isEmpty()) {
                        this.f27270c = null;
                        this.f27269b = true;
                        return;
                    } else {
                        list = this.f27270c;
                        this.f27270c = arrayList;
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }

        private void a(Runnable runnable) {
            synchronized (this) {
                if (!this.f27269b) {
                    this.f27270c.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        @Override // io.grpc.internal.Oc
        public void a(Oc.a aVar) {
            if (this.f27269b) {
                this.f27268a.a(aVar);
            } else {
                a(new RunnableC2507za(this, aVar));
            }
        }

        @Override // io.grpc.internal.Oc
        public void a() {
            if (this.f27269b) {
                this.f27268a.a();
            } else {
                a(new Aa(this));
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(io.grpc.P p) {
            a(new Ba(this, p));
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, io.grpc.P p) {
            a(new Ca(this, status, p));
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
            a(new Da(this, status, rpcProgress, p));
        }
    }

    @Override // io.grpc.internal.X
    public void b(int i) {
        if (this.f27262a) {
            this.f27264c.b(i);
        } else {
            a(new RunnableC2476qa(this, i));
        }
    }

    @Override // io.grpc.internal.X
    public void c(int i) {
        if (this.f27262a) {
            this.f27264c.c(i);
        } else {
            a(new RunnableC2479ra(this, i));
        }
    }

    @Override // io.grpc.internal.Nc
    public void flush() {
        if (this.f27262a) {
            this.f27264c.flush();
        } else {
            a(new RunnableC2495va(this));
        }
    }

    public final void a(X x) {
        synchronized (this) {
            if (this.f27264c != null) {
                return;
            }
            Preconditions.a(x, "stream");
            this.f27264c = x;
            b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:            if (r0.hasNext() == false) goto L54;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:            ((java.lang.Runnable) r0.next()).run();     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:            r0 = r1.iterator();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f27266e     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L1d
            r0 = 0
            r3.f27266e = r0     // Catch: java.lang.Throwable -> L3b
            r0 = 1
            r3.f27262a = r0     // Catch: java.lang.Throwable -> L3b
            io.grpc.internal.Ea$a r0 = r3.f27267f     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L1c
            r0.b()
        L1c:
            return
        L1d:
            java.util.List<java.lang.Runnable> r1 = r3.f27266e     // Catch: java.lang.Throwable -> L3b
            r3.f27266e = r0     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            java.util.Iterator r0 = r1.iterator()
        L26:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L36
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L26
        L36:
            r1.clear()
            r0 = r1
            goto L5
        L3b:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            goto L3f
        L3e:
            throw r0
        L3f:
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Ea.b():void");
    }

    private void a(Runnable runnable) {
        synchronized (this) {
            if (!this.f27262a) {
                this.f27266e.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // io.grpc.internal.X
    public void a(String str) {
        Preconditions.b(this.f27263b == null, "May only be called before start");
        Preconditions.a(str, "authority");
        a(new RunnableC2483sa(this, str));
    }

    @Override // io.grpc.internal.X
    public void a(ClientStreamListener clientStreamListener) {
        Status status;
        boolean z;
        Preconditions.b(this.f27263b == null, "already started");
        synchronized (this) {
            Preconditions.a(clientStreamListener, "listener");
            this.f27263b = clientStreamListener;
            status = this.f27265d;
            z = this.f27262a;
            if (!z) {
                a aVar = new a(clientStreamListener);
                this.f27267f = aVar;
                clientStreamListener = aVar;
            }
        }
        if (status != null) {
            clientStreamListener.a(status, new io.grpc.P());
        } else if (z) {
            this.f27264c.a(clientStreamListener);
        } else {
            a(new RunnableC2487ta(this, clientStreamListener));
        }
    }

    @Override // io.grpc.internal.Nc
    public void a(InputStream inputStream) {
        Preconditions.a(inputStream, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.f27262a) {
            this.f27264c.a(inputStream);
        } else {
            a(new RunnableC2491ua(this, inputStream));
        }
    }

    @Override // io.grpc.internal.X
    public void a(Status status) {
        boolean z;
        ClientStreamListener clientStreamListener;
        Preconditions.a(status, "reason");
        synchronized (this) {
            if (this.f27264c == null) {
                this.f27264c = Tb.f27506a;
                z = false;
                clientStreamListener = this.f27263b;
                this.f27265d = status;
            } else {
                z = true;
                clientStreamListener = null;
            }
        }
        if (z) {
            a(new RunnableC2498wa(this, status));
            return;
        }
        if (clientStreamListener != null) {
            clientStreamListener.a(status, new io.grpc.P());
        }
        b();
    }

    @Override // io.grpc.internal.X
    public void a() {
        a(new RunnableC2501xa(this));
    }

    @Override // io.grpc.internal.Nc
    public void a(int i) {
        if (this.f27262a) {
            this.f27264c.a(i);
        } else {
            a(new RunnableC2504ya(this, i));
        }
    }

    @Override // io.grpc.internal.Nc
    public void a(InterfaceC2521p interfaceC2521p) {
        Preconditions.a(interfaceC2521p, "compressor");
        a(new RunnableC2464na(this, interfaceC2521p));
    }

    @Override // io.grpc.internal.X
    public void a(boolean z) {
        a(new RunnableC2468oa(this, z));
    }

    @Override // io.grpc.internal.X
    public void a(C2528x c2528x) {
        Preconditions.a(c2528x, "decompressorRegistry");
        a(new RunnableC2472pa(this, c2528x));
    }
}
