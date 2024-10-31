package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzad {

    /* renamed from: a, reason: collision with root package name */
    private Context f16506a;

    /* renamed from: b, reason: collision with root package name */
    private String f16507b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f16508c;

    /* renamed from: d, reason: collision with root package name */
    private Logger f16509d;

    public zzad(Context context, String str) {
        Preconditions.a(context);
        Preconditions.b(str);
        this.f16507b = str;
        this.f16506a = context.getApplicationContext();
        this.f16508c = this.f16506a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f16507b), 0);
        this.f16509d = new Logger("StorageHelpers", new String[0]);
    }

    private final String c(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzl.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzl zzlVar = (zzl) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzlVar.Y());
            jSONObject.put("applicationName", zzlVar.V().d());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzlVar.aa() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzh> aa = zzlVar.aa();
                for (int i = 0; i < aa.size(); i++) {
                    jSONArray.put(aa.get(i).zzdz());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzlVar.U());
            jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "2");
            if (zzlVar.Z() != null) {
                jSONObject.put("userMetadata", ((zzn) zzlVar.Z()).c());
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            this.f16509d.b("Failed to turn object into JSON", e2, new Object[0]);
            throw new zzaf(e2);
        }
    }

    public final void a(FirebaseUser firebaseUser) {
        Preconditions.a(firebaseUser);
        String c2 = c(firebaseUser);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        this.f16508c.edit().putString("com.google.firebase.auth.FIREBASE_USER", c2).apply();
    }

    public final zzcz b(FirebaseUser firebaseUser) {
        Preconditions.a(firebaseUser);
        String string = this.f16508c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.R()), null);
        if (string != null) {
            return zzcz.zzcf(string);
        }
        return null;
    }

    public final FirebaseUser a() {
        String string = this.f16508c.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return a(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void a(FirebaseUser firebaseUser, zzcz zzczVar) {
        Preconditions.a(firebaseUser);
        Preconditions.a(zzczVar);
        this.f16508c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.R()), zzczVar.zzdz()).apply();
    }

    public final void a(String str) {
        this.f16508c.edit().remove(str).apply();
    }

    private final zzl a(JSONObject jSONObject) {
        zzn a2;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray = jSONObject.getJSONArray("userInfos");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzh.e(jSONArray.getString(i)));
            }
            zzl zzlVar = new zzl(FirebaseApp.a(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzlVar.a(zzcz.zzcf(string));
            }
            if (!z) {
                zzlVar.W();
            }
            zzlVar.e(str);
            if (jSONObject.has("userMetadata") && (a2 = zzn.a(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzlVar.a(a2);
            }
            return zzlVar;
        } catch (zzaf | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e2) {
            this.f16509d.a(e2);
            return null;
        }
    }
}
