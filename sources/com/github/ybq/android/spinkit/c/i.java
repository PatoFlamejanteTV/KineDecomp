package com.github.ybq.android.spinkit.c;

import com.github.ybq.android.spinkit.b.q;
import com.github.ybq.android.spinkit.b.r;

/* compiled from: MultiplePulseRing.java */
/* loaded from: classes.dex */
public class i extends r {
    @Override // com.github.ybq.android.spinkit.b.r
    public void a(q... qVarArr) {
        int i = 0;
        while (i < qVarArr.length) {
            q qVar = qVarArr[i];
            i++;
            qVar.a(i * 200);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.r
    public q[] s() {
        return new q[]{new k(), new k(), new k()};
    }
}
