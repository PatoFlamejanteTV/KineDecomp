package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.jf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1928jf implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC1937kf f22407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1928jf(ViewTreeObserverOnGlobalLayoutListenerC1937kf viewTreeObserverOnGlobalLayoutListenerC1937kf) {
        this.f22407a = viewTreeObserverOnGlobalLayoutListenerC1937kf;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        NexThemeView nexThemeView;
        NexThemeView nexThemeView2;
        NexThemeView nexThemeView3;
        NexThemeView nexThemeView4;
        ProjectEditActivity projectEditActivity = this.f22407a.f22429b;
        i = projectEditActivity.Qa;
        projectEditActivity.p(i);
        nexThemeView = this.f22407a.f22429b.P;
        nexThemeView.getMeasuredWidth();
        nexThemeView2 = this.f22407a.f22429b.P;
        nexThemeView2.getMeasuredHeight();
        Rect rect = new Rect();
        nexThemeView3 = this.f22407a.f22429b.P;
        nexThemeView3.getGlobalVisibleRect(rect);
        nexThemeView4 = this.f22407a.f22429b.P;
        nexThemeView4.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
