package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.ArrayList;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class hv implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Theme f3965a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hv(ProjectEditActivity projectEditActivity, Theme theme) {
        this.b = projectEditActivity;
        this.f3965a = theme;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean a2;
        TimelineView timelineView;
        TimelineView timelineView2;
        KMUsage.EditScreen_Theme_Confirm.logEvent("confirm", "ok", "theme", this.f3965a.i());
        dialogInterface.dismiss();
        a2 = this.b.a(this.f3965a, (ArrayList<String>) null, true);
        if (a2) {
            this.b.p().C();
            this.b.p().l();
            this.b.p().n();
            timelineView = this.b.k;
            timelineView.e();
            timelineView2 = this.b.k;
            timelineView2.invalidate();
        }
    }
}
