package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.concurrent.TimeUnit;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4129a;
    final /* synthetic */ View b;
    final /* synthetic */ ab c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, int i, View view) {
        this.c = abVar;
        this.f4129a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        com.nexstreaming.kinemaster.project.f fVar;
        x xVar2;
        ImageView imageView;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        View view;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        Activity D;
        String format;
        View view9;
        View view10;
        View view11;
        View view12;
        View view13;
        ImageCyclerView imageCyclerView;
        View view14;
        View view15;
        x xVar3;
        this.c.f4128a.z = null;
        xVar = this.c.f4128a.g;
        if (xVar != null) {
            xVar3 = this.c.f4128a.g;
            fVar = xVar3.getItem(this.f4129a);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            KMUsage.ProjectList_ProjectDetails.begin();
            this.c.f4128a.b = true;
            this.c.f4128a.q = fVar;
            xVar2 = this.c.f4128a.g;
            Bitmap a2 = xVar2.a(this.c.f4128a, this.f4129a);
            imageView = this.c.f4128a.n;
            imageView.setImageBitmap(a2);
            View view16 = this.b;
            iArr = this.c.f4128a.o;
            view16.getLocationOnScreen(iArr);
            iArr2 = this.c.f4128a.o;
            int i = iArr2[0];
            iArr3 = this.c.f4128a.o;
            int i2 = iArr3[1];
            float width = this.b.getWidth();
            float height = this.b.getHeight();
            view = this.c.f4128a.j;
            iArr4 = this.c.f4128a.o;
            view.getLocationOnScreen(iArr4);
            iArr5 = this.c.f4128a.o;
            int i3 = iArr5[0];
            iArr6 = this.c.f4128a.o;
            int i4 = i - i3;
            int i5 = i2 - iArr6[1];
            float width2 = width / a2.getWidth();
            float height2 = height / a2.getHeight();
            view2 = this.c.f4128a.j;
            view2.setPivotX(0.0f);
            view3 = this.c.f4128a.j;
            view3.setPivotY(0.0f);
            view4 = this.c.f4128a.j;
            view4.setTranslationX(i4);
            view5 = this.c.f4128a.j;
            view5.setTranslationY(i5);
            view6 = this.c.f4128a.j;
            view6.setScaleX(width2);
            view7 = this.c.f4128a.j;
            view7.setScaleY(height2);
            this.c.f4128a.u = i4;
            this.c.f4128a.v = i5;
            this.c.f4128a.w = width2;
            this.c.f4128a.x = height2;
            view8 = this.c.f4128a.j;
            view8.animate().setStartDelay(0L).translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(400L);
            if (fVar.c() == null) {
                format = "";
            } else {
                D = this.c.f4128a.D();
                format = DateFormat.getMediumDateFormat(D).format(fVar.c());
            }
            ((TextView) this.c.f4128a.findViewById(R.id.projectDetailDate)).setText(format);
            int d = fVar.d();
            if (d < 1000 && d >= 1) {
                d = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            }
            ((TextView) this.c.f4128a.findViewById(R.id.projectDetailTime)).setText(String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(d)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(d) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(d))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(fVar.d()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(d)))));
            view9 = this.c.f4128a.i;
            view9.setVisibility(0);
            view10 = this.c.f4128a.i;
            view10.setAlpha(1.0f);
            view11 = this.c.f4128a.m;
            view11.setAlpha(0.0f);
            view12 = this.c.f4128a.m;
            view12.animate().setStartDelay(0L).alpha(1.0f).setDuration(500L);
            view13 = this.c.f4128a.h;
            view13.animate().alpha(0.0f).setStartDelay(0L).setDuration(510L).withEndAction(new ad(this));
            imageCyclerView = this.c.f4128a.k;
            ObjectAnimator.ofObject(imageCyclerView, "blur", new FloatEvaluator(), 0, 1).setDuration(500L).start();
            view14 = this.c.f4128a.p;
            view14.setAlpha(0.0f);
            view15 = this.c.f4128a.p;
            view15.animate().alpha(1.0f).setStartDelay(350L).setDuration(200L);
        }
    }
}
