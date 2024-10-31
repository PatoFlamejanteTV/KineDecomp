package com.nexstreaming.kinemaster.ui.share;

import android.view.View;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class br implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(ShareQualityActivity shareQualityActivity) {
        this.f4329a = shareQualityActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.f4329a.g;
        if (view.getVisibility() == 0) {
            view2 = this.f4329a.g;
            view2.setVisibility(8);
            view3 = this.f4329a.f;
            view3.setVisibility(0);
        }
    }
}
