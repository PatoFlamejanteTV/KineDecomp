package com.nexstreaming.kinemaster.h;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScratchBitmapCache.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f3392a = new ArrayList();

    /* compiled from: ScratchBitmapCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f3393a;
        public final Canvas b;
        public final int c;
        public final int d;
        boolean e;

        private a(int i, int i2) {
            this.e = false;
            this.f3393a = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.b = new Canvas(this.f3393a);
            this.c = i;
            this.d = i2;
        }
    }

    public void a() {
        for (int size = this.f3392a.size() - 1; size >= 0; size--) {
            a aVar = this.f3392a.get(size);
            if (!aVar.e) {
                this.f3392a.remove(size);
            } else {
                aVar.e = false;
            }
        }
    }

    public a a(int i, int i2) {
        for (int size = this.f3392a.size() - 1; size >= 0; size--) {
            a aVar = this.f3392a.get(size);
            if (!aVar.e && aVar.c == i && aVar.d == i2) {
                aVar.e = true;
                return aVar;
            }
        }
        a aVar2 = new a(i, i2);
        aVar2.e = true;
        this.f3392a.add(aVar2);
        return aVar2;
    }
}
