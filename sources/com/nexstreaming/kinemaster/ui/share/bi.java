package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(ShareQualityActivity shareQualityActivity) {
        this.f4320a = shareQualityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity D;
        View view2;
        View view3;
        z = this.f4320a.j;
        if (!z) {
            D = this.f4320a.D();
            com.nexstreaming.kinemaster.ui.widget.g gVar = new com.nexstreaming.kinemaster.ui.widget.g(D, true, true);
            gVar.a(R.id.export_bitrate_setting, R.string.export_bitrate_menu);
            view2 = this.f4320a.h;
            view3 = this.f4320a.h;
            gVar.a(view2, 83, view3.getWidth(), 0);
            gVar.a(new bj(this));
        }
    }
}
