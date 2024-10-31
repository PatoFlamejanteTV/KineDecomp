package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.cx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(ProjectGalleryActivity projectGalleryActivity) {
        this.f4169a = projectGalleryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        Runnable runnable;
        View view2;
        View view3;
        View view4;
        ImageView imageView;
        ImageView imageView2;
        View view5;
        View view6;
        View view7;
        View view8;
        Runnable runnable2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        View view9;
        ImageView imageView3;
        ImageView imageView4;
        View view10;
        View view11;
        View view12;
        View view13;
        view = this.f4169a.L;
        runnable = this.f4169a.R;
        view.removeCallbacks(runnable);
        cx.a a2 = cx.a(this.f4169a);
        if (a2 != null) {
            view4 = this.f4169a.L;
            if (view4.getVisibility() == 8) {
                view10 = this.f4169a.K;
                view10.setVisibility(0);
                view11 = this.f4169a.L;
                view11.setVisibility(0);
                view12 = this.f4169a.L;
                view12.setAlpha(0.0f);
                view13 = this.f4169a.L;
                view13.animate().alpha(1.0f).setDuration(2000L).start();
            }
            if (a2.f4204a != 0) {
                imageView3 = this.f4169a.N;
                imageView3.setImageDrawable(this.f4169a.getResources().getDrawable(a2.f4204a));
                imageView4 = this.f4169a.N;
                imageView4.setVisibility(0);
            } else {
                imageView = this.f4169a.N;
                imageView.setImageDrawable(null);
                imageView2 = this.f4169a.N;
                imageView2.setVisibility(8);
            }
            if (a2.e()) {
                view9 = this.f4169a.L;
                view9.setOnClickListener(new bq(this, a2));
            } else {
                view5 = this.f4169a.L;
                view5.setOnClickListener(new bu(this));
            }
            if (a2.b == null) {
                view6 = this.f4169a.L;
                view6.setVisibility(8);
                view7 = this.f4169a.K;
                view7.setVisibility(8);
            } else if (a2.e()) {
                textView3 = this.f4169a.M;
                textView3.setText(a2.a());
            } else {
                textView = this.f4169a.M;
                textView.setTextColor(this.f4169a.getResources().getColor(R.color.tip_normal_text_color));
                textView2 = this.f4169a.M;
                textView2.setText(a2.b);
            }
            view8 = this.f4169a.L;
            runnable2 = this.f4169a.R;
            view8.postDelayed(runnable2, 7000L);
            return;
        }
        view2 = this.f4169a.L;
        view2.setVisibility(8);
        view3 = this.f4169a.K;
        view3.setVisibility(8);
    }
}
