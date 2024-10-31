package com.nexstreaming.kinemaster.support;

import android.view.View;
import com.nexstreaming.kinemaster.support.SupportInfoV4Fragment;

/* compiled from: SupportInfoV4Fragment.java */
/* loaded from: classes.dex */
class m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SupportInfoV4Fragment f21250a;

    public m(SupportInfoV4Fragment supportInfoV4Fragment) {
        this.f21250a = supportInfoV4Fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21250a.a(SupportInfoV4Fragment.WhereToGo.WECHAT);
    }
}
