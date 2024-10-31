package com.nexstreaming.kinemaster.support;

import android.view.View;
import com.nexstreaming.kinemaster.support.SupportInfoV4Fragment;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInfoV4Fragment f21247a;

    public j(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21247a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21247a.a(SupportInfoV4Fragment.WhereToGo.INSTAGRAM);
    }
}
