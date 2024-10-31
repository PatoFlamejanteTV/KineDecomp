package com.nexstreaming.kinemaster.support;

import android.view.View;

/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInputActivity f21253a;

    public p(SupportInputActivity supportInputActivity) {
        this.f21253a = supportInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.f21253a.f21235g;
        if (rVar != null) {
            SupportInputActivity supportInputActivity = this.f21253a;
            rVar2 = supportInputActivity.f21235g;
            supportInputActivity.a(rVar2);
            return;
        }
        this.f21253a.finish();
    }
}
