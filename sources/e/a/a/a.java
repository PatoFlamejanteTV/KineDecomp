package e.a.a;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_Timestamp.java */
@Immutable
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: b */
    private final long f26732b;

    /* renamed from: c */
    private final int f26733c;

    public a(long j, int i) {
        this.f26732b = j;
        this.f26733c = i;
    }

    @Override // e.a.a.b
    public int a() {
        return this.f26733c;
    }

    @Override // e.a.a.b
    public long d() {
        return this.f26732b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f26732b == bVar.d() && this.f26733c == bVar.a();
    }

    public int hashCode() {
        long j = this.f26732b;
        return this.f26733c ^ (((int) (1000003 ^ (j ^ (j >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Timestamp{seconds=" + this.f26732b + ", nanos=" + this.f26733c + "}";
    }
}
