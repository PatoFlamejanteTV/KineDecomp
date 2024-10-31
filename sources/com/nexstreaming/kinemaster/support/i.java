package com.nexstreaming.kinemaster.support;

import android.view.View;
import com.nexstreaming.kinemaster.support.SupportInfoV4Fragment;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInfoV4Fragment f21246a;

    public i(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21246a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21246a.a(SupportInfoV4Fragment.WhereToGo.TWITTER);
    }
}
