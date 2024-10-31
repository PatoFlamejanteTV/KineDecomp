package android.support.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class ta implements va {

    /* renamed from: a */
    private final IBinder f648a;

    public ta(IBinder iBinder) {
        this.f648a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ta) && ((ta) obj).f648a.equals(this.f648a);
    }

    public int hashCode() {
        return this.f648a.hashCode();
    }
}
