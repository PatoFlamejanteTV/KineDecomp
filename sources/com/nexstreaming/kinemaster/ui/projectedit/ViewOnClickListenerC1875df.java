package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.df, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1875df implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1875df(ProjectEditActivity projectEditActivity) {
        this.f22314a = projectEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (EditorGlobal.p) {
            Crashlytics.log("tap remove watermark button");
        }
        this.f22314a.a("deleteWatermarkButton", "Remove Watermark");
    }
}
