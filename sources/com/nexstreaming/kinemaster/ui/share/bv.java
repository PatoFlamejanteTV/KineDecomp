package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(ShareSNSActivity shareSNSActivity) {
        this.f4333a = shareSNSActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexExportProfile nexExportProfile;
        ShareSNSActivity shareSNSActivity = this.f4333a;
        nexExportProfile = this.f4333a.n;
        shareSNSActivity.a(nexExportProfile);
    }
}
