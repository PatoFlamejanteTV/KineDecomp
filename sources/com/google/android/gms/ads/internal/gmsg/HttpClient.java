package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import com.facebook.GraphResponse;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@zzark
@KeepName
/* loaded from: classes.dex */
public class HttpClient implements zzu<zzahu> {
    private final Context mContext;
    private final zzbbi zzbob;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f10034a;

        /* renamed from: b, reason: collision with root package name */
        private final String f10035b;

        public a(String str, String str2) {
            this.f10034a = str;
            this.f10035b = str2;
        }

        public final String a() {
            return this.f10034a;
        }

        public final String b() {
            return this.f10035b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f10036a;

        /* renamed from: b, reason: collision with root package name */
        private final URL f10037b;

        /* renamed from: c, reason: collision with root package name */
        private final ArrayList<a> f10038c;

        /* renamed from: d, reason: collision with root package name */
        private final String f10039d;

        b(String str, URL url, ArrayList<a> arrayList, String str2) {
            this.f10036a = str;
            this.f10037b = url;
            this.f10038c = arrayList;
            this.f10039d = str2;
        }

        public final String a() {
            return this.f10036a;
        }

        public final URL b() {
            return this.f10037b;
        }

        public final ArrayList<a> c() {
            return this.f10038c;
        }

        public final String d() {
            return this.f10039d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f10040a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f10041b;

        /* renamed from: c, reason: collision with root package name */
        private final String f10042c;

        public c(HttpClient httpClient, boolean z, d dVar, String str) {
            this.f10041b = z;
            this.f10040a = dVar;
            this.f10042c = str;
        }

        public final String a() {
            return this.f10042c;
        }

        public final boolean b() {
            return this.f10041b;
        }

        public final d c() {
            return this.f10040a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f10043a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10044b;

        /* renamed from: c, reason: collision with root package name */
        private final List<a> f10045c;

        /* renamed from: d, reason: collision with root package name */
        private final String f10046d;

        d(String str, int i, List<a> list, String str2) {
            this.f10043a = str;
            this.f10044b = i;
            this.f10045c = list;
            this.f10046d = str2;
        }

        public final String a() {
            return this.f10046d;
        }

        public final int b() {
            return this.f10044b;
        }

        public final String c() {
            return this.f10043a;
        }

        public final Iterable<a> d() {
            return this.f10045c;
        }
    }

    public HttpClient(Context context, zzbbi zzbbiVar) {
        this.mContext = context;
        this.zzbob = zzbbiVar;
    }

    private static JSONObject zza(d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", dVar.c());
            if (dVar.a() != null) {
                jSONObject.put("body", dVar.a());
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : dVar.d()) {
                jSONArray.put(new JSONObject().put("key", aVar.a()).put("value", aVar.b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", dVar.b());
        } catch (JSONException e2) {
            zzbbd.zzb("Error constructing JSON for http response.", e2);
        }
        return jSONObject;
    }

    private static b zzc(JSONObject jSONObject) {
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        URL url = null;
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e2) {
            zzbbd.zzb("Error constructing http request.", e2);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new b(optString, url, arrayList, optString3);
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String str = "";
        try {
            str = jSONObject.optString("http_request_id");
            c zza = zza(zzc(jSONObject));
            if (zza.b()) {
                jSONObject2.put("response", zza(zza.c()));
                jSONObject2.put(GraphResponse.SUCCESS_KEY, true);
            } else {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                jSONObject2.put("reason", zza.a());
            }
        } catch (Exception e2) {
            zzbbd.zzb("Error executing http request.", e2);
            try {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                jSONObject2.put("reason", e2.toString());
            } catch (JSONException e3) {
                zzbbd.zzb("Error executing http request.", e3);
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.ads.internal.gmsg.HttpClient.c zza(com.google.android.gms.ads.internal.gmsg.HttpClient.b r13) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.HttpClient$b):com.google.android.gms.ads.internal.gmsg.HttpClient$c");
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzahu zzahuVar, Map map) {
        zzayf.zzc(new o(this, map, zzahuVar));
    }
}
