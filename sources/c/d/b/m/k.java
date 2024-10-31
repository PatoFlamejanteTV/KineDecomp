package c.d.b.m;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScratchBitmapCache.java */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a */
    private List<a> f3851a = new ArrayList();

    /* compiled from: ScratchBitmapCache.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public final Bitmap f3852a;

        /* renamed from: b */
        public final Canvas f3853b;

        /* renamed from: c */
        public final int f3854c;

        /* renamed from: d */
        public final int f3855d;

        /* renamed from: e */
        boolean f3856e;

        /* synthetic */ a(int i, int i2, j jVar) {
            this(i, i2);
        }

        private a(int i, int i2) {
            this.f3856e = false;
            this.f3852a = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f3853b = new Canvas(this.f3852a);
            this.f3854c = i;
            this.f3855d = i2;
        }
    }

    public void a() {
        for (int size = this.f3851a.size() - 1; size >= 0; size--) {
            a aVar = this.f3851a.get(size);
            if (!aVar.f3856e) {
                this.f3851a.remove(size);
            } else {
                aVar.f3856e = false;
            }
        }
    }

    public a a(int i, int i2) {
        for (int size = this.f3851a.size() - 1; size >= 0; size--) {
            a aVar = this.f3851a.get(size);
            if (!aVar.f3856e && aVar.f3854c == i && aVar.f3855d == i2) {
                aVar.f3856e = true;
                return aVar;
            }
        }
        a aVar2 = new a(i, i2);
        aVar2.f3856e = true;
        this.f3851a.add(aVar2);
        return aVar2;
    }
}
