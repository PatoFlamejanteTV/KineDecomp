package com.google.android.gms.common.images;

import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zad extends zaa {

    /* renamed from: b */
    private WeakReference<ImageManager.OnImageLoadedListener> f11038b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zad)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zad zadVar = (zad) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.f11038b.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zadVar.f11038b.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.a(onImageLoadedListener2, onImageLoadedListener) && Objects.a(zadVar.f11036a, this.f11036a);
    }

    public final int hashCode() {
        return Objects.a(this.f11036a);
    }
}
