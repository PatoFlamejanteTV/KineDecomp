package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a */
    private static final long f17379a = TimeUnit.DAYS.toMillis(7);

    /* renamed from: b */
    final String f17380b;

    /* renamed from: c */
    private final String f17381c;

    /* renamed from: d */
    private final long f17382d;

    private s(String str, String str2, long j) {
        this.f17380b = str;
        this.f17381c = str2;
        this.f17382d = j;
    }

    public static s a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new s(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("Failed to parse token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }
        return new s(str, null, 0L);
    }

    public final boolean b(String str) {
        return System.currentTimeMillis() > this.f17382d + f17379a || !str.equals(this.f17381c);
    }

    public static String a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public static String a(s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar.f17380b;
    }
}
