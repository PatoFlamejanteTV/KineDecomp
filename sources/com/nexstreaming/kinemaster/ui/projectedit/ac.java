package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FullScreenInputActivity fullScreenInputActivity) {
        this.f3756a = fullScreenInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3756a.b.hideSoftInputFromWindow(this.f3756a.f3732a.getWindowToken(), 0, null);
        this.f3756a.setResult(0);
        this.f3756a.finish();
    }
}
