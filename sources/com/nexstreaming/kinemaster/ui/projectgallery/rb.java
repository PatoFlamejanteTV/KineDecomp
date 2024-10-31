package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.project.k;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.ProjectAspectRatio;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class rb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sb f22975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rb(sb sbVar) {
        this.f22975a = sbVar;
    }

    public /* synthetic */ void a(ProjectAspectRatio projectAspectRatio) {
        ((TextView) this.f22975a.f22980c.findViewById(R.id.projectDetailRatio)).setText(projectAspectRatio.getString());
    }

    @Override // java.lang.Runnable
    public void run() {
        Eb eb;
        Eb eb2;
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
        View view9;
        View view10;
        View view11;
        View view12;
        View view13;
        ImageCyclerView imageCyclerView;
        View view14;
        View view15;
        Eb eb3;
        com.nexstreaming.kinemaster.project.k kVar = null;
        this.f22975a.f22980c.wa = null;
        eb = this.f22975a.f22980c.ua;
        if (eb != null) {
            eb3 = this.f22975a.f22980c.ua;
            kVar = eb3.getItem(this.f22975a.f22979b);
        }
        if (kVar != null) {
            KMEvents.VIEW_PROJECT_INFO.trackScreen(this.f22975a.f22980c);
            this.f22975a.f22980c.K = true;
            this.f22975a.f22980c.va = kVar;
            eb2 = this.f22975a.f22980c.ua;
            sb sbVar = this.f22975a;
            com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.c.a((FragmentActivity) this.f22975a.f22980c).a(eb2.a(sbVar.f22980c, sbVar.f22979b));
            imageView = this.f22975a.f22980c.ga;
            a2.a(imageView);
            sb sbVar2 = this.f22975a;
            View view16 = sbVar2.f22978a;
            iArr = sbVar2.f22980c.P;
            view16.getLocationInWindow(iArr);
            iArr2 = this.f22975a.f22980c.P;
            int i = iArr2[0];
            iArr3 = this.f22975a.f22980c.P;
            int i2 = iArr3[1];
            float width = this.f22975a.f22978a.getWidth();
            float height = this.f22975a.f22978a.getHeight();
            view = this.f22975a.f22980c.Y;
            iArr4 = this.f22975a.f22980c.P;
            view.getLocationOnScreen(iArr4);
            iArr5 = this.f22975a.f22980c.P;
            int i3 = iArr5[0];
            iArr6 = this.f22975a.f22980c.P;
            int i4 = iArr6[1];
            float width2 = width / r1.getWidth();
            float height2 = height / r1.getHeight();
            view2 = this.f22975a.f22980c.Y;
            view2.setPivotX(0.0f);
            view3 = this.f22975a.f22980c.Y;
            view3.setPivotY(0.0f);
            view4 = this.f22975a.f22980c.Y;
            float f2 = i - i3;
            view4.setTranslationX(f2);
            view5 = this.f22975a.f22980c.Y;
            float f3 = i2 - i4;
            view5.setTranslationY(f3);
            view6 = this.f22975a.f22980c.Y;
            view6.setScaleX(width2);
            view7 = this.f22975a.f22980c.Y;
            view7.setScaleY(height2);
            this.f22975a.f22980c.R = f2;
            this.f22975a.f22980c.S = f3;
            this.f22975a.f22980c.T = width2;
            this.f22975a.f22980c.U = height2;
            view8 = this.f22975a.f22980c.Y;
            view8.animate().setStartDelay(0L).translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(400L);
            ((TextView) this.f22975a.f22980c.findViewById(R.id.projectDetailDate)).setText(kVar.d() == null ? "" : DateFormat.getMediumDateFormat(this.f22975a.f22980c).format(kVar.d()));
            int g2 = kVar.g();
            if (g2 < 1000 && g2 >= 1) {
                g2 = 1000;
            }
            long j = g2;
            ((TextView) this.f22975a.f22980c.findViewById(R.id.projectDetailTime)).setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(kVar.g()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
            view9 = this.f22975a.f22980c.X;
            view9.setVisibility(0);
            view10 = this.f22975a.f22980c.X;
            view10.setAlpha(1.0f);
            view11 = this.f22975a.f22980c.Z;
            view11.setAlpha(0.0f);
            view12 = this.f22975a.f22980c.Z;
            view12.animate().setStartDelay(0L).alpha(1.0f).setDuration(500L);
            view13 = this.f22975a.f22980c.W;
            view13.animate().alpha(0.0f).setStartDelay(0L).setDuration(510L).withEndAction(new qb(this));
            imageCyclerView = this.f22975a.f22980c.ta;
            ObjectAnimator.ofObject(imageCyclerView, "blur", new FloatEvaluator(), 0, 1).setDuration(500L).start();
            view14 = this.f22975a.f22980c.aa;
            view14.setAlpha(0.0f);
            view15 = this.f22975a.f22980c.aa;
            view15.animate().alpha(1.0f).setStartDelay(350L).setDuration(200L);
            kVar.a(new k.b() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.e
                @Override // com.nexstreaming.kinemaster.project.k.b
                public final void a(ProjectAspectRatio projectAspectRatio) {
                    rb.this.a(projectAspectRatio);
                }
            });
            kVar.a(this.f22975a.f22980c);
        }
    }
}
