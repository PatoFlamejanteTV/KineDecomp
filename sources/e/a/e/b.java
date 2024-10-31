package e.a.e;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TagValue.java */
@Immutable
/* loaded from: classes3.dex */
public final class b extends i {

    /* renamed from: a */
    private final String f26757a;

    public b(String str) {
        if (str != null) {
            this.f26757a = str;
            return;
        }
        throw new NullPointerException("Null asString");
    }

    @Override // e.a.e.i
    public String a() {
        return this.f26757a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.f26757a.equals(((i) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f26757a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "TagValue{asString=" + this.f26757a + "}";
    }
}
