package c.d.b.b;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteConfig.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3620a = "k";

    /* renamed from: b, reason: collision with root package name */
    private final Context f3621b;

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseRemoteConfig f3622c = FirebaseRemoteConfig.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.f3621b = context;
        this.f3622c.a(new FirebaseRemoteConfigSettings.Builder().a(false).a());
        this.f3622c.a(R.xml.remote_config_defaults);
    }

    private long k() {
        return this.f3622c.b().getConfigSettings().a() ? 100L : 43200L;
    }

    public void b() {
        a(k(), null);
    }

    public String c() {
        String c2 = this.f3622c.c("ads_data");
        if (c2 == null || c2.length() <= 0) {
            return c2;
        }
        try {
            return new JSONObject(c2).optString("result");
        } catch (JSONException e2) {
            Log.e(f3620a, e2.getMessage(), e2);
            return c2;
        }
    }

    public AdManager.ExportInterstitialAdsType d() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.f3622c;
        if (firebaseRemoteConfig != null) {
            String c2 = firebaseRemoteConfig.c("export_ADs");
            char c3 = 65535;
            int hashCode = c2.hashCode();
            if (hashCode != -1392885889) {
                if (hashCode != 92734940) {
                    if (hashCode == 422410158 && c2.equals("exporting")) {
                        c3 = 2;
                    }
                } else if (c2.equals("after")) {
                    c3 = 1;
                }
            } else if (c2.equals("before")) {
                c3 = 0;
            }
            if (c3 == 0) {
                return AdManager.ExportInterstitialAdsType.BEFORE;
            }
            if (c3 == 1) {
                return AdManager.ExportInterstitialAdsType.AFTER;
            }
            if (c3 != 2) {
                return AdManager.ExportInterstitialAdsType.NONE;
            }
            return AdManager.ExportInterstitialAdsType.EXPORTING;
        }
        return AdManager.ExportInterstitialAdsType.NONE;
    }

    public long e() {
        long j;
        try {
            j = this.f3622c.b("dci_update_period");
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            j = 7;
        }
        return j * 1000 * 60 * 60 * 24;
    }

    public int f() {
        try {
            return (int) this.f3622c.b("font_number");
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 20;
        }
    }

    public int[] g() {
        int[] iArr = {2, 2, 2};
        try {
            iArr[0] = this.f3622c.b("sku_30day_idx_android_v2") == 0 ? 2 : (int) this.f3622c.b("sku_30day_idx_android_v2");
            iArr[1] = this.f3622c.b("sku_monthly_sub_idx_android_v2") == 0 ? 2 : (int) this.f3622c.b("sku_monthly_sub_idx_android_v2");
            iArr[2] = this.f3622c.b("sku_annual_sub_idx_android_v2") == 0 ? 2 : (int) this.f3622c.b("sku_annual_sub_idx_android_v2");
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public int h() {
        try {
            int b2 = (int) this.f3622c.b("watermark_size_ratios");
            if (b2 < 20) {
                return 20;
            }
            if (b2 > 100) {
                return 100;
            }
            return b2;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 80;
        }
    }

    public boolean i() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.f3622c;
        if (firebaseRemoteConfig == null) {
            return false;
        }
        return firebaseRemoteConfig.a("ads_enabled");
    }

    public boolean j() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.f3622c;
        if (firebaseRemoteConfig == null) {
            return false;
        }
        return firebaseRemoteConfig.a("subscriptionlist_assist_enabled");
    }

    public void a(OnCompleteListener onCompleteListener) {
        a(k(), onCompleteListener);
    }

    public void a(long j, OnCompleteListener onCompleteListener) {
        this.f3622c.a(j).a(new j(this, onCompleteListener));
    }
}
