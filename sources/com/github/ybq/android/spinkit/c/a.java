package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.view.animation.LinearInterpolator;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: ChasingDots.java */
/* loaded from: classes.dex */
public class a extends r {

    /* compiled from: ChasingDots.java */
    /* renamed from: com.github.ybq.android.spinkit.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066a extends com.github.ybq.android.spinkit.b.b {
        C0066a() {
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.q
        public ValueAnimator p() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
            Float valueOf = Float.valueOf(0.0f);
            dVar.a(fArr, valueOf, Float.valueOf(1.0f), valueOf);
            dVar.a(2000L);
            dVar.a(fArr);
            return dVar.a();
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public void a(q... qVarArr) {
        super.a(qVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            qVarArr[1].a(1000);
        } else {
            qVarArr[1].a(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a2 = a(rect);
        int width = (int) (a2.width() * 0.6f);
        q h2 = h(0);
        int i = a2.right;
        int i2 = a2.top;
        h2.a(i - width, i2, i, i2 + width);
        q h3 = h(1);
        int i3 = a2.right;
        int i4 = a2.bottom;
        h3.a(i3 - width, i4 - width, i3, i4);
    }

    @Override // com.github.ybq.android.spinkit.b.r, com.github.ybq.android.spinkit.b.q
    public ValueAnimator p() {
        com.github.ybq.android.spinkit.a.d dVar = new com.github.ybq.android.spinkit.a.d(this);
        dVar.b(new float[]{0.0f, 1.0f}, 0, 360);
        dVar.a(2000L);
        dVar.a(new LinearInterpolator());
        return dVar.a();
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        return new q[]{new C0066a(), new C0066a()};
    }
}
