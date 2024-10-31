package com.nexstreaming.kinemaster.ad.providers;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
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
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.nexstreaming.app.kinemasterfree.a.m;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.List;

/* loaded from: classes.dex */
public class AdmobNativeAdvancedAdProvider extends AdmobAdProvider<AdmobNativeAdContainer> {
    private static final String TAG = "AdmobNativeAdvancedAdProvider";
    private static final String UNIT_ID = "ca-app-pub-6554794109779706/6897864314";
    private boolean isShowAds;

    /* loaded from: classes.dex */
    public static class AdmobAdViewFragment extends DialogFragment {
        private AdmobNativeAdContainer adContainer;
        private int animationDuration;
        private m binding;
        private String mProviderName;
        private DialogInterface.OnDismissListener onDismissListener;
        private int startX;
        private int startY;

        public AdmobAdViewFragment() {
            this.startX = -1;
            this.startY = -1;
            this.mProviderName = AdmobNativeAdvancedAdProvider.class.getSimpleName();
        }

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
            final AdmobAdProvider admobAdProvider = (AdmobAdProvider) AdManager.a(getActivity()).c(this.mProviderName);
            if (admobAdProvider != null) {
                this.adContainer = (AdmobNativeAdContainer) admobAdProvider.getAd();
                AdmobNativeAdContainer admobNativeAdContainer = this.adContainer;
                if (admobNativeAdContainer != null) {
                    this.binding.z.addView(admobNativeAdContainer);
                    if (this.adContainer.getNativeAdView() instanceof NativeAppInstallAdView) {
                        Button button = (Button) ((NativeAppInstallAdView) ((AdmobNativeAdContainer) admobAdProvider.getAd()).getNativeAdView()).findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_call_to_action);
                        button.setAlpha(0.0f);
                        button.setScaleX(0.7f);
                        button.setScaleY(0.7f);
                    }
                }
            }
            this.binding.a(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider.AdmobAdViewFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdmobAdViewFragment.this.dismiss();
                }
            });
            this.binding.A.setAlpha(0.0f);
            this.binding.A.setScaleX(0.0f);
            this.binding.A.setScaleY(0.0f);
            this.binding.A.setRotation(-45.0f);
            this.binding.A.setRotationX(15.0f);
            this.binding.A.setRotationY(-15.0f);
            if (this.startX != -1) {
                this.binding.A.setTranslationX(r6 - (getResources().getDisplayMetrics().widthPixels / 2));
            }
            if (this.startY != -1) {
                this.binding.A.setTranslationY(r6 - (getResources().getDisplayMetrics().heightPixels / 2));
            }
            this.binding.A.animate().setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.animationDuration).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotation(0.0f).rotationX(0.0f).rotationY(0.0f).translationX(0.0f).translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider.AdmobAdViewFragment.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AdmobAdProvider admobAdProvider2 = admobAdProvider;
                    if (admobAdProvider2 == null || !(((AdmobNativeAdContainer) admobAdProvider2.getAd()).getNativeAdView() instanceof NativeAppInstallAdView)) {
                        return;
                    }
                    ((Button) ((NativeAppInstallAdView) ((AdmobNativeAdContainer) admobAdProvider.getAd()).getNativeAdView()).findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_call_to_action)).animate().setInterpolator(new OvershootInterpolator()).setDuration(AdmobAdViewFragment.this.animationDuration).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
                }
            }).start();
            this.binding.y.setAlpha(0.0f);
            this.binding.A.setScaleX(0.0f);
            this.binding.A.setScaleY(0.0f);
            this.binding.y.animate().setInterpolator(new OvershootInterpolator()).setDuration(this.animationDuration).setStartDelay(150L).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
            return this.binding.e();
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onDestroyView() {
            AdmobNativeAdContainer admobNativeAdContainer = this.adContainer;
            if (admobNativeAdContainer != null) {
                this.binding.z.removeView(admobNativeAdContainer);
                this.adContainer.destroy();
                AdListener adListener = this.adContainer.getAdListener();
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
            AdmobNativeAdContainer admobNativeAdContainer = this.adContainer;
            if (admobNativeAdContainer != null) {
                admobNativeAdContainer.pause();
            }
            super.onPause();
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            AdmobNativeAdContainer admobNativeAdContainer = this.adContainer;
            if (admobNativeAdContainer != null) {
                admobNativeAdContainer.resume();
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

        @SuppressLint({"ValidFragment"})
        public AdmobAdViewFragment(String str) {
            this.startX = -1;
            this.startY = -1;
            this.mProviderName = str;
        }
    }

    /* loaded from: classes.dex */
    public static class AdmobNativeAdContainer extends FrameLayout {
        private AdListener adListener;
        private NativeAdView nativeAdView;

        public AdmobNativeAdContainer(Context context) {
            super(context);
        }

        public void destroy() {
            NativeAdView nativeAdView = this.nativeAdView;
            if (nativeAdView != null) {
                nativeAdView.a();
                this.nativeAdView = null;
            }
            removeAllViews();
        }

        public AdListener getAdListener() {
            return this.adListener;
        }

        public <T extends NativeAdView> T getNativeAdView() {
            return (T) this.nativeAdView;
        }

        public void pause() {
        }

        public void resume() {
        }

        public void setAdListener(AdListener adListener) {
            this.adListener = adListener;
        }

        public <T extends NativeAdView> void setNativeAdView(T t) {
            removeAllViews();
            addView(t);
            this.nativeAdView = t;
        }

        public AdmobNativeAdContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public AdmobNativeAdContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public AdmobNativeAdvancedAdProvider(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NativeAppInstallAdView createAppInstallAdView(Context context) {
        NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) View.inflate(context, com.nexstreaming.app.kinemasterfree.R.layout.layout_admob_native_app_install, null);
        nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_headline));
        nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_body));
        nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_call_to_action));
        nativeAppInstallAdView.setIconView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_app_icon));
        nativeAppInstallAdView.setPriceView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_price));
        nativeAppInstallAdView.setStarRatingView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_stars));
        nativeAppInstallAdView.setStoreView(nativeAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_store));
        return nativeAppInstallAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NativeContentAdView createContentAdView(Context context) {
        NativeContentAdView nativeContentAdView = (NativeContentAdView) View.inflate(context, com.nexstreaming.app.kinemasterfree.R.layout.layout_admob_native_content, null);
        nativeContentAdView.setHeadlineView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_headline));
        nativeContentAdView.setImageView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_image));
        nativeContentAdView.setBodyView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_body));
        nativeContentAdView.setCallToActionView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_call_to_action));
        nativeContentAdView.setLogoView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_logo));
        nativeContentAdView.setAdvertiserView(nativeContentAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.contentad_advertiser));
        return nativeContentAdView;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobNativeAdvancedAdProvider.class.getSimpleName();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return this.isShowAds;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        AdLoader.Builder builder = new AdLoader.Builder(getContext(), UNIT_ID);
        builder.a(new NativeAppInstallAd.OnAppInstallAdLoadedListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider.1
            @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
            public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                if (EditorGlobal.p) {
                    Crashlytics.log("[ANAP] onInstallAdLoaded Invoked");
                }
                NativeAppInstallAdView createAppInstallAdView = AdmobNativeAdvancedAdProvider.createAppInstallAdView(AdmobNativeAdvancedAdProvider.this.getContext());
                ((TextView) createAppInstallAdView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
                ((TextView) createAppInstallAdView.getBodyView()).setText(nativeAppInstallAd.getBody());
                ((Button) createAppInstallAdView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());
                ((ImageView) createAppInstallAdView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon().getDrawable());
                MediaView mediaView = (MediaView) createAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_media);
                ImageView imageView = (ImageView) createAppInstallAdView.findViewById(com.nexstreaming.app.kinemasterfree.R.id.appinstall_image);
                if (nativeAppInstallAd.getVideoController().a()) {
                    createAppInstallAdView.setMediaView(mediaView);
                    createAppInstallAdView.setVisibility(0);
                    imageView.setVisibility(8);
                } else {
                    createAppInstallAdView.setImageView(imageView);
                    List<NativeAd.Image> images = nativeAppInstallAd.getImages();
                    if (images.size() > 0) {
                        imageView.setImageDrawable(images.get(0).getDrawable());
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                    mediaView.setVisibility(8);
                }
                if (nativeAppInstallAd.getPrice() != null) {
                    createAppInstallAdView.getPriceView().setVisibility(0);
                    ((TextView) createAppInstallAdView.getPriceView()).setText(nativeAppInstallAd.getPrice());
                } else {
                    createAppInstallAdView.getPriceView().setVisibility(4);
                }
                if (nativeAppInstallAd.getStore() != null) {
                    createAppInstallAdView.getStoreView().setVisibility(0);
                    ((TextView) createAppInstallAdView.getStoreView()).setText(nativeAppInstallAd.getStore());
                } else {
                    createAppInstallAdView.getStoreView().setVisibility(4);
                }
                if (nativeAppInstallAd.getStarRating() != null) {
                    ((RatingBar) createAppInstallAdView.getStarRatingView()).setRating(nativeAppInstallAd.getStarRating().floatValue());
                    createAppInstallAdView.getStarRatingView().setVisibility(0);
                } else {
                    createAppInstallAdView.getStarRatingView().setVisibility(4);
                }
                createAppInstallAdView.setNativeAd(nativeAppInstallAd);
                if (AdmobNativeAdvancedAdProvider.this.getAd() != null) {
                    AdmobNativeAdvancedAdProvider.this.getAd().setNativeAdView(createAppInstallAdView);
                }
            }
        });
        builder.a(new NativeContentAd.OnContentAdLoadedListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider.2
            @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
            public void onContentAdLoaded(NativeContentAd nativeContentAd) {
                if (EditorGlobal.p) {
                    Crashlytics.log("[ANAP] onContentAdLoaded Invoked");
                }
                NativeContentAdView createContentAdView = AdmobNativeAdvancedAdProvider.createContentAdView(AdmobNativeAdvancedAdProvider.this.getContext());
                ((TextView) createContentAdView.getHeadlineView()).setText(nativeContentAd.getHeadline());
                ((TextView) createContentAdView.getBodyView()).setText(nativeContentAd.getBody());
                ((TextView) createContentAdView.getCallToActionView()).setText(nativeContentAd.getCallToAction());
                ((TextView) createContentAdView.getAdvertiserView()).setText(nativeContentAd.getAdvertiser());
                List<NativeAd.Image> images = nativeContentAd.getImages();
                if (images.size() > 0) {
                    ((ImageView) createContentAdView.getImageView()).setImageDrawable(images.get(0).getDrawable());
                }
                NativeAd.Image logo = nativeContentAd.getLogo();
                if (logo != null) {
                    ((ImageView) createContentAdView.getLogoView()).setImageDrawable(logo.getDrawable());
                    createContentAdView.getLogoView().setVisibility(0);
                } else {
                    createContentAdView.getLogoView().setVisibility(4);
                }
                createContentAdView.setNativeAd(nativeContentAd);
                if (AdmobNativeAdvancedAdProvider.this.getAd() != null) {
                    AdmobNativeAdvancedAdProvider.this.getAd().setNativeAdView(createContentAdView);
                }
            }
        });
        builder.a(new NativeAdOptions.Builder().a(new VideoOptions.Builder().a(true).a()).a());
        builder.a(this).a().a(newAdRequest());
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        if (!isReady() || this.isShowAds) {
            return;
        }
        new AdmobAdViewFragment().show(appCompatActivity.getSupportFragmentManager(), i, i2).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AdmobNativeAdvancedAdProvider.this.isShowAds = false;
            }
        });
        this.isShowAds = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public AdmobNativeAdContainer onCreateAd() {
        AdmobNativeAdContainer admobNativeAdContainer = new AdmobNativeAdContainer(getContext());
        admobNativeAdContainer.setAdListener(this);
        return admobNativeAdContainer;
    }
}
