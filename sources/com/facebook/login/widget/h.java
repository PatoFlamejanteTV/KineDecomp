package com.facebook.login.widget;

/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolTipPopup f329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ToolTipPopup toolTipPopup) {
        this.f329a = toolTipPopup;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f329a.dismiss();
    }
}
