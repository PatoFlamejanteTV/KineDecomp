package com.google.firebase.storage.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.SlashUtil;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactory;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactoryImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class NetworkRequest {

    /* renamed from: a */
    public static String f18177a = "https://firebasestorage.googleapis.com/v0";

    /* renamed from: b */
    public static String f18178b = "https://firebasestorage.googleapis.com/v0/b/";

    /* renamed from: c */
    static HttpURLConnectionFactory f18179c = new HttpURLConnectionFactoryImpl();

    /* renamed from: d */
    private static String f18180d;

    /* renamed from: e */
    protected final Uri f18181e;

    /* renamed from: f */
    protected Exception f18182f;

    /* renamed from: g */
    private Context f18183g;

    /* renamed from: h */
    private Map<String, List<String>> f18184h;
    private int i;
    private String j;
    private int k;
    private InputStream l;
    private HttpURLConnection m;
    private Map<String, String> n = new HashMap();

    public NetworkRequest(Uri uri, FirebaseApp firebaseApp) {
        Preconditions.a(uri);
        Preconditions.a(firebaseApp);
        this.f18181e = uri;
        this.f18183g = firebaseApp.b();
        a("x-firebase-gmpid", firebaseApp.e().b());
    }

    public static String a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        return (encodedPath == null || !encodedPath.startsWith("/")) ? encodedPath : encodedPath.substring(1);
    }

    public static String b() {
        return Uri.parse(f18177a).getAuthority();
    }

    private final void c(String str) {
        b(str);
        try {
            t();
        } catch (IOException e2) {
            Log.w("NetworkRequest", "error sending network request " + a() + " " + o(), e2);
            this.f18182f = e2;
            this.i = -2;
        }
        q();
    }

    private HttpURLConnection s() throws IOException {
        String str;
        String h2 = h();
        if (TextUtils.isEmpty(h2)) {
            str = o();
        } else {
            str = o() + "?" + h2;
        }
        return f18179c.a(new URL(str));
    }

    private void t() throws IOException {
        if (p()) {
            b(this.l);
        } else {
            a(this.l);
        }
    }

    protected abstract String a();

    protected JSONObject d() {
        return null;
    }

    protected byte[] e() {
        return null;
    }

    protected int f() {
        return 0;
    }

    public String g() {
        return a(this.f18181e);
    }

    protected String h() throws UnsupportedEncodingException {
        return null;
    }

    public String i() {
        return this.j;
    }

    public JSONObject j() {
        if (!TextUtils.isEmpty(this.j)) {
            try {
                return new JSONObject(this.j);
            } catch (JSONException e2) {
                Log.e("NetworkRequest", "error parsing result into JSON:" + this.j, e2);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public int k() {
        return this.i;
    }

    public Map<String, List<String>> l() {
        return this.f18184h;
    }

    public int m() {
        return this.k;
    }

    public InputStream n() {
        return this.l;
    }

    protected String o() {
        return b(this.f18181e);
    }

    public boolean p() {
        int i = this.i;
        return i >= 200 && i < 300;
    }

    public void q() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final void r() {
        this.f18182f = null;
        this.i = 0;
    }

    public static String b(Uri uri) {
        Preconditions.a(uri);
        String a2 = a(uri);
        StringBuilder sb = new StringBuilder();
        sb.append(f18177a);
        sb.append("/b/");
        sb.append(uri.getAuthority());
        sb.append("/o/");
        sb.append(a2 != null ? SlashUtil.d(a2) : "");
        return sb.toString();
    }

    public void a(String str, String str2) {
        this.n.put(str, str2);
    }

    public void a(String str, Context context) {
        if (a(context)) {
            c(str);
        }
    }

    private boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        this.f18182f = new SocketException("Network subsystem is unavailable");
        this.i = -2;
        return false;
    }

    private void c(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else {
                        sb.append(readLine);
                    }
                } finally {
                    bufferedReader.close();
                }
            }
        }
        this.j = sb.toString();
        if (p()) {
            return;
        }
        this.f18182f = new IOException(this.j);
    }

    public void b(String str) {
        if (this.f18182f != null) {
            this.i = -1;
            return;
        }
        if (Log.isLoggable("NetworkRequest", 3)) {
            Log.d("NetworkRequest", "sending network request " + a() + " " + o());
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f18183g.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            try {
                this.m = s();
                this.m.setRequestMethod(a());
                a(this.m, str);
                a(this.m);
                if (Log.isLoggable("NetworkRequest", 3)) {
                    Log.d("NetworkRequest", "network request result " + this.i);
                    return;
                }
                return;
            } catch (IOException e2) {
                Log.w("NetworkRequest", "error sending network request " + a() + " " + o(), e2);
                this.f18182f = e2;
                this.i = -2;
                return;
            }
        }
        this.i = -2;
        this.f18182f = new SocketException("Network subsystem is unavailable");
    }

    private void a(HttpURLConnection httpURLConnection, String str) throws IOException {
        byte[] e2;
        int f2;
        Preconditions.a(httpURLConnection);
        if (TextUtils.isEmpty(str)) {
            Log.w("NetworkRequest", "no auth token for request");
        } else {
            httpURLConnection.setRequestProperty("Authorization", "Firebase " + str);
        }
        StringBuilder sb = new StringBuilder("Android/");
        String b2 = b(this.f18183g);
        if (!TextUtils.isEmpty(b2)) {
            sb.append(b2);
        }
        httpURLConnection.setRequestProperty("X-Firebase-Storage-Version", sb.toString());
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject d2 = d();
        if (d2 != null) {
            e2 = d2.toString().getBytes("UTF-8");
            f2 = e2.length;
        } else {
            e2 = e();
            f2 = f();
            if (f2 == 0 && e2 != null) {
                f2 = e2.length;
            }
        }
        if (e2 != null && e2.length > 0) {
            if (d2 != null) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Integer.toString(f2));
        } else {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (e2 == null || e2.length <= 0) {
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            try {
                bufferedOutputStream.write(e2, 0, f2);
                return;
            } finally {
                bufferedOutputStream.close();
            }
        }
        Log.e("NetworkRequest", "Unable to write to the http request!");
    }

    public Exception c() {
        return this.f18182f;
    }

    private static String b(Context context) {
        if (f18180d == null) {
            try {
                f18180d = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("NetworkRequest", "Unable to find gmscore in package manager", e2);
            }
            if (f18180d == null) {
                f18180d = "[No Gmscore]";
            }
        }
        return f18180d;
    }

    protected void b(InputStream inputStream) throws IOException {
        c(inputStream);
    }

    private void a(HttpURLConnection httpURLConnection) throws IOException {
        Preconditions.a(httpURLConnection);
        this.i = httpURLConnection.getResponseCode();
        this.f18184h = httpURLConnection.getHeaderFields();
        this.k = httpURLConnection.getContentLength();
        if (p()) {
            this.l = httpURLConnection.getInputStream();
        } else {
            this.l = httpURLConnection.getErrorStream();
        }
    }

    protected void a(InputStream inputStream) throws IOException {
        c(inputStream);
    }

    public String a(List<String> list, List<String> list2, boolean z) throws UnsupportedEncodingException {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (int i = 0; i < list.size(); i++) {
            if (z2) {
                z2 = false;
            } else {
                sb.append("&");
            }
            sb.append(z ? URLEncoder.encode(list.get(i), "UTF-8") : list.get(i));
            sb.append("=");
            sb.append(z ? URLEncoder.encode(list2.get(i), "UTF-8") : list2.get(i));
        }
        return sb.toString();
    }

    public String a(String str) {
        List<String> list;
        Map<String, List<String>> l = l();
        if (l == null || (list = l.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }
}
