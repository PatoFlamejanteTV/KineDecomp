package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.ui.projectedit.Xg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
public class Wg extends c.e.a.a.f {
    final /* synthetic */ Xg o;
    final /* synthetic */ Context p;
    final /* synthetic */ Xg.a q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wg(Xg.a aVar, Context context, Xg xg, Context context2) {
        super(context);
        this.q = aVar;
        this.o = xg;
        this.p = context2;
    }

    @Override // c.e.a.a.f
    protected Bitmap a(Object obj) {
        if (obj instanceof c.d.b.h.a) {
            return ((c.d.b.h.a) obj).a(this.p, 200, 200);
        }
        return null;
    }
}
