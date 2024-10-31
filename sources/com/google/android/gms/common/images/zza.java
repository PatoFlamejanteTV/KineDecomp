package com.google.android.gms.common.images;

import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzw;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class zza {

    /* renamed from: a, reason: collision with root package name */
    final a f991a;

    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f992a;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.a(((a) obj).f992a, this.f992a);
        }

        public int hashCode() {
            return zzw.a(this.f992a);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zza {
        private WeakReference<ImageView> b;

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = this.b.get();
            ImageView imageView2 = ((zzb) obj).b.get();
            return (imageView2 == null || imageView == null || !zzw.a(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zza {
        private WeakReference<ImageManager.OnImageLoadedListener> b;

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = this.b.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzcVar.b.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.a(onImageLoadedListener2, onImageLoadedListener) && zzw.a(zzcVar.f991a, this.f991a);
        }

        public int hashCode() {
            return zzw.a(this.f991a);
        }
    }
}
