package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.nexstreaming.app.general.nexasset.overlay.a.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LottieOverlayAsset.java */
/* loaded from: classes2.dex */
public class f extends LruCache<Integer, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ g.a f19608a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g.a aVar, int i) {
        super(i);
        this.f19608a = aVar;
    }

    @Override // android.util.LruCache
    /* renamed from: a */
    public int sizeOf(Integer num, Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
