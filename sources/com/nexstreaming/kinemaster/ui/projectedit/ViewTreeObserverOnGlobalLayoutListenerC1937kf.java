package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC1937kf implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22428a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22429b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1937kf(ProjectEditActivity projectEditActivity, View view) {
        this.f22429b = projectEditActivity;
        this.f22428a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        NexThemeView nexThemeView;
        NexThemeView nexThemeView2;
        NexThemeView nexThemeView3;
        NexThemeView nexThemeView4;
        float measuredWidth = this.f22428a.getMeasuredWidth() / this.f22428a.getMeasuredHeight();
        nexThemeView = this.f22429b.P;
        ViewGroup.LayoutParams layoutParams = nexThemeView.getLayoutParams();
        if (measuredWidth < EditorGlobal.l()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        nexThemeView2 = this.f22429b.P;
        nexThemeView2.setLayoutParams(layoutParams);
        nexThemeView3 = this.f22429b.P;
        nexThemeView3.requestLayout();
        nexThemeView4 = this.f22429b.P;
        nexThemeView4.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1928jf(this));
        this.f22428a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
