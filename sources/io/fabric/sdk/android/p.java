package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.settings.s;
import io.fabric.sdk.android.services.settings.u;
import io.fabric.sdk.android.services.settings.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Onboarding.java */
/* loaded from: classes3.dex */
public class p extends l<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.services.network.f f26865a = new io.fabric.sdk.android.services.network.c();

    /* renamed from: b, reason: collision with root package name */
    private PackageManager f26866b;

    /* renamed from: c, reason: collision with root package name */
    private String f26867c;

    /* renamed from: d, reason: collision with root package name */
    private PackageInfo f26868d;

    /* renamed from: e, reason: collision with root package name */
    private String f26869e;

    /* renamed from: f, reason: collision with root package name */
    private String f26870f;

    /* renamed from: g, reason: collision with root package name */
    private String f26871g;

    /* renamed from: h, reason: collision with root package name */
    private String f26872h;
    private String i;
    private final Future<Map<String, n>> j;
    private final Collection<l> k;

    public p(Future<Map<String, n>> future, Collection<l> collection) {
        this.j = future;
        this.k = collection;
    }

    private u a() {
        try {
            s b2 = s.b();
            b2.a(this, this.idManager, this.f26865a, this.f26869e, this.f26870f, getOverridenSpiEndpoint());
            b2.c();
            return s.b().a();
        } catch (Exception e2) {
            f.f().c("Fabric", "Error dealing with settings", e2);
            return null;
        }
    }

    private boolean b(String str, io.fabric.sdk.android.services.settings.e eVar, Collection<n> collection) {
        return new io.fabric.sdk.android.services.settings.i(this, getOverridenSpiEndpoint(), eVar.f27012c, this.f26865a).a(a(io.fabric.sdk.android.services.settings.o.a(getContext(), str), collection));
    }

    private boolean c(String str, io.fabric.sdk.android.services.settings.e eVar, Collection<n> collection) {
        return a(eVar, io.fabric.sdk.android.services.settings.o.a(getContext(), str), collection);
    }

    @Override // io.fabric.sdk.android.l
    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    String getOverridenSpiEndpoint() {
        return CommonUtils.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    @Override // io.fabric.sdk.android.l
    public String getVersion() {
        return "1.4.2.22";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.l
    public boolean onPreExecute() {
        try {
            this.f26871g = getIdManager().h();
            this.f26866b = getContext().getPackageManager();
            this.f26867c = getContext().getPackageName();
            this.f26868d = this.f26866b.getPackageInfo(this.f26867c, 0);
            this.f26869e = Integer.toString(this.f26868d.versionCode);
            this.f26870f = this.f26868d.versionName == null ? "0.0" : this.f26868d.versionName;
            this.f26872h = this.f26866b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            f.f().c("Fabric", "Failed init", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.fabric.sdk.android.l
    public Boolean doInBackground() {
        Map<String, n> hashMap;
        boolean a2;
        String c2 = CommonUtils.c(getContext());
        u a3 = a();
        if (a3 != null) {
            try {
                if (this.j != null) {
                    hashMap = this.j.get();
                } else {
                    hashMap = new HashMap<>();
                }
                a(hashMap, this.k);
                a2 = a(c2, a3.f27055a, hashMap.values());
            } catch (Exception e2) {
                f.f().c("Fabric", "Error performing auto configuration.", e2);
            }
            return Boolean.valueOf(a2);
        }
        a2 = false;
        return Boolean.valueOf(a2);
    }

    Map<String, n> a(Map<String, n> map, Collection<l> collection) {
        for (l lVar : collection) {
            if (!map.containsKey(lVar.getIdentifier())) {
                map.put(lVar.getIdentifier(), new n(lVar.getIdentifier(), lVar.getVersion(), "binary"));
            }
        }
        return map;
    }

    private boolean a(String str, io.fabric.sdk.android.services.settings.e eVar, Collection<n> collection) {
        if ("new".equals(eVar.f27011b)) {
            if (b(str, eVar, collection)) {
                return s.b().d();
            }
            f.f().c("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals(eVar.f27011b)) {
            return s.b().d();
        }
        if (eVar.f27015f) {
            f.f().d("Fabric", "Server says an update is required - forcing a full App update.");
            c(str, eVar, collection);
        }
        return true;
    }

    private boolean a(io.fabric.sdk.android.services.settings.e eVar, io.fabric.sdk.android.services.settings.o oVar, Collection<n> collection) {
        return new z(this, getOverridenSpiEndpoint(), eVar.f27012c, this.f26865a).a(a(oVar, collection));
    }

    private io.fabric.sdk.android.services.settings.d a(io.fabric.sdk.android.services.settings.o oVar, Collection<n> collection) {
        Context context = getContext();
        return new io.fabric.sdk.android.services.settings.d(new io.fabric.sdk.android.services.common.i().d(context), getIdManager().e(), this.f26870f, this.f26869e, CommonUtils.a(CommonUtils.n(context)), this.f26872h, DeliveryMechanism.determineFrom(this.f26871g).getId(), this.i, AppEventsConstants.EVENT_PARAM_VALUE_NO, oVar, collection);
    }
}
