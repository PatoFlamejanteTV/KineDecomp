package com.nexstreaming.app.general.tracelog;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.r;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyApp.java */
/* loaded from: classes2.dex */
public class q extends AsyncTask<r.a, Void, NotifyAppResponse> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f19789a = null;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f19790b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ResultTask resultTask) {
        this.f19790b = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotifyAppResponse doInBackground(r.a... aVarArr) {
        byte[] bArr;
        Gson gson = new Gson();
        try {
            byte[] bytes = gson.toJson(aVarArr[0].f19792b).getBytes("UTF-8");
            URI[] uriArr = aVarArr[0].f19791a;
            int length = uriArr.length;
            NotifyAppResponse notifyAppResponse = null;
            int i = 0;
            while (i < length) {
                URI uri = uriArr[i];
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
                        try {
                            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
                            httpURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.close();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            StringBuilder sb = new StringBuilder();
                            byte[] bArr2 = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                bArr = bytes;
                                try {
                                    sb.append(new String(bArr2, 0, read, "UTF-8"));
                                    bytes = bArr;
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        httpURLConnection.disconnect();
                                        throw th;
                                        break;
                                    } catch (JsonSyntaxException e2) {
                                        e = e2;
                                        Log.i("NotifyApp", "Failed parsing data from server : " + uri, e);
                                        this.f19789a = Task.makeTaskError("Failed parsing data from server", e);
                                        i++;
                                        bytes = bArr;
                                    } catch (IOException e3) {
                                        e = e3;
                                        Log.i("NotifyApp", "Failed reading data from server : " + uri, e);
                                        this.f19789a = Task.makeTaskError("Failed reading data from server", e);
                                        i++;
                                        bytes = bArr;
                                    }
                                }
                            }
                            bArr = bytes;
                            NotifyAppResponse notifyAppResponse2 = (NotifyAppResponse) gson.fromJson(sb.toString(), NotifyAppResponse.class);
                            try {
                                httpURLConnection.disconnect();
                                notifyAppResponse = notifyAppResponse2;
                            } catch (JsonSyntaxException e4) {
                                e = e4;
                                notifyAppResponse = notifyAppResponse2;
                                Log.i("NotifyApp", "Failed parsing data from server : " + uri, e);
                                this.f19789a = Task.makeTaskError("Failed parsing data from server", e);
                                i++;
                                bytes = bArr;
                            } catch (IOException e5) {
                                e = e5;
                                notifyAppResponse = notifyAppResponse2;
                                Log.i("NotifyApp", "Failed reading data from server : " + uri, e);
                                this.f19789a = Task.makeTaskError("Failed reading data from server", e);
                                i++;
                                bytes = bArr;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bArr = bytes;
                        }
                    } catch (JsonSyntaxException e6) {
                        e = e6;
                        bArr = bytes;
                    } catch (IOException e7) {
                        e = e7;
                        bArr = bytes;
                    }
                } catch (MalformedURLException e8) {
                    bArr = bytes;
                    Log.i("NotifyApp", "Bad URL; skipping : " + uri, e8);
                }
                i++;
                bytes = bArr;
            }
            return notifyAppResponse;
        } catch (UnsupportedEncodingException e9) {
            throw new RuntimeException(e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(NotifyAppResponse notifyAppResponse) {
        if (notifyAppResponse == null) {
            this.f19790b.sendFailure(this.f19789a);
            return;
        }
        int i = notifyAppResponse.result;
        if (i != 6 && i != 0 && i != 13) {
            this.f19790b.sendFailure(ResponseCode.fromValue(i));
        } else {
            this.f19790b.sendResult(notifyAppResponse);
        }
    }
}
