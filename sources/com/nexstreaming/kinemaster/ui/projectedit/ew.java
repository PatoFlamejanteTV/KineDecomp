package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionMenuFragment.java */
/* loaded from: classes.dex */
class ew implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3884a;
    final /* synthetic */ es b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(es esVar, String str) {
        this.b = esVar;
        this.f3884a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.nexstreaming.kinemaster.mediainfo.ad.a(this.b.getActivity(), this.f3884a, null);
    }
}
