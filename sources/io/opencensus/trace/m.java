package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: TraceId.java */
@Immutable
/* loaded from: classes3.dex */
public final class m implements Comparable<m> {

    /* renamed from: a */
    public static final m f28081a = new m(new byte[16]);

    /* renamed from: b */
    private final byte[] f28082b;

    private m(byte[] bArr) {
        this.f28082b = bArr;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(m mVar) {
        for (int i = 0; i < 16; i++) {
            byte[] bArr = this.f28082b;
            byte b2 = bArr[i];
            byte[] bArr2 = mVar.f28082b;
            if (b2 != bArr2[i]) {
                return bArr[i] < bArr2[i] ? -1 : 1;
            }
        }
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return Arrays.equals(this.f28082b, ((m) obj).f28082b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f28082b);
    }

    public String toString() {
        return MoreObjects.a(this).a("traceId", BaseEncoding.a().c().a(this.f28082b)).toString();
    }
}
