package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.BaseAdapter;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bk implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ShareQualityActivity shareQualityActivity) {
        this.f4322a = shareQualityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        View view2;
        View view3;
        BaseAdapter baseAdapter;
        z = this.f4322a.j;
        if (z) {
            this.f4322a.j = false;
            view2 = this.f4322a.h;
            view2.setVisibility(0);
            view3 = this.f4322a.i;
            view3.setVisibility(8);
            baseAdapter = this.f4322a.k;
            baseAdapter.notifyDataSetChanged();
        }
    }
}
