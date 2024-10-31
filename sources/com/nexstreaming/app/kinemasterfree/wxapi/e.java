package com.nexstreaming.app.kinemasterfree.wxapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.gson.Gson;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimeline;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: WXApiManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private static e f19920a;

    /* renamed from: b */
    private IWXAPI f19921b;

    /* renamed from: c */
    private boolean f19922c = false;

    /* renamed from: d */
    private boolean f19923d = false;

    /* renamed from: e */
    private Context f19924e;

    /* compiled from: WXApiManager.java */
    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(T t);

        void onError(Exception exc);
    }

    private e(Context context) {
        this.f19921b = null;
        this.f19924e = null;
        this.f19924e = context;
        this.f19921b = b(this.f19924e);
    }

    private void b(boolean z) {
        Log.i("WXApiManager", "initWxApi() isBeijing : " + z);
        this.f19923d = z;
        if (z) {
            this.f19921b = a(this.f19924e);
        } else {
            this.f19921b = b(this.f19924e);
        }
    }

    public static void c(Context context) {
        f19920a = new e(context);
    }

    public boolean a(boolean z) {
        Log.i("WXApiManager", "sendAuthRequest() progress : " + this.f19922c + " isBeijing : " + z);
        b(z);
        if (!this.f19922c) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
            this.f19921b.sendReq(req);
            this.f19922c = true;
        }
        return this.f19922c;
    }

    public WXAccessToken d() {
        Context context = this.f19924e;
        if (context == null) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("wx_a_token", null);
        String string2 = defaultSharedPreferences.getString("wx_r_token", null);
        String string3 = defaultSharedPreferences.getString("openid", null);
        String string4 = defaultSharedPreferences.getString("wx_scope", null);
        int i = defaultSharedPreferences.getInt("wx_expire_in", 0);
        long j = defaultSharedPreferences.getLong("wx_request_millis", 0L);
        Log.i("WXApiManager", "aToken :" + string);
        Log.i("WXApiManager", "rToken :" + string2);
        Log.i("WXApiManager", "openId :" + string3);
        Log.i("WXApiManager", "scope :" + string4);
        Log.i("WXApiManager", "expire_in :" + i);
        Log.i("WXApiManager", "request :" + j);
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        WXAccessToken wXAccessToken = new WXAccessToken();
        wXAccessToken.a(string);
        wXAccessToken.c(string2);
        wXAccessToken.b(string3);
        wXAccessToken.d(string4);
        wXAccessToken.a(i);
        wXAccessToken.a(j);
        return wXAccessToken;
    }

    public IWXAPI e() {
        return this.f19921b;
    }

    public void f() {
        this.f19922c = true;
    }

    public void g() {
        Context context = this.f19924e;
        if (context != null) {
            context.sendBroadcast(new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.canceld").putExtra("isBeijing", this.f19923d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WXApiManager.java */
    /* loaded from: classes2.dex */
    public static class b<T> extends AsyncTask<String, Void, String> {

        /* renamed from: a */
        private a<T> f19925a;

        /* renamed from: b */
        private Type f19926b;

        public b(a<T> aVar, Type type) {
            this.f19925a = null;
            this.f19926b = null;
            this.f19925a = aVar;
            this.f19926b = type;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return e.a(strArr[0], "GET", false, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Log.i("WXApiManager", "response = " + str);
            if (this.f19925a == null || this.f19926b == null) {
                return;
            }
            try {
                this.f19925a.a(new Gson().fromJson(str, this.f19926b));
            } catch (Exception e2) {
                this.f19925a.onError(e2);
            }
        }
    }

    public static e c() {
        e eVar = f19920a;
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalStateException("WXApiManager must init() in Application");
    }

    public void b(WXAccessToken wXAccessToken, a<WXUserInfo> aVar) {
        if (wXAccessToken == null || wXAccessToken.a() == null) {
            return;
        }
        String format = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s", wXAccessToken.a(), wXAccessToken.c());
        Log.d("WXApiManager", "getUserInfo() called with: token = [" + wXAccessToken + "]");
        StringBuilder sb = new StringBuilder();
        sb.append("getUserInfo() api = ");
        sb.append(format);
        Log.d("WXApiManager", sb.toString());
        new b(aVar, new com.nexstreaming.app.kinemasterfree.wxapi.b(this).getType()).execute(format);
    }

    public void a(WXUserInfo wXUserInfo) {
        Context context = this.f19924e;
        if (context == null || wXUserInfo == null || this.f19923d) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("openid", wXUserInfo.e()).putString("nickname", wXUserInfo.d()).putString("province", wXUserInfo.f()).putString("city", wXUserInfo.a()).putString("country", wXUserInfo.b()).putString("headimgurl", wXUserInfo.c()).putInt("gender", wXUserInfo.g()).apply();
        Log.d("WXUserInfo", wXUserInfo.toString());
    }

    public void b() {
        PreferenceManager.getDefaultSharedPreferences(this.f19924e).edit().putString("openid", null).putString("wx_a_token", null).putString("wx_r_token", null).putInt("wx_expire_in", 0).commit();
        this.f19924e.sendBroadcast(new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.logout"));
    }

    public static IWXAPI b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, null);
        createWXAPI.registerApp(context.getString(R.string.wx_app_id));
        return createWXAPI;
    }

    public void a(String str, a<WXAccessToken> aVar) {
        Context context;
        int i;
        Context context2;
        int i2;
        this.f19922c = false;
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        Log.d("WXApiManager", "getAccessToken() called with: code = [" + str + "]");
        if (this.f19923d) {
            context = this.f19924e;
            i = R.string.wx_app_id_beijing;
        } else {
            context = this.f19924e;
            i = R.string.wx_app_id;
        }
        String string = context.getString(i);
        if (this.f19923d) {
            context2 = this.f19924e;
            i2 = R.string.wx_app_secret_beijing;
        } else {
            context2 = this.f19924e;
            i2 = R.string.wx_app_secret;
        }
        String format = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", string, context2.getString(i2), str);
        Log.d("WXApiManager", "getAccessToken() api = " + format);
        new b(aVar, new c(this).getType()).execute(format);
    }

    public void a() {
        Log.i("WXApiManager", "cancelAuth() called");
        this.f19922c = false;
        b(false);
    }

    public void a(WXAccessToken wXAccessToken, a<WXAccessToken> aVar) {
        if (wXAccessToken == null || aVar == null) {
            return;
        }
        Log.d("WXApiManager", "getRefreshToken() called with: token = [" + wXAccessToken + "], ll = [" + aVar + "]");
        String format = String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", this.f19924e.getString(R.string.wx_app_id), wXAccessToken.d());
        StringBuilder sb = new StringBuilder();
        sb.append("getRefreshToken() api = ");
        sb.append(format);
        Log.d("WXApiManager", sb.toString());
        new b(aVar, new d(this).getType()).execute(format);
    }

    public void a(WXAccessToken wXAccessToken) {
        if (wXAccessToken == null || this.f19924e == null || wXAccessToken.a() == null || wXAccessToken.c() == null || wXAccessToken.d() == null) {
            return;
        }
        Log.d("WXApiManager", "saveAccessToken() called with : token = [" + wXAccessToken + "]");
        if (!this.f19923d) {
            PreferenceManager.getDefaultSharedPreferences(this.f19924e).edit().putString("wx_a_token", wXAccessToken.a()).putString("wx_r_token", wXAccessToken.d()).putString("openid", wXAccessToken.c()).putString("wx_scope", wXAccessToken.e()).putInt("wx_expire_in", wXAccessToken.b()).putLong("wx_request_millis", System.currentTimeMillis()).apply();
        }
        Intent intent = new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
        intent.putExtra("isBeijing", this.f19923d);
        intent.putExtra(WXAccessToken.class.getName(), wXAccessToken);
        this.f19924e.sendBroadcast(intent);
    }

    public static String a(String str, String str2, boolean z, Pair<String, String>[] pairArr, String str3) {
        String str4 = "";
        try {
            boolean equalsIgnoreCase = str2.equalsIgnoreCase("POST");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(str2);
            if (pairArr != null) {
                for (Pair<String, String> pair : pairArr) {
                    httpURLConnection.addRequestProperty((String) pair.first, (String) pair.second);
                }
            }
            httpURLConnection.setUseCaches(z);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(equalsIgnoreCase);
            httpURLConnection.connect();
            if (equalsIgnoreCase && str3 != null && str3.length() > 0) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(str3);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
            }
            Log.i("WXApiManager", "responseCode = " + httpURLConnection.getResponseCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str4 = str4 + readLine;
            }
            bufferedReader.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str4;
    }

    public static IWXAPI a(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, null);
        createWXAPI.registerApp(context.getString(R.string.wx_app_id_beijing));
        return createWXAPI;
    }
}
