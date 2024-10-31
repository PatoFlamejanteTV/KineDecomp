package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: ThreeBounce.java */
/* loaded from: classes.dex */
public class n extends r {

    /* compiled from: ThreeBounce.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            Float valueOf = Float.valueOf(0.0f);
            dVar.a(fArr, valueOf, Float.valueOf(1.0f), valueOf, valueOf);
            dVar.a(1400L);
            dVar.a(fArr);
            return dVar.a();
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public void a(q... qVarArr) {
        super.a(qVarArr);
        qVarArr[1].a(160);
        qVarArr[2].a(ModuleDescriptor.MODULE_VERSION);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = a2.width() / 8;
        int centerY = a2.centerY() - width;
        int centerY2 = a2.centerY() + width;
        for (int i = 0; i < r(); i++) {
            int width2 = ((a2.width() * i) / 3) + a2.left;
            h(i).a(width2, centerY, (width * 2) + width2, centerY2);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        return new q[]{new a(), new a(), new a()};
    }
}
