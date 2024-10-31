package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzakx;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbho;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzas {
    public static View a(zzaxf zzaxfVar) {
        zzbgg zzbggVar;
        if (zzaxfVar == null) {
            zzbbd.e("AdState is null");
            return null;
        }
        if (b(zzaxfVar) && (zzbggVar = zzaxfVar.zzdrv) != null) {
            return zzbggVar.getView();
        }
        try {
            IObjectWrapper zzut = zzaxfVar.zzdnc != null ? zzaxfVar.zzdnc.zzut() : null;
            if (zzut == null) {
                zzbbd.zzeo("View in mediation adapter is null.");
                return null;
            }
            return (View) ObjectWrapper.a(zzut);
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not get View from mediation adapter.", e2);
            return null;
        }
    }

    public static boolean b(zzaxf zzaxfVar) {
        zzakq zzakqVar;
        return (zzaxfVar == null || !zzaxfVar.zzdyd || (zzakqVar = zzaxfVar.zzdnb) == null || zzakqVar.zzdli == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(zzbgg zzbggVar) {
        View.OnClickListener onClickListener = zzbggVar.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(zzbggVar.getView());
        }
    }

    private static String b(zzadb zzadbVar) {
        try {
            IObjectWrapper zzsa = zzadbVar.zzsa();
            if (zzsa == null) {
                zzbbd.zzeo("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) ObjectWrapper.a(zzsa);
            if (!(drawable instanceof BitmapDrawable)) {
                zzbbd.zzeo("Drawable is not an instance of BitmapDrawable. Returning empty string");
                return "";
            }
            return a(((BitmapDrawable) drawable).getBitmap());
        } catch (RemoteException unused) {
            zzbbd.zzeo("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    public static boolean a(final zzbgg zzbggVar, zzakx zzakxVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            View view = zzbggVar.getView();
            if (view == null) {
                zzbbd.zzeo("AdWebView is null");
            } else {
                view.setVisibility(4);
                List<String> list = zzakxVar.zzdnb.zzdll;
                if (list != null && !list.isEmpty()) {
                    zzbggVar.zza("/nativeExpressAssetsLoaded", new C0785k(countDownLatch));
                    zzbggVar.zza("/nativeExpressAssetsLoadingFailed", new C0786l(countDownLatch));
                    zzals zzuu = zzakxVar.zzdnc.zzuu();
                    zzalv zzuv = zzakxVar.zzdnc.zzuv();
                    if (list.contains("2") && zzuu != null) {
                        final zzabs zzabsVar = new zzabs(zzuu.getHeadline(), zzuu.getImages(), zzuu.getBody(), zzuu.zzsb(), zzuu.getCallToAction(), zzuu.getStarRating(), zzuu.getStore(), zzuu.getPrice(), null, zzuu.getExtras(), null, zzuu.zzvc() != null ? (View) ObjectWrapper.a(zzuu.zzvc()) : null, zzuu.zzsd(), null);
                        final String str = zzakxVar.zzdnb.zzdlk;
                        zzbggVar.zzadl().zza(new zzbho(zzabsVar, str, zzbggVar) { // from class: com.google.android.gms.ads.internal.i

                            /* renamed from: a, reason: collision with root package name */
                            private final zzabs f10084a;

                            /* renamed from: b, reason: collision with root package name */
                            private final String f10085b;

                            /* renamed from: c, reason: collision with root package name */
                            private final zzbgg f10086c;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f10084a = zzabsVar;
                                this.f10085b = str;
                                this.f10086c = zzbggVar;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbho
                            public final void zzp(boolean z2) {
                                zzas.a(this.f10084a, this.f10085b, this.f10086c, z2);
                            }
                        });
                    } else if (list.contains("1") && zzuv != null) {
                        final zzabu zzabuVar = new zzabu(zzuv.getHeadline(), zzuv.getImages(), zzuv.getBody(), zzuv.zzsf(), zzuv.getCallToAction(), zzuv.getAdvertiser(), null, zzuv.getExtras(), null, zzuv.zzvc() != null ? (View) ObjectWrapper.a(zzuv.zzvc()) : null, zzuv.zzsd(), null);
                        final String str2 = zzakxVar.zzdnb.zzdlk;
                        zzbggVar.zzadl().zza(new zzbho(zzabuVar, str2, zzbggVar) { // from class: com.google.android.gms.ads.internal.j

                            /* renamed from: a, reason: collision with root package name */
                            private final zzabu f10087a;

                            /* renamed from: b, reason: collision with root package name */
                            private final String f10088b;

                            /* renamed from: c, reason: collision with root package name */
                            private final zzbgg f10089c;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f10087a = zzabuVar;
                                this.f10088b = str2;
                                this.f10089c = zzbggVar;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbho
                            public final void zzp(boolean z2) {
                                zzas.a(this.f10087a, this.f10088b, this.f10089c, z2);
                            }
                        });
                    } else {
                        zzbbd.zzeo("No matching template id and mapper");
                    }
                    String str3 = zzakxVar.zzdnb.zzdli;
                    String str4 = zzakxVar.zzdnb.zzdlj;
                    if (str4 != null) {
                        zzbggVar.loadDataWithBaseURL(str4, str3, "text/html", "UTF-8", null);
                    } else {
                        zzbggVar.loadData(str3, "text/html", "UTF-8");
                    }
                    z = true;
                }
                zzbbd.zzeo("No template ids present in mediation response");
            }
        } catch (RemoteException e2) {
            zzbbd.zzc("Unable to invoke load assets", e2);
        } catch (RuntimeException e3) {
            countDownLatch.countDown();
            throw e3;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static zzu<zzbgg> a(zzals zzalsVar, zzalv zzalvVar, zzab zzabVar) {
        return new C0787m(zzalsVar, zzabVar, zzalvVar);
    }

    private static JSONObject a(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (bundle.containsKey(next)) {
                    if (MessengerShareContentUtility.MEDIA_IMAGE.equals(jSONObject2.getString(next))) {
                        Object obj = bundle.get(next);
                        if (obj instanceof Bitmap) {
                            jSONObject.put(next, a((Bitmap) obj));
                        } else {
                            zzbbd.zzeo("Invalid type. An image type extra should return a bitmap");
                        }
                    } else if (bundle.get(next) instanceof Bitmap) {
                        zzbbd.zzeo("Invalid asset type. Bitmap should be returned only for image type");
                    } else {
                        jSONObject.put(next, String.valueOf(bundle.get(next)));
                    }
                }
            }
        }
        return jSONObject;
    }

    @VisibleForTesting
    private static String a(zzadb zzadbVar) {
        if (zzadbVar == null) {
            zzbbd.zzeo("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzadbVar.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException unused) {
            zzbbd.zzeo("Unable to get image uri. Trying data uri next");
        }
        return b(zzadbVar);
    }

    private static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzbbd.zzeo("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        return valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
    }

    private static zzadb a(Object obj) {
        if (obj instanceof IBinder) {
            return zzadc.zzj((IBinder) obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzabu zzabuVar, String str, zzbgg zzbggVar, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", zzabuVar.getHeadline());
            jSONObject.put("body", zzabuVar.getBody());
            jSONObject.put("call_to_action", zzabuVar.getCallToAction());
            jSONObject.put("advertiser", zzabuVar.getAdvertiser());
            jSONObject.put("logo", a(zzabuVar.zzsf()));
            JSONArray jSONArray = new JSONArray();
            List images = zzabuVar.getImages();
            if (images != null) {
                Iterator it = images.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(a(it.next())));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, a(zzabuVar.getExtras(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            zzbggVar.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e2) {
            zzbbd.zzc("Exception occurred when loading assets", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzabs zzabsVar, String str, zzbgg zzbggVar, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", zzabsVar.getHeadline());
            jSONObject.put("body", zzabsVar.getBody());
            jSONObject.put("call_to_action", zzabsVar.getCallToAction());
            jSONObject.put("price", zzabsVar.getPrice());
            jSONObject.put("star_rating", String.valueOf(zzabsVar.getStarRating()));
            jSONObject.put("store", zzabsVar.getStore());
            jSONObject.put("icon", a(zzabsVar.zzsb()));
            JSONArray jSONArray = new JSONArray();
            List images = zzabsVar.getImages();
            if (images != null) {
                Iterator it = images.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(a(it.next())));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, a(zzabsVar.getExtras(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            zzbggVar.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e2) {
            zzbbd.zzc("Exception occurred when loading assets", e2);
        }
    }
}
