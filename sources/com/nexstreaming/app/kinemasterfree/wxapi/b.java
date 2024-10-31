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
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import org.keyczar.Keyczar;

/* compiled from: WXApiManager.java */
/* loaded from: classes.dex */
public class b {
    private static b c = null;

    /* renamed from: a, reason: collision with root package name */
    private IWXAPI f3248a;
    private boolean b = false;
    private Context d;

    /* compiled from: WXApiManager.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(Exception exc);

        void a(T t);
    }

    public static void a(Context context) {
        c = new b(context);
    }

    public static b a() {
        if (c == null) {
            throw new IllegalStateException("WXApiManager must init() in Application");
        }
        return c;
    }

    private b(Context context) {
        this.f3248a = null;
        this.d = null;
        this.d = context;
        this.f3248a = KMUsage.getWXAPIInstance(context);
    }

    public boolean b() {
        Log.i("WXApiManager", "sendAuthRequest() progress : " + this.b);
        if (!this.b) {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "none";
            this.f3248a.sendReq(req);
            this.b = true;
        }
        return this.b;
    }

    public void a(String str, a<WXAccessToken> aVar) {
        this.b = false;
        if (!TextUtils.isEmpty(str) && aVar != null) {
            Log.d("WXApiManager", "getAccessToken() called with: code = [" + str + "]");
            String format = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", this.d.getString(R.string.wx_app_id), this.d.getString(R.string.wx_app_secret), str);
            Log.d("WXApiManager", "getAccessToken() api = " + format);
            new AsyncTaskC0065b(aVar, new c(this).getType()).execute(format);
        }
    }

    public void c() {
        Log.i("WXApiManager", "cancelAuth() called");
        this.b = false;
    }

    public void d() {
        if (this.d != null) {
            this.d.sendBroadcast(new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.canceld"));
        }
    }

    public void a(WXAccessToken wXAccessToken, a<WXAccessToken> aVar) {
        if (wXAccessToken != null && aVar != null) {
            Log.d("WXApiManager", "getRefreshToken() called with: token = [" + wXAccessToken + "], ll = [" + aVar + "]");
            String format = String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", this.d.getString(R.string.wx_app_id), wXAccessToken.c());
            Log.d("WXApiManager", "getRefreshToken() api = " + format);
            new AsyncTaskC0065b(aVar, new d(this).getType()).execute(format);
        }
    }

    public void a(WXAccessToken wXAccessToken) {
        if (wXAccessToken != null && this.d != null && wXAccessToken.a() != null && wXAccessToken.d() != null && wXAccessToken.c() != null) {
            Log.d("WXApiManager", "saveAccessToken() called with: token = [" + wXAccessToken + "]");
            PreferenceManager.getDefaultSharedPreferences(this.d).edit().putString("wx_a_token", wXAccessToken.a()).putString("wx_r_token", wXAccessToken.c()).putString("openid", wXAccessToken.d()).putString("wx_scope", wXAccessToken.e()).putInt("wx_expire_in", wXAccessToken.b()).putLong("wx_request_millis", System.currentTimeMillis()).apply();
            Intent intent = new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
            intent.putExtra(WXAccessToken.class.getName(), wXAccessToken);
            this.d.sendBroadcast(intent);
        }
    }

    public WXAccessToken e() {
        if (this.d == null) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.d);
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
        wXAccessToken.b(string2);
        wXAccessToken.c(string3);
        wXAccessToken.d(string4);
        wXAccessToken.a(i);
        wXAccessToken.a(j);
        return wXAccessToken;
    }

    /* compiled from: WXApiManager.java */
    /* renamed from: com.nexstreaming.app.kinemasterfree.wxapi.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class AsyncTaskC0065b<T> extends AsyncTask<String, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        private a<T> f3249a;
        private Type b;

        public AsyncTaskC0065b(a<T> aVar, Type type) {
            this.f3249a = null;
            this.b = null;
            this.f3249a = aVar;
            this.b = type;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr[0] == null) {
                return null;
            }
            return b.a(strArr[0], "GET", false, null, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Log.i("WXApiManager", "response = " + str);
            if (this.f3249a != null && this.b != null) {
                try {
                    this.f3249a.a((a<T>) new Gson().fromJson(str, this.b));
                } catch (Exception e) {
                    this.f3249a.a(e);
                }
            }
        }
    }

    public static String a(String str, String str2, boolean z, Pair<String, String>[] pairArr, String str3) {
        Exception e;
        String str4;
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
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Keyczar.DEFAULT_ENCODING));
                bufferedWriter.write(str3);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
            }
            Log.i("WXApiManager", "responseCode = " + httpURLConnection.getResponseCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            str4 = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str4 = str4 + readLine;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str4;
                }
            }
            bufferedReader.close();
        } catch (Exception e3) {
            e = e3;
            str4 = "";
        }
        return str4;
    }

    public void f() {
        PreferenceManager.getDefaultSharedPreferences(this.d).edit().putString("openid", null).putString("wx_a_token", null).putString("wx_r_token", null).putInt("wx_expire_in", 0).commit();
        this.d.sendBroadcast(new Intent("com.nexstreaming.app.kinemasterfree.wechat.login.logout"));
    }
}
