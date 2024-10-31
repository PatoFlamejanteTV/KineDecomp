package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXLocalStorageCopyOnWrite.java */
/* loaded from: classes.dex */
public class Da implements ob {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f4135a = new SimpleDateFormat("yyyy-MM-dd");

    private String a(C0225c c0225c) {
        String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
        String b2 = org.apache.commons.io.c.b(c0225c.k());
        if (b2 == null || b2.length() <= 0) {
            return a2;
        }
        return a2.concat(org.apache.commons.io.c.f29315a + b2);
    }

    private boolean n(C0231f c0231f) {
        File file = new File(org.apache.commons.io.c.a(c0231f.z(), "manifest.base"));
        boolean c2 = file.exists() ? org.apache.commons.io.b.c(file) : true;
        if (c2) {
            c0231f.S();
        }
        return c2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0141 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0142 A[RETURN] */
    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r18) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Da.b(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f):long");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String c(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String d(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push.manifest.base");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String e(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "clientdata");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String f(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "pull.manifest.base");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String g(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "pull.manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String h(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push.journal");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean i(C0231f c0231f) {
        return a(c0231f) && n(c0231f) && m(c0231f);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean j(C0231f c0231f) {
        File[] listFiles;
        File file = new File(org.apache.commons.io.c.a(c0231f.z(), "components"));
        if (file.exists() && file.isDirectory() && ((listFiles = file.listFiles()) == null || listFiles.length == 0)) {
            return false;
        }
        try {
            org.apache.commons.io.b.b(new File(c0231f.z()));
            return true;
        } catch (IOException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXLocalStorageCopyOnWrite.removeLocalFilesOfComposite", e2.getMessage());
            return false;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String k(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push.manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String l(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "manifest.base");
    }

    public boolean m(C0231f c0231f) {
        File file = new File(org.apache.commons.io.c.a(c0231f.z(), "push.journal"));
        boolean z = !file.exists() || org.apache.commons.io.b.c(file);
        if (z) {
            File file2 = new File(org.apache.commons.io.c.a(c0231f.z(), "push.manifest"));
            z = !file2.exists() || org.apache.commons.io.b.c(file2);
        }
        if (z) {
            File file3 = new File(org.apache.commons.io.c.a(c0231f.z(), "push.manifest.base"));
            z = !file3.exists() || org.apache.commons.io.b.c(file3);
        }
        if (z) {
            b(c0231f);
        }
        return z;
    }

    private String c(C0225c c0225c, Fa fa) {
        JSONObject a2 = a(fa, true);
        String optString = a2.optString(c0225c.b(), null);
        if (optString == null && fa.d(c0225c) == null) {
            optString = a(c0225c);
            try {
                a2.putOpt(c0225c.b(), optString);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXLocalStorageCopyOnWrite.getStorageIdForComponent", e2.getMessage());
                return null;
            }
        }
        return optString;
    }

    private JSONObject a(Fa fa, boolean z) {
        JSONObject jSONObject = (JSONObject) fa.b("local");
        if (jSONObject == null) {
            if (!z) {
                return null;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("copyOnWrite#storageIds", new JSONObject());
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXLocalStorageCopyOnWrite.getStorageIdLookupOfManifest", e2.getMessage());
            }
            fa.a(jSONObject, "local");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("copyOnWrite#storageIds");
        if (optJSONObject == null) {
            if (!z) {
                return null;
            }
            optJSONObject = new JSONObject();
            try {
                jSONObject.putOpt("copyOnWrite#storageIds", optJSONObject);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXLocalStorageCopyOnWrite.getStorageIdLookupOfManifest", e3.getMessage());
            }
        }
        return optJSONObject;
    }

    private String a(C0225c c0225c, Fa fa, boolean z) {
        if (z) {
            return c(c0225c, fa);
        }
        JSONObject a2 = a(fa, false);
        if (a2 == null) {
            return null;
        }
        return a2.optString(c0225c.b(), null);
    }

    private void a(String str, C0225c c0225c, Fa fa) {
        JSONObject a2 = a(fa, true);
        try {
            if (str == null) {
                a2.remove(c0225c.b());
            } else {
                a2.putOpt(c0225c.b(), str);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXLocalStorageCopyOnWrite.setStorageId", e2.getMessage());
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String a(C0225c c0225c, Fa fa, C0231f c0231f) throws AdobeDCXException {
        String a2 = org.apache.commons.io.c.a(org.apache.commons.io.c.a(c0231f.z(), "components"), a(c0225c));
        if (!new File(a2).exists()) {
            return a2;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure, "Component file already exits at " + a2);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(Ka ka, Fa fa, C0231f c0231f, String str) throws AdobeDCXException {
        if (str == null) {
            a((String) null, ka, fa);
            return true;
        }
        String k = org.apache.commons.io.c.k(org.apache.commons.io.c.a(c0231f.z(), "components"));
        String j = org.apache.commons.io.c.j(str);
        if (j.startsWith(k)) {
            a(new File(j).getName(), ka, fa);
            com.adobe.creativesdk.foundation.internal.storage.model.util.f.d(j);
            if (c0231f.v()) {
                com.adobe.creativesdk.foundation.internal.storage.model.util.f.c(j);
            }
            ka.a(org.apache.commons.io.b.h(new File(j)));
            return true;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath, "Component path " + j + " reaches out of composite directory");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String a(C0225c c0225c, Fa fa, C0231f c0231f, boolean z) throws AdobeDCXException {
        if (fa.d(c0225c) != null) {
            return null;
        }
        String c2 = c(c0225c, fa);
        String k = org.apache.commons.io.c.k(org.apache.commons.io.c.a(c0231f.z(), "components"));
        String j = org.apache.commons.io.c.j(org.apache.commons.io.c.a(k, c2));
        if (j.startsWith(k)) {
            return j;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath, "Component path " + c0225c.k() + " reaches out of composite directory");
    }

    public void b(C0225c c0225c, Fa fa) {
        JSONObject a2 = a(fa, false);
        if (a2 == null || a2.opt(c0225c.b()) == null) {
            return;
        }
        a2.remove(c0225c.b());
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(Fa fa, C0231f c0231f) throws AdobeDCXException {
        String g2 = g(c0231f);
        String c2 = c(c0231f);
        boolean z = true;
        if (fa != null) {
            fa.a(c2, true);
            org.apache.commons.io.b.c(new File(g2));
        } else {
            if (!new File(g2).exists()) {
                return true;
            }
            z = com.adobe.creativesdk.foundation.internal.storage.model.util.f.b(g2, c2);
        }
        if (!z) {
            return z;
        }
        boolean b2 = com.adobe.creativesdk.foundation.internal.storage.model.util.f.b(f(c0231f), l(c0231f));
        c0231f.S();
        return b2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(C0231f c0231f) {
        File file = new File(org.apache.commons.io.c.a(c0231f.z(), "pull.manifest"));
        boolean z = !file.exists() || org.apache.commons.io.b.c(file);
        if (!z) {
            return z;
        }
        File file2 = new File(org.apache.commons.io.c.a(c0231f.z(), "pull.manifest.base"));
        return !file2.exists() || org.apache.commons.io.b.c(file2);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public void a(Fa fa, List<Fa> list) {
        ArrayList arrayList = new ArrayList();
        com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(fa.b(), (ArrayList<C0225c>) arrayList);
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                C0225c c0225c = (C0225c) it.next();
                String a2 = a(c0225c, fa, false);
                if (a2 == null) {
                    Iterator<Fa> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Fa next = it2.next();
                        if (next != null) {
                            C0225c c0225c2 = next.b() != null ? next.b().get(c0225c.b()) : null;
                            if (c0225c2 != null && next.d(c0225c2) != null) {
                                z = true;
                                break;
                            } else if (c0225c2 != null && c0225c.d().equals(c0225c2.d()) && !c0225c2.m().equals("modified") && (a2 = c(c0225c2, next)) != null) {
                                break;
                            }
                        }
                    }
                    if (z) {
                        break;
                    }
                    if (a2 == null) {
                        a2 = a(c0225c);
                    }
                    a(a2, c0225c, fa);
                }
            }
            return;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public void a(C0225c c0225c, Fa fa) {
        b(c0225c, fa);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(C0225c c0225c, Fa fa, Fa fa2) {
        String c2 = c(c0225c, fa);
        String c3 = c(c0225c, fa2);
        return (c2 == null || c3 == null || !c2.equals(c3)) ? false : true;
    }
}
