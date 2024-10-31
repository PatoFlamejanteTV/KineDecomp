package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.os.Build;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Va implements CapabilityManager.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.t f22889a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CapabilityReport.CapabilityInfo f22890b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22891c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(ProjectGalleryActivity projectGalleryActivity, com.nexstreaming.kinemaster.ui.a.t tVar, CapabilityReport.CapabilityInfo capabilityInfo) {
        this.f22891c = projectGalleryActivity;
        this.f22889a = tVar;
        this.f22890b = capabilityInfo;
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.CapabilityManager.c
    public void a(boolean z) {
        Activity u;
        this.f22889a.dismiss();
        if (z || this.f22890b != null || Build.VERSION.SDK_INT < 18) {
            return;
        }
        u = this.f22891c.u();
        e.a aVar = new e.a(u);
        aVar.e(R.string.capa_hw_perform_analysis_popup_title);
        aVar.c(R.string.capa_hw_perform_analysis_popup_msg);
        aVar.c(R.string.run_analysis_now, new Ua(this));
        aVar.a(R.string.rate_remind_me, new Ta(this));
        aVar.a().show();
    }
}
