package com.nexstreaming.kinemaster.kmpackage;

import android.content.Intent;
import android.os.AsyncTask;
import com.facebook.internal.Utility;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.KMTServerIndex;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class d extends AsyncTask<URI, Integer, KMTServerIndex> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f3448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EffectLibrary effectLibrary) {
        this.f3448a = effectLibrary;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public KMTServerIndex doInBackground(URI... uriArr) {
        int i;
        int i2;
        KMTServerIndex kMTServerIndex;
        int i3;
        HttpURLConnection httpURLConnection;
        int i4;
        int i5;
        int i6 = 0;
        do {
            int i7 = i6;
            int length = uriArr.length;
            int i8 = 0;
            int i9 = 0;
            while (i8 < length) {
                URI uri = uriArr[i8];
                try {
                    httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
                    httpURLConnection.setInstanceFollowRedirects(true);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    kMTServerIndex = null;
                    i3 = i9;
                } catch (SocketTimeoutException e2) {
                    kMTServerIndex = null;
                    i3 = i9 + 1;
                } catch (ConnectTimeoutException e3) {
                    kMTServerIndex = null;
                    i3 = i9 + 1;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    kMTServerIndex = null;
                    i3 = i9;
                }
                try {
                    if (!uri.getHost().equals(httpURLConnection.getURL().getHost())) {
                        if (EffectLibrary.H != null) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addFlags(268435456);
                            intent.setData(EffectLibrary.H);
                            this.f3448a.g.startActivity(intent);
                        }
                        return null;
                    }
                    i4 = this.f3448a.ae;
                    httpURLConnection.setConnectTimeout(i4);
                    i5 = this.f3448a.af;
                    httpURLConnection.setReadTimeout(i5);
                    httpURLConnection.getResponseCode();
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
                    String sb2 = sb.toString();
                    if (Pattern.compile(".*http-equiv=\"?refresh\"?.*", 2).matcher(sb2).find()) {
                        if (EffectLibrary.H != null) {
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            intent2.setData(EffectLibrary.H);
                            this.f3448a.g.startActivity(intent2);
                        }
                        return null;
                    }
                    KMTServerIndex kMTServerIndex2 = (KMTServerIndex) new Gson().fromJson(sb2, KMTServerIndex.class);
                    try {
                        if (httpURLConnection.getURL() == null || kMTServerIndex2 == null) {
                            kMTServerIndex2 = null;
                        } else {
                            kMTServerIndex2.base_uri = httpURLConnection.getURL().toURI();
                        }
                    } catch (URISyntaxException e5) {
                        kMTServerIndex2 = null;
                    }
                    kMTServerIndex = kMTServerIndex2;
                    i3 = i9;
                    if (kMTServerIndex != null) {
                        return kMTServerIndex;
                    }
                    i8++;
                    i9 = i3;
                } finally {
                    httpURLConnection.disconnect();
                }
            }
            if (i9 >= uriArr.length) {
                EffectLibrary effectLibrary = this.f3448a;
                i = this.f3448a.ae;
                effectLibrary.ae = Math.min(35000, i + 5000);
                EffectLibrary effectLibrary2 = this.f3448a;
                i2 = this.f3448a.af;
                effectLibrary2.af = Math.min(35000, i2 + 5000);
            }
            i6 = i7 + 1;
        } while (i6 <= 2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(KMTServerIndex kMTServerIndex) {
        ResultTask resultTask;
        ResultTask resultTask2;
        ResultTask resultTask3;
        ResultTask resultTask4;
        ResultTask resultTask5;
        int i;
        com.nexstreaming.kinemaster.b.a aVar = new com.nexstreaming.kinemaster.b.a();
        Theme[] themeArr = null;
        if (kMTServerIndex != null) {
            if (kMTServerIndex.fontlists != null) {
                this.f3448a.J = kMTServerIndex.fontlists;
                this.f3448a.K = true;
                this.f3448a.L = kMTServerIndex.base_uri;
            }
            int length = kMTServerIndex.themes.length;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                KMTServerIndex.Item item = kMTServerIndex.themes[i4];
                if (item.minimum_version <= 1) {
                    i2++;
                    if (i3 < item.package_date) {
                        i3 = item.package_date;
                    }
                }
            }
            Theme[] themeArr2 = new Theme[i2];
            int i5 = 0;
            int i6 = 0;
            while (i6 < length) {
                KMTServerIndex.Item item2 = kMTServerIndex.themes[i6];
                if (item2.minimum_version > 1) {
                    i = i5;
                } else {
                    if (item2.id == null || item2.id.trim().length() < 1) {
                        themeArr = null;
                        break;
                    }
                    Theme e = this.f3448a.e(item2.id);
                    if (e == null) {
                        Theme b = Theme.b(item2.id);
                        b.a(item2, kMTServerIndex.base_uri, this.f3448a, item2.package_date > i3 + (-30));
                        e = b;
                    } else {
                        e.a(item2, kMTServerIndex.base_uri);
                    }
                    themeArr2[i5] = e;
                    i = i5 + 1;
                }
                i6++;
                i5 = i;
            }
            themeArr = themeArr2;
        }
        if (themeArr == null) {
            resultTask4 = this.f3448a.t;
            if (resultTask4 != null) {
                resultTask5 = this.f3448a.t;
                resultTask5.signalEvent(Task.Event.FAIL);
                this.f3448a.t = null;
            }
        } else {
            resultTask = this.f3448a.t;
            if (resultTask != null) {
                resultTask2 = this.f3448a.t;
                resultTask2.setResult(themeArr);
                resultTask3 = this.f3448a.t;
                resultTask3.signalEvent(Task.Event.COMPLETE);
            }
            this.f3448a.F = System.nanoTime();
        }
        aVar.a();
    }
}
