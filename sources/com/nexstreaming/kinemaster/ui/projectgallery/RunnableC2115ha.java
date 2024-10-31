package com.nexstreaming.kinemaster.ui.projectgallery;

import android.annotation.SuppressLint;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ha, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2115ha implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22926a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2134oa f22927b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2115ha(C2134oa c2134oa, String str) {
        this.f22927b = c2134oa;
        this.f22926a = str;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"StringFormatInvalid"})
    public void run() {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        rVar = this.f22927b.f22963a.za;
        if (rVar != null) {
            this.f22927b.f22963a.X();
        }
        e.a a2 = com.nexstreaming.kinemaster.ui.a.e.a(this.f22927b.f22963a);
        a2.a(this.f22927b.f22963a.getString(R.string.upload_project_complete, new Object[]{this.f22926a}));
        a2.a().show();
    }
}
