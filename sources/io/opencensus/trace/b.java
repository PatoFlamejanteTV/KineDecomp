package io.opencensus.trace;

import io.opencensus.trace.g;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: AutoValue_EndSpanOptions.java */
@Immutable
/* loaded from: classes3.dex */
final class b extends g {

    /* renamed from: b */
    private final boolean f28057b;

    /* renamed from: c */
    private final Status f28058c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_EndSpanOptions.java */
    /* loaded from: classes3.dex */
    public static final class a extends g.a {

        /* renamed from: a */
        private Boolean f28059a;

        /* renamed from: b */
        private Status f28060b;

        @Override // io.opencensus.trace.g.a
        public g.a a(boolean z) {
            this.f28059a = Boolean.valueOf(z);
            return this;
        }

        @Override // io.opencensus.trace.g.a
        public g.a a(@Nullable Status status) {
            this.f28060b = status;
            return this;
        }

        @Override // io.opencensus.trace.g.a
        public g a() {
            String str = "";
            if (this.f28059a == null) {
                str = " sampleToLocalSpanStore";
            }
            if (str.isEmpty()) {
                return new b(this.f28059a.booleanValue(), this.f28060b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ b(boolean z, Status status, io.opencensus.trace.a aVar) {
        this(z, status);
    }

    @Override // io.opencensus.trace.g
    public boolean b() {
        return this.f28057b;
    }

    @Override // io.opencensus.trace.g
    @Nullable
    public Status c() {
        return this.f28058c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f28057b == gVar.b()) {
            Status status = this.f28058c;
            if (status == null) {
                if (gVar.c() == null) {
                    return true;
                }
            } else if (status.equals(gVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f28057b ? 1231 : 1237) ^ 1000003) * 1000003;
        Status status = this.f28058c;
        return i ^ (status == null ? 0 : status.hashCode());
    }

    public String toString() {
        return "EndSpanOptions{sampleToLocalSpanStore=" + this.f28057b + ", status=" + this.f28058c + "}";
    }

    private b(boolean z, @Nullable Status status) {
        this.f28057b = z;
        this.f28058c = status;
    }
}
