package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ga implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(FullScreenInputActivity fullScreenInputActivity) {
        this.f21870a = fullScreenInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FullScreenInputActivity fullScreenInputActivity = this.f21870a;
        fullScreenInputActivity.f21854b.hideSoftInputFromWindow(fullScreenInputActivity.f21853a.getWindowToken(), 0, null);
        this.f21870a.setResult(0);
        this.f21870a.finish();
    }
}
