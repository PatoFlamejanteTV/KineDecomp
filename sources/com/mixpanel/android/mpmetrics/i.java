package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.mixpanel.android.a;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppFragment.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f3033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f3033a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState;
        View view3;
        View view4;
        Activity activity;
        View view5;
        view = this.f3033a.i;
        view.setVisibility(0);
        view2 = this.f3033a.i;
        inAppNotificationState = this.f3033a.f;
        view2.setBackgroundColor(inAppNotificationState.b());
        view3 = this.f3033a.i;
        view3.setOnTouchListener(new j(this));
        view4 = this.f3033a.i;
        ImageView imageView = (ImageView) view4.findViewById(a.c.com_mixpanel_android_notification_image);
        activity = this.f3033a.b;
        float applyDimension = TypedValue.applyDimension(1, 75.0f, activity.getResources().getDisplayMetrics());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, applyDimension, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200L);
        view5 = this.f3033a.i;
        view5.startAnimation(translateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, applyDimension / 2.0f, applyDimension / 2.0f);
        scaleAnimation.setInterpolator(new g.a());
        scaleAnimation.setDuration(400L);
        scaleAnimation.setStartOffset(200L);
        imageView.startAnimation(scaleAnimation);
    }
}
