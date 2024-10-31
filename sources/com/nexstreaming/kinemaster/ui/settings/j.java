package com.nexstreaming.kinemaster.ui.settings;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.JsonReader;
import com.nexstreaming.app.general.util.C1699c;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.ui.settings.DeviceCapabilityProfileImporter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
public class J extends AsyncTask<Void, DeviceCapabilityProfileImporter.a, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceCapabilityProfileImporter f23060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter) {
        this.f23060a = deviceCapabilityProfileImporter;
    }

    private boolean b() {
        InputStream inputStream = null;
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (!absolutePath.endsWith(File.separator)) {
                absolutePath = absolutePath + File.separator;
            }
            inputStream = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", String.format(Locale.US, "find %1$s -type f | grep -E -i \"\\.json\"", absolutePath)}).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return true;
                }
                if (a(readLine)) {
                    publishProgress(new DeviceCapabilityProfileImporter.a(1, readLine));
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } finally {
            C1702f.a(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        return Boolean.valueOf(a() & b());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        DeviceCapabilityProfileImporter.b bVar;
        DeviceCapabilityProfileImporter.b bVar2;
        this.f23060a.H().B.setVisibility(0);
        bVar = this.f23060a.I;
        bVar.f();
        bVar2 = this.f23060a.J;
        bVar2.f();
    }

    private boolean a() {
        C1699c c1699c;
        IOException e2;
        try {
            c1699c = new C1699c(this.f23060a.getAssets().open("km_device_capability_chipset_v1.csv"));
        } catch (IOException e3) {
            c1699c = null;
            e2 = e3;
        } catch (Throwable th) {
            th = th;
            c1699c = null;
            C1702f.a(c1699c);
            throw th;
        }
        try {
            try {
                Iterator<String> a2 = c1699c.a();
                while (a2.hasNext()) {
                    publishProgress(new DeviceCapabilityProfileImporter.a(0, a2.next()));
                }
                C1702f.a(c1699c);
                return true;
            } catch (Throwable th2) {
                th = th2;
                C1702f.a(c1699c);
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            e2.printStackTrace();
            C1702f.a(c1699c);
            return false;
        }
    }

    private boolean a(String str) {
        JsonReader jsonReader = null;
        try {
            try {
                JsonReader jsonReader2 = new JsonReader(new FileReader(str));
                try {
                    jsonReader2.beginObject();
                    while (jsonReader2.hasNext()) {
                        if ("capabilityInfo".equalsIgnoreCase(jsonReader2.nextName())) {
                            C1702f.a(jsonReader2);
                            return true;
                        }
                        jsonReader2.skipValue();
                    }
                    jsonReader2.endObject();
                    C1702f.a(jsonReader2);
                    return false;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    jsonReader = jsonReader2;
                    e.printStackTrace();
                    C1702f.a(jsonReader);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    jsonReader = jsonReader2;
                    e.printStackTrace();
                    C1702f.a(jsonReader);
                    return false;
                } catch (IllegalStateException e4) {
                    e = e4;
                    jsonReader = jsonReader2;
                    e.printStackTrace();
                    C1702f.a(jsonReader);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    jsonReader = jsonReader2;
                    C1702f.a(jsonReader);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            } catch (IllegalStateException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(DeviceCapabilityProfileImporter.a... aVarArr) {
        DeviceCapabilityProfileImporter.b bVar;
        DeviceCapabilityProfileImporter.b bVar2;
        DeviceCapabilityProfileImporter.a aVar = aVarArr[0];
        if (aVar.f23030a == 0) {
            bVar2 = this.f23060a.I;
            bVar2.a(aVar);
        } else {
            bVar = this.f23060a.J;
            bVar.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        DeviceCapabilityProfileImporter.b bVar;
        DeviceCapabilityProfileImporter.b bVar2;
        bVar = this.f23060a.I;
        bVar.g();
        bVar.notifyDataSetChanged();
        bVar2 = this.f23060a.J;
        bVar2.g();
        bVar2.notifyDataSetChanged();
        this.f23060a.H().B.setVisibility(8);
    }
}
