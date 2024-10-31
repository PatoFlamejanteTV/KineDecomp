package io.opencensus.trace;

import io.opencensus.trace.h;
import javax.annotation.Nullable;

/* compiled from: Tracer.java */
/* loaded from: classes3.dex */
public abstract class p {

    /* renamed from: a */
    private static final a f28085a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Tracer.java */
    /* loaded from: classes3.dex */
    public static final class a extends p {
        /* synthetic */ a(o oVar) {
            this();
        }

        @Override // io.opencensus.trace.p
        public h a(String str, @Nullable Span span) {
            return h.a.a(str, span);
        }

        private a() {
        }
    }

    protected p() {
    }

    public static p b() {
        return f28085a;
    }

    public final Span a() {
        Span a2 = f.a();
        return a2 != null ? a2 : e.f28072e;
    }

    public abstract h a(String str, @Nullable Span span);
}
