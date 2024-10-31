package com.google.android.gms.appinvite;

import android.view.View;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ PreviewActivity f10388a;

    public b(PreviewActivity previewActivity) {
        this.f10388a = previewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10388a.finish();
    }
}
