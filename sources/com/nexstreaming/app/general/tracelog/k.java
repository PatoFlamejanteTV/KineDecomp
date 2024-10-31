package com.nexstreaming.app.general.tracelog;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.j;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyApp.java */
/* loaded from: classes.dex */
public final class k extends AsyncTask<j.a, Void, NotifyAppResponse> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f3214a = null;
    final /* synthetic */ ResultTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ResultTask resultTask) {
        this.b = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotifyAppResponse doInBackground(j.a... aVarArr) {
        NotifyAppResponse notifyAppResponse;
        NotifyAppResponse notifyAppResponse2 = null;
        Gson gson = new Gson();
        try {
            byte[] bytes = gson.toJson(aVarArr[0].b).getBytes(Keyczar.DEFAULT_ENCODING);
            URI[] uriArr = aVarArr[0].f3213a;
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
                            StringBuilder sb = new StringBuilder();
                            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                sb.append(new String(bArr, 0, read, Keyczar.DEFAULT_ENCODING));
                            }
                            notifyAppResponse = (NotifyAppResponse) gson.fromJson(sb.toString(), NotifyAppResponse.class);
                            try {
                                httpURLConnection.disconnect();
                            } catch (JsonSyntaxException e) {
                                e = e;
                                Log.i("NotifyApp", "Failed parsing data from server : " + uri, e);
                                this.f3214a = Task.makeTaskError("Failed parsing data from server", e);
                                i++;
                                notifyAppResponse2 = notifyAppResponse;
                            } catch (IOException e2) {
                                e = e2;
                                Log.i("NotifyApp", "Failed reading data from server : " + uri, e);
                                this.f3214a = Task.makeTaskError("Failed reading data from server", e);
                                i++;
                                notifyAppResponse2 = notifyAppResponse;
                            }
                        } catch (Throwable th) {
                            httpURLConnection.disconnect();
                            throw th;
                            break;
                        }
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        notifyAppResponse = notifyAppResponse2;
                    } catch (IOException e4) {
                        e = e4;
                        notifyAppResponse = notifyAppResponse2;
                    }
                } catch (MalformedURLException e5) {
                    Log.i("NotifyApp", "Bad URL; skipping : " + uri, e5);
                    notifyAppResponse = notifyAppResponse2;
                }
                i++;
                notifyAppResponse2 = notifyAppResponse;
            }
            return notifyAppResponse2;
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(NotifyAppResponse notifyAppResponse) {
        if (notifyAppResponse == null) {
            this.b.sendFailure(this.f3214a);
        } else if (notifyAppResponse.result != 6 && notifyAppResponse.result != 0 && notifyAppResponse.result != 13) {
            this.b.sendFailure(ResponseCode.fromValue(notifyAppResponse.result));
        } else {
            this.b.sendResult(notifyAppResponse);
        }
    }
}
