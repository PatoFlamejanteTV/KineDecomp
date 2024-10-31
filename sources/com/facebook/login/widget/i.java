package com.facebook.login.widget;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ToolTipPopup f9417a;

    public i(ToolTipPopup toolTipPopup) {
        this.f9417a = toolTipPopup;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9417a.dismiss();
    }
}
