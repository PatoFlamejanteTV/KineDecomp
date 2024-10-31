package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import android.widget.BaseAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.g;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bj implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bi f4321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.f4321a = biVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        boolean z;
        View view;
        View view2;
        BaseAdapter baseAdapter;
        z = this.f4321a.f4320a.j;
        if (!z) {
            switch (i) {
                case R.id.export_bitrate_setting /* 2131820598 */:
                    this.f4321a.f4320a.j = true;
                    view = this.f4321a.f4320a.h;
                    view.setVisibility(8);
                    view2 = this.f4321a.f4320a.i;
                    view2.setVisibility(0);
                    baseAdapter = this.f4321a.f4320a.k;
                    baseAdapter.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }
}
