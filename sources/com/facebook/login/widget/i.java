package com.facebook.login.widget;

import android.view.View;

/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolTipPopup f330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ToolTipPopup toolTipPopup) {
        this.f330a = toolTipPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f330a.dismiss();
    }
}
