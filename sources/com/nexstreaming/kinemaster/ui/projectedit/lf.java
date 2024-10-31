package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.ui.projectedit.kx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
public class lf extends com.nextreaming.a.a.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kx f4059a;
    final /* synthetic */ Context b;
    final /* synthetic */ kx.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf(kx.a aVar, Context context, kx kxVar, Context context2) {
        super(context);
        this.c = aVar;
        this.f4059a = kxVar;
        this.b = context2;
    }

    @Override // com.nextreaming.a.a.e
    protected Bitmap a(Object obj) {
        if (obj instanceof com.nexstreaming.kinemaster.e.a) {
            return ((com.nexstreaming.kinemaster.e.a) obj).a(this.b, 200, 200);
        }
        return null;
    }
}
