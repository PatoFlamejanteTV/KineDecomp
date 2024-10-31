package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionPanelMissingMedia.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ne, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1963ne implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22458a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1972oe f22459b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1963ne(C1972oe c1972oe, String str) {
        this.f22459b = c1972oe;
        this.f22458a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.nexstreaming.kinemaster.mediainfo.J.a(this.f22459b.getActivity(), this.f22458a, null);
    }
}
