package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

/* compiled from: ProjectAdapter.java */
/* loaded from: classes.dex */
class y extends com.nextreaming.a.a.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Resources f4226a;
    final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, Context context, Resources resources) {
        super(context);
        this.b = xVar;
        this.f4226a = resources;
    }

    @Override // com.nextreaming.a.a.e
    protected Bitmap a(Object obj) {
        return x.a(((com.nexstreaming.kinemaster.project.f) obj).e(), this.f4226a, false);
    }
}
