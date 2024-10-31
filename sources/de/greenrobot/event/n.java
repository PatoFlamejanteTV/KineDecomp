package de.greenrobot.event;

/* compiled from: Subscription.java */
/* loaded from: classes3.dex */
final class n {

    /* renamed from: a */
    final Object f26719a;

    /* renamed from: b */
    final l f26720b;

    /* renamed from: c */
    final int f26721c;

    /* renamed from: d */
    volatile boolean f26722d = true;

    public n(Object obj, l lVar, int i) {
        this.f26719a = obj;
        this.f26720b = lVar;
        this.f26721c = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f26719a == nVar.f26719a && this.f26720b.equals(nVar.f26720b);
    }

    public int hashCode() {
        return this.f26719a.hashCode() + this.f26720b.f26716d.hashCode();
    }
}
