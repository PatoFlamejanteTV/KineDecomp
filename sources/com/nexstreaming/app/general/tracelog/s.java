package com.nexstreaming.app.general.tracelog;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [TRESPONSE] */
/* compiled from: TLP.java */
/* loaded from: classes2.dex */
public class s<TRESPONSE> extends AsyncTask<TLP.b<?>, Void, TRESPONSE> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f19793a = null;

    /* renamed from: b, reason: collision with root package name */
    URI f19794b = null;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f19795c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TLP f19796d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TLP tlp, ResultTask resultTask) {
        this.f19796d = tlp;
        this.f19795c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: ([Lcom/nexstreaming/app/general/tracelog/TLP$b<*>;)TTRESPONSE; */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TLP.BaseResponse doInBackground(TLP.b... bVarArr) {
        byte[] bArr;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        StringBuilder sb;
        byte[] bArr2;
        String sb2;
        Class cls;
        TLP.BaseResponse baseResponse;
        Gson gson = new Gson();
        String json = gson.toJson(bVarArr[0].f19778b);
        Log.i("TLP", "Send request : " + json);
        try {
            byte[] bytes = json.getBytes("UTF-8");
            URI[] uriArr = bVarArr[0].f19777a;
            int length = uriArr.length;
            TLP.BaseResponse baseResponse2 = null;
            int i = 0;
            while (i < length) {
                URI uri = uriArr[i];
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
                        try {
                            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
                            httpURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.close();
                            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            sb = new StringBuilder();
                            bArr2 = new byte[8192];
                        } catch (Throwable th) {
                            th = th;
                            bArr = bytes;
                        }
                        while (true) {
                            int read = bufferedInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            bArr = bytes;
                            try {
                                sb.append(new String(bArr2, 0, read, "UTF-8"));
                                bytes = bArr;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                httpURLConnection.disconnect();
                                throw th;
                                break;
                            } catch (JsonSyntaxException e2) {
                                e = e2;
                                Log.i("TLP", "Failed parsing data from server : " + uri, e);
                                this.f19793a = new TLP.c(e, "Failed parsing data from server");
                                i++;
                                bytes = bArr;
                            } catch (IOException e3) {
                                e = e3;
                                Log.i("TLP", "Failed reading data from server : " + uri, e);
                                this.f19793a = new TLP.a(e, "Failed reading data from server");
                                i++;
                                bytes = bArr;
                            }
                        }
                        bArr = bytes;
                        sb2 = sb.toString();
                        cls = this.f19796d.f19770b;
                        baseResponse = (TLP.BaseResponse) gson.fromJson(sb2, cls);
                    } catch (JsonSyntaxException e4) {
                        e = e4;
                        bArr = bytes;
                    } catch (IOException e5) {
                        e = e5;
                        bArr = bytes;
                    }
                } catch (MalformedURLException e6) {
                    bArr = bytes;
                    Log.i("TLP", "Bad URL; skipping : " + uri, e6);
                }
                try {
                    this.f19794b = uri;
                    this.f19796d.a(sb2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (JsonSyntaxException e7) {
                        e = e7;
                        baseResponse2 = baseResponse;
                        Log.i("TLP", "Failed parsing data from server : " + uri, e);
                        this.f19793a = new TLP.c(e, "Failed parsing data from server");
                        i++;
                        bytes = bArr;
                    } catch (IOException e8) {
                        e = e8;
                        baseResponse2 = baseResponse;
                        Log.i("TLP", "Failed reading data from server : " + uri, e);
                        this.f19793a = new TLP.a(e, "Failed reading data from server");
                        i++;
                        bytes = bArr;
                    }
                    if (baseResponse != null && !this.f19796d.h()) {
                        return baseResponse;
                    }
                    baseResponse2 = baseResponse;
                    i++;
                    bytes = bArr;
                } catch (Throwable th3) {
                    th = th3;
                    baseResponse2 = baseResponse;
                }
            }
            return baseResponse2;
        } catch (UnsupportedEncodingException e9) {
            throw new RuntimeException(e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TTRESPONSE;)V */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(TLP.BaseResponse baseResponse) {
        TLP.BaseResponse baseResponse2;
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        long j;
        long j2;
        if (baseResponse == null) {
            this.f19796d.a(this.f19793a, (Task.TaskError) null);
            ResultTask resultTask = this.f19795c;
            if (resultTask != null) {
                resultTask.sendFailure(this.f19793a);
                return;
            }
            return;
        }
        ResponseCode fromValue = ResponseCode.fromValue(baseResponse.getResult());
        if (!this.f19796d.a(fromValue)) {
            this.f19796d.a((Task.TaskError) fromValue, (ResponseCode) baseResponse);
            ResultTask resultTask2 = this.f19795c;
            if (resultTask2 != null) {
                resultTask2.sendFailure(fromValue);
                return;
            }
            return;
        }
        this.f19796d.b((TLP) baseResponse);
        URI uri = this.f19794b;
        String host = uri != null ? uri.getHost() : "?";
        baseResponse2 = this.f19796d.f19774f;
        if (baseResponse2 == baseResponse) {
            weakHashMap2 = TLP.f19769a;
            j = this.f19796d.f19775g;
            j2 = this.f19796d.f19776h;
            weakHashMap2.put(baseResponse, new TLP.TLPResponseInfo(false, j, j2, System.currentTimeMillis(), host));
        } else {
            weakHashMap = TLP.f19769a;
            weakHashMap.put(baseResponse, new TLP.TLPResponseInfo(false, -1L, -1L, System.currentTimeMillis(), host));
        }
        ResultTask resultTask3 = this.f19795c;
        if (resultTask3 != null) {
            resultTask3.sendResult(baseResponse);
        }
    }
}
