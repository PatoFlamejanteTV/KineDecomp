package io.opencensus.trace.propagation;

import com.google.common.base.Preconditions;
import io.opencensus.trace.i;

/* compiled from: BinaryFormat.java */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a */
    static final a f28086a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BinaryFormat.java */
    /* loaded from: classes3.dex */
    public static final class a extends b {
        /* synthetic */ a(io.opencensus.trace.propagation.a aVar) {
            this();
        }

        @Override // io.opencensus.trace.propagation.b
        public byte[] a(i iVar) {
            Preconditions.a(iVar, "spanContext");
            return new byte[0];
        }

        private a() {
        }

        @Override // io.opencensus.trace.propagation.b
        public i a(byte[] bArr) {
            Preconditions.a(bArr, "bytes");
            return i.f28074a;
        }
    }

    public static b a() {
        return f28086a;
    }

    public abstract i a(byte[] bArr) throws SpanContextParseException;

    public abstract byte[] a(i iVar);
}
