package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.a;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: InAppFragment.java */
@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
/* loaded from: classes.dex */
public class g extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private n f3030a;
    private Activity b;
    private GestureDetector c;
    private Handler d;
    private int e;
    private UpdateDisplayState.DisplayState.InAppNotificationState f;
    private Runnable g;
    private Runnable h;
    private View i;
    private boolean j;

    public void a(n nVar, int i, UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState) {
        this.f3030a = nVar;
        this.e = i;
        this.f = inAppNotificationState;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = activity;
        if (this.f == null) {
            a();
            return;
        }
        this.d = new Handler();
        this.g = new h(this);
        this.h = new i(this);
        this.c = new GestureDetector(activity, new k(this));
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = false;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f == null) {
            a();
        } else {
            this.i = layoutInflater.inflate(a.d.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            TextView textView = (TextView) this.i.findViewById(a.c.com_mixpanel_android_notification_title);
            ImageView imageView = (ImageView) this.i.findViewById(a.c.com_mixpanel_android_notification_image);
            InAppNotification c = this.f.c();
            textView.setText(c.e());
            imageView.setImageBitmap(c.l());
            this.d.postDelayed(this.g, 10000L);
        }
        return this.i;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.j) {
            this.b.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.d.postDelayed(this.h, 500L);
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        a();
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a();
    }

    private void a() {
        if (!this.j) {
            this.d.removeCallbacks(this.g);
            this.d.removeCallbacks(this.h);
            UpdateDisplayState.a(this.e);
            this.b.getFragmentManager().beginTransaction().remove(this).commit();
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null && !this.j) {
            this.d.removeCallbacks(this.g);
            this.d.removeCallbacks(this.h);
            this.b.getFragmentManager().beginTransaction().setCustomAnimations(0, a.C0054a.com_mixpanel_android_slide_down).remove(this).commit();
            UpdateDisplayState.a(this.e);
            this.j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InAppFragment.java */
    /* loaded from: classes.dex */
    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) (-(Math.pow(2.718281828459045d, (-8.0f) * f) * Math.cos(12.0f * f)))) + 1.0f;
        }
    }
}
