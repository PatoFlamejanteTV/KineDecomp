package com.nexstreaming.kinemaster.support;

import android.view.View;
import com.nexstreaming.kinemaster.support.SupportInfoV4Fragment;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInfoV4Fragment f21249a;

    public l(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21249a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21249a.a(SupportInfoV4Fragment.WhereToGo.WEIBO);
    }
}
