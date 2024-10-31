package io.opencensus.trace;

/* compiled from: TraceComponent.java */
/* loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraceComponent.java */
    /* loaded from: classes3.dex */
    public static final class a extends l {

        /* renamed from: a */
        private final io.opencensus.trace.a.c f28080a;

        /* synthetic */ a(k kVar) {
            this();
        }

        @Override // io.opencensus.trace.l
        public io.opencensus.trace.propagation.d a() {
            return io.opencensus.trace.propagation.d.b();
        }

        @Override // io.opencensus.trace.l
        public p b() {
            return p.b();
        }

        private a() {
            this.f28080a = io.opencensus.trace.a.c.a();
        }
    }

    public static l c() {
        return new a();
    }

    public abstract io.opencensus.trace.propagation.d a();

    public abstract p b();
}
