package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultCachedSettingsIo.java */
/* loaded from: classes3.dex */
public class j implements h {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.l f27019a;

    public j(io.fabric.sdk.android.l lVar) {
        this.f27019a = lVar;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:20:0x0059 */
    @Override // io.fabric.sdk.android.services.settings.h
    public JSONObject a() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObject;
        io.fabric.sdk.android.f.f().d("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File file = new File(new io.fabric.sdk.android.a.c.b(this.f27019a).a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.b(fileInputStream));
                        fileInputStream3 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        io.fabric.sdk.android.f.f().c("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    io.fabric.sdk.android.f.f().d("Fabric", "No cached settings found.");
                    jSONObject = null;
                }
                CommonUtils.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                CommonUtils.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream3 = fileInputStream2;
            CommonUtils.a((Closeable) fileInputStream3, "Error while closing settings cache file.");
            throw th;
        }
    }

    @Override // io.fabric.sdk.android.services.settings.h
    public void a(long j, JSONObject jSONObject) {
        io.fabric.sdk.android.f.f().d("Fabric", "Writing settings to cache file...");
        if (jSONObject == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                jSONObject.put("expires_at", j);
                FileWriter fileWriter2 = new FileWriter(new File(new io.fabric.sdk.android.a.c.b(this.f27019a).a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    CommonUtils.a((Closeable) fileWriter2, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    io.fabric.sdk.android.f.f().c("Fabric", "Failed to cache settings", e);
                    CommonUtils.a((Closeable) fileWriter, "Failed to close settings writer.");
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    CommonUtils.a((Closeable) fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
