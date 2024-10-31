package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: AdobeDCXJournal.java */
/* loaded from: classes.dex */
public class Ca {

    /* renamed from: a, reason: collision with root package name */
    private String f4132a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f4133b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AdobeDCXJournal.java */
    /* loaded from: classes.dex */
    public interface a {
        JSONObject create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AdobeDCXJournal.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(JSONObject jSONObject) throws AdobeDCXException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Ca(String str, b bVar, a aVar) throws AdobeDCXException {
        String str2;
        JSONObject a2;
        if (new File(str).exists()) {
            try {
                str2 = Za.b(str);
            } catch (IOException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXJournal creation failed", e2.getMessage());
                str2 = null;
            }
            if (str2 == null) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, String.format("Failed to read from journal file %s.", str));
            }
            a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(str2);
            if (a2 == null && aVar == null) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, String.format("Failed to parse the journal data from file %s.", str));
            }
        } else {
            a2 = null;
        }
        if (a2 != null && bVar != null) {
            try {
                bVar.a(a2);
            } catch (AdobeDCXException e3) {
                if (aVar == null) {
                    throw e3;
                }
                a2 = null;
            }
        }
        if (a2 == null && aVar != null) {
            a2 = aVar.create();
        }
        if (a2 != null) {
            this.f4133b = a2;
            this.f4132a = str;
            return;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, "Could not find journal file.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        String str = this.f4132a;
        if (str == null) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public String b() {
        return this.f4133b.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject c() {
        return this.f4133b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() {
        try {
            return Za.b(this.f4132a, b()).booleanValue();
        } catch (IOException unused) {
            return false;
        }
    }
}
