package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;

/* compiled from: CallTracer.java */
/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a */
    static final b f27211a = new A();

    /* renamed from: b */
    static final a f27212b = new B();

    /* renamed from: c */
    private final b f27213c;

    /* renamed from: d */
    private final InterfaceC2496vb f27214d = C2499wb.a();

    /* renamed from: e */
    private final InterfaceC2496vb f27215e = C2499wb.a();

    /* renamed from: f */
    private final InterfaceC2496vb f27216f = C2499wb.a();

    /* renamed from: g */
    private volatile long f27217g;

    /* compiled from: CallTracer.java */
    /* loaded from: classes3.dex */
    public interface a {
        C create();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallTracer.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public interface b {
        long a();
    }

    public C(b bVar) {
        this.f27213c = bVar;
    }

    public void a(boolean z) {
        if (z) {
            this.f27215e.add(1L);
        } else {
            this.f27216f.add(1L);
        }
    }

    public void b() {
        this.f27214d.add(1L);
        this.f27217g = this.f27213c.a();
    }

    public static a a() {
        return f27212b;
    }
}
