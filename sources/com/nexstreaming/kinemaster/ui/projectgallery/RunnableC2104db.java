package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.Lb;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.db */
/* loaded from: classes2.dex */
public class RunnableC2104db implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ProjectGalleryActivity f22914a;

    public RunnableC2104db(ProjectGalleryActivity projectGalleryActivity) {
        this.f22914a = projectGalleryActivity;
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
        view = this.f22914a.ca;
        runnable = this.f22914a.Ma;
        view.removeCallbacks(runnable);
        Lb.a a2 = Lb.a(this.f22914a);
        if (a2 != null) {
            view4 = this.f22914a.ca;
            if (view4.getVisibility() == 8) {
                view10 = this.f22914a.ba;
                view10.setVisibility(0);
                view11 = this.f22914a.ca;
                view11.setVisibility(0);
                view12 = this.f22914a.ca;
                view12.setAlpha(0.0f);
                view13 = this.f22914a.ca;
                view13.animate().alpha(1.0f).setDuration(2000L).start();
            }
            if (a2.f22858a != 0) {
                imageView3 = this.f22914a.ha;
                imageView3.setImageDrawable(this.f22914a.getResources().getDrawable(a2.f22858a));
                imageView4 = this.f22914a.ha;
                imageView4.setVisibility(0);
            } else {
                imageView = this.f22914a.ha;
                imageView.setImageDrawable(null);
                imageView2 = this.f22914a.ha;
                imageView2.setVisibility(8);
            }
            if (a2.d()) {
                view9 = this.f22914a.ca;
                view9.setOnClickListener(new ViewOnClickListenerC2098bb(this, a2));
            } else {
                view5 = this.f22914a.ca;
                view5.setOnClickListener(new ViewOnClickListenerC2101cb(this));
            }
            if (a2.f22859b == null) {
                view6 = this.f22914a.ca;
                view6.setVisibility(8);
                view7 = this.f22914a.ba;
                view7.setVisibility(8);
            } else if (a2.d()) {
                textView3 = this.f22914a.ea;
                textView3.setText(a2.a());
            } else {
                textView = this.f22914a.ea;
                textView.setTextColor(this.f22914a.getResources().getColor(R.color.tip_normal_text_color));
                textView2 = this.f22914a.ea;
                textView2.setText(a2.f22859b);
            }
            view8 = this.f22914a.ca;
            runnable2 = this.f22914a.Ma;
            view8.postDelayed(runnable2, 7000L);
            return;
        }
        view2 = this.f22914a.ca;
        view2.setVisibility(8);
        view3 = this.f22914a.ba;
        view3.setVisibility(8);
    }
}
