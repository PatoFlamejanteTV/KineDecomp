package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: WanderingCubes.java */
/* loaded from: classes.dex */
public class o extends r {

    /* compiled from: WanderingCubes.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.c {
        int H;

        public a(int i) {
            this.H = i;
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            dVar.b(fArr, 0, -90, -179, -180, -270, -360);
            Float valueOf = Float.valueOf(0.0f);
            Float valueOf2 = Float.valueOf(0.75f);
            dVar.c(fArr, valueOf, valueOf2, valueOf2, valueOf2, valueOf, valueOf);
            dVar.d(fArr, valueOf, valueOf, valueOf2, valueOf2, valueOf2, valueOf);
            Float valueOf3 = Float.valueOf(1.0f);
            Float valueOf4 = Float.valueOf(0.5f);
            dVar.a(fArr, valueOf3, valueOf4, valueOf3, valueOf3, valueOf4, valueOf3);
            dVar.a(1800L);
            dVar.a(fArr);
            if (Build.VERSION.SDK_INT >= 24) {
                dVar.a(this.H);
            }
            return dVar.a();
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public void a(q... qVarArr) {
        super.a(qVarArr);
        if (Build.VERSION.SDK_INT < 24) {
            qVarArr[1].a(-900);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Rect a2 = a(rect);
        super.onBoundsChange(a2);
        for (int i = 0; i < r(); i++) {
            q h2 = h(i);
            int i2 = a2.left;
            h2.a(i2, a2.top, (a2.width() / 4) + i2, a2.top + (a2.height() / 4));
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        return new q[]{new a(0), new a(3)};
    }
}
