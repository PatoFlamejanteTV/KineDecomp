package e.a.d;

import e.a.d.d;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_Measure_MeasureDouble.java */
@Immutable
/* loaded from: classes3.dex */
public final class a extends d.a {

    /* renamed from: a */
    private final String f26743a;

    /* renamed from: b */
    private final String f26744b;

    /* renamed from: c */
    private final String f26745c;

    public a(String str, String str2, String str3) {
        if (str != null) {
            this.f26743a = str;
            if (str2 != null) {
                this.f26744b = str2;
                if (str3 != null) {
                    this.f26745c = str3;
                    return;
                }
                throw new NullPointerException("Null unit");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    @Override // e.a.d.d.a
    public String a() {
        return this.f26744b;
    }

    @Override // e.a.d.d.a
    public String b() {
        return this.f26743a;
    }

    @Override // e.a.d.d.a
    public String c() {
        return this.f26745c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d.a)) {
            return false;
        }
        d.a aVar = (d.a) obj;
        return this.f26743a.equals(aVar.b()) && this.f26744b.equals(aVar.a()) && this.f26745c.equals(aVar.c());
    }

    public int hashCode() {
        return ((((this.f26743a.hashCode() ^ 1000003) * 1000003) ^ this.f26744b.hashCode()) * 1000003) ^ this.f26745c.hashCode();
    }

    public String toString() {
        return "MeasureDouble{name=" + this.f26743a + ", description=" + this.f26744b + ", unit=" + this.f26745c + "}";
    }
}
