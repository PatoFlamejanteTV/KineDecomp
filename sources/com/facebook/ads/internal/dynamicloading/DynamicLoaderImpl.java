package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdChoicesViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.api.NativeAdViewApi;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;
import com.facebook.ads.internal.api.NativeComponentTagApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.redexgen.X.AnonymousClass89;
import com.facebook.ads.redexgen.X.AnonymousClass90;
import com.facebook.ads.redexgen.X.AnonymousClass93;
import com.facebook.ads.redexgen.X.AnonymousClass96;
import com.facebook.ads.redexgen.X.C01937n;
import com.facebook.ads.redexgen.X.C01997u;
import com.facebook.ads.redexgen.X.C02027x;
import com.facebook.ads.redexgen.X.C02047z;
import com.facebook.ads.redexgen.X.C02148j;
import com.facebook.ads.redexgen.X.C02298y;
import com.facebook.ads.redexgen.X.C0443Hg;
import com.facebook.ads.redexgen.X.C0444Hh;
import com.facebook.ads.redexgen.X.C0454Hs;
import com.facebook.ads.redexgen.X.C8J;
import com.facebook.ads.redexgen.X.C8M;
import com.facebook.ads.redexgen.X.C8N;
import com.facebook.ads.redexgen.X.C8X;
import com.facebook.ads.redexgen.X.C8Y;
import com.facebook.ads.redexgen.X.C9J;
import com.facebook.ads.redexgen.X.EnumC0457Hw;
import com.facebook.ads.redexgen.X.G2;
import com.facebook.ads.redexgen.X.HH;
import com.facebook.ads.redexgen.X.HX;
import com.facebook.ads.redexgen.X.HY;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public class DynamicLoaderImpl implements DynamicLoader {
    public static AdSettingsApi A00;
    public static AudienceNetworkAdsApi A01;
    public static BidderTokenProviderApi A02;
    public static NativeAdViewApi A03;
    public static NativeBannerAdViewApi A04;
    public static final InitApi A05 = new InitApi() { // from class: com.facebook.ads.redexgen.X.8O
        public final void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
            G2.A0G(C8N.A07(context), multithreadedBundleWrapper, initListener, i);
        }

        public final boolean isInitialized() {
            return G2.A0I();
        }

        public final void maybeAttachCrashListener(Context context) {
            G2.A07(C8N.A07(context));
        }

        public final void onAdEventManagerCreated(Context context) {
            G2.A08(C8N.A07(context));
        }

        public final void onAdLoadInvoked(Context context) {
            G2.A09(C8N.A07(context));
        }

        public final void onContentProviderCreated(Context context) {
            G2.A0A(C8N.A07(context));
        }
    };

    public AdChoicesViewApi createAdChoicesViewApi(AdChoicesView adChoicesView, Context context, NativeAdBase nativeAdBase) {
        return new C01997u(adChoicesView, context, nativeAdBase);
    }

    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        return new C02027x(context, nativeAdBase, nativeAdLayout, orientation, i, adOptionsView);
    }

    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        return new C02027x(context, nativeAdBase, nativeAdLayout, adOptionsView);
    }

    public AdSettingsApi createAdSettingsApi() {
        if (A00 == null) {
            A00 = new AdSettingsApi() { // from class: com.facebook.ads.redexgen.X.7y
                public static byte[] A00;
                public static final String A01;
                public static final Collection<String> A02;
                public static volatile boolean A03;

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public static java.lang.String A00(int r2, int r3, int r4) {
                    /*
                        r0 = 0
                        r0 = 0
                        byte[] r1 = com.facebook.ads.redexgen.X.C02037y.A00
                        int r0 = r2 + r3
                        byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
                        r1 = 0
                        r0 = 2
                    Lc:
                        switch(r0) {
                            case 2: goto L10;
                            case 3: goto L19;
                            case 4: goto L27;
                            default: goto Lf;
                        }
                    Lf:
                        goto Lc
                    L10:
                        byte[] r2 = (byte[]) r2
                        int r0 = r2.length
                        if (r1 >= r0) goto L17
                        r0 = 3
                        goto Lc
                    L17:
                        r0 = 4
                        goto Lc
                    L19:
                        byte[] r2 = (byte[]) r2
                        r0 = r2[r1]
                        int r0 = r0 - r4
                        int r0 = r0 + (-8)
                        byte r0 = (byte) r0
                        r2[r1] = r0
                        int r1 = r1 + 1
                        r0 = 2
                        goto Lc
                    L27:
                        byte[] r2 = (byte[]) r2
                        java.lang.String r0 = new java.lang.String
                        r0.<init>(r2)
                        java.lang.String r0 = (java.lang.String) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02037y.A00(int, int, int):java.lang.String");
                }

                public static void A01() {
                    A00 = new byte[]{-20, -12, -12, -20, -15, -22, -28, -8, -23, -16, -89, -72, -58, -57, 115, -64, -62, -73, -72, 115, -73, -72, -55, -68, -74, -72, 115, -69, -76, -58, -69, -115, 115, -10, -25, -18, -106, -105, -88, -101, -107, -105, 123, -106, 122, -109, -91, -102, -55, -54, -56, -43, -70, -69, -52, -65, -71, -69, -43, -65, -70, -43, -66, -73, -55, -66, -43, -63, -69, -49, 110, 106, 105, -116, 120, -102, -115, -114, -101, 102, 109, Byte.MAX_VALUE, -110, 126, -117, -108, 84, 82, -116, -50, -33, -36, -27, -105, -21, -36, -22, -21, -32, -27, -34, -105, -16, -26, -20, -23, -105, -40, -25, -25, -105, -18, -32, -21, -33, -105, -67, -40, -38, -36, -39, -26, -26, -30, -98, -22, -105, -40, -37, -105, -20, -27, -32, -21, -22, -105, -16, -26, -20, -105, -28, -20, -22, -21, -105, -22, -25, -36, -38, -32, -35, -16, -105, -21, -33, -36, -105, -37, -36, -19, -32, -38, -36, -105, -33, -40, -22, -33, -36, -37, -105, -64, -69, -105, -21, -26, -105, -36, -27, -22, -20, -23, -36, -105, -21, -33, -36, -105, -37, -36, -29, -32, -19, -36, -23, -16, -105, -26, -35, -105, -21, -36, -22, -21, -105, -40, -37, -22, -93, -105, -40, -37, -37, -105, -21, -33, -36, -105, -35, -26, -29, -29, -26, -18, -32, -27, -34, -105, -38, -26, -37, -36, -105, -39, -36, -35, -26, -23, -36, -105, -29, -26, -40, -37, -32, -27, -34, -105, -40, -27, -105, -40, -37, -79, -105, -72, -37, -54, -36, -21, -21, -32, -27, -34, -22, -91, -40, -37, -37, -53, -36, -22, -21, -69, -36, -19, -32, -38, -36, -97, -103, -39, -59, -46, -37, -101, -103, -41, -45};
                }

                static {
                    A01();
                    A01 = AdInternalSettings.class.getSimpleName();
                    A02 = new HashSet();
                    A02.add(A00(33, 3, 123));
                    A02.add(A00(0, 10, 125));
                    A02.add(A00(82, 7, 20));
                    A02.add(A00(281, 8, 91));
                    A03 = false;
                }

                public static void A02(String str) {
                    if (A03) {
                        return;
                    }
                    A03 = true;
                    Log.i(A01, A00(10, 23, 75) + str);
                    Log.i(A01, A00(89, 192, 111) + str + A00(79, 3, 60));
                }

                /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:            return r8;     */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean isTestMode(android.content.Context r10) {
                    /*
                        r9 = this;
                        r6 = 0
                        r0 = 0
                        r7 = 0
                        r0 = 0
                        r0 = 0
                        r5 = 0
                        r8 = 1
                        r4 = 0
                        boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebugBuild()
                        if (r0 != 0) goto Lc4
                        r0 = 2
                    Lf:
                        switch(r0) {
                            case 2: goto L41;
                            case 3: goto L63;
                            case 4: goto Lc7;
                            case 5: goto L4b;
                            case 6: goto L13;
                            case 7: goto L85;
                            case 8: goto L71;
                            case 9: goto La8;
                            case 10: goto Lbb;
                            default: goto L12;
                        }
                    L12:
                        goto Lf
                    L13:
                        android.content.Context r10 = (android.content.Context) r10
                        r4 = 0
                        r2 = 70
                        r1 = 9
                        r0 = 32
                        java.lang.String r0 = A00(r2, r1, r0)
                        java.lang.String r0 = com.facebook.ads.internal.util.process.ProcessUtils.getProcessSpecificName(r0, r10)
                        android.content.SharedPreferences r6 = r10.getSharedPreferences(r0, r4)
                        r2 = 36
                        r1 = 12
                        r0 = 42
                        java.lang.String r0 = A00(r2, r1, r0)
                        java.lang.String r7 = r6.getString(r0, r5)
                        boolean r0 = android.text.TextUtils.isEmpty(r7)
                        if (r0 == 0) goto L3e
                        r0 = 7
                        goto Lf
                    L3e:
                        r0 = 8
                        goto Lf
                    L41:
                        boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isExplicitTestMode()
                        if (r0 != 0) goto L49
                        r0 = 3
                        goto Lf
                    L49:
                        r0 = 4
                        goto Lf
                    L4b:
                        r5 = 0
                        com.facebook.ads.internal.settings.MultithreadedBundleWrapper r3 = com.facebook.ads.internal.settings.AdInternalSettings.sSettingsBundle
                        r2 = 48
                        r1 = 22
                        r0 = 110(0x6e, float:1.54E-43)
                        java.lang.String r0 = A00(r2, r1, r0)
                        java.lang.String r7 = r3.getString(r0, r5)
                        if (r7 != 0) goto L60
                        r0 = 6
                        goto Lf
                    L60:
                        r0 = 9
                        goto Lf
                    L63:
                        java.util.Collection<java.lang.String> r1 = com.facebook.ads.redexgen.X.C02037y.A02
                        java.lang.String r0 = android.os.Build.PRODUCT
                        boolean r0 = r1.contains(r0)
                        if (r0 == 0) goto L6f
                        r0 = 4
                        goto Lf
                    L6f:
                        r0 = 5
                        goto Lf
                    L71:
                        java.lang.String r7 = (java.lang.String) r7
                        com.facebook.ads.internal.settings.MultithreadedBundleWrapper r3 = com.facebook.ads.internal.settings.AdInternalSettings.sSettingsBundle
                        r2 = 48
                        r1 = 22
                        r0 = 110(0x6e, float:1.54E-43)
                        java.lang.String r0 = A00(r2, r1, r0)
                        r3.putString(r0, r7)
                        r0 = 9
                        goto Lf
                    L85:
                        android.content.SharedPreferences r6 = (android.content.SharedPreferences) r6
                        java.util.UUID r0 = java.util.UUID.randomUUID()
                        java.lang.String r7 = r0.toString()
                        android.content.SharedPreferences$Editor r3 = r6.edit()
                        r2 = 36
                        r1 = 12
                        r0 = 42
                        java.lang.String r0 = A00(r2, r1, r0)
                        android.content.SharedPreferences$Editor r0 = r3.putString(r0, r7)
                        r0.apply()
                        r0 = 8
                        goto Lf
                    La8:
                        java.lang.String r7 = (java.lang.String) r7
                        java.util.ArrayList r0 = com.facebook.ads.internal.settings.AdInternalSettings.getTestDevicesList()
                        boolean r0 = r0.contains(r7)
                        if (r0 != 0) goto Lb8
                        r0 = 10
                        goto Lf
                    Lb8:
                        r0 = 4
                        goto Lf
                    Lbb:
                        java.lang.String r7 = (java.lang.String) r7
                        A02(r7)
                        r8 = r4
                        r0 = 4
                        goto Lf
                    Lc4:
                        r0 = 4
                        goto Lf
                    Lc7:
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02037y.isTestMode(android.content.Context):boolean");
                }

                public final void turnOnDebugger() {
                    I5.A02();
                }
            };
        }
        return A00;
    }

    public AdSizeApi createAdSizeApi(int i) {
        return EnumC0457Hw.A00(i);
    }

    public AdViewApi createAdViewApi(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        return (AdViewApi) C01937n.A00(new C02047z(context, str, adSize, adViewParentApi, adView), AdViewApi.class);
    }

    public AdViewApi createAdViewApi(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws Exception {
        try {
            return (AdViewApi) C01937n.A00(new C02047z(context, str, str2, adViewParentApi, adView), AdViewApi.class);
        } catch (C0454Hs e) {
            throw new Exception(e.A01());
        }
    }

    public AudienceNetworkActivityApi createAudienceNetworkActivity(final AudienceNetworkActivity audienceNetworkActivity, final AudienceNetworkActivityApi audienceNetworkActivityApi) {
        final AnonymousClass89 anonymousClass89 = new AnonymousClass89(audienceNetworkActivity, audienceNetworkActivityApi);
        return new AudienceNetworkActivityApi(audienceNetworkActivity, audienceNetworkActivityApi, anonymousClass89) { // from class: com.facebook.ads.redexgen.X.8A
            public static byte[] A04;
            public boolean A00;
            public final AudienceNetworkActivity A01;
            public final AudienceNetworkActivityApi A02;
            public final AnonymousClass89 A03;

            static {
                A01();
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String A00(int r2, int r3, int r4) {
                /*
                    r0 = 0
                    r0 = 0
                    byte[] r1 = com.facebook.ads.redexgen.X.C8A.A04
                    int r0 = r2 + r3
                    byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
                    r1 = 0
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L19;
                        case 4: goto L27;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    byte[] r2 = (byte[]) r2
                    int r0 = r2.length
                    if (r1 >= r0) goto L17
                    r0 = 3
                    goto Lc
                L17:
                    r0 = 4
                    goto Lc
                L19:
                    byte[] r2 = (byte[]) r2
                    r0 = r2[r1]
                    int r0 = r0 - r4
                    int r0 = r0 + (-73)
                    byte r0 = (byte) r0
                    r2[r1] = r0
                    int r1 = r1 + 1
                    r0 = 2
                    goto Lc
                L27:
                    byte[] r2 = (byte[]) r2
                    java.lang.String r0 = new java.lang.String
                    r0.<init>(r2)
                    java.lang.String r0 = (java.lang.String) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8A.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A04 = new byte[]{-64, -68, -69, -17, -34, -29, -33, -24, -35, -33, -56, -33, -18, -15, -23, -20, -27, -4, 9, -6, -4, -2, 15, 4, 17, 4, 15, 20, -32, -7, -16, 3, -5, -16, -18, -1, -16, -17, -85, -16, 3, -18, -16, -5, -1, -12, -6, -7, -71};
            }

            {
                this.A01 = audienceNetworkActivity;
                this.A02 = audienceNetworkActivityApi;
                this.A03 = anonymousClass89;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void A02(java.lang.Throwable r7) {
                /*
                    r6 = this;
                    r4 = r6
                    r5 = 0
                    r0 = 1
                    r4.A00 = r0
                    r4.finish()
                    com.facebook.ads.redexgen.X.89 r0 = r4.A03
                    if (r0 == 0) goto L61
                    r0 = 2
                Ld:
                    switch(r0) {
                        case 2: goto L51;
                        case 3: goto L49;
                        case 4: goto L2b;
                        case 5: goto L63;
                        case 6: goto L11;
                        case 7: goto L5b;
                        default: goto L10;
                    }
                L10:
                    goto Ld
                L11:
                    java.lang.Throwable r7 = (java.lang.Throwable) r7
                    r2 = 0
                    r1 = 17
                    r0 = 49
                    java.lang.String r3 = A00(r2, r1, r0)
                    r2 = 28
                    r1 = 21
                    r0 = 66
                    java.lang.String r0 = A00(r2, r1, r0)
                    android.util.Log.e(r3, r0, r7)
                    r0 = 5
                    goto Ld
                L2b:
                    java.lang.Throwable r7 = (java.lang.Throwable) r7
                    com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
                    com.facebook.ads.redexgen.X.Kf r3 = r5.A06()
                    r2 = 17
                    r1 = 11
                    r0 = 82
                    java.lang.String r2 = A00(r2, r1, r0)
                    int r1 = com.facebook.ads.redexgen.X.C0512Kc.A04
                    com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
                    r0.<init>(r7)
                    r3.A5W(r2, r1, r0)
                    r0 = 5
                    goto Ld
                L49:
                    com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
                    if (r5 == 0) goto L4f
                    r0 = 4
                    goto Ld
                L4f:
                    r0 = 6
                    goto Ld
                L51:
                    com.facebook.ads.redexgen.X.8A r4 = (com.facebook.ads.redexgen.X.C8A) r4
                    com.facebook.ads.redexgen.X.89 r0 = r4.A03
                    com.facebook.ads.redexgen.X.Ec r5 = r0.A0I()
                    r0 = 3
                    goto Ld
                L5b:
                    com.facebook.ads.redexgen.X.Ef r5 = com.facebook.ads.redexgen.X.C0363Ed.A00()
                    r0 = 3
                    goto Ld
                L61:
                    r0 = 7
                    goto Ld
                L63:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8A.A02(java.lang.Throwable):void");
            }

            public final void finish() {
                this.A03.finish();
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onBackPressed() {
                try {
                    if (!this.A00) {
                        this.A03.onBackPressed();
                    }
                } catch (Throwable th) {
                    A02(th);
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onConfigurationChanged(Configuration configuration) {
                C8A c8a = this;
                char c = 2;
                while (true) {
                    switch (c) {
                        case 2:
                            try {
                                c8a = c8a;
                                if (!c8a.A00) {
                                    c = 6;
                                    break;
                                } else {
                                    c = 4;
                                    break;
                                }
                            } catch (Throwable th) {
                                c8a.A02(th);
                                c8a.A02.onConfigurationChanged(configuration);
                                return;
                            }
                        case 4:
                            c8a.A02.onConfigurationChanged(configuration);
                            return;
                        case 6:
                            c8a = c8a;
                            c8a.A03.onConfigurationChanged(configuration);
                            break;
                    }
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onCreate(Bundle bundle) {
                this.A02.onCreate(bundle);
                try {
                    this.A03.onCreate(bundle);
                } catch (Throwable th) {
                    A02(th);
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onDestroy() {
                C8A c8a = this;
                char c = 2;
                while (true) {
                    switch (c) {
                        case 2:
                            try {
                                c8a = c8a;
                                if (!c8a.A00) {
                                    c = 6;
                                    break;
                                } else {
                                    c = 4;
                                    break;
                                }
                            } catch (Throwable th) {
                                c8a.A02(th);
                                c8a.A02.onDestroy();
                                return;
                            }
                        case 4:
                            c8a.A02.onDestroy();
                            return;
                        case 6:
                            c8a = c8a;
                            c8a.A03.onDestroy();
                            break;
                    }
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onPause() {
                C8A c8a = this;
                char c = 2;
                while (true) {
                    switch (c) {
                        case 2:
                            try {
                                c8a = c8a;
                                if (!c8a.A00) {
                                    c = 6;
                                    break;
                                } else {
                                    c = 4;
                                    break;
                                }
                            } catch (Throwable th) {
                                c8a.A02(th);
                                c8a.A02.onPause();
                                return;
                            }
                        case 4:
                            c8a.A02.onPause();
                            return;
                        case 6:
                            c8a = c8a;
                            c8a.A03.onPause();
                            break;
                    }
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onResume() {
                this.A02.onResume();
                try {
                    if (!this.A00) {
                        this.A03.onResume();
                    }
                } catch (Throwable th) {
                    A02(th);
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onSaveInstanceState(Bundle bundle) {
                this.A02.onSaveInstanceState(bundle);
                try {
                    if (!this.A00) {
                        this.A03.onSaveInstanceState(bundle);
                    }
                } catch (Throwable th) {
                    A02(th);
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onStart() {
                this.A02.onStart();
                try {
                    if (!this.A00) {
                        this.A03.onStart();
                    }
                } catch (Throwable th) {
                    A02(th);
                }
            }

            @SuppressLint({"CatchGeneralException"})
            public final void onStop() {
                this.A02.onStop();
                try {
                    if (!this.A00) {
                        this.A03.onStop();
                    }
                } catch (Throwable th) {
                    A02(th);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:            return r1;     */
            @android.annotation.SuppressLint({"CatchGeneralException"})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean onTouchEvent(android.view.MotionEvent r4) {
                /*
                    r3 = this;
                    r2 = r3
                    r1 = 0
                    r0 = 2
                L3:
                    switch(r0) {
                        case 2: goto L1a;
                        case 4: goto Lf;
                        case 7: goto L7;
                        case 11: goto L31;
                        default: goto L6;
                    }
                L6:
                    goto L3
                L7:
                    com.facebook.ads.redexgen.X.8A r2 = (com.facebook.ads.redexgen.X.C8A) r2     // Catch: java.lang.Throwable -> L24
                    com.facebook.ads.redexgen.X.89 r0 = r2.A03     // Catch: java.lang.Throwable -> L24
                    r0.onTouchEvent(r4)     // Catch: java.lang.Throwable -> L24
                    goto L28
                Lf:
                    com.facebook.ads.redexgen.X.8A r2 = (com.facebook.ads.redexgen.X.C8A) r2     // Catch: java.lang.Throwable -> L24
                    com.facebook.ads.internal.api.AudienceNetworkActivityApi r0 = r2.A02     // Catch: java.lang.Throwable -> L24
                    boolean r1 = r0.onTouchEvent(r4)     // Catch: java.lang.Throwable -> L24
                    r0 = 11
                    goto L3
                L1a:
                    com.facebook.ads.redexgen.X.8A r2 = (com.facebook.ads.redexgen.X.C8A) r2     // Catch: java.lang.Throwable -> L24
                    boolean r0 = r2.A00     // Catch: java.lang.Throwable -> L24
                    if (r0 == 0) goto L22
                    r0 = 4
                    goto L3
                L22:
                    r0 = 7
                    goto L3
                L24:
                    r0 = move-exception
                    r2.A02(r0)
                L28:
                    com.facebook.ads.internal.api.AudienceNetworkActivityApi r0 = r2.A02
                    boolean r1 = r0.onTouchEvent(r4)
                    r0 = 11
                    goto L3
                L31:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8A.onTouchEvent(android.view.MotionEvent):boolean");
            }
        };
    }

    public AudienceNetworkAdsApi createAudienceNetworkAdsApi() {
        if (A01 == null) {
            A01 = new AudienceNetworkAdsApi() { // from class: com.facebook.ads.redexgen.X.8C
                public final int getAdFormatForPlacement(String str) {
                    return GT.A00(str).intValue();
                }

                public final void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener) {
                    if (initListener == null) {
                        initListener = new AudienceNetworkAds.InitListener() { // from class: com.facebook.ads.redexgen.X.8B
                            public final void onInitialized(AudienceNetworkAds.InitResult initResult) {
                            }
                        };
                    }
                    DynamicLoaderFactory.makeLoader(context).getInitApi().initialize(context, multithreadedBundleWrapper, initListener, 1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return r2;     */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean isInitialized() {
                    /*
                        r3 = this;
                        r0 = 0
                        r2 = 0
                        com.facebook.ads.internal.dynamicloading.DynamicLoader r1 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.getDynamicLoader()
                        if (r1 != 0) goto L1c
                        r0 = 2
                    L9:
                        switch(r0) {
                            case 2: goto Ld;
                            case 3: goto L1e;
                            case 4: goto L10;
                            default: goto Lc;
                        }
                    Lc:
                        goto L9
                    Ld:
                        r2 = 0
                        r0 = 3
                        goto L9
                    L10:
                        com.facebook.ads.internal.dynamicloading.DynamicLoader r1 = (com.facebook.ads.internal.dynamicloading.DynamicLoader) r1
                        com.facebook.ads.internal.api.InitApi r0 = r1.getInitApi()
                        boolean r2 = r0.isInitialized()
                        r0 = 3
                        goto L9
                    L1c:
                        r0 = 4
                        goto L9
                    L1e:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8C.isInitialized():boolean");
                }

                public final void onContentProviderCreated(Context context) {
                    DynamicLoaderFactory.makeLoader(context).getInitApi().onContentProviderCreated(context);
                }
            };
        }
        return A01;
    }

    public BidderTokenProviderApi createBidderTokenProviderApi() {
        if (A02 == null) {
            A02 = new C8M();
        }
        return A02;
    }

    public DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi() {
        return new HH();
    }

    public InstreamVideoAdViewApi createInstreamVideoAdViewApi(InstreamVideoAdView instreamVideoAdView, Context context, Bundle bundle) {
        return (InstreamVideoAdViewApi) C01937n.A00(new C8X(instreamVideoAdView, context, bundle), InstreamVideoAdViewApi.class);
    }

    public InstreamVideoAdViewApi createInstreamVideoAdViewApi(InstreamVideoAdView instreamVideoAdView, Context context, String str, AdSize adSize) {
        return (InstreamVideoAdViewApi) C01937n.A00(new C8X(instreamVideoAdView, context, str, adSize), InstreamVideoAdViewApi.class);
    }

    public InterstitialAdApi createInterstitialAd(Context context, String str, InterstitialAd interstitialAd) {
        return (InterstitialAdApi) C01937n.A00(new C8Y(context, str, interstitialAd), InterstitialAdApi.class);
    }

    public MediaViewApi createMediaViewApi() {
        return new C02148j();
    }

    public MediaViewVideoRendererApi createMediaViewVideoRendererApi() {
        return new C02298y();
    }

    public AnonymousClass90 createNativeAdApi(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new AnonymousClass90(nativeAd, nativeAdBaseApi);
    }

    public AnonymousClass90 createNativeAdApi(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new AnonymousClass90(nativeAdBase, nativeAd, nativeAdBaseApi);
    }

    public NativeAdBaseApi createNativeAdBaseApi(Context context, String str) {
        return new HX(context, str, HX.A0I(), false);
    }

    public NativeAdBaseApi createNativeAdBaseApi(NativeAdBaseApi nativeAdBaseApi) {
        return new HX((HX) nativeAdBaseApi);
    }

    public NativeAdBase createNativeAdBaseFromBidPayload(Context context, String str, String str2) throws Exception {
        try {
            return HX.A0A(context, str, str2);
        } catch (C0454Hs e) {
            throw new Exception(e.A01());
        }
    }

    @Nullable
    public NativeAdImageApi createNativeAdImageApi(JSONObject jSONObject) {
        return HY.A00(jSONObject);
    }

    public NativeAdLayoutApi createNativeAdLayoutApi() {
        return new C8J();
    }

    @Nullable
    public C0443Hg createNativeAdRatingApi(JSONObject jSONObject) {
        return C0443Hg.A00(jSONObject);
    }

    public NativeAdScrollViewApi createNativeAdScrollViewApi(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, @Nullable NativeAdScrollView.AdViewProvider adViewProvider, int i, @Nullable NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        return new AnonymousClass93(nativeAdScrollView, context, nativeAdsManager, adViewProvider, i, type, nativeAdViewAttributes, i2);
    }

    public NativeAdViewApi createNativeAdViewApi() {
        if (A03 == null) {
            A03 = new NativeAdViewApi() { // from class: com.facebook.ads.redexgen.X.94
                public static View A00(C0362Ec c0362Ec, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    C0444Hh c0444Hh = (C0444Hh) nativeAdViewAttributes.getInternalAttributes();
                    HX A0J = HX.A0J(nativeAd.getInternalNativeAd());
                    A0J.A1N(EnumC0445Hi.A00(type.getEnumCode()));
                    A0J.A1M(c0444Hh);
                    C02308z c02308z = new C02308z();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c0362Ec, c02308z);
                    c02308z.A05(nativeAdLayout, c0362Ec, nativeAd, c0444Hh);
                    nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (KE.A01 * type.getHeight())));
                    return nativeAdLayout;
                }

                public static View A01(C0362Ec c0362Ec, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    HX A0J = HX.A0J(nativeAd.getInternalNativeAd());
                    C0444Hh c0444Hh = (C0444Hh) nativeAdViewAttributes.getInternalAttributes();
                    A0J.A1N(EnumC0445Hi.A0B);
                    A0J.A1M(c0444Hh);
                    C02308z c02308z = new C02308z();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c0362Ec, c02308z);
                    c02308z.A05(nativeAdLayout, c0362Ec, nativeAd, c0444Hh);
                    return nativeAdLayout;
                }

                public final View render(Context context, NativeAd nativeAd) {
                    return render(context, nativeAd, (NativeAdViewAttributes) null);
                }

                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
                    return render(context, nativeAd, type, null);
                }

                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(C8N.A02(context), nativeAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return C0540Le.A00(C8N.A02(context), th);
                    }
                }

                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A01(C8N.A02(context), nativeAd, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return C0540Le.A00(C8N.A02(context), th);
                    }
                }
            };
        }
        return A03;
    }

    public NativeAdViewAttributesApi createNativeAdViewAttributesApi() {
        return new C0444Hh();
    }

    public NativeAdViewTypeApi createNativeAdViewTypeApi(final int i) {
        return new NativeAdViewTypeApi(i) { // from class: com.facebook.ads.redexgen.X.95
            public final EnumC0445Hi A00;

            {
                this.A00 = EnumC0445Hi.A00(i);
            }

            public final int getHeight() {
                return this.A00.A03();
            }

            public final int getValue() {
                return this.A00.A04();
            }

            public final int getWidth() {
                return this.A00.A05();
            }
        };
    }

    public NativeAdsManagerApi createNativeAdsManagerApi(Context context, String str, int i) {
        return (NativeAdsManagerApi) C01937n.A00(new AnonymousClass96(context, str, i), NativeAdsManagerApi.class);
    }

    public NativeBannerAdApi createNativeBannerAdApi(NativeBannerAd nativeBannerAd, final NativeAdBaseApi nativeAdBaseApi) {
        return new NativeBannerAdApi(nativeAdBaseApi) { // from class: com.facebook.ads.redexgen.X.9G
            public static byte[] A01;
            public final HX A00;

            static {
                A01();
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String A00(int r2, int r3, int r4) {
                /*
                    r0 = 0
                    r0 = 0
                    byte[] r1 = com.facebook.ads.redexgen.X.C9G.A01
                    int r0 = r2 + r3
                    byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
                    r1 = 0
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L19;
                        case 4: goto L27;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    byte[] r2 = (byte[]) r2
                    int r0 = r2.length
                    if (r1 >= r0) goto L17
                    r0 = 3
                    goto Lc
                L17:
                    r0 = 4
                    goto Lc
                L19:
                    byte[] r2 = (byte[]) r2
                    r0 = r2[r1]
                    r0 = r0 ^ r4
                    r0 = r0 ^ 39
                    byte r0 = (byte) r0
                    r2[r1] = r0
                    int r1 = r1 + 1
                    r0 = 2
                    goto Lc
                L27:
                    byte[] r2 = (byte[]) r2
                    java.lang.String r0 = new java.lang.String
                    r0.<init>(r2)
                    java.lang.String r0 = (java.lang.String) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9G.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A01 = new byte[]{70, 66, 65, 117, 100, 105, 101, 110, 99, 101, 78, 101, 116, 119, 111, 114, 107};
            }

            {
                this.A00 = HX.A0J(nativeAdBaseApi);
                this.A00.A1O(EnumC0458Hx.A05);
            }

            /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void A02(android.widget.ImageView r17, com.facebook.ads.internal.api.NativeAdBaseApi r18) {
                /*
                    r16 = this;
                    r10 = r17
                    r11 = r16
                    r9 = 0
                    r8 = 0
                    r0 = 0
                    r0 = 0
                    r7 = 0
                    r0 = 0
                    r6 = 0
                    com.facebook.ads.redexgen.X.HX r5 = com.facebook.ads.redexgen.X.HX.A0J(r18)
                    com.facebook.ads.redexgen.X.9C r4 = new com.facebook.ads.redexgen.X.9C
                    r4.<init>()
                    com.facebook.ads.redexgen.X.HY r3 = r5.getAdIcon()
                    if (r3 == 0) goto Ld7
                    r0 = 2
                L1b:
                    switch(r0) {
                        case 2: goto L91;
                        case 3: goto L43;
                        case 4: goto Lda;
                        case 5: goto L66;
                        case 6: goto L1f;
                        case 7: goto Lb3;
                        case 8: goto Lc2;
                        default: goto L1e;
                    }
                L1e:
                    goto L1b
                L1f:
                    com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
                    com.facebook.ads.redexgen.X.HZ r8 = r5.A0z()
                    com.facebook.ads.internal.protocol.AdErrorType r9 = com.facebook.ads.internal.protocol.AdErrorType.NATIVE_AD_IS_NOT_LOADED
                    com.facebook.ads.redexgen.X.Ec r0 = r5.A0v()
                    com.facebook.ads.redexgen.X.0c r13 = r0.A08()
                    r0 = -1
                    int r12 = r9.getErrorCode()
                    java.lang.String r2 = r9.getDefaultErrorMessage()
                    r13.A2a(r0, r12, r2)
                    if (r8 == 0) goto L40
                    r0 = 7
                    goto L1b
                L40:
                    r0 = 8
                    goto L1b
                L43:
                    com.facebook.ads.redexgen.X.9G r11 = (com.facebook.ads.redexgen.X.C9G) r11
                    android.widget.ImageView r10 = (android.widget.ImageView) r10
                    com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
                    android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
                    com.facebook.ads.redexgen.X.Ec r6 = (com.facebook.ads.redexgen.X.C0362Ec) r6
                    boolean r1 = r5.A1T()
                    java.lang.String r0 = r5.A14()
                    android.graphics.drawable.Drawable r1 = com.facebook.ads.redexgen.X.HX.A05(r6, r7, r1, r0)
                    com.facebook.ads.redexgen.X.HX.A0Y(r1, r10)
                    com.facebook.ads.redexgen.X.9D r0 = new com.facebook.ads.redexgen.X.9D
                    r0.<init>()
                    r10.post(r0)
                    r0 = 4
                    goto L1b
                L66:
                    com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
                    com.facebook.ads.redexgen.X.9C r4 = (com.facebook.ads.redexgen.X.C9C) r4
                    com.facebook.ads.redexgen.X.HY r3 = (com.facebook.ads.redexgen.X.HY) r3
                    com.facebook.ads.redexgen.X.Ec r6 = (com.facebook.ads.redexgen.X.C0362Ec) r6
                    com.facebook.ads.redexgen.X.9E r15 = new com.facebook.ads.redexgen.X.9E
                    boolean r1 = r5.A1T()
                    r0 = 0
                    r15.<init>(r6, r4, r1, r0)
                    r0 = 1
                    com.facebook.ads.redexgen.X.9F[] r14 = new com.facebook.ads.redexgen.X.C9F[r0]
                    r13 = 0
                    com.facebook.ads.redexgen.X.9F r12 = new com.facebook.ads.redexgen.X.9F
                    java.lang.String r2 = r3.getUrl()
                    java.lang.String r1 = r5.A14()
                    r0 = 0
                    r12.<init>(r2, r1, r0)
                    r14[r13] = r12
                    r15.execute(r14)
                    r0 = 4
                    goto L1b
                L91:
                    android.widget.ImageView r10 = (android.widget.ImageView) r10
                    com.facebook.ads.redexgen.X.HX r5 = (com.facebook.ads.redexgen.X.HX) r5
                    com.facebook.ads.redexgen.X.HY r3 = (com.facebook.ads.redexgen.X.HY) r3
                    com.facebook.ads.redexgen.X.EV r1 = r5.A0u()
                    java.lang.String r0 = r3.getUrl()
                    android.graphics.Bitmap r7 = r1.A0H(r0)
                    android.content.Context r0 = r10.getContext()
                    com.facebook.ads.redexgen.X.Ec r6 = com.facebook.ads.redexgen.X.C8N.A02(r0)
                    if (r7 == 0) goto Lb0
                    r0 = 3
                    goto L1b
                Lb0:
                    r0 = 5
                    goto L1b
                Lb3:
                    com.facebook.ads.redexgen.X.HZ r8 = (com.facebook.ads.redexgen.X.HZ) r8
                    com.facebook.ads.internal.protocol.AdErrorType r9 = (com.facebook.ads.internal.protocol.AdErrorType) r9
                    com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A01(r9)
                    r8.A6Y(r0)
                    r0 = 8
                    goto L1b
                Lc2:
                    com.facebook.ads.internal.protocol.AdErrorType r9 = (com.facebook.ads.internal.protocol.AdErrorType) r9
                    r2 = 0
                    r1 = 17
                    r0 = 39
                    java.lang.String r1 = A00(r2, r1, r0)
                    java.lang.String r0 = r9.getDefaultErrorMessage()
                    android.util.Log.e(r1, r0)
                    r0 = 4
                    goto L1b
                Ld7:
                    r0 = 6
                    goto L1b
                Lda:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9G.A02(android.widget.ImageView, com.facebook.ads.internal.api.NativeAdBaseApi):void");
            }

            public final void registerViewForInteraction(View view, ImageView imageView) {
                registerViewForInteraction(view, imageView, (List<View>) null);
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void registerViewForInteraction(android.view.View r3, android.widget.ImageView r4, @android.support.annotation.Nullable java.util.List<android.view.View> r5) {
                /*
                    r2 = this;
                    r1 = r2
                    if (r4 == 0) goto L37
                    r0 = 2
                L4:
                    switch(r0) {
                        case 2: goto L8;
                        case 3: goto L13;
                        case 4: goto L1b;
                        case 5: goto L39;
                        case 6: goto L2a;
                        default: goto L7;
                    }
                L7:
                    goto L4
                L8:
                    com.facebook.ads.redexgen.X.9G r1 = (com.facebook.ads.redexgen.X.C9G) r1
                    android.widget.ImageView r4 = (android.widget.ImageView) r4
                    com.facebook.ads.redexgen.X.HX r0 = r1.A00
                    r1.A02(r4, r0)
                    r0 = 3
                    goto L4
                L13:
                    java.util.List r5 = (java.util.List) r5
                    if (r5 == 0) goto L19
                    r0 = 4
                    goto L4
                L19:
                    r0 = 6
                    goto L4
                L1b:
                    com.facebook.ads.redexgen.X.9G r1 = (com.facebook.ads.redexgen.X.C9G) r1
                    android.view.View r3 = (android.view.View) r3
                    android.widget.ImageView r4 = (android.widget.ImageView) r4
                    java.util.List r5 = (java.util.List) r5
                    com.facebook.ads.redexgen.X.HX r0 = r1.A00
                    r0.A1E(r3, r4, r5)
                    r0 = 5
                    goto L4
                L2a:
                    com.facebook.ads.redexgen.X.9G r1 = (com.facebook.ads.redexgen.X.C9G) r1
                    android.view.View r3 = (android.view.View) r3
                    android.widget.ImageView r4 = (android.widget.ImageView) r4
                    com.facebook.ads.redexgen.X.HX r0 = r1.A00
                    r0.A1D(r3, r4)
                    r0 = 5
                    goto L4
                L37:
                    r0 = 3
                    goto L4
                L39:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9G.registerViewForInteraction(android.view.View, android.widget.ImageView, java.util.List):void");
            }

            public final void registerViewForInteraction(View view, MediaView mediaView) {
                registerViewForInteraction(view, mediaView, (List<View>) null);
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void registerViewForInteraction(android.view.View r5, com.facebook.ads.MediaView r6, @android.support.annotation.Nullable java.util.List<android.view.View> r7) {
                /*
                    r4 = this;
                    r3 = r4
                    if (r6 == 0) goto L3e
                    r0 = 2
                L4:
                    switch(r0) {
                        case 2: goto L8;
                        case 3: goto L1a;
                        case 4: goto L22;
                        case 5: goto L40;
                        case 6: goto L31;
                        default: goto L7;
                    }
                L7:
                    goto L4
                L8:
                    com.facebook.ads.redexgen.X.9G r3 = (com.facebook.ads.redexgen.X.C9G) r3
                    com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
                    com.facebook.ads.internal.api.MediaViewApi r2 = r6.getMediaViewApi()
                    com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
                    com.facebook.ads.redexgen.X.HX r1 = r3.A00
                    r0 = 1
                    r2.A0I(r1, r0)
                    r0 = 3
                    goto L4
                L1a:
                    java.util.List r7 = (java.util.List) r7
                    if (r7 == 0) goto L20
                    r0 = 4
                    goto L4
                L20:
                    r0 = 6
                    goto L4
                L22:
                    com.facebook.ads.redexgen.X.9G r3 = (com.facebook.ads.redexgen.X.C9G) r3
                    android.view.View r5 = (android.view.View) r5
                    com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
                    java.util.List r7 = (java.util.List) r7
                    com.facebook.ads.redexgen.X.HX r0 = r3.A00
                    r0.A1G(r5, r6, r7)
                    r0 = 5
                    goto L4
                L31:
                    com.facebook.ads.redexgen.X.9G r3 = (com.facebook.ads.redexgen.X.C9G) r3
                    android.view.View r5 = (android.view.View) r5
                    com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
                    com.facebook.ads.redexgen.X.HX r0 = r3.A00
                    r0.A1F(r5, r6)
                    r0 = 5
                    goto L4
                L3e:
                    r0 = 3
                    goto L4
                L40:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9G.registerViewForInteraction(android.view.View, com.facebook.ads.MediaView, java.util.List):void");
            }
        };
    }

    public NativeBannerAdViewApi createNativeBannerAdViewApi() {
        if (A04 == null) {
            A04 = new NativeBannerAdViewApi() { // from class: com.facebook.ads.redexgen.X.9H
                /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.ads.redexgen.X.8K, com.facebook.ads.internal.api.NativeAdLayoutApi] */
                public static View A00(C0362Ec c0362Ec, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    HX.A0J(nativeBannerAd.getInternalNativeAd()).A1N(EnumC0445Hi.A00(type.getEnumCode()));
                    ?? r1 = new C8J() { // from class: com.facebook.ads.redexgen.X.8K
                        public InterfaceC0650Pm A00;

                        public final void A05(C0362Ec c0362Ec2, NativeBannerAd nativeBannerAd2, C0444Hh c0444Hh, NativeAdLayout nativeAdLayout) {
                            MediaView mediaView = new MediaView(nativeAdLayout.getContext());
                            AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd2, nativeAdLayout);
                            c0444Hh.A09(adOptionsView, 20);
                            this.A00 = new C0651Pn(c0362Ec2, nativeBannerAd2, c0444Hh, HX.A0J(nativeBannerAd2.getInternalNativeAd()).A11(), mediaView, adOptionsView);
                            KE.A0P(nativeAdLayout, c0444Hh.A00());
                            nativeBannerAd2.registerViewForInteraction(nativeAdLayout, mediaView, this.A00.getViewsForInteraction());
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                            layoutParams.gravity = 17;
                            nativeAdLayout.addView(this.A00.getView(), layoutParams);
                        }

                        @Override // com.facebook.ads.redexgen.X.C02017w
                        public final void onDetachedFromWindow() {
                            super.onDetachedFromWindow();
                            this.A00.unregisterView();
                        }
                    };
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c0362Ec, (NativeAdLayoutApi) r1);
                    r1.A05(c0362Ec, nativeBannerAd, (C0444Hh) nativeAdViewAttributes.getInternalAttributes(), nativeAdLayout);
                    nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (KE.A01 * type.getHeight())));
                    return nativeAdLayout;
                }

                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type) {
                    return render(context, nativeBannerAd, type, null);
                }

                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(C8N.A02(context), nativeBannerAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return C0540Le.A00(C8N.A02(context), th);
                    }
                }
            };
        }
        return A04;
    }

    public NativeComponentTagApi createNativeComponentTagApi() {
        return new NativeComponentTagApi() { // from class: com.facebook.ads.redexgen.X.9I
            /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void tagView(android.view.View r2, com.facebook.ads.NativeAdBase.NativeComponentTag r3) {
                /*
                    r1 = this;
                    if (r2 == 0) goto L18
                    r0 = 2
                L3:
                    switch(r0) {
                        case 2: goto L7;
                        case 3: goto Lf;
                        case 4: goto L1a;
                        default: goto L6;
                    }
                L6:
                    goto L3
                L7:
                    com.facebook.ads.NativeAdBase$NativeComponentTag r3 = (com.facebook.ads.NativeAdBase.NativeComponentTag) r3
                    if (r3 == 0) goto Ld
                    r0 = 3
                    goto L3
                Ld:
                    r0 = 4
                    goto L3
                Lf:
                    android.view.View r2 = (android.view.View) r2
                    com.facebook.ads.NativeAdBase$NativeComponentTag r3 = (com.facebook.ads.NativeAdBase.NativeComponentTag) r3
                    com.facebook.ads.redexgen.X.EnumC0489Je.A03(r2, r3)
                    r0 = 4
                    goto L3
                L18:
                    r0 = 4
                    goto L3
                L1a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9I.tagView(android.view.View, com.facebook.ads.NativeAdBase$NativeComponentTag):void");
            }
        };
    }

    public RewardedVideoAdApi createRewardedVideoAd(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        return (RewardedVideoAdApi) C01937n.A00(new C9J(context, str, rewardedVideoAd), RewardedVideoAdApi.class);
    }

    public InitApi getInitApi() {
        return A05;
    }

    public void maybeInitInternally(Context context) {
        G2.A0B(C8N.A07(context));
    }
}
