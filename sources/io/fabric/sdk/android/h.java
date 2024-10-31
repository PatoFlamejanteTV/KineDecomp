package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FabricKitsFinder.java */
/* loaded from: classes3.dex */
public class h implements Callable<Map<String, n>> {

    /* renamed from: a, reason: collision with root package name */
    final String f26860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f26860a = str;
    }

    private n a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                zipFile = null;
                CommonUtils.a(zipFile);
                throw th;
            }
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
                    n nVar = new n(property, property2, property3);
                    CommonUtils.a((Closeable) inputStream);
                    return nVar;
                }
                throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
            } catch (IOException e3) {
                e = e3;
                f.f().c("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                CommonUtils.a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.a(zipFile);
            throw th;
        }
    }

    private Map<String, n> b() {
        HashMap hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            n nVar = new n("com.google.firebase.firebase-ads", "0.0.0", "binary");
            hashMap.put(nVar.b(), nVar);
            f.f().c("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private Map<String, n> c() throws Exception {
        n a2;
        HashMap hashMap = new HashMap();
        ZipFile a3 = a();
        Enumeration<? extends ZipEntry> entries = a3.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith("fabric/") && nextElement.getName().length() > 7 && (a2 = a(nextElement, a3)) != null) {
                hashMap.put(a2.b(), a2);
                f.f().c("Fabric", String.format("Found kit:[%s] version:[%s]", a2.b(), a2.c()));
            }
        }
        if (a3 != null) {
            try {
                a3.close();
            } catch (IOException unused) {
            }
        }
        return hashMap;
    }

    @Override // java.util.concurrent.Callable
    public Map<String, n> call() throws Exception {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(b());
        hashMap.putAll(c());
        f.f().c("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return hashMap;
    }

    protected ZipFile a() throws IOException {
        return new ZipFile(this.f26860a);
    }
}
