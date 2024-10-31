package io.grpc.internal;

import com.facebook.internal.ServerProtocol;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: ManagedChannelOrphanWrapper.java */
/* loaded from: classes3.dex */
public final class Mb extends Oa {

    /* renamed from: b */
    private static final ReferenceQueue<Mb> f27425b = new ReferenceQueue<>();

    /* renamed from: c */
    private static final ConcurrentMap<a, a> f27426c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final Logger f27427d = Logger.getLogger(Mb.class.getName());

    /* renamed from: e */
    private final a f27428e;

    public Mb(io.grpc.K k) {
        this(k, f27425b, f27426c);
    }

    @VisibleForTesting
    Mb(io.grpc.K k, ReferenceQueue<Mb> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
        super(k);
        this.f27428e = new a(this, k, referenceQueue, concurrentMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ManagedChannelOrphanWrapper.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class a extends WeakReference<Mb> {

        /* renamed from: a */
        private static final boolean f27429a = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));

        /* renamed from: b */
        private static final RuntimeException f27430b = b();

        /* renamed from: c */
        private final ReferenceQueue<Mb> f27431c;

        /* renamed from: d */
        private final ConcurrentMap<a, a> f27432d;

        /* renamed from: e */
        private final io.grpc.K f27433e;

        /* renamed from: f */
        private final Reference<RuntimeException> f27434f;

        /* renamed from: g */
        private volatile boolean f27435g;

        /* renamed from: h */
        private volatile boolean f27436h;

        a(Mb mb, io.grpc.K k, ReferenceQueue<Mb> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
            super(mb, referenceQueue);
            RuntimeException runtimeException;
            if (f27429a) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = f27430b;
            }
            this.f27434f = new SoftReference(runtimeException);
            this.f27433e = k;
            this.f27431c = referenceQueue;
            this.f27432d = concurrentMap;
            this.f27432d.put(this, this);
            a(referenceQueue);
        }

        private void a() {
            super.clear();
            this.f27432d.remove(this);
            this.f27434f.clear();
        }

        private static RuntimeException b() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            a();
            a(this.f27431c);
        }

        @VisibleForTesting
        static int a(ReferenceQueue<Mb> referenceQueue) {
            int i = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i;
                }
                RuntimeException runtimeException = aVar.f27434f.get();
                aVar.a();
                if (!aVar.f27435g || !aVar.f27433e.c()) {
                    i++;
                    Level level = aVar.f27436h ? Level.FINE : Level.SEVERE;
                    if (Mb.f27427d.isLoggable(level)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("*~*~*~ Channel {0} was not ");
                        sb.append(!aVar.f27435g ? "shutdown" : "terminated");
                        sb.append(" properly!!! ~*~*~*");
                        sb.append(System.getProperty("line.separator"));
                        sb.append("    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        LogRecord logRecord = new LogRecord(level, sb.toString());
                        logRecord.setLoggerName(Mb.f27427d.getName());
                        logRecord.setParameters(new Object[]{aVar.f27433e.toString()});
                        logRecord.setThrown(runtimeException);
                        Mb.f27427d.log(logRecord);
                    }
                }
            }
        }
    }
}
