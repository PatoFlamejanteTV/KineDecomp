package io.opencensus.trace;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: SpanBuilder.java */
/* loaded from: classes3.dex */
public abstract class h {

    /* compiled from: SpanBuilder.java */
    /* loaded from: classes3.dex */
    static final class a extends h {
        private a(String str) {
            Preconditions.a(str, "name");
        }

        public static a a(String str, @Nullable Span span) {
            return new a(str);
        }

        @Override // io.opencensus.trace.h
        public h a(boolean z) {
            return this;
        }

        @Override // io.opencensus.trace.h
        public Span a() {
            return e.f28072e;
        }
    }

    public abstract Span a();

    public abstract h a(boolean z);
}
