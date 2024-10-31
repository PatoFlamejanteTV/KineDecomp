package kotlin.text;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a */
    private final String f28565a;

    /* renamed from: b */
    private final kotlin.c.d f28566b;

    public g(String str, kotlin.c.d dVar) {
        kotlin.jvm.internal.h.b(str, "value");
        kotlin.jvm.internal.h.b(dVar, "range");
        this.f28565a = str;
        this.f28566b = dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.h.a((Object) this.f28565a, (Object) gVar.f28565a) && kotlin.jvm.internal.h.a(this.f28566b, gVar.f28566b);
    }

    public int hashCode() {
        String str = this.f28565a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.c.d dVar = this.f28566b;
        return hashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.f28565a + ", range=" + this.f28566b + ")";
    }
}
