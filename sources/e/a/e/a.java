package e.a.e;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TagKey.java */
@Immutable
/* loaded from: classes3.dex */
public final class a extends h {

    /* renamed from: a */
    private final String f26756a;

    public a(String str) {
        if (str != null) {
            this.f26756a = str;
            return;
        }
        throw new NullPointerException("Null name");
    }

    @Override // e.a.e.h
    public String a() {
        return this.f26756a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            return this.f26756a.equals(((h) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f26756a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "TagKey{name=" + this.f26756a + "}";
    }
}
