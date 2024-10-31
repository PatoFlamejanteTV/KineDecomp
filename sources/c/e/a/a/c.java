package c.e.a.a;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCache.java */
/* loaded from: classes.dex */
public class c extends LruCache<String, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ d f3884a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, int i) {
        super(i);
        this.f3884a = dVar;
    }

    @Override // android.util.LruCache
    /* renamed from: a */
    public int sizeOf(String str, Bitmap bitmap) {
        return d.a(bitmap);
    }
}
