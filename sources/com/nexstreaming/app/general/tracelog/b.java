package com.nexstreaming.app.general.tracelog;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.gson.Gson;
import com.nexstreaming.app.general.tracelog.AppUsage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppUsage.java */
/* loaded from: classes.dex */
public class b extends AsyncTask<AppUsage.AppUsageRequest, Integer, AppUsage.AppUsageResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppUsage f3205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppUsage appUsage) {
        this.f3205a = appUsage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppUsage.AppUsageResponse doInBackground(AppUsage.AppUsageRequest... appUsageRequestArr) {
        String[] strArr;
        AppUsage.AppUsageResponse appUsageResponse;
        IOException iOException;
        HttpURLConnection httpURLConnection;
        AppUsage.AppUsageRequest appUsageRequest = appUsageRequestArr[0];
        AppUsage.AppUsageResponse appUsageResponse2 = null;
        Gson gson = new Gson();
        try {
            byte[] bytes = gson.toJson(appUsageRequest).getBytes(Keyczar.DEFAULT_ENCODING);
            strArr = this.f3205a.j;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    } catch (IOException e) {
                        iOException = e;
                        appUsageResponse = appUsageResponse2;
                    }
                } catch (MalformedURLException e2) {
                    Log.i("nexau", "Bad server URL; skipping : " + str, e2);
                    appUsageResponse = appUsageResponse2;
                }
                try {
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.close();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read, Keyczar.DEFAULT_ENCODING));
                    }
                    bufferedInputStream.close();
                    String sb2 = sb.toString();
                    if (!Pattern.compile(".*http-equiv=\"?refresh\"?.*", 2).matcher(sb2).find()) {
                        AppUsage.AppUsageResponse appUsageResponse3 = (AppUsage.AppUsageResponse) gson.fromJson(sb2, AppUsage.AppUsageResponse.class);
                        try {
                            httpURLConnection.disconnect();
                            return appUsageResponse3;
                        } catch (IOException e3) {
                            appUsageResponse = appUsageResponse3;
                            iOException = e3;
                            Log.i("nexau", "Error connecting to server; skipping : " + str, iOException);
                            i++;
                            appUsageResponse2 = appUsageResponse;
                        }
                    } else {
                        httpURLConnection.disconnect();
                        appUsageResponse = appUsageResponse2;
                        i++;
                        appUsageResponse2 = appUsageResponse;
                    }
                } catch (Throwable th) {
                    httpURLConnection.disconnect();
                    throw th;
                    break;
                }
            }
            return appUsageResponse2;
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(AppUsage.AppUsageResponse appUsageResponse) {
        SharedPreferences sharedPreferences;
        this.f3205a.k = false;
        long currentTimeMillis = System.currentTimeMillis();
        sharedPreferences = this.f3205a.c;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("nexau_last_try", currentTimeMillis);
        if (appUsageResponse != null) {
            if (appUsageResponse.result == 0) {
                edit.putLong("nexau_last_report", currentTimeMillis);
            }
            if (appUsageResponse.next > 0) {
                edit.putLong("nexau_report_interval", appUsageResponse.next * 86400000);
            }
        }
        edit.commit();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        onPostExecute((AppUsage.AppUsageResponse) null);
    }
}
