package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class jv implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4019a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jv(ProjectEditActivity projectEditActivity) {
        this.f4019a = projectEditActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        NexThemeView nexThemeView;
        TimelineView timelineView;
        TimelineView timelineView2;
        NexThemeView nexThemeView2;
        NexThemeView nexThemeView3;
        TimelineView timelineView3;
        TimelineView timelineView4;
        NexThemeView nexThemeView4;
        NexThemeView nexThemeView5;
        float f7;
        float f8;
        NexThemeView nexThemeView6;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f4019a.D = motionEvent.getRawX();
                this.f4019a.E = motionEvent.getRawY();
                return true;
            case 1:
                return true;
            case 2:
                f = this.f4019a.D;
                f2 = this.f4019a.E;
                this.f4019a.D = motionEvent.getRawX();
                this.f4019a.E = motionEvent.getRawY();
                f3 = this.f4019a.B;
                f4 = this.f4019a.D;
                float f9 = (f - f4) + f3;
                f5 = this.f4019a.C;
                f6 = this.f4019a.E;
                float f10 = (f2 - f6) + f5;
                if (f9 <= 0.0f) {
                    this.f4019a.B = 0.0f;
                } else {
                    nexThemeView = this.f4019a.j;
                    float width = nexThemeView.getWidth() + f9;
                    timelineView = this.f4019a.k;
                    if (width <= timelineView.getWidth()) {
                        this.f4019a.B = f9;
                    } else {
                        ProjectEditActivity projectEditActivity = this.f4019a;
                        timelineView2 = this.f4019a.k;
                        int width2 = timelineView2.getWidth();
                        nexThemeView2 = this.f4019a.j;
                        projectEditActivity.B = width2 - nexThemeView2.getWidth();
                    }
                }
                if (f10 <= 0.0f) {
                    this.f4019a.C = 0.0f;
                } else {
                    nexThemeView3 = this.f4019a.j;
                    float height = nexThemeView3.getHeight() + f10;
                    timelineView3 = this.f4019a.k;
                    if (height <= timelineView3.getHeight()) {
                        this.f4019a.C = f10;
                    } else {
                        ProjectEditActivity projectEditActivity2 = this.f4019a;
                        timelineView4 = this.f4019a.k;
                        int height2 = timelineView4.getHeight();
                        nexThemeView4 = this.f4019a.j;
                        projectEditActivity2.C = height2 - nexThemeView4.getHeight();
                    }
                }
                nexThemeView5 = this.f4019a.j;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nexThemeView5.getLayoutParams();
                f7 = this.f4019a.B;
                layoutParams.rightMargin = (int) f7;
                f8 = this.f4019a.C;
                layoutParams.bottomMargin = (int) f8;
                nexThemeView6 = this.f4019a.j;
                nexThemeView6.setLayoutParams(layoutParams);
                return true;
            default:
                return false;
        }
    }
}
