package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnTouchListenerC1858bg implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    float f22285b;

    /* renamed from: c, reason: collision with root package name */
    float f22286c;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22289f;

    /* renamed from: a, reason: collision with root package name */
    boolean f22284a = false;

    /* renamed from: d, reason: collision with root package name */
    float f22287d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    float f22288e = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnTouchListenerC1858bg(ProjectEditActivity projectEditActivity) {
        this.f22289f = projectEditActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        NexThemeView nexThemeView;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        InterfaceC2025f interfaceC2025f3;
        InterfaceC2025f interfaceC2025f4;
        float f8;
        float f9;
        nexThemeView = this.f22289f.Q;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f22284a = false;
            this.f22285b = motionEvent.getX();
            this.f22286c = motionEvent.getY();
            this.f22289f.ra = motionEvent.getRawX();
            this.f22289f.sa = motionEvent.getRawY();
            return true;
        }
        if (actionMasked == 1) {
            this.f22287d = 0.0f;
            this.f22288e = 0.0f;
            return true;
        }
        if (actionMasked != 2) {
            return false;
        }
        this.f22287d += Math.abs(motionEvent.getX() - this.f22285b);
        this.f22288e += Math.abs(motionEvent.getY() - this.f22286c);
        if (this.f22287d > 5.0f || this.f22288e > 5.0f) {
            this.f22284a = true;
        }
        f2 = this.f22289f.ra;
        f3 = this.f22289f.sa;
        this.f22289f.ra = motionEvent.getRawX();
        this.f22289f.sa = motionEvent.getRawY();
        f4 = this.f22289f.pa;
        f5 = this.f22289f.ra;
        float f10 = f4 + (f2 - f5);
        f6 = this.f22289f.qa;
        f7 = this.f22289f.sa;
        float f11 = f6 + (f3 - f7);
        if (f10 <= 0.0f) {
            this.f22289f.pa = 0.0f;
        } else {
            float measuredWidth = nexThemeView.getMeasuredWidth() + f10;
            interfaceC2025f = this.f22289f.T;
            if (measuredWidth <= interfaceC2025f.getWidth()) {
                this.f22289f.pa = f10;
            } else {
                ProjectEditActivity projectEditActivity = this.f22289f;
                interfaceC2025f2 = projectEditActivity.T;
                projectEditActivity.pa = interfaceC2025f2.getWidth() - nexThemeView.getMeasuredWidth();
            }
        }
        if (f11 <= 0.0f) {
            this.f22289f.qa = 0.0f;
        } else {
            float measuredHeight = nexThemeView.getMeasuredHeight() + f11;
            interfaceC2025f3 = this.f22289f.T;
            if (measuredHeight <= interfaceC2025f3.getHeight()) {
                this.f22289f.qa = f11;
            } else {
                ProjectEditActivity projectEditActivity2 = this.f22289f;
                interfaceC2025f4 = projectEditActivity2.T;
                projectEditActivity2.qa = interfaceC2025f4.getHeight() - nexThemeView.getMeasuredHeight();
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nexThemeView.getLayoutParams();
        f8 = this.f22289f.pa;
        layoutParams.rightMargin = (int) f8;
        f9 = this.f22289f.qa;
        layoutParams.bottomMargin = (int) f9;
        nexThemeView.setLayoutParams(layoutParams);
        return true;
    }
}
