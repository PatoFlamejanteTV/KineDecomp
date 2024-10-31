package com.nexstreaming.kinemaster.ui.settings;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
public class M extends AsyncTask<Uri, Void, CapabilityReport.CapabilityInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceCapabilityProfileImporter f23067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter) {
        this.f23067a = deviceCapabilityProfileImporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CapabilityReport.CapabilityInfo doInBackground(Uri... uriArr) {
        Throwable th;
        InputStream inputStream;
        String str;
        String str2;
        String str3;
        try {
            try {
                inputStream = this.f23067a.getContentResolver().openInputStream(uriArr[0]);
            } catch (JsonSyntaxException e2) {
                e = e2;
                inputStream = null;
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = null;
            } catch (UnsupportedEncodingException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                uriArr = 0;
                C1702f.a(uriArr);
                throw th;
            }
            if (inputStream == null) {
                C1702f.a(inputStream);
                return null;
            }
            try {
                CapabilityReport capabilityReport = (CapabilityReport) new Gson().fromJson((Reader) new BufferedReader(new InputStreamReader(inputStream, "UTF-8")), CapabilityReport.class);
                if (capabilityReport != null) {
                    CapabilityReport.CapabilityInfo capabilityInfo = capabilityReport.capabilityInfo;
                    C1702f.a(inputStream);
                    return capabilityInfo;
                }
            } catch (JsonSyntaxException e5) {
                e = e5;
                str3 = DeviceCapabilityProfileImporter.TAG;
                Log.e(str3, e.getMessage(), e);
                C1702f.a(inputStream);
                return null;
            } catch (FileNotFoundException e6) {
                e = e6;
                str2 = DeviceCapabilityProfileImporter.TAG;
                Log.e(str2, e.getMessage(), e);
                C1702f.a(inputStream);
                return null;
            } catch (UnsupportedEncodingException e7) {
                e = e7;
                str = DeviceCapabilityProfileImporter.TAG;
                Log.e(str, e.getMessage(), e);
                C1702f.a(inputStream);
                return null;
            }
            C1702f.a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C1702f.a(uriArr);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(CapabilityReport.CapabilityInfo capabilityInfo) {
        this.f23067a.a(capabilityInfo);
    }
}
