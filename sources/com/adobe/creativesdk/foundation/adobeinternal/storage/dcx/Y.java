package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class Y {

    /* renamed from: a, reason: collision with root package name */
    private static volatile com.adobe.creativesdk.foundation.internal.net.k f4276a;

    /* renamed from: b, reason: collision with root package name */
    private static Integer f4277b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f4278c = new Object();

    /* compiled from: AdobeDCXCompositeXfer.java */
    /* loaded from: classes.dex */
    interface a {
    }

    /* compiled from: AdobeDCXCompositeXfer.java */
    /* loaded from: classes.dex */
    interface b {
    }

    /* compiled from: AdobeDCXCompositeXfer.java */
    /* loaded from: classes.dex */
    interface c {
    }

    public static com.adobe.creativesdk.foundation.internal.net.k c() {
        d();
        return f4276a;
    }

    private static void d() {
        if (f4276a == null) {
            f4276a = new com.adobe.creativesdk.foundation.internal.net.k(5, 5, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            f4277b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(rb rbVar, Handler handler, AdobeCSDKException adobeCSDKException) {
        if (handler != null) {
            handler.post(new RunnableC0260u(rbVar, adobeCSDKException));
        } else {
            rbVar.a(adobeCSDKException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(qb qbVar, Handler handler, AdobeCSDKException adobeCSDKException) {
        if (handler != null) {
            handler.post(new P(qbVar, adobeCSDKException));
        } else {
            qbVar.a(null, adobeCSDKException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(String str, C0225c c0225c, C0231f c0231f) {
        File file = new File(str);
        if (c0231f.L() && c0225c.f() != -1) {
            return c0225c.f();
        }
        return file.length();
    }

    public static com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, boolean z, com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, rb rbVar, Handler handler) {
        d();
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pushComposite compositeId = ");
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        Q q = new Q(c0231f, raVar);
        if (c0231f.p() != null && c0231f.p().o()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, Y.class.getSimpleName(), "pushComposite has been called with a composite that has uncommitted changes in its current branch.Uncommitted changes will not be included in the pushed composite.");
        }
        try {
            Fa d2 = c0231f.d();
            String n = c0231f.n();
            Aa o = c0231f.o();
            rb s = o != null ? new S(rbVar, c0231f, o) : rbVar;
            C0324c c0324c = new C0324c();
            FutureTask futureTask = new FutureTask(new U(c0324c, c0231f, d2, z, raVar, q, handler, s));
            c0324c.a(futureTask);
            f4276a.execute(futureTask);
            if (o != null) {
                o.c(n, c0324c);
            }
            return c0324c;
        } catch (AdobeDCXException e2) {
            if (rbVar != null) {
                b(rbVar, handler, e2);
            }
            return null;
        }
    }

    public static com.adobe.creativesdk.foundation.internal.net.E b(C0231f c0231f, zb zbVar, qb qbVar, Handler handler) {
        d();
        C0245m c0245m = new C0245m(c0231f, zbVar);
        C0324c c0324c = new C0324c();
        String n = c0231f.n();
        Aa o = c0231f.o();
        FutureTask futureTask = new FutureTask(new CallableC0251p(c0324c, c0231f, zbVar, c0245m, handler, o != null ? new C0247n(qbVar, o, c0231f) : qbVar));
        c0324c.a(futureTask);
        f4276a.execute(futureTask);
        if (o != null) {
            o.b(n, c0324c);
        }
        return c0324c;
    }

    private static Fa b(C0231f c0231f) {
        Fa fa;
        String C = c0231f.C();
        File file = new File(C);
        if (!file.exists()) {
            return null;
        }
        try {
            fa = Fa.a(C);
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer.getPreviouslyPulledManifestOfComposite", e2.getMessage(), e2);
            fa = null;
        }
        Fa w = c0231f.w();
        if (w == null || fa == null || w.h() == null || w.h().equals(fa.h())) {
            return fa;
        }
        file.delete();
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0130, code lost:            if (r3 == null) goto L61;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0132, code lost:            r4 = r10.a(r3);     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ab] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ab] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.zb] */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.adobe.creativesdk.foundation.internal.storage.a.b.ra] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r30v0, types: [java.util.ArrayList<com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException, android.os.Handler, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r25, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r26, com.adobe.creativesdk.foundation.internal.storage.a.b.ra r27, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Qa r28, com.adobe.creativesdk.foundation.internal.net.C0324c r29, java.util.ArrayList<com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException> r30) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, com.adobe.creativesdk.foundation.internal.storage.a.b.ra, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Qa, com.adobe.creativesdk.foundation.internal.net.c, java.util.ArrayList):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static C0233g b(ArrayList<C0225c> arrayList, C0231f c0231f, Fa fa, zb zbVar, C0324c c0324c) throws AdobeCSDKException {
        HashSet hashSet;
        ReentrantLock reentrantLock;
        String str;
        HashSet hashSet2;
        ArrayList arrayList2;
        Fa fa2;
        AdobeCSDKException adobeCSDKException;
        C c2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "Entered inside internalDownloadComponents");
        String C = c0231f.C();
        String q = c0231f.q();
        Fa w = c0231f.w();
        ReentrantLock reentrantLock2 = new ReentrantLock(true);
        Fa a2 = (w == null && new File(q).exists()) ? Fa.a(q) : w;
        AdobeCSDKException adobeCSDKException2 = null;
        db dbVar = zbVar.b() == null ? null : new db(zbVar, c0324c);
        boolean z = fa != null;
        Fa fa3 = !z ? a2 : fa;
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null) {
            HashSet hashSet3 = new HashSet();
            Iterator<C0225c> it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet3.add(it.next().b());
            }
            hashSet = hashSet3;
        } else {
            hashSet = null;
        }
        if (fa3 == null) {
            return null;
        }
        Map<String, C0225c> b2 = fa3.b();
        C c3 = new C(b2.size(), arrayList3);
        for (Map.Entry<String, C0225c> entry : b2.entrySet()) {
            reentrantLock2.lock();
            try {
                if (hashSet != null && !hashSet.contains(entry.getKey())) {
                    c3.a(adobeCSDKException2);
                    reentrantLock2.unlock();
                } else {
                    C0225c c0225c = fa3.b().get(entry.getKey());
                    String d2 = fa3.d(c0225c);
                    if (dbVar == null) {
                        reentrantLock = reentrantLock2;
                        C c4 = c3;
                        hashSet2 = hashSet;
                        arrayList2 = arrayList3;
                        fa2 = fa3;
                        String str2 = C;
                        str = C;
                        String str3 = adobeCSDKException2;
                        try {
                            new A(reentrantLock2, fa3, dbVar, c0225c, c4, c0231f, z, str2, a2, c0324c, zbVar).a(str3, c0225c, str3);
                            c2 = c4;
                            adobeCSDKException = str3;
                        } catch (Throwable th) {
                            th = th;
                            reentrantLock.unlock();
                            throw th;
                        }
                    } else {
                        str = C;
                        C c5 = c3;
                        hashSet2 = hashSet;
                        arrayList2 = arrayList3;
                        fa2 = fa3;
                        adobeCSDKException = adobeCSDKException2;
                        reentrantLock = reentrantLock2;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "calling requestFileToDownloadComponent inside internalDownloadComponents");
                        c2 = c5;
                        dbVar.a(c0225c, c0231f, d2, new F(reentrantLock, c5, fa2, c0225c, zbVar, c0324c, a2, str, z, c0231f, dbVar), new D(c2));
                    }
                    reentrantLock.unlock();
                    adobeCSDKException2 = adobeCSDKException;
                    c3 = c2;
                    reentrantLock2 = reentrantLock;
                    hashSet = hashSet2;
                    arrayList3 = arrayList2;
                    fa3 = fa2;
                    C = str;
                }
            } catch (Throwable th2) {
                th = th2;
                reentrantLock = reentrantLock2;
            }
        }
        ArrayList arrayList4 = arrayList3;
        Fa fa4 = fa3;
        c3.a();
        if (arrayList4.size() > 0) {
            AdobeCSDKException adobeCSDKException3 = (AdobeCSDKException) arrayList4.get(0);
            arrayList4.remove(0);
            HashMap<String, Object> data = adobeCSDKException3.getData();
            if (arrayList4.size() <= 0) {
                throw adobeCSDKException3;
            }
            if (data != null) {
                data.put(AdobeCSDKException.AdobeErrorOtherErrorsKey, arrayList4);
                throw adobeCSDKException3;
            }
            new HashMap();
            throw adobeCSDKException3;
        }
        c0324c.f();
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "Exiting internalDownloadComponents");
        if (z) {
            c0231f.b(fa4);
            return c0231f.A();
        }
        return c0231f.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0233g b(C0231f c0231f, zb zbVar, C0324c c0324c) throws AdobeCSDKException {
        C0233g a2 = a(c0231f, zbVar, c0324c, new C0258t(c0231f, zbVar));
        if (a2 != null) {
            return b(null, c0231f, a2.g(), zbVar, c0324c);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x011d, code lost:            if ((r0.getData().containsKey(com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException.AdobeNetworkHTTPStatusKey) ? ((java.lang.Integer) r0.getData().get(com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue() : 0) == 404) goto L54;     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r21, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r22, boolean r23, com.adobe.creativesdk.foundation.internal.storage.a.b.ra r24, com.adobe.creativesdk.foundation.internal.net.C0324c r25, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb r26) throws com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa, boolean, com.adobe.creativesdk.foundation.internal.storage.a.b.ra, com.adobe.creativesdk.foundation.internal.net.c, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.lb):boolean");
    }

    public static com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, zb zbVar, qb qbVar, Handler handler) {
        d();
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pullComposite compositeId = ");
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        C0324c c0324c = new C0324c();
        String n = c0231f.n();
        Aa o = c0231f.o();
        FutureTask futureTask = new FutureTask(new CallableC0243l(c0324c, c0231f, zbVar, handler, o != null ? new C0239j(qbVar, c0231f, o) : qbVar));
        c0324c.a(futureTask);
        f4276a.execute(futureTask);
        if (o != null) {
            o.b(n, c0324c);
        }
        return c0324c;
    }

    public static com.adobe.creativesdk.foundation.internal.net.E a(ArrayList<C0225c> arrayList, C0233g c0233g, zb zbVar, qb qbVar, Handler handler) {
        d();
        C0231f l = c0233g.l();
        if (l == null) {
            return null;
        }
        C0324c c0324c = new C0324c();
        String n = l.n();
        Aa o = l.o();
        FutureTask futureTask = new FutureTask(new CallableC0256s(c0324c, arrayList, l, c0233g.equals(l.p()) ? null : c0233g.g(), zbVar, handler, o != null ? new C0253q(qbVar, o, n) : qbVar));
        c0324c.a(futureTask);
        f4276a.execute(futureTask);
        if (o != null) {
            o.a(n, c0324c);
        }
        return c0324c;
    }

    public static C0233g a(ArrayList<C0225c> arrayList, C0233g c0233g, zb zbVar) throws AdobeCSDKException {
        d();
        C0231f l = c0233g.l();
        if (l == null) {
            return null;
        }
        return b(arrayList, l, c0233g != l.p() ? c0233g.g() : null, zbVar, new C0324c());
    }

    public static C0233g a(ArrayList<C0225c> arrayList, C0231f c0231f, zb zbVar) throws AdobeCSDKException {
        d();
        return a(arrayList, c0231f.A() != null ? c0231f.A() : c0231f.p(), zbVar);
    }

    private static Fa a(C0231f c0231f) throws AdobeDCXException {
        String q = c0231f.q();
        File file = new File(q);
        if (c0231f.p() == null && file.exists()) {
            try {
                c0231f.a(Fa.a(q), true);
            } catch (AdobeDCXException e2) {
                if (e2.getErrorCode() == AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest) {
                    throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalManifest, null, e2.getData(), e2);
                }
                throw e2;
            }
        }
        if (c0231f.p() == null) {
            return null;
        }
        return c0231f.p().g();
    }

    private static AdobeCSDKException a(AdobeCSDKException adobeCSDKException, com.adobe.creativesdk.foundation.internal.net.E e2) {
        if (e2 != null && e2.c()) {
            adobeCSDKException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
        } else {
            if (adobeCSDKException.getClass().equals(AdobeNetworkException.class) && ((AdobeNetworkException) adobeCSDKException).getStatusCode().intValue() == 404) {
                return new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorMissingManifest, adobeCSDKException.getDescription(), adobeCSDKException.getData(), null);
            }
            if (adobeCSDKException.getClass().equals(AdobeDCXException.class) && ((AdobeDCXException) adobeCSDKException).getErrorCode() == AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest) {
                return new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidRemoteManifest, adobeCSDKException.getDescription(), adobeCSDKException.getData(), null);
            }
            if (adobeCSDKException.getData() != null && adobeCSDKException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey) && ((Integer) adobeCSDKException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue() == 404) {
                return new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorMissingManifest, adobeCSDKException.getDescription(), adobeCSDKException.getData(), null);
            }
        }
        return adobeCSDKException;
    }

    private static C0233g a(C0231f c0231f, C0324c c0324c, Fa fa, Fa fa2) throws AdobeDCXException {
        Fa w = c0231f.w();
        if (fa == null) {
            if (fa2 == null) {
                fa = w;
            }
            fa = fa2;
        } else if (fa2 != null) {
            if (fa2.l() == null || !fa2.l().equals(fa.l())) {
                if (!c0231f.L()) {
                    Iterator<Map.Entry<String, C0225c>> it = fa2.b().entrySet().iterator();
                    while (it.hasNext()) {
                        C0225c value = it.next().getValue();
                        C0225c c0225c = fa.b().get(value.b());
                        if (c0225c == null || ((value.d() != null && !value.d().equals(c0225c.d())) || (c0225c.m() != null && c0225c.m().equals("committedDelete")))) {
                            String a2 = c0231f.u().a(value, fa2, c0231f, true);
                            File file = new File(a2);
                            if (a2 != null && file.exists()) {
                                file.delete();
                            }
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(fa2);
                c0231f.a(fa, arrayList);
                Fa.a(fa, fa2);
            }
            fa = fa2;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(w);
            c0231f.a(fa, arrayList2);
            Fa.a(fa, w);
        }
        if (!(w == null || !(w.l() == null || w.l().equals(fa.l())))) {
            c0324c.f();
            c0231f.f();
            return null;
        }
        String C = c0231f.C();
        File file2 = new File(org.apache.commons.io.c.d(C));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        fa.a(C, true);
        try {
            fa.a(c0231f.B(), false);
            c0231f.b(fa);
            return c0231f.A();
        } catch (AdobeDCXException e2) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorFailedToStoreBaseManifest, null, e2, c0231f.B());
        }
    }

    public static C0233g a(C0231f c0231f, zb zbVar, C0324c c0324c, kb kbVar) throws AdobeCSDKException {
        Fa fa;
        a(c0231f);
        Fa b2 = b(c0231f);
        if (c0231f.r() != null) {
            try {
                fa = kbVar.a(b2);
                e = null;
            } catch (AdobeCSDKException e2) {
                e = e2;
                fa = null;
            }
            if (e == null && !c0324c.c()) {
                if (fa != null && fa.i() != null && fa.i().equals("committedDelete")) {
                    if (c0231f.m() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                        try {
                            zbVar.a(c0231f);
                        } catch (AdobeDCXException e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Y.class.getSimpleName(), null, e3);
                        }
                    } else {
                        try {
                            zbVar.b(c0231f);
                        } catch (AdobeDCXException e4) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Y.class.getSimpleName(), null, e4);
                        }
                    }
                    throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorUnknownComposite);
                }
                C0233g a2 = a(c0231f, c0324c, fa, b2);
                if (a2 == null) {
                    return a2;
                }
                ArrayList arrayList = new ArrayList(1);
                C0225c a3 = Ia.a((InterfaceC0223b) a2);
                if (a3 != null) {
                    arrayList.add(a3);
                }
                return arrayList.size() > 0 ? b(arrayList, c0231f, a2.g(), zbVar, c0324c) : a2;
            }
            throw a(e, c0324c);
        }
        throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorCompositeHrefUnassigned);
    }
}
