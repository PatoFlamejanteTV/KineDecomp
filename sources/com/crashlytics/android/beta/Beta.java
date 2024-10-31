package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import io.fabric.sdk.android.a.a.b;
import io.fabric.sdk.android.a.c.d;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.n;
import io.fabric.sdk.android.services.common.y;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.settings.g;
import io.fabric.sdk.android.services.settings.s;
import io.fabric.sdk.android.services.settings.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Beta extends l<Boolean> implements n {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final b<String> deviceTokenCache = new b<>();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    private String getBetaDeviceToken(Context context, String str) {
        String str2 = null;
        try {
            String a2 = this.deviceTokenCache.a(context, this.deviceTokenLoader);
            if (!"".equals(a2)) {
                str2 = a2;
            }
        } catch (Exception e2) {
            f.f().c(TAG, "Failed to load the Beta device token", e2);
        }
        o f2 = f.f();
        StringBuilder sb = new StringBuilder();
        sb.append("Beta device token present: ");
        sb.append(!TextUtils.isEmpty(str2));
        f2.d(TAG, sb.toString());
        return str2;
    }

    private g getBetaSettingsData() {
        u a2 = s.b().a();
        if (a2 != null) {
            return a2.f27060f;
        }
        return null;
    }

    public static Beta getInstance() {
        return (Beta) f.a(Beta.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.crashlytics.android.beta.BuildProperties] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v3, types: [io.fabric.sdk.android.o] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.crashlytics.android.beta.BuildProperties] */
    private BuildProperties loadBuildProperties(Context context) {
        ?? r8;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        ?? r2 = 0;
        InputStream inputStream3 = null;
        InputStream inputStream4 = null;
        try {
            try {
                inputStream = context.getAssets().open(CRASHLYTICS_BUILD_PROPERTIES);
                if (inputStream != null) {
                    try {
                        r2 = BuildProperties.fromPropertiesStream(inputStream);
                        f.f().d(TAG, r2.packageName + " build properties: " + r2.versionName + " (" + r2.versionCode + ") - " + r2.buildId);
                        inputStream3 = r2;
                    } catch (Exception e2) {
                        e = e2;
                        Object obj = r2;
                        inputStream4 = inputStream;
                        r8 = obj;
                        f.f().c(TAG, "Error reading Beta build properties", e);
                        inputStream2 = inputStream4;
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                                inputStream2 = inputStream4;
                            } catch (IOException e3) {
                                f.f().c(TAG, "Error closing Beta build properties asset", e3);
                                inputStream2 = e3;
                            }
                        }
                        return r8;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                f.f().c(TAG, "Error closing Beta build properties asset", e4);
                            }
                        }
                        throw th;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        f.f().c(TAG, "Error closing Beta build properties asset", e5);
                    }
                }
                r8 = inputStream3;
                inputStream2 = inputStream3;
            } catch (Exception e6) {
                e = e6;
                r8 = null;
            }
            return r8;
        } catch (Throwable th3) {
            InputStream inputStream5 = inputStream2;
            th = th3;
            inputStream = inputStream5;
        }
    }

    boolean canCheckForUpdates(g gVar, BuildProperties buildProperties) {
        return (gVar == null || TextUtils.isEmpty(gVar.f27017a) || buildProperties == null) ? false : true;
    }

    @TargetApi(14)
    UpdatesController createUpdatesController(int i, Application application) {
        if (i >= 14) {
            return new ActivityLifecycleCheckForUpdatesController(getFabric().a(), getFabric().c());
        }
        return new ImmediateCheckForUpdatesController();
    }

    @Override // io.fabric.sdk.android.services.common.n
    public Map<IdManager.DeviceIdentifierType, String> getDeviceIdentifiers() {
        String betaDeviceToken = getBetaDeviceToken(getContext(), getIdManager().h());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            hashMap.put(IdManager.DeviceIdentifierType.FONT_TOKEN, betaDeviceToken);
        }
        return hashMap;
    }

    @Override // io.fabric.sdk.android.l
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getOverridenSpiEndpoint() {
        return CommonUtils.b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }

    @Override // io.fabric.sdk.android.l
    public String getVersion() {
        return "1.2.7.19";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.l
    @TargetApi(14)
    public boolean onPreExecute() {
        this.updatesController = createUpdatesController(Build.VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.fabric.sdk.android.l
    public Boolean doInBackground() {
        f.f().d(TAG, "Beta kit initializing...");
        Context context = getContext();
        IdManager idManager = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, idManager.h()))) {
            f.f().d(TAG, "A Beta device token was not found for this app");
            return false;
        }
        f.f().d(TAG, "Beta device token is present, checking for app updates.");
        g betaSettingsData = getBetaSettingsData();
        BuildProperties loadBuildProperties = loadBuildProperties(context);
        if (canCheckForUpdates(betaSettingsData, loadBuildProperties)) {
            this.updatesController.initialize(context, this, idManager, betaSettingsData, loadBuildProperties, new d(this), new y(), new c(f.f()));
        }
        return true;
    }
}
