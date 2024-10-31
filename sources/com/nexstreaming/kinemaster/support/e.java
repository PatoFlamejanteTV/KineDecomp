package com.nexstreaming.kinemaster.support;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SupportInputActivity f3634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SupportInputActivity supportInputActivity) {
        this.f3634a = supportInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.f3634a.g;
        if (gVar != null) {
            SupportInputActivity supportInputActivity = this.f3634a;
            gVar2 = this.f3634a.g;
            supportInputActivity.c(gVar2);
            return;
        }
        this.f3634a.finish();
    }
}
