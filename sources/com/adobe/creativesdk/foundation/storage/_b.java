package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import junit.framework.Assert;

/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
class _b {
    public static com.adobe.creativesdk.foundation.internal.net.E a(Lb lb, boolean z, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar, Handler handler) {
        Qb qb = new Qb(raVar, lb, tVar);
        if (lb.c().p().o()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "Warning: pushComposite has been called with a composite that has uncommitted changes in its current branch. ", "Uncommitted changes will not be included in the pushed composite.");
        }
        try {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa d2 = lb.c().d();
            C0324c c0324c = new C0324c();
            FutureTask futureTask = new FutureTask(new Sb(lb, d2, z, raVar, c0324c, qb, handler, fVar));
            c0324c.a(futureTask);
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.c().execute(futureTask);
            return c0324c;
        } catch (AdobeDCXException e2) {
            if (fVar == null) {
                return null;
            }
            a(fVar, handler, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mb b(Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c) throws AdobeCSDKException {
        if (a(lb, tVar, raVar, c0324c) != null) {
            return a((ArrayList<C0536ac>) null, false, lb, raVar, c0324c);
        }
        return null;
    }

    public static boolean a(Lb lb, boolean z, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar) throws AdobeCSDKException {
        Ub ub = new Ub(raVar, lb, tVar);
        if (lb.c().p().o()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "Warning: pushComposite has been called with a composite that has uncommitted changes in its current branch. ", "Uncommitted changes will not be included in the pushed composite.");
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa = null;
        try {
            fa = lb.c().d();
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDCompositeXfer.pushPSDComposite", e2.getMessage());
        }
        return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(lb.c(), fa, z, raVar, new C0324c(), ub);
    }

    public static void a(com.adobe.creativesdk.foundation.adobeinternal.storage.psd.f fVar, Handler handler, AdobeCSDKException adobeCSDKException) {
        if (handler != null) {
            handler.post(new Vb(fVar, adobeCSDKException));
        } else if (fVar != null) {
            fVar.a(adobeCSDKException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0040 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r8, com.adobe.creativesdk.foundation.internal.storage.model.resources.f r9) {
        /*
            java.lang.String r0 = "source"
            java.lang.String r1 = "AdobePSDCompositeXfer.createUpdatedManifestFromPushedManifest"
            r2 = 0
            if (r9 == 0) goto L95
            byte[] r3 = r9.d()
            if (r3 == 0) goto L95
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r3 = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa     // Catch: java.io.UnsupportedEncodingException -> L1e com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L23
            java.lang.String r4 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L1e com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L23
            byte[] r5 = r9.d()     // Catch: java.io.UnsupportedEncodingException -> L1e com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L23
            java.lang.String r6 = "UTF-8"
            r4.<init>(r5, r6)     // Catch: java.io.UnsupportedEncodingException -> L1e com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L23
            r3.<init>(r4)     // Catch: java.io.UnsupportedEncodingException -> L1e com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L23
            goto L2e
        L1e:
            r3 = move-exception
            r3.printStackTrace()
            goto L2d
        L23:
            r3 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r4 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r3 = r3.getMessage()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r4, r1, r3)
        L2d:
            r3 = r2
        L2e:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.j()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L33
            goto L3e
        L33:
            r7 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r4 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r7 = r7.getMessage()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r4, r1, r7)
            r7 = r2
        L3e:
            if (r7 == 0) goto L96
            if (r3 == 0) goto L96
            java.lang.String r9 = r9.f6613e
            r7.g(r9)
            org.json.JSONObject r9 = r3.m()
            java.lang.Object r9 = r9.get(r0)     // Catch: org.json.JSONException -> L52
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch: org.json.JSONException -> L52
            goto L5d
        L52:
            r9 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r9 = r9.getMessage()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r1, r9)
            r9 = r2
        L5d:
            if (r9 == 0) goto L96
            org.json.JSONObject r2 = r7.m()
            if (r2 != 0) goto L72
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r9 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(r9)     // Catch: org.json.JSONException -> L84
            r2.put(r0, r9)     // Catch: org.json.JSONException -> L84
            goto L84
        L72:
            org.json.JSONObject r9 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(r9)     // Catch: org.json.JSONException -> L7a
            r2.put(r0, r9)     // Catch: org.json.JSONException -> L7a
            goto L84
        L7a:
            r9 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r0 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r9 = r9.getMessage()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r0, r1, r9)
        L84:
            r7.b(r2)
            java.net.URI r9 = r7.g()
            if (r9 != 0) goto L96
            java.net.URI r8 = r8.r()
            r7.a(r8)
            goto L96
        L95:
            r7 = r2
        L96:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.storage._b.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, com.adobe.creativesdk.foundation.internal.storage.model.resources.f):com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa");
    }

    public static com.adobe.creativesdk.foundation.internal.net.E a(Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar, Handler handler) {
        C0324c c0324c = new C0324c();
        boolean[] zArr = {false};
        Yb yb = new Yb(new Xb(zArr, lb, tVar, raVar, c0324c, handler, eVar), zArr, eVar, handler, c0324c);
        c0324c.a(yb);
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.c().execute(yb);
        return c0324c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.adobe.creativesdk.foundation.adobeinternal.storage.psd.e eVar, Handler handler, AdobeCSDKException adobeCSDKException) {
        if (handler != null) {
            handler.post(new Zb(eVar, adobeCSDKException));
        } else if (eVar != null) {
            eVar.a(adobeCSDKException);
        }
    }

    static Mb a(Lb lb, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c) throws AdobeCSDKException {
        Assert.assertNotNull("composite should not be null", lb);
        C0231f c2 = lb.c();
        Assert.assertNotNull("composite.dcxComposite should not be null", c2);
        if (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(lb.c(), raVar, c0324c, new Pb(raVar, c2, tVar, lb)) == null) {
            return null;
        }
        return lb.e();
    }

    static Mb a(ArrayList<C0536ac> arrayList, boolean z, Lb lb, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0324c c0324c) throws AdobeCSDKException {
        ArrayList arrayList2;
        if (arrayList != null) {
            arrayList2 = new ArrayList();
            C0233g A = lb.c().A();
            if (A == null) {
                A = lb.c().p();
            }
            Iterator<C0536ac> it = arrayList.iterator();
            while (it.hasNext()) {
                a((ArrayList<C0225c>) arrayList2, it.next().a(), z, A);
            }
        } else {
            arrayList2 = null;
        }
        if (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a((ArrayList<C0225c>) arrayList2, lb.c(), raVar) == null) {
            return null;
        }
        if (lb.e() != null) {
            return lb.e();
        }
        return lb.b();
    }

    static void a(ArrayList<C0225c> arrayList, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, boolean z, C0233g c0233g) {
        List<C0225c> b2 = c0233g.b(ha);
        if (b2 != null && b2.size() > 0) {
            arrayList.addAll(b2);
        }
        if (z) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> it = c0233g.a(ha).iterator();
            while (it.hasNext()) {
                a(arrayList, it.next(), true, c0233g);
            }
        }
    }
}
