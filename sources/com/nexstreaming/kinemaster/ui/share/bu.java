package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(ShareSNSActivity shareSNSActivity) {
        this.f4332a = shareSNSActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity D;
        ShareSNSActivity shareSNSActivity = this.f4332a;
        D = this.f4332a.D();
        shareSNSActivity.startActivityForResult(FullScreenInputActivity.a(D).c(true).f(true).a(), R.id.add_tag);
    }
}
