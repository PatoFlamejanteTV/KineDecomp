package io.opencensus.trace;

import com.google.common.base.MoreObjects;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: SpanId.java */
@Immutable
/* loaded from: classes3.dex */
public final class j implements Comparable<j> {

    /* renamed from: a */
    public static final j f28078a = new j(new byte[8]);

    /* renamed from: b */
    private final byte[] f28079b;

    private j(byte[] bArr) {
        this.f28079b = bArr;
    }

    public byte[] a() {
        return Arrays.copyOf(this.f28079b, 8);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return Arrays.equals(this.f28079b, ((j) obj).f28079b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f28079b);
    }

    public String toString() {
        return MoreObjects.a(this).a("spanId", BaseEncoding.a().c().a(this.f28079b)).toString();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(j jVar) {
        for (int i = 0; i < 8; i++) {
            byte[] bArr = this.f28079b;
            byte b2 = bArr[i];
            byte[] bArr2 = jVar.f28079b;
            if (b2 != bArr2[i]) {
                return bArr[i] < bArr2[i] ? -1 : 1;
            }
        }
        return 0;
    }
}
