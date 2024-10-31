package com.nexstreaming.kinemaster.ad.providers;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedAdProvider;
import com.umeng.analytics.pro.b;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: AdmobNativeUnifiedAdProvider.kt */
/* loaded from: classes.dex */
public final class AdmobNativeUnifiedAdProvider extends AdmobAdProvider<AdmobUnifiedAdContainer> {
    public static final Companion Companion = new Companion(null);
    private final String TAG;
    private final String UNIT_ID;
    private boolean isShowAds;

    /* compiled from: AdmobNativeUnifiedAdProvider.kt */
    /* loaded from: classes.dex */
    public static final class AdmobUnifiedAdContainer extends AdmobNativeAdvancedAdProvider.AdmobNativeAdContainer {
        private HashMap _$_findViewCache;
        private UnifiedNativeAdView nativeAdView;

        public AdmobUnifiedAdContainer(Context context) {
            this(context, null, 0, 6, null);
        }

        public AdmobUnifiedAdContainer(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdmobUnifiedAdContainer(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            h.b(context, b.Q);
        }

        public void _$_clearFindViewByIdCache() {
            HashMap hashMap = this._$_findViewCache;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public View _$_findCachedViewById(int i) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view != null) {
                return view;
            }
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }

        public final <T extends UnifiedNativeAdView> T getNativeView() {
            T t = (T) this.nativeAdView;
            if (t == null) {
                h.b("nativeAdView");
                throw null;
            }
            if (t != null) {
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }

        public final <T extends UnifiedNativeAdView> void setNativeAdView(T t) {
            h.b(t, "nativeAdView");
            removeAllViews();
            addView(t);
            this.nativeAdView = t;
        }

        public /* synthetic */ AdmobUnifiedAdContainer(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }
    }

    /* compiled from: AdmobNativeUnifiedAdProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final UnifiedNativeAdView createUnifiedAdView(Context context, UnifiedNativeAd unifiedNativeAd, int i) {
            List<NativeAd.Image> images;
            if (context == null || unifiedNativeAd == null || (images = unifiedNativeAd.getImages()) == null || images.size() == 0) {
                return null;
            }
            View inflate = View.inflate(context, i, null);
            if (inflate != null) {
                UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) inflate;
                ImageView imageView = (ImageView) unifiedNativeAdView.findViewById(R.id.app_icon);
                if (imageView != null) {
                    unifiedNativeAdView.setIconView(imageView);
                    if (unifiedNativeAd.getIcon() != null) {
                        NativeAd.Image icon = unifiedNativeAd.getIcon();
                        h.a((Object) icon, "unifiedNativeAd.icon");
                        if (icon.getDrawable() != null) {
                            View iconView = unifiedNativeAdView.getIconView();
                            if (iconView != null) {
                                NativeAd.Image icon2 = unifiedNativeAd.getIcon();
                                h.a((Object) icon2, "unifiedNativeAd.icon");
                                ((ImageView) iconView).setImageDrawable(icon2.getDrawable());
                                View iconView2 = unifiedNativeAdView.getIconView();
                                h.a((Object) iconView2, "adView.iconView");
                                iconView2.setVisibility(0);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                            }
                        }
                    }
                    View iconView3 = unifiedNativeAdView.getIconView();
                    h.a((Object) iconView3, "adView.iconView");
                    iconView3.setVisibility(8);
                }
                unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.headline_textview));
                unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
                View callToActionView = unifiedNativeAdView.getCallToActionView();
                if (callToActionView != null) {
                    ((Button) callToActionView).setText(unifiedNativeAd.getCallToAction());
                    View headlineView = unifiedNativeAdView.getHeadlineView();
                    if (headlineView != null) {
                        ((TextView) headlineView).setText(unifiedNativeAd.getHeadline());
                        unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(R.id.ad_media));
                        TextView textView = (TextView) unifiedNativeAdView.findViewById(R.id.body_text);
                        if (textView != null) {
                            unifiedNativeAdView.setBodyView(textView);
                            View bodyView = unifiedNativeAdView.getBodyView();
                            if (bodyView == null) {
                                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                            }
                            ((TextView) bodyView).setText(unifiedNativeAd.getBody());
                        }
                        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
                        return unifiedNativeAdView;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.google.android.gms.ads.formats.UnifiedNativeAdView");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdmobNativeUnifiedAdProvider(Context context, String str) {
        super(context, str);
        h.b(context, b.Q);
        h.b(str, "unitID");
        this.TAG = AdmobNativeUnifiedAdProvider.class.getSimpleName();
        this.UNIT_ID = AdmobAdProvider.TIMELINE_AD_UNIT_ID;
    }

    public static final UnifiedNativeAdView createUnifiedAdView(Context context, UnifiedNativeAd unifiedNativeAd, int i) {
        return Companion.createUnifiedAdView(context, unifiedNativeAd, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void populateUnifiedAdView(UnifiedNativeAd unifiedNativeAd, UnifiedNativeAdView unifiedNativeAdView) {
        VideoController videoController = unifiedNativeAd.getVideoController();
        h.a((Object) videoController, "vc");
        videoController.a(new VideoController.VideoLifecycleCallbacks() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider$populateUnifiedAdView$1
        });
        unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(R.id.appinstall_media));
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.appinstall_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.appinstall_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.appinstall_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.appinstall_app_icon));
        unifiedNativeAdView.setPriceView(unifiedNativeAdView.findViewById(R.id.appinstall_price));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.appinstall_stars));
        unifiedNativeAdView.setStoreView(unifiedNativeAdView.findViewById(R.id.appinstall_store));
        View headlineView = unifiedNativeAdView.getHeadlineView();
        if (!(headlineView instanceof TextView)) {
            headlineView = null;
        }
        TextView textView = (TextView) headlineView;
        if (textView != null) {
            textView.setText(unifiedNativeAd.getHeadline());
        }
        View bodyView = unifiedNativeAdView.getBodyView();
        if (!(bodyView instanceof TextView)) {
            bodyView = null;
        }
        TextView textView2 = (TextView) bodyView;
        if (textView2 != null) {
            textView2.setText(unifiedNativeAd.getBody());
        }
        View callToActionView = unifiedNativeAdView.getCallToActionView();
        if (!(callToActionView instanceof Button)) {
            callToActionView = null;
        }
        Button button = (Button) callToActionView;
        if (button != null) {
            button.setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() == null) {
            View iconView = unifiedNativeAdView.getIconView();
            h.a((Object) iconView, "adView.iconView");
            iconView.setVisibility(8);
        } else {
            View iconView2 = unifiedNativeAdView.getIconView();
            if (!(iconView2 instanceof ImageView)) {
                iconView2 = null;
            }
            ImageView imageView = (ImageView) iconView2;
            if (imageView != null) {
                NativeAd.Image icon = unifiedNativeAd.getIcon();
                h.a((Object) icon, "nativeAd.icon");
                imageView.setImageDrawable(icon.getDrawable());
            }
            View iconView3 = unifiedNativeAdView.getIconView();
            h.a((Object) iconView3, "adView.iconView");
            iconView3.setVisibility(0);
        }
        if (unifiedNativeAd.getPrice() == null) {
            View priceView = unifiedNativeAdView.getPriceView();
            h.a((Object) priceView, "adView.priceView");
            priceView.setVisibility(4);
        } else {
            View priceView2 = unifiedNativeAdView.getPriceView();
            h.a((Object) priceView2, "adView.priceView");
            priceView2.setVisibility(0);
            View priceView3 = unifiedNativeAdView.getPriceView();
            if (!(priceView3 instanceof TextView)) {
                priceView3 = null;
            }
            TextView textView3 = (TextView) priceView3;
            if (textView3 != null) {
                textView3.setText(unifiedNativeAd.getPrice());
            }
        }
        if (unifiedNativeAd.getStore() == null) {
            View storeView = unifiedNativeAdView.getStoreView();
            h.a((Object) storeView, "adView.storeView");
            storeView.setVisibility(4);
        } else {
            View storeView2 = unifiedNativeAdView.getStoreView();
            h.a((Object) storeView2, "adView.storeView");
            storeView2.setVisibility(0);
            View storeView3 = unifiedNativeAdView.getStoreView();
            if (!(storeView3 instanceof TextView)) {
                storeView3 = null;
            }
            TextView textView4 = (TextView) storeView3;
            if (textView4 != null) {
                textView4.setText(unifiedNativeAd.getStore());
            }
        }
        if (unifiedNativeAd.getStarRating() == null) {
            View starRatingView = unifiedNativeAdView.getStarRatingView();
            h.a((Object) starRatingView, "adView.starRatingView");
            starRatingView.setVisibility(4);
        } else {
            View starRatingView2 = unifiedNativeAdView.getStarRatingView();
            if (!(starRatingView2 instanceof RatingBar)) {
                starRatingView2 = null;
            }
            RatingBar ratingBar = (RatingBar) starRatingView2;
            if (ratingBar != null) {
                Double starRating = unifiedNativeAd.getStarRating();
                if (starRating == null) {
                    h.a();
                    throw null;
                }
                ratingBar.setRating((float) starRating.doubleValue());
            }
            View starRatingView3 = unifiedNativeAdView.getStarRatingView();
            h.a((Object) starRatingView3, "adView.starRatingView");
            starRatingView3.setVisibility(0);
        }
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        if (getAd() != null) {
            getAd().setNativeAdView((AdmobUnifiedAdContainer) unifiedNativeAdView);
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        String simpleName = AdmobNativeUnifiedAdProvider.class.getSimpleName();
        h.a((Object) simpleName, "AdmobNativeUnifiedAdProv…er::class.java.simpleName");
        return simpleName;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return this.isShowAds;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        AdLoader.Builder builder = new AdLoader.Builder(getContext(), this.UNIT_ID);
        builder.a(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider$onLoadAd$1
            @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
            public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                View inflate = View.inflate(AdmobNativeUnifiedAdProvider.this.getContext(), R.layout.layout_admob_native_app_unified, null);
                if (inflate != null) {
                    AdmobNativeUnifiedAdProvider admobNativeUnifiedAdProvider = AdmobNativeUnifiedAdProvider.this;
                    h.a((Object) unifiedNativeAd, "unifiedNativeAd");
                    admobNativeUnifiedAdProvider.populateUnifiedAdView(unifiedNativeAd, (UnifiedNativeAdView) inflate);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.google.android.gms.ads.formats.UnifiedNativeAdView");
            }
        });
        builder.a(new NativeAdOptions.Builder().a(new VideoOptions.Builder().a(true).a()).a());
        builder.a(this).a().a(newAdRequest());
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        h.b(appCompatActivity, "callerActivity");
        if (!isReady() || this.isShowAds) {
            return;
        }
        new AdmobNativeAdvancedAdProvider.AdmobAdViewFragment(AdmobNativeUnifiedAdProvider.class.getSimpleName()).show(appCompatActivity.getSupportFragmentManager(), i, i2).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider$showAd$1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AdmobNativeUnifiedAdProvider.this.isShowAds = false;
            }
        });
        this.isShowAds = true;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public void showDialogAd(AppCompatActivity appCompatActivity, int i, int i2) {
        h.b(appCompatActivity, "callerActivity");
        if (!isReady() || this.isShowAds) {
            return;
        }
        new AdmobNativeAdvancedAdProvider.AdmobAdViewFragment(AdmobNativeUnifiedAdProvider.class.getSimpleName()).show(appCompatActivity.getSupportFragmentManager(), i, i2).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider$showDialogAd$1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AdmobNativeUnifiedAdProvider.this.isShowAds = false;
            }
        });
        this.isShowAds = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public AdmobUnifiedAdContainer onCreateAd() {
        Context context = getContext();
        h.a((Object) context, b.Q);
        AdmobUnifiedAdContainer admobUnifiedAdContainer = new AdmobUnifiedAdContainer(context, null, 0, 6, null);
        admobUnifiedAdContainer.setAdListener(this);
        return admobUnifiedAdContainer;
    }
}
