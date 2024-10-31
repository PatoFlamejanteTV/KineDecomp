package com.nexstreaming.kinemaster.ad;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentNativeExpressAdProvider;

/* compiled from: AdDialogFragment.java */
/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: a */
    private DialogInterface.OnDismissListener f19940a;

    /* renamed from: b */
    private int f19941b;

    /* renamed from: c */
    private com.nexstreaming.app.kinemasterfree.a.m f19942c;

    /* renamed from: d */
    private TencentNativeExpressAdProvider f19943d;

    /* renamed from: e */
    private ViewGroup f19944e;

    /* renamed from: f */
    private int f19945f;

    /* renamed from: g */
    private int f19946g;

    /* renamed from: h */
    private String f19947h;

    public b() {
        this.f19945f = -1;
        this.f19946g = -1;
        this.f19947h = TencentNativeExpressAdProvider.class.getSimpleName();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.Theme.Translucent.NoTitleBar);
        this.f19941b = getResources().getInteger(R.integer.config_mediumAnimTime);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCancelable(true);
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), new ColorDrawable(Color.argb(200, 0, 0, 0))});
        onCreateDialog.getWindow().setBackgroundDrawable(transitionDrawable);
        transitionDrawable.startTransition(this.f19941b);
        return onCreateDialog;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19942c = (com.nexstreaming.app.kinemasterfree.a.m) android.databinding.e.a(layoutInflater, com.nexstreaming.app.kinemasterfree.R.layout.fragment_adview_admob, viewGroup, false);
        this.f19942c.z.removeAllViews();
        TencentNativeExpressAdProvider tencentNativeExpressAdProvider = this.f19943d;
        if (tencentNativeExpressAdProvider != null) {
            this.f19944e = tencentNativeExpressAdProvider.getMContainerView();
            ViewGroup viewGroup2 = this.f19944e;
            if (viewGroup2 != null) {
                this.f19942c.z.addView(viewGroup2);
            }
        }
        this.f19942c.a((View.OnClickListener) new a(this));
        this.f19942c.A.setAlpha(0.0f);
        this.f19942c.A.setScaleX(0.0f);
        this.f19942c.A.setScaleY(0.0f);
        this.f19942c.A.setRotation(-45.0f);
        this.f19942c.A.setRotationX(15.0f);
        this.f19942c.A.setRotationY(-15.0f);
        if (this.f19945f != -1) {
            this.f19942c.A.setTranslationX(r3 - (getResources().getDisplayMetrics().widthPixels / 2));
        }
        if (this.f19946g != -1) {
            this.f19942c.A.setTranslationY(r3 - (getResources().getDisplayMetrics().heightPixels / 2));
        }
        this.f19942c.A.animate().setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.f19941b).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotation(0.0f).rotationX(0.0f).rotationY(0.0f).translationX(0.0f).translationY(0.0f).start();
        this.f19942c.y.setAlpha(0.0f);
        this.f19942c.A.setScaleX(0.0f);
        this.f19942c.A.setScaleY(0.0f);
        this.f19942c.y.animate().setInterpolator(new OvershootInterpolator()).setDuration(this.f19941b).setStartDelay(150L).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
        return this.f19942c.e();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        ViewGroup viewGroup = this.f19944e;
        if (viewGroup != null) {
            this.f19942c.z.removeView(viewGroup);
        }
        DialogInterface.OnDismissListener onDismissListener = this.f19940a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(getDialog());
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public b show(FragmentManager fragmentManager, int i, int i2) {
        this.f19945f = i;
        this.f19946g = i2;
        super.show(fragmentManager, b.class.getName());
        return this;
    }

    @SuppressLint({"ValidFragment"})
    public b(TencentNativeExpressAdProvider tencentNativeExpressAdProvider) {
        this.f19945f = -1;
        this.f19946g = -1;
        this.f19943d = tencentNativeExpressAdProvider;
    }
}
