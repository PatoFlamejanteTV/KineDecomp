package io.opencensus.trace;

import javax.annotation.concurrent.Immutable;

/* compiled from: BlankSpan.java */
@Immutable
/* loaded from: classes3.dex */
public final class e extends Span {

    /* renamed from: e */
    public static final e f28072e = new e();

    private e() {
        super(i.f28074a, null);
    }

    @Override // io.opencensus.trace.Span
    public void a(NetworkEvent networkEvent) {
    }

    @Override // io.opencensus.trace.Span
    public void a(g gVar) {
    }

    public String toString() {
        return "BlankSpan";
    }
}
