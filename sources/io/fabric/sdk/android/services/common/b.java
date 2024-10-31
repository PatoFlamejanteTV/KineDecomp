package io.fabric.sdk.android.services.common;

/* compiled from: AdvertisingInfo.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public final String f26885a;

    /* renamed from: b */
    public final boolean f26886b;

    public b(String str, boolean z) {
        this.f26885a = str;
        this.f26886b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f26886b != bVar.f26886b) {
            return false;
        }
        String str = this.f26885a;
        return str == null ? bVar.f26885a == null : str.equals(bVar.f26885a);
    }

    public int hashCode() {
        String str = this.f26885a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f26886b ? 1 : 0);
    }
}
