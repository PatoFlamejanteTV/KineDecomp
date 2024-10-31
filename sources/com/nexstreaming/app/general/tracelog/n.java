package com.nexstreaming.app.general.tracelog;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.internal.Utility;
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
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [TRESPONSE] */
/* compiled from: TLP.java */
/* loaded from: classes.dex */
public class n<TRESPONSE> extends AsyncTask<TLP.b<?>, Void, TRESPONSE> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f3217a = null;
    URI b = null;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ TLP d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TLP tlp, ResultTask resultTask) {
        this.d = tlp;
        this.c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect return type in method signature: ([Lcom/nexstreaming/app/general/tracelog/TLP$b<*>;)TTRESPONSE; */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TLP.BaseResponse doInBackground(TLP.b... bVarArr) {
        TLP.BaseResponse baseResponse;
        String sb;
        Class cls;
        TLP.BaseResponse baseResponse2 = null;
        Gson gson = new Gson();
        String json = gson.toJson(bVarArr[0].b);
        Log.i("TLP", "Send request : " + json);
        try {
            byte[] bytes = json.getBytes(Keyczar.DEFAULT_ENCODING);
            URI[] uriArr = bVarArr[0].f3203a;
            int length = uriArr.length;
            int i = 0;
            while (i < length) {
                URI uri = uriArr[i];
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
                        try {
                            httpURLConnection.setRequestProperty("Content-Type", "application/json");
                            httpURLConnection.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.close();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            StringBuilder sb2 = new StringBuilder();
                            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                sb2.append(new String(bArr, 0, read, Keyczar.DEFAULT_ENCODING));
                            }
                            sb = sb2.toString();
                            cls = this.d.b;
                            baseResponse = (TLP.BaseResponse) gson.fromJson(sb, cls);
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            this.b = uri;
                            this.d.a(sb);
                            try {
                                httpURLConnection.disconnect();
                                if (baseResponse != null && !this.d.e()) {
                                    return baseResponse;
                                }
                            } catch (JsonSyntaxException e) {
                                e = e;
                                Log.i("TLP", "Failed parsing data from server : " + uri, e);
                                this.f3217a = new TLP.c(e, "Failed parsing data from server");
                                i++;
                                baseResponse2 = baseResponse;
                            } catch (IOException e2) {
                                e = e2;
                                Log.i("TLP", "Failed reading data from server : " + uri, e);
                                this.f3217a = new TLP.a(e, "Failed reading data from server");
                                i++;
                                baseResponse2 = baseResponse;
                            }
                        } catch (Throwable th2) {
                            baseResponse2 = baseResponse;
                            th = th2;
                            httpURLConnection.disconnect();
                            throw th;
                            break;
                        }
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        baseResponse = baseResponse2;
                    } catch (IOException e4) {
                        e = e4;
                        baseResponse = baseResponse2;
                    }
                } catch (MalformedURLException e5) {
                    Log.i("TLP", "Bad URL; skipping : " + uri, e5);
                    baseResponse = baseResponse2;
                }
                i++;
                baseResponse2 = baseResponse;
            }
            return baseResponse2;
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException(e6);
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
            this.d.a(this.f3217a, (Task.TaskError) null);
            if (this.c != null) {
                this.c.sendFailure(this.f3217a);
                return;
            }
            return;
        }
        ResponseCode fromValue = ResponseCode.fromValue(baseResponse.getResult());
        if (!this.d.a(fromValue)) {
            this.d.a((Task.TaskError) fromValue, (ResponseCode) baseResponse);
            if (this.c != null) {
                this.c.sendFailure(fromValue);
                return;
            }
            return;
        }
        this.d.b((TLP) baseResponse);
        String str = "?";
        if (this.b != null) {
            str = this.b.getHost();
        }
        baseResponse2 = this.d.f;
        if (baseResponse2 == baseResponse) {
            weakHashMap2 = TLP.k;
            j = this.d.g;
            j2 = this.d.h;
            weakHashMap2.put(baseResponse, new TLP.TLPResponseInfo(false, j, j2, System.currentTimeMillis(), str));
        } else {
            weakHashMap = TLP.k;
            weakHashMap.put(baseResponse, new TLP.TLPResponseInfo(false, -1L, -1L, System.currentTimeMillis(), str));
        }
        if (this.c != null) {
            this.c.sendResult(baseResponse);
        }
    }
}
