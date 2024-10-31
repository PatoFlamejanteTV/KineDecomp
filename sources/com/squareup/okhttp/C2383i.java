package com.squareup.okhttp;

import com.squareup.okhttp.z;
import java.io.IOException;

/* compiled from: Call.java */
/* renamed from: com.squareup.okhttp.i */
/* loaded from: classes3.dex */
public class C2383i {

    /* renamed from: a */
    private final C f25265a;

    /* renamed from: b */
    private boolean f25266b;

    /* renamed from: c */
    volatile boolean f25267c;

    /* renamed from: d */
    E f25268d;

    /* renamed from: e */
    com.squareup.okhttp.internal.http.m f25269e;

    /* compiled from: Call.java */
    /* renamed from: com.squareup.okhttp.i$a */
    /* loaded from: classes3.dex */
    public class a implements z.a {

        /* renamed from: a */
        private final int f25270a;

        /* renamed from: b */
        private final E f25271b;

        /* renamed from: c */
        private final boolean f25272c;

        a(int i, E e2, boolean z) {
            this.f25270a = i;
            this.f25271b = e2;
            this.f25272c = z;
        }

        @Override // com.squareup.okhttp.z.a
        public E a() {
            return this.f25271b;
        }

        @Override // com.squareup.okhttp.z.a
        public H a(E e2) throws IOException {
            if (this.f25270a < C2383i.this.f25265a.u().size()) {
                a aVar = new a(this.f25270a + 1, e2, this.f25272c);
                z zVar = C2383i.this.f25265a.u().get(this.f25270a);
                H a2 = zVar.a(aVar);
                if (a2 != null) {
                    return a2;
                }
                throw new NullPointerException("application interceptor " + zVar + " returned null");
            }
            return C2383i.this.a(e2, this.f25272c);
        }
    }

    public C2383i(C c2, E e2) {
        this.f25265a = c2.a();
        this.f25268d = e2;
    }

    public H a() throws IOException {
        synchronized (this) {
            if (!this.f25266b) {
                this.f25266b = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.f25265a.h().a(this);
            H a2 = a(false);
            if (a2 != null) {
                return a2;
            }
            throw new IOException("Canceled");
        } finally {
            this.f25265a.h().b(this);
        }
    }

    private H a(boolean z) throws IOException {
        return new a(0, this.f25268d, z).a(this.f25268d);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.squareup.okhttp.H a(com.squareup.okhttp.E r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.C2383i.a(com.squareup.okhttp.E, boolean):com.squareup.okhttp.H");
    }
}
