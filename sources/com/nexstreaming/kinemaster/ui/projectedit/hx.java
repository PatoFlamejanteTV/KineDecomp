package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class hx implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3967a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hx(ProjectEditActivity projectEditActivity) {
        this.f3967a = projectEditActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        ImageView imageView;
        NexThemeView nexThemeView;
        NexThemeView nexThemeView2;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        NexThemeView nexThemeView3;
        NexThemeView nexThemeView4;
        int measuredWidth;
        NexThemeView nexThemeView5;
        NexThemeView nexThemeView6;
        ImageView imageView5;
        ImageView imageView6;
        NexThemeView nexThemeView7;
        NexThemeView nexThemeView8;
        NexThemeView nexThemeView9;
        int i10;
        NexThemeView nexThemeView10;
        Configuration configuration = this.f3967a.getResources().getConfiguration();
        view.removeOnLayoutChangeListener(this);
        if (!this.f3967a.B() && configuration.screenWidthDp > configuration.screenHeightDp) {
            if (this.f3967a.findViewById(R.id.previewViewHolder) == null) {
                i9 = 0;
            } else {
                if (this.f3967a.findViewById(R.id.previewViewHolder).getMeasuredWidth() > 0) {
                    int measuredWidth2 = this.f3967a.findViewById(R.id.previewViewHolder).getMeasuredWidth();
                    nexThemeView10 = this.f3967a.i;
                    i10 = (measuredWidth2 - nexThemeView10.getMeasuredWidth()) / 2;
                } else {
                    i10 = 0;
                }
                i9 = i10;
            }
            imageView = this.f3967a.l;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            nexThemeView = this.f3967a.i;
            int measuredHeight = (((int) ((nexThemeView.getMeasuredHeight() * 0.1f) * 0.75f)) + i2) - (layoutParams.height / 2);
            nexThemeView2 = this.f3967a.i;
            layoutParams.setMargins(-((int) (nexThemeView2.getMeasuredWidth() * 0.035f)), measuredHeight, 0, 0);
            imageView2 = this.f3967a.l;
            imageView2.setLayoutParams(layoutParams);
            imageView3 = this.f3967a.l;
            imageView3.requestLayout();
            imageView4 = this.f3967a.m;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView4.getLayoutParams();
            nexThemeView3 = this.f3967a.i;
            int measuredHeight2 = (int) (i2 + (nexThemeView3.getMeasuredHeight() * 0.051f));
            if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
                nexThemeView7 = this.f3967a.i;
                measuredWidth = (int) (i9 + (nexThemeView7.getMeasuredWidth() * 0.036f));
                nexThemeView8 = this.f3967a.i;
                layoutParams2.height = (int) (nexThemeView8.getMeasuredHeight() * 0.13f);
                nexThemeView9 = this.f3967a.i;
                layoutParams2.width = (int) (nexThemeView9.getMeasuredWidth() * 0.154f);
            } else {
                nexThemeView4 = this.f3967a.i;
                measuredWidth = (int) (i9 + (nexThemeView4.getMeasuredWidth() * 0.035f));
                nexThemeView5 = this.f3967a.i;
                layoutParams2.height = (int) (nexThemeView5.getMeasuredHeight() * 0.06f);
                nexThemeView6 = this.f3967a.i;
                layoutParams2.width = (int) (nexThemeView6.getMeasuredWidth() * 0.32f);
            }
            layoutParams2.setMargins(0, measuredHeight2, measuredWidth, 0);
            imageView5 = this.f3967a.m;
            imageView5.setLayoutParams(layoutParams2);
            imageView6 = this.f3967a.m;
            imageView6.requestLayout();
        }
    }
}
