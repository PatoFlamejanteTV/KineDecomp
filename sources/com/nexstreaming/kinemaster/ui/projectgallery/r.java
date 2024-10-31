package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportFileListActivity f4219a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ExportFileListActivity exportFileListActivity) {
        this.f4219a = exportFileListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.nexstreaming.kinemaster.project.f e;
        com.nexstreaming.kinemaster.project.f e2;
        e = this.f4219a.e();
        if (e != null) {
            e2 = this.f4219a.e();
            new a(this.f4219a, e2.a()).b().onComplete(new s(this, e2));
        }
    }
}
