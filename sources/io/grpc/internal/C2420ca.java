package io.grpc.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: CompositeReadableBuffer.java */
/* renamed from: io.grpc.internal.ca */
/* loaded from: classes3.dex */
public class C2420ca extends AbstractC2423d {

    /* renamed from: a */
    private int f27582a;

    /* renamed from: b */
    private final Queue<InterfaceC2426dc> f27583b = new ArrayDeque();

    /* compiled from: CompositeReadableBuffer.java */
    /* renamed from: io.grpc.internal.ca$a */
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a */
        int f27584a;

        /* renamed from: b */
        IOException f27585b;

        private a() {
        }

        final void a(InterfaceC2426dc interfaceC2426dc, int i) {
            try {
                this.f27584a = b(interfaceC2426dc, i);
            } catch (IOException e2) {
                this.f27585b = e2;
            }
        }

        abstract int b(InterfaceC2426dc interfaceC2426dc, int i) throws IOException;

        public /* synthetic */ a(C2412aa c2412aa) {
            this();
        }

        final boolean a() {
            return this.f27585b != null;
        }
    }

    private void b() {
        if (this.f27583b.peek().B() == 0) {
            this.f27583b.remove().close();
        }
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int B() {
        return this.f27582a;
    }

    public void a(InterfaceC2426dc interfaceC2426dc) {
        if (!(interfaceC2426dc instanceof C2420ca)) {
            this.f27583b.add(interfaceC2426dc);
            this.f27582a += interfaceC2426dc.B();
            return;
        }
        C2420ca c2420ca = (C2420ca) interfaceC2426dc;
        while (!c2420ca.f27583b.isEmpty()) {
            this.f27583b.add(c2420ca.f27583b.remove());
        }
        this.f27582a += c2420ca.f27582a;
        c2420ca.f27582a = 0;
        c2420ca.close();
    }

    @Override // io.grpc.internal.AbstractC2423d, io.grpc.internal.InterfaceC2426dc, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f27583b.isEmpty()) {
            this.f27583b.remove().close();
        }
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int readUnsignedByte() {
        C2412aa c2412aa = new C2412aa(this);
        a(c2412aa, 1);
        return c2412aa.f27584a;
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public C2420ca g(int i) {
        a(i);
        this.f27582a -= i;
        C2420ca c2420ca = new C2420ca();
        while (i > 0) {
            InterfaceC2426dc peek = this.f27583b.peek();
            if (peek.B() > i) {
                c2420ca.a(peek.g(i));
                i = 0;
            } else {
                c2420ca.a(this.f27583b.poll());
                i -= peek.B();
            }
        }
        return c2420ca;
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public void a(byte[] bArr, int i, int i2) {
        a(new C2416ba(this, i, bArr), i2);
    }

    private void a(a aVar, int i) {
        a(i);
        if (!this.f27583b.isEmpty()) {
            b();
        }
        while (i > 0 && !this.f27583b.isEmpty()) {
            InterfaceC2426dc peek = this.f27583b.peek();
            int min = Math.min(i, peek.B());
            aVar.a(peek, min);
            if (aVar.a()) {
                return;
            }
            i -= min;
            this.f27582a -= min;
            b();
        }
        if (i > 0) {
            throw new AssertionError("Failed executing read operation");
        }
    }
}
