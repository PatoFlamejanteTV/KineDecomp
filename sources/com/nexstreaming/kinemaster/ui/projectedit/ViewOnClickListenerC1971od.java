package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionMenuFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.od, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1971od implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22469a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1980pd f22470b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1971od(C1980pd c1980pd, String str) {
        this.f22470b = c1980pd;
        this.f22469a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.nexstreaming.kinemaster.mediainfo.J.a(this.f22470b.getActivity(), this.f22469a, null);
    }
}
