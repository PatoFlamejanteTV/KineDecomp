package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import android.view.ViewTreeObserver;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
class Ag implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f21742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ag(ProjectEditActivity projectEditActivity) {
        this.f21742a = projectEditActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        NexThemeView nexThemeView;
        ProjectEditActivity projectEditActivity = this.f21742a;
        i = projectEditActivity.Qa;
        projectEditActivity.p(i);
        Log.d("ProjectEditActivity", "video view layout change oncreate");
        nexThemeView = this.f21742a.P;
        nexThemeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
