package e.a.d;

import e.a.d.d;
import javax.annotation.concurrent.Immutable;

/* compiled from: AutoValue_Measure_MeasureLong.java */
@Immutable
/* loaded from: classes3.dex */
public final class b extends d.b {

    /* renamed from: a */
    private final String f26746a;

    /* renamed from: b */
    private final String f26747b;

    /* renamed from: c */
    private final String f26748c;

    public b(String str, String str2, String str3) {
        if (str != null) {
            this.f26746a = str;
            if (str2 != null) {
                this.f26747b = str2;
                if (str3 != null) {
                    this.f26748c = str3;
                    return;
                }
                throw new NullPointerException("Null unit");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    @Override // e.a.d.d.b
    public String a() {
        return this.f26747b;
    }

    @Override // e.a.d.d.b
    public String b() {
        return this.f26746a;
    }

    @Override // e.a.d.d.b
    public String c() {
        return this.f26748c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d.b)) {
            return false;
        }
        d.b bVar = (d.b) obj;
        return this.f26746a.equals(bVar.b()) && this.f26747b.equals(bVar.a()) && this.f26748c.equals(bVar.c());
    }

    public int hashCode() {
        return ((((this.f26746a.hashCode() ^ 1000003) * 1000003) ^ this.f26747b.hashCode()) * 1000003) ^ this.f26748c.hashCode();
    }

    public String toString() {
        return "MeasureLong{name=" + this.f26746a + ", description=" + this.f26747b + ", unit=" + this.f26748c + "}";
    }
}
