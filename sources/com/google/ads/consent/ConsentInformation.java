package com.google.ads.consent;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class ConsentInformation {
    private static final String CONSENT_DATA_KEY = "consent_string";
    private static final String MOBILE_ADS_SERVER_URL = "https://adservice.google.com/getconfig/pubvendors";
    private static final String PREFERENCES_FILE_KEY = "mobileads_consent";
    private static final String TAG = "ConsentInformation";
    private static ConsentInformation instance;
    private final Context context;
    private DebugGeography debugGeography = DebugGeography.DEBUG_GEOGRAPHY_DISABLED;
    private List<String> testDevices = new ArrayList();
    private String hashedDeviceId = c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AdNetworkLookupResponse {

        @SerializedName("company_ids")
        private List<String> companyIds;

        @SerializedName("ad_network_id")
        private String id;

        @SerializedName("is_npa")
        private boolean isNPA;

        @SerializedName("lookup_failed")
        private boolean lookupFailed;

        @SerializedName("not_found")
        private boolean notFound;

        private AdNetworkLookupResponse() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ConsentInfoUpdateResponse {
        String responseInfo;
        boolean success;

        ConsentInfoUpdateResponse(boolean z, String str) {
            this.success = z;
            this.responseInfo = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class ServerResponse {

        @SerializedName("ad_network_ids")
        List<AdNetworkLookupResponse> adNetworkLookupResponses;
        List<AdProvider> companies;

        @SerializedName("is_request_in_eea_or_unknown")
        Boolean isRequestLocationInEeaOrUnknown;

        protected ServerResponse() {
        }
    }

    private ConsentInformation(Context context) {
        this.context = context.getApplicationContext();
    }

    private boolean g() {
        return Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT);
    }

    public DebugGeography b() {
        return this.debugGeography;
    }

    protected String c() {
        ContentResolver contentResolver = this.context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || g()) {
            string = "emulator";
        }
        return a(string);
    }

    public boolean d() {
        return f().g();
    }

    public boolean e() {
        return g() || this.testDevices.contains(this.hashedDeviceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConsentData f() {
        String string = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).getString(CONSENT_DATA_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return new ConsentData();
        }
        return (ConsentData) new Gson().fromJson(string, ConsentData.class);
    }

    public static synchronized ConsentInformation a(Context context) {
        ConsentInformation consentInformation;
        synchronized (ConsentInformation.class) {
            if (instance == null) {
                instance = new ConsentInformation(context);
            }
            consentInformation = instance;
        }
        return consentInformation;
    }

    private String a(String str) {
        for (int i = 0; i < 3; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format("%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    private void a(ServerResponse serverResponse) throws Exception {
        Boolean bool = serverResponse.isRequestLocationInEeaOrUnknown;
        if (bool != null) {
            if (serverResponse.companies == null && bool.booleanValue()) {
                throw new Exception("Could not parse Event FE preflight response.");
            }
            if (serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                    if (adNetworkLookupResponse.lookupFailed) {
                        hashSet.add(adNetworkLookupResponse.id);
                    }
                    if (adNetworkLookupResponse.notFound) {
                        hashSet2.add(adNetworkLookupResponse.id);
                    }
                }
                if (hashSet.isEmpty() && hashSet2.isEmpty()) {
                    return;
                }
                StringBuilder sb = new StringBuilder("Response error.");
                if (!hashSet.isEmpty()) {
                    sb.append(String.format(" Lookup failure for: %s.", TextUtils.join(",", hashSet)));
                }
                if (!hashSet2.isEmpty()) {
                    sb.append(String.format(" Publisher Ids not found: %s", TextUtils.join(",", hashSet2)));
                }
                throw new Exception(sb.toString());
            }
            return;
        }
        throw new Exception("Could not parse Event FE preflight response.");
    }

    /* loaded from: classes.dex */
    private static class ConsentInfoUpdateTask extends AsyncTask<Void, Void, ConsentInfoUpdateResponse> {
        private static final String UPDATE_SUCCESS = "Consent update successful.";
        private final ConsentInformation consentInformation;
        private final ConsentInfoUpdateListener listener;
        private final List<String> publisherIds;
        private final String url;

        private String a(InputStream inputStream) {
            byte[] bArr = new byte[1024];
            StringBuilder sb = new StringBuilder();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            while (true) {
                try {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            sb.append(new String(bArr, 0, read));
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                Log.e(ConsentInformation.TAG, e2.getLocalizedMessage());
                            }
                        }
                    } catch (IOException e3) {
                        Log.e(ConsentInformation.TAG, e3.getLocalizedMessage());
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            Log.e(ConsentInformation.TAG, e4.getLocalizedMessage());
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e5) {
                        Log.e(ConsentInformation.TAG, e5.getLocalizedMessage());
                    }
                    throw th;
                }
            }
            bufferedInputStream.close();
            return sb.toString();
        }

        private ConsentInfoUpdateResponse a(String str) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection.getResponseCode() == 200) {
                    String a2 = a(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    this.consentInformation.a(a2, this.publisherIds);
                    return new ConsentInfoUpdateResponse(true, UPDATE_SUCCESS);
                }
                return new ConsentInfoUpdateResponse(false, httpURLConnection.getResponseMessage());
            } catch (Exception e2) {
                return new ConsentInfoUpdateResponse(false, e2.getLocalizedMessage());
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConsentInfoUpdateResponse doInBackground(Void... voidArr) {
            String join = TextUtils.join(",", this.publisherIds);
            ConsentData f2 = this.consentInformation.f();
            Uri.Builder appendQueryParameter = Uri.parse(this.url).buildUpon().appendQueryParameter("pubs", join).appendQueryParameter("es", "2").appendQueryParameter("plat", f2.d()).appendQueryParameter("v", f2.e());
            if (this.consentInformation.e() && this.consentInformation.b() != DebugGeography.DEBUG_GEOGRAPHY_DISABLED) {
                appendQueryParameter = appendQueryParameter.appendQueryParameter("debug_geo", this.consentInformation.b().getCode().toString());
            }
            return a(appendQueryParameter.build().toString());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ConsentInfoUpdateResponse consentInfoUpdateResponse) {
            if (consentInfoUpdateResponse.success) {
                this.listener.a(this.consentInformation.a());
            } else {
                this.listener.a(consentInfoUpdateResponse.responseInfo);
            }
        }
    }

    private HashSet<AdProvider> a(List<AdProvider> list, HashSet<String> hashSet) {
        ArrayList arrayList = new ArrayList();
        for (AdProvider adProvider : list) {
            if (hashSet.contains(adProvider.a())) {
                arrayList.add(adProvider);
            }
        }
        return new HashSet<>(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, List<String> list) throws Exception {
        boolean z;
        HashSet<AdProvider> hashSet;
        ServerResponse serverResponse = (ServerResponse) new Gson().fromJson(str, ServerResponse.class);
        a(serverResponse);
        HashSet<String> hashSet2 = new HashSet<>();
        boolean z2 = true;
        if (serverResponse.adNetworkLookupResponses != null) {
            z = false;
            for (AdNetworkLookupResponse adNetworkLookupResponse : serverResponse.adNetworkLookupResponses) {
                if (adNetworkLookupResponse.isNPA) {
                    List list2 = adNetworkLookupResponse.companyIds;
                    if (list2 != null) {
                        hashSet2.addAll(list2);
                    }
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (serverResponse.companies == null) {
            hashSet = new HashSet<>();
        } else if (z) {
            hashSet = a(serverResponse.companies, hashSet2);
        } else {
            hashSet = new HashSet<>(serverResponse.companies);
        }
        ConsentData f2 = f();
        if (f2.f() == z) {
            z2 = false;
        }
        f2.a(z);
        f2.b(str);
        f2.c(new HashSet<>(list));
        f2.a(hashSet);
        f2.b(serverResponse.isRequestLocationInEeaOrUnknown.booleanValue());
        if (!serverResponse.isRequestLocationInEeaOrUnknown.booleanValue()) {
            a(f2);
            return;
        }
        if (!f2.a().equals(f2.c()) || z2) {
            f2.a(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
            f2.a(ConsentStatus.UNKNOWN);
            f2.b(new HashSet<>());
        }
        a(f2);
    }

    private void a(ConsentData consentData) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(PREFERENCES_FILE_KEY, 0).edit();
        edit.putString(CONSENT_DATA_KEY, new Gson().toJson(consentData));
        edit.apply();
    }

    public void a(ConsentStatus consentStatus) {
        a(consentStatus, "programmatic");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(ConsentStatus consentStatus, String str) {
        ConsentData f2 = f();
        if (consentStatus == ConsentStatus.UNKNOWN) {
            f2.b(new HashSet<>());
        } else {
            f2.b(f2.a());
        }
        f2.a(str);
        f2.a(consentStatus);
        a(f2);
    }

    public synchronized ConsentStatus a() {
        return f().b();
    }
}
