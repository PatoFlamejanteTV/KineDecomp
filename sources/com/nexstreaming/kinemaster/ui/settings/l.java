package com.nexstreaming.kinemaster.ui.settings;

import android.os.AsyncTask;
import com.nexstreaming.app.general.util.C1699c;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
public class L extends AsyncTask<String, Void, CapabilityReport.CapabilityInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceCapabilityProfileImporter f23065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter) {
        this.f23065a = deviceCapabilityProfileImporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CapabilityReport.CapabilityInfo doInBackground(String... strArr) {
        String lowerCase;
        C1699c c1699c = null;
        C1699c c1699c2 = null;
        try {
            try {
                lowerCase = strArr[0].toLowerCase();
                c1699c = new C1699c(this.f23065a.getAssets().open("km_device_capability_chipset_v1.csv"));
            } catch (IOException e2) {
                e = e2;
                c1699c = null;
            } catch (Throwable th) {
                th = th;
                C1702f.a(c1699c2);
                throw th;
            }
            try {
                c1699c.e(lowerCase);
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                C1702f.a(c1699c);
                return null;
            }
            C1702f.a(c1699c);
            return null;
        } catch (Throwable th2) {
            th = th2;
            c1699c2 = c1699c;
            C1702f.a(c1699c2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(CapabilityReport.CapabilityInfo capabilityInfo) {
        this.f23065a.a(capabilityInfo);
    }
}
