package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: TraceOptions.java */
@Immutable
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a */
    public static final n f28083a = new n((byte) 0);

    /* renamed from: b */
    private final byte f28084b;

    private n(byte b2) {
        this.f28084b = b2;
    }

    public boolean a() {
        return a(1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f28084b == ((n) obj).f28084b;
    }

    public int hashCode() {
        return Objects.a(Byte.valueOf(this.f28084b));
    }

    public String toString() {
        return MoreObjects.a(this).a("sampled", a()).toString();
    }

    private boolean a(int i) {
        return (i & this.f28084b) != 0;
    }
}
