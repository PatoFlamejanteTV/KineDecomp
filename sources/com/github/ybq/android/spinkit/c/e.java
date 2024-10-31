package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: DoubleBounce.java */
/* loaded from: classes.dex */
public class e extends r {

    /* compiled from: DoubleBounce.java */
    /* loaded from: classes.dex */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            setAlpha(153);
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

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        return new q[]{new a(), new a()};
    }
}
