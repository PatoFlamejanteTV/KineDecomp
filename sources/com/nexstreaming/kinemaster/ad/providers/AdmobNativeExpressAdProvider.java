package com.nexstreaming.kinemaster.ad.providers;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.e;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import com.nexstreaming.app.kinemasterfree.a.m;
import com.nexstreaming.kinemaster.ad.AdManager;

/* loaded from: classes.dex */
public class AdmobNativeExpressAdProvider extends AdmobAdProvider<NativeExpressAdView> {
    private static final String TAG = "AdmobNativeExpressAdProvider";
    private static final String UNIT_ID = "ca-app-pub-6554794109779706/7470496076";
    private boolean isShowAds;

    /* loaded from: classes.dex */
    public static class AdmobAdViewFragment extends DialogFragment {
        private NativeExpressAdView adView;
        private int animationDuration;
        private m binding;
        private DialogInterface.OnDismissListener onDismissListener;
        private int startX = -1;
        private int startY = -1;

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setStyle(1, R.style.Theme.Translucent.NoTitleBar);
            this.animationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        }

        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            onCreateDialog.setCancelable(true);
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), new ColorDrawable(Color.argb(200, 0, 0, 0))});
            onCreateDialog.getWindow().setBackgroundDrawable(transitionDrawable);
            transitionDrawable.startTransition(this.animationDuration);
            return onCreateDialog;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.binding = (m) e.a(layoutInflater, com.nexstreaming.app.kinemasterfree.R.layout.fragment_adview_admob, viewGroup, false);
            this.binding.z.removeAllViews();
            AdmobAdProvider admobAdProvider = (AdmobAdProvider) AdManager.a(getActivity()).c(AdmobNativeExpressAdProvider.class.getSimpleName());
            if (admobAdProvider != null) {
                this.adView = (NativeExpressAdView) admobAdProvider.getAd();
                this.binding.z.addView(this.adView);
            }
            this.binding.a(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeExpressAdProvider.AdmobAdViewFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdmobAdViewFragment.this.dismiss();
                }
            });
            this.binding.A.setAlpha(0.0f);
            this.binding.A.setScaleX(0.0f);
            this.binding.A.setScaleY(0.0f);
            this.binding.A.setRotation(-45.0f);
            this.binding.A.setRotationX(30.0f);
            this.binding.A.setRotationY(-30.0f);
            if (this.startX != -1) {
                this.binding.A.setTranslationX(r3 - (getResources().getDisplayMetrics().widthPixels / 2));
            }
            if (this.startY != -1) {
                this.binding.A.setTranslationY(r3 - (getResources().getDisplayMetrics().heightPixels / 2));
            }
            this.binding.A.animate().setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.animationDuration).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotation(0.0f).rotationX(0.0f).rotationY(0.0f).translationX(0.0f).translationY(0.0f).start();
            this.binding.y.setAlpha(0.0f);
            this.binding.y.setScaleX(0.0f);
            this.binding.y.setScaleY(0.0f);
            this.binding.y.animate().setInterpolator(new OvershootInterpolator()).setDuration(this.animationDuration).setStartDelay(this.animationDuration).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
            return this.binding.e();
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onDestroyView() {
            NativeExpressAdView nativeExpressAdView = this.adView;
            if (nativeExpressAdView != null) {
                this.binding.z.removeView(nativeExpressAdView);
                this.adView.a();
                AdListener adListener = this.adView.getAdListener();
                if (adListener != null) {
                    adListener.onAdClosed();
                }
            }
            DialogInterface.OnDismissListener onDismissListener = this.onDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(getDialog());
            }
            super.onDestroyView();
        }

        @Override // android.support.v4.app.Fragment
        public void onPause() {
            NativeExpressAdView nativeExpressAdView = this.adView;
            if (nativeExpressAdView != null) {
                nativeExpressAdView.b();
            }
            super.onPause();
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            NativeExpressAdView nativeExpressAdView = this.adView;
            if (nativeExpressAdView != null) {
                nativeExpressAdView.c();
            }
        }

        public AdmobAdViewFragment setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
            return this;
        }

        public AdmobAdViewFragment show(FragmentManager fragmentManager) {
            return show(fragmentManager, -1, -1);
        }

        public AdmobAdViewFragment show(FragmentManager fragmentManager, int i, int i2) {
            this.startX = i;
            this.startY = i2;
            super.show(fragmentManager, AdmobAdViewFragment.class.getName());
            return this;
        }
    }

    public AdmobNativeExpressAdProvider(Context context) {
        super(context, UNIT_ID);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobNativeExpressAdProvider.class.getSimpleName();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return this.isShowAds;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        getAd().a(newAdRequest());
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        if (!isReady() || this.isShowAds) {
            return;
        }
        new AdmobAdViewFragment().show(appCompatActivity.getSupportFragmentManager(), i, i2).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeExpressAdProvider.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AdmobNativeExpressAdProvider.this.isShowAds = false;
            }
        });
        this.isShowAds = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public NativeExpressAdView onCreateAd() {
        NativeExpressAdView nativeExpressAdView = new NativeExpressAdView(getContext());
        nativeExpressAdView.setAdUnitId(UNIT_ID);
        nativeExpressAdView.setAdSize(AdSize.f9936e);
        nativeExpressAdView.setAdListener(this);
        return nativeExpressAdView;
    }
}
