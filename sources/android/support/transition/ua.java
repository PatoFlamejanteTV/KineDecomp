package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class ua implements va {

    /* renamed from: a */
    private final WindowId f656a;

    public ua(View view) {
        this.f656a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ua) && ((ua) obj).f656a.equals(this.f656a);
    }

    public int hashCode() {
        return this.f656a.hashCode();
    }
}
