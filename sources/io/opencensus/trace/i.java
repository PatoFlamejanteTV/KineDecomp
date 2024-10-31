package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: SpanContext.java */
@Immutable
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a */
    public static final i f28074a = new i(m.f28081a, j.f28078a, n.f28083a);

    /* renamed from: b */
    private final m f28075b;

    /* renamed from: c */
    private final j f28076c;

    /* renamed from: d */
    private final n f28077d;

    private i(m mVar, j jVar, n nVar) {
        this.f28075b = mVar;
        this.f28076c = jVar;
        this.f28077d = nVar;
    }

    public j a() {
        return this.f28076c;
    }

    public n b() {
        return this.f28077d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f28075b.equals(iVar.f28075b) && this.f28076c.equals(iVar.f28076c) && this.f28077d.equals(iVar.f28077d);
    }

    public int hashCode() {
        return Objects.a(this.f28075b, this.f28076c, this.f28077d);
    }

    public String toString() {
        return MoreObjects.a(this).a("traceId", this.f28075b).a("spanId", this.f28076c).a("traceOptions", this.f28077d).toString();
    }
}
