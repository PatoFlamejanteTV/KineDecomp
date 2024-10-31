package com.facebook.login.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ToolTipPopup f9418a;

    public j(ToolTipPopup toolTipPopup) {
        this.f9418a = toolTipPopup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9418a.dismiss();
    }
}
