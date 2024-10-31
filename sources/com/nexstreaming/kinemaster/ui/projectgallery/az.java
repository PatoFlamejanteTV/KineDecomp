package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.io.File;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ay f4152a;

    public az(ay ayVar) {
        this.f4152a = ayVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        KMUsage.Rate_Report.logEvent("selection", "Feedback");
        this.f4152a.f4151a.edit().putBoolean("rate_neverShowReviewPopup", true).remove("rate_nextShowPopupDate").apply();
        dialogInterface.dismiss();
        D = this.f4152a.b.D();
        com.nexstreaming.kinemaster.support.i.a(D, "RVW", new File[0]);
    }
}
