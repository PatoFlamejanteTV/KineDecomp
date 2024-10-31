package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzdl implements zzdk {
    private final Context mContext;
    private final VersionInfoParcel zzpb;

    @zzgr
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final String f1700a;
        private final String b;

        public a(String str, String str2) {
            this.f1700a = str;
            this.b = str2;
        }

        public String a() {
            return this.f1700a;
        }

        public String b() {
            return this.b;
        }
    }

    @zzgr
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        private final String f1701a;
        private final URL b;
        private final ArrayList<a> c;
        private final String d;

        public b(String str, URL url, ArrayList<a> arrayList, String str2) {
            this.f1701a = str;
            this.b = url;
            if (arrayList == null) {
                this.c = new ArrayList<>();
            } else {
                this.c = arrayList;
            }
            this.d = str2;
        }

        public String a() {
            return this.f1701a;
        }

        public URL b() {
            return this.b;
        }

        public ArrayList<a> c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }
    }

    @zzgr
    /* loaded from: classes.dex */
    public class c {
        private final d b;
        private final boolean c;
        private final String d;

        public c(boolean z, d dVar, String str) {
            this.c = z;
            this.b = dVar;
            this.d = str;
        }

        public String a() {
            return this.d;
        }

        public d b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }
    }

    @zzgr
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        private final String f1703a;
        private final int b;
        private final List<a> c;
        private final String d;

        public d(String str, int i, List<a> list, String str2) {
            this.f1703a = str;
            this.b = i;
            if (list == null) {
                this.c = new ArrayList();
            } else {
                this.c = list;
            }
            this.d = str2;
        }

        public String a() {
            return this.f1703a;
        }

        public int b() {
            return this.b;
        }

        public Iterable<a> c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }
    }

    public zzdl(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpb = versionInfoParcel;
    }

    public JSONObject zzX(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                c zza = zza(zzb(jSONObject));
                if (zza.c()) {
                    jSONObject2.put("response", zza(zza.b()));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", zza.a());
                }
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.b("The request is not a valid JSON.");
            try {
                return new JSONObject().put(GraphResponse.SUCCESS_KEY, false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected c zza(b bVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) bVar.b().openConnection();
            com.google.android.gms.ads.internal.zzp.e().zza(this.mContext, this.zzpb.b, false, httpURLConnection);
            Iterator<a> it = bVar.c().iterator();
            while (it.hasNext()) {
                a next = it.next();
                httpURLConnection.addRequestProperty(next.a(), next.b());
            }
            if (!TextUtils.isEmpty(bVar.d())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = bVar.d().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                    Iterator<String> it2 = entry.getValue().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new a(entry.getKey(), it2.next()));
                    }
                }
            }
            return new c(true, new d(bVar.a(), httpURLConnection.getResponseCode(), arrayList, com.google.android.gms.ads.internal.zzp.e().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new c(false, null, e.toString());
        }
    }

    protected JSONObject zza(d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", dVar.a());
            if (dVar.d() != null) {
                jSONObject.put("body", dVar.d());
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : dVar.c()) {
                jSONArray.put(new JSONObject().put("key", aVar.a()).put("value", aVar.b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", dVar.b());
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zzic.zza(new at(this, map, zzizVar));
    }

    protected b zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error constructing http request.", e);
            url = null;
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
}
