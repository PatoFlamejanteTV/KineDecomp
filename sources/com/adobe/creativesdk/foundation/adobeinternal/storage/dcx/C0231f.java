package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: AdobeDCXComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0231f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Map<String, C0231f> f4363a;

    /* renamed from: b, reason: collision with root package name */
    private C0235h f4364b;

    /* renamed from: c, reason: collision with root package name */
    private C0233g f4365c;

    /* renamed from: d, reason: collision with root package name */
    private C0233g f4366d;

    /* renamed from: e, reason: collision with root package name */
    private C0233g f4367e;

    /* renamed from: f, reason: collision with root package name */
    private C0233g f4368f;

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f4369g;

    /* renamed from: h, reason: collision with root package name */
    private String f4370h;
    private URI i;
    private String j;
    private AdobeCollaborationType k;
    private ob l;
    private WeakReference<Aa> m;
    private String n;
    private Date o;
    private Set<Fa> p;
    private Set<String> q;
    private boolean r;
    private long s;
    private boolean t;
    private boolean u;
    private boolean v;
    private jb w;
    private WeakReference<Fa> x;
    private AdobeCollaborationRoleType y;
    private JSONObject z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeDCXComposite.java */
    /* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0231f(java.lang.String r4, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme r5, java.net.URI r6, java.lang.String r7, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r8) throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            r3 = this;
            r3.<init>()
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            r3.f4369g = r0
            r0 = 0
            r3.x = r0
            if (r8 == 0) goto L16
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r8)
            r3.m = r1
        L16:
            r3.i = r6
            r3.f4370h = r7
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob r5 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r5)
            r3.l = r5
            r3.j = r4
            java.util.concurrent.atomic.AtomicInteger r5 = r3.f4369g
            r6 = 0
            r5.set(r6)
            r5 = 1
            r3.t = r5
            r3.u = r5
            r3.v = r6
            r3.r = r6
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationType r6 = com.adobe.creativesdk.foundation.storage.AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE
            r3.k = r6
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            r3.p = r6
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            r3.q = r6
            if (r4 == 0) goto Lba
            java.lang.String r4 = r3.q()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L55
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r4)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L55
            org.json.JSONObject r6 = r3.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L53
            r4.a(r6)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L53
            goto L62
        L53:
            r6 = move-exception
            goto L57
        L55:
            r6 = move-exception
            r4 = r0
        L57:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r7 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r8 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r8 = r8.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r7, r8, r0, r6)
        L62:
            if (r4 == 0) goto L68
            r3.a(r4, r5)
            goto Lba
        L68:
            java.lang.String r4 = r3.C()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L7b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r4)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L7b
            org.json.JSONObject r5 = r3.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L76
            r4.a(r5)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L76
            goto L8a
        L76:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L7d
        L7b:
            r4 = move-exception
            r5 = r0
        L7d:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r6 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r7 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r7 = r7.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r6, r7, r0, r4)
            r0 = r4
            r4 = r5
        L8a:
            if (r4 == 0) goto Lb0
            r3.b(r4)
            java.net.URI r5 = r3.i
            if (r5 != 0) goto L99
            java.net.URI r5 = r4.g()
            r3.i = r5
        L99:
            java.lang.String r5 = r3.f4370h
            if (r5 != 0) goto La3
            java.lang.String r5 = r4.h()
            r3.f4370h = r5
        La3:
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationType r5 = r4.e()
            r3.k = r5
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType r4 = r4.d()
            r3.y = r4
            goto Lba
        Lb0:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r4 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r5 = "CSDK::Release::DCX"
            java.lang.String r6 = "Inside AdobeDCXComposite:AdobeDCXComposite negative path should never come here"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r4, r5, r6)
            throw r0
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.<init>(java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme, java.net.URI, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa):void");
    }

    private static Map<String, C0231f> V() {
        if (f4363a == null) {
            synchronized (C0231f.class) {
                if (f4363a == null) {
                    f4363a = new HashMap();
                }
            }
        }
        return f4363a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g A() {
        /*
            r5 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4365c
            if (r0 != 0) goto L2a
            java.lang.String r0 = r5.C()
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r0)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            org.json.JSONObject r2 = r5.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            r0.a(r2)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            goto L22
        L13:
            r2 = move-exception
            goto L17
        L15:
            r2 = move-exception
            r0 = r1
        L17:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r4 = r4.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r1, r2)
        L22:
            if (r0 == 0) goto L2a
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g.a(r5, r0)
            r5.f4365c = r0
        L2a:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4365c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.A():com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String B() {
        if (this.j == null) {
            return null;
        }
        return this.l.f(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String C() {
        if (this.j == null) {
            return null;
        }
        return this.l.g(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String D() {
        if (this.j == null) {
            return null;
        }
        return this.l.h(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g E() {
        /*
            r5 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4366d
            if (r0 != 0) goto L2a
            java.lang.String r0 = r5.G()
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r0)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            org.json.JSONObject r2 = r5.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            r0.a(r2)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            goto L22
        L13:
            r2 = move-exception
            goto L17
        L15:
            r2 = move-exception
            r0 = r1
        L17:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r4 = r4.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r1, r2)
        L22:
            if (r0 == 0) goto L2a
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g.a(r5, r0)
            r5.f4366d = r0
        L2a:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4366d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.E():com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String F() {
        if (this.j == null) {
            return null;
        }
        return this.l.d(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G() {
        if (this.j == null) {
            return null;
        }
        return this.l.k(this);
    }

    public boolean H() {
        return this.z != null;
    }

    public boolean I() {
        return w() == null ? this.i != null : w().x();
    }

    public boolean J() {
        return l() == AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER;
    }

    public boolean K() {
        return m() != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L() {
        return this.l.a();
    }

    public boolean M() throws AdobeDCXException {
        String n = n();
        boolean j = this.l.j(this);
        if (j) {
            e(null);
        }
        Za.a("csdk_android_dcx", "AdobeDCXComposite.removeLocalStorage", "composite deleted: " + n + Arrays.toString(Thread.currentThread().getStackTrace()), this.j);
        return j;
    }

    public long N() {
        if (this.l.a()) {
            return this.l.b(this);
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        if (this.u && this.l.a() && this.f4369g.incrementAndGet() == 1) {
            new Thread(new RunnableC0227d(this, this)).start();
            jb jbVar = this.w;
            if (jbVar != null) {
                jbVar.a(this);
            }
        }
    }

    public void P() throws AdobeDCXException {
        this.i = null;
        if (w() != null) {
            w().y();
        }
        e();
    }

    boolean Q() throws AdobeDCXException {
        boolean z;
        AdobeDCXException adobeDCXException = null;
        if (new File(q()).exists()) {
            a((Fa) null, false);
            z = p() != null;
            if (!z) {
                adobeDCXException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalManifest, String.format("An unexpected error occurred while trying to load %s.", q()), null);
            }
        } else {
            adobeDCXException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestFileNotFound, String.format("Manifest with path %s does not exist.", q()), null);
            z = false;
        }
        if (adobeDCXException == null) {
            return z;
        }
        throw adobeDCXException;
    }

    public boolean R() throws AdobeDCXException {
        AdobeDCXException e2 = null;
        boolean z = false;
        if (new File(j()).exists()) {
            z = com.adobe.creativesdk.foundation.internal.storage.model.util.f.a(j(), q());
            if (z) {
                try {
                    z = Q();
                } catch (AdobeDCXException e3) {
                    e2 = e3;
                }
            }
        } else {
            e2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestFileNotFound, String.format("Base branch manifest with path %s does not exist.", j()), null);
        }
        if (e2 == null) {
            return z;
        }
        throw e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.f4367e = null;
    }

    void T() {
        this.o = new Date((System.currentTimeMillis() / 1000) * 1000);
    }

    void U() {
        this.f4368f = null;
    }

    public void d(String str) {
        if (w() == null) {
            this.f4370h = str;
        } else {
            w().e(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:32:0x0017, B:15:0x0024, B:17:0x0028, B:19:0x002f, B:20:0x0032, B:21:0x0034), top: B:31:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(java.lang.String r6) throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L8
            java.lang.String r2 = r5.j
            if (r2 == 0) goto L4d
        L8:
            java.lang.String r2 = r5.j
            boolean r2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r6, r2)
            if (r2 != 0) goto L4d
            java.util.Map r2 = V()
            monitor-enter(r2)
            if (r6 == 0) goto L21
            java.lang.Object r3 = r2.get(r6)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L1f:
            r6 = move-exception
            goto L4b
        L21:
            r3 = 0
        L22:
            if (r3 != 0) goto L34
            java.lang.String r4 = r5.j     // Catch: java.lang.Throwable -> L1f
            if (r4 == 0) goto L2d
            java.lang.String r4 = r5.j     // Catch: java.lang.Throwable -> L1f
            r2.remove(r4)     // Catch: java.lang.Throwable -> L1f
        L2d:
            if (r6 == 0) goto L32
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L1f
        L32:
            r5.j = r6     // Catch: java.lang.Throwable -> L1f
        L34:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1f
            if (r3 != 0) goto L39
            r1 = r3
            goto L4d
        L39:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException r2 = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode r3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode.AdobeDCXErrorInstanceCacheConflict
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r6
            java.lang.String r6 = "A composite instance with the storage path %s does alreay exist."
            java.lang.String r6 = java.lang.String.format(r6, r0)
            r2.<init>(r3, r6)
            throw r2
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1f
            throw r6
        L4d:
            r6 = r1 ^ 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.e(java.lang.String):boolean");
    }

    @Deprecated
    public void f(String str) {
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        File file = new File(G());
        if (file.exists()) {
            file.delete();
            c((Fa) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Fa h() {
        WeakReference<Fa> weakReference = this.x;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g i() {
        /*
            r5 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4367e
            if (r0 != 0) goto L2c
            java.lang.String r0 = r5.j()
            if (r0 == 0) goto L2c
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r0)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L17
            org.json.JSONObject r2 = r5.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            r0.a(r2)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            goto L24
        L15:
            r2 = move-exception
            goto L19
        L17:
            r2 = move-exception
            r0 = r1
        L19:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r4 = r4.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r1, r2)
        L24:
            if (r0 == 0) goto L2c
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g.a(r5, r0)
            r5.f4367e = r0
        L2c:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4367e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.i():com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g");
    }

    String j() {
        if (this.j == null) {
            return null;
        }
        return this.l.l(this);
    }

    public String k() {
        if (this.j == null) {
            return null;
        }
        return this.l.e(this);
    }

    public AdobeCollaborationRoleType l() {
        if (w() == null) {
            return this.y;
        }
        return w().d();
    }

    public AdobeCollaborationType m() {
        if (w() == null) {
            return this.k;
        }
        return w().e();
    }

    public String n() {
        if (w() == null) {
            return this.f4370h;
        }
        return w().h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa o() {
        WeakReference<Aa> weakReference = this.m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h p() {
        /*
            r5 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r0 = r5.f4364b
            if (r0 != 0) goto L2d
            java.lang.String r0 = r5.q()
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r0)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            org.json.JSONObject r2 = r5.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            r0.a(r2)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            goto L22
        L13:
            r2 = move-exception
            goto L17
        L15:
            r2 = move-exception
            r0 = r1
        L17:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r4 = r4.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r1, r2)
        L22:
            if (r0 == 0) goto L2d
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h.b(r5, r0)
            r5.f4364b = r0
            r5.T()
        L2d:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r0 = r5.f4364b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.p():com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        if (this.j == null) {
            return null;
        }
        return this.l.c(this);
    }

    public URI r() {
        if (w() == null) {
            return this.i;
        }
        return w().g();
    }

    public JSONObject s() {
        return this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g t() {
        /*
            r5 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4368f
            if (r0 != 0) goto L2a
            java.lang.String r0 = r5.q()
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.a(r0)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L15
            org.json.JSONObject r2 = r5.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            r0.a(r2)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L13
            goto L22
        L13:
            r2 = move-exception
            goto L17
        L15:
            r2 = move-exception
            r0 = r1
        L17:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r4 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r4 = r4.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r1, r2)
        L22:
            if (r0 == 0) goto L2a
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g.a(r5, r0)
            r5.f4368f = r0
        L2a:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r0 = r5.f4368f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.t():com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ob u() {
        return this.l;
    }

    public boolean v() {
        return this.v;
    }

    public Fa w() {
        C0235h c0235h = this.f4364b;
        if (c0235h != null) {
            return c0235h.g();
        }
        return null;
    }

    public Ma x() {
        C0235h c0235h = this.f4364b;
        if (c0235h == null) {
            return null;
        }
        Ma ma = (Ma) c0235h.h();
        if (ma != null || !this.t) {
            return ma;
        }
        Ma ma2 = new Ma(this.f4364b.g());
        p().a(ma2);
        return ma2;
    }

    public long y() {
        return this.s;
    }

    @Deprecated
    public String z() {
        return this.j;
    }

    private static C0231f a(Map<String, C0231f> map, String str, C0231f c0231f, Aa aa) throws AdobeDCXException {
        synchronized (map) {
            C0231f c0231f2 = map.get(str);
            if (c0231f2 == null) {
                if (c0231f != null) {
                    map.put(str, c0231f);
                }
                return c0231f;
            }
            if (aa != null && c0231f2.o() != null && !aa.c().equals(c0231f2.o().c())) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInstanceCacheConflict, "Controller mismatch.");
            }
            if (c0231f2.o() == null) {
                c0231f2.a(aa);
            }
            return c0231f2;
        }
    }

    public void b(String str) {
        synchronized (this.q) {
            this.q.remove(str.split("/")[r3.length - 1]);
        }
    }

    public void c(String str) {
        this.n = str;
    }

    public boolean f() throws AdobeDCXException {
        boolean a2 = this.l.a(this);
        if (a2) {
            b((Fa) null);
            O();
            Aa o = o();
            if (o != null) {
                o.b(n());
            }
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fa fa) {
        if (fa == null) {
            this.f4366d = null;
            return;
        }
        C0233g c0233g = this.f4366d;
        if (c0233g == null) {
            this.f4366d = C0233g.a(this, fa);
        } else {
            c0233g.a(fa);
        }
    }

    public Fa d() throws AdobeDCXException {
        C0233g c0233g = this.f4368f;
        if (c0233g == null) {
            Fa a2 = Fa.a(q());
            if (a2 == null) {
                return null;
            }
            a2.a(this.z);
            return a2;
        }
        return c0233g.g().j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fa fa) {
        if (fa == null) {
            this.f4365c = null;
            return;
        }
        C0233g c0233g = this.f4365c;
        if (c0233g == null) {
            this.f4365c = C0233g.a(this, fa);
        } else {
            c0233g.a(fa);
        }
    }

    public boolean c() throws AdobeDCXException {
        C0235h c0235h = this.f4364b;
        Ma ma = null;
        String str = c0235h != null ? c0235h.g().j : null;
        C0235h c0235h2 = this.f4364b;
        if (c0235h2 != null && c0235h2.g().m) {
            this.f4364b.g().j = Fa.k().format(new Date());
        }
        C0235h c0235h3 = this.f4364b;
        if (c0235h3 != null && c0235h3.g().m) {
            ma = x();
        } else if (p() != null && p().f() != null && p().f().g()) {
            ma = x();
        }
        if (ma != null && (ma.g() || p().c().equals("modified"))) {
            ma.e(n());
            ma.a();
            if (ma.a(p()) == null) {
                this.f4364b.g().j = str;
                return false;
            }
        }
        if (p() != null && p().f(q())) {
            U();
            String c2 = p().c();
            this.n = c2;
            T();
            Aa o = o();
            if (o == null) {
                return true;
            }
            if (!c2.equals("modified") && !c2.equals("pendingDelete")) {
                return true;
            }
            o.a(n());
            return true;
        }
        C0235h c0235h4 = this.f4364b;
        if (c0235h4 != null) {
            c0235h4.g().j = str;
        }
        return false;
    }

    public static C0231f a(String str, Aa aa) throws AdobeDCXException {
        Map<String, C0231f> V = V();
        C0231f c0231f = null;
        try {
            c0231f = a(V, str, (C0231f) null, aa);
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0231f.class.getSimpleName(), null, e2);
        }
        return c0231f == null ? a(V, str, new C0231f(str, aa), aa) : c0231f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        Map<String, C0231f> V = V();
        synchronized (V) {
            V.clear();
        }
    }

    public boolean e() throws AdobeDCXException {
        return this.l.i(this);
    }

    @Deprecated
    public static C0231f a(URI uri, String str, String str2, AdobeDCXLocalStorageScheme adobeDCXLocalStorageScheme) throws AdobeDCXException {
        C0231f c0231f = new C0231f(uri, str, adobeDCXLocalStorageScheme);
        c0231f.f(str2);
        return c0231f;
    }

    public static C0231f a(URI uri, String str, String str2, Aa aa) throws AdobeDCXException {
        C0231f c0231f;
        if (str2 == null) {
            return new C0231f(null, null, null, str, uri, aa);
        }
        V();
        synchronized (f4363a) {
            if (f4363a.get(str2) == null) {
                c0231f = new C0231f(null, null, str2, str, uri, aa);
                f4363a.put(str2, c0231f);
            } else {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInstanceCacheConflict, String.format("A composite instance with the storage path %s does already exist.", str2));
            }
        }
        return c0231f;
    }

    public static C0231f a(String str, String str2, URI uri, String str3, String str4, Aa aa) throws AdobeDCXException {
        C0231f c0231f;
        if (str4 == null) {
            return new C0231f(str, str2, null, str3, uri, aa);
        }
        V();
        synchronized (f4363a) {
            if (f4363a.get(str4) == null) {
                c0231f = new C0231f(str, str2, str4, str3, uri, aa);
                f4363a.put(str4, c0231f);
            } else {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInstanceCacheConflict, String.format("A composite instance with the storage path %s does already exist.", str4));
            }
        }
        return c0231f;
    }

    public C0231f(String str, Aa aa) throws AdobeDCXException {
        this(str, AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeCopyOnWrite, (URI) null, (String) null, aa);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0231f(java.lang.String r7, java.lang.String r8, java.lang.String r9, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme r10, java.lang.String r11) throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            r6 = this;
            r1 = 0
            r3 = 0
            r5 = 0
            r0 = r6
            r2 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob r10 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r10)
            r6.l = r10
            r6.j = r9
            java.util.concurrent.atomic.AtomicInteger r10 = r6.f4369g
            r0 = 0
            r10.set(r0)
            r10 = 1
            r6.t = r10
            r6.u = r10
            r6.v = r0
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationType r1 = com.adobe.creativesdk.foundation.storage.AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE
            r6.k = r1
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r6.p = r1
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r6.q = r1
            r1 = 0
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.e(r7, r8)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L3d
            org.json.JSONObject r8 = r6.z     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L3b
            r7.a(r8)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L3b
            goto L4a
        L3b:
            r8 = move-exception
            goto L3f
        L3d:
            r8 = move-exception
            r7 = r1
        L3f:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f> r3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.class
            java.lang.String r3 = r3.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r3, r1, r8)
        L4a:
            r6.a(r7, r0)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            if (r7 == 0) goto L6d
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.g()
            if (r7 == 0) goto L6d
            if (r11 == 0) goto L63
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.g()
            r7.e(r11)
            goto L6d
        L63:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.g()
            java.lang.String r11 = r7.h()
        L6d:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            if (r7 == 0) goto L86
            java.lang.String r8 = "unmodified"
            r7.d(r8)
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.g()
            if (r7 == 0) goto L86
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r7 = r6.f4364b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r7 = r7.g()
            r7.m = r10
        L86:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "composite created: "
            r7.append(r8)
            r7.append(r11)
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r8 = r8.getStackTrace()
            java.lang.String r8 = java.util.Arrays.toString(r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "csdk_android_dcx"
            java.lang.String r10 = "AdobeDCXComposite"
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r8, r10, r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.<init>(java.lang.String, java.lang.String, java.lang.String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme, java.lang.String):void");
    }

    public void a(URI uri) {
        if (w() == null) {
            this.i = uri;
        } else {
            w().a(uri);
        }
    }

    public void a(AdobeCollaborationType adobeCollaborationType) {
        if (w() == null) {
            this.k = adobeCollaborationType;
        } else {
            w().a(adobeCollaborationType);
        }
    }

    public void a(AdobeCollaborationRoleType adobeCollaborationRoleType) {
        if (w() == null) {
            this.y = adobeCollaborationRoleType;
        } else {
            w().a(adobeCollaborationRoleType);
        }
    }

    public void a(Aa aa) {
        if (aa != null) {
            this.m = new WeakReference<>(aa);
        }
    }

    public void a(String str) {
        synchronized (this.q) {
            this.q.add(str.split("/")[r3.length - 1]);
        }
    }

    public void a(Fa fa, boolean z) {
        if (fa == null) {
            this.f4364b = null;
            this.o = null;
        } else {
            C0235h c0235h = this.f4364b;
            if (c0235h == null) {
                this.f4364b = C0235h.b(this, fa);
            } else {
                c0235h.a(fa);
            }
        }
        if (fa == null || !z) {
            return;
        }
        T();
    }

    public C0231f(String str, String str2, String str3, String str4, URI uri, Aa aa) throws AdobeDCXException {
        this(str, str2, str3, AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeCopyOnWrite, str4);
        a(uri);
        if (aa != null) {
            a(aa);
        }
    }

    @Deprecated
    public C0231f(URI uri, String str, AdobeDCXLocalStorageScheme adobeDCXLocalStorageScheme) throws AdobeDCXException {
        this((String) null, adobeDCXLocalStorageScheme, uri, str, (Aa) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fa fa, List<Fa> list) {
        this.l.a(fa, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b1, code lost:            if (r6 != false) goto L52;     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c r9, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r10, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r11, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha r12, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa r13, boolean r14, java.lang.String r15) throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.c, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa, boolean, java.lang.String):com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0225c a(C0225c c0225c, Fa fa) {
        if (fa == null) {
            fa = w();
        }
        C0225c e2 = fa.e(c0225c);
        if (e2 != null) {
            this.l.a(e2, fa);
            fa.a((String) null, e2);
            fa.b((String) null, e2);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Ha a(Ha ha, Fa fa, C0231f c0231f, Ha ha2, long j, Fa fa2, boolean z, String str, String str2) throws AdobeDCXException {
        HashMap hashMap;
        C0231f c0231f2;
        ArrayList arrayList;
        HashMap hashMap2;
        Object obj;
        AdobeDCXException adobeDCXException;
        String str3;
        String str4;
        ArrayList arrayList2 = new ArrayList();
        fa.a(ha, (List<C0225c>) arrayList2);
        HashMap hashMap3 = new HashMap();
        Iterator it = arrayList2.iterator();
        while (true) {
            boolean z2 = true;
            String str5 = null;
            if (it.hasNext()) {
                C0225c c0225c = (C0225c) it.next();
                try {
                    str3 = c0231f.u().a(c0225c, fa, c0231f, false);
                    adobeDCXException = null;
                } catch (AdobeDCXException e2) {
                    adobeDCXException = e2;
                    str3 = null;
                }
                if (str3 == null || !new File(str3).exists()) {
                    z2 = false;
                }
                if (c0231f.equals(this)) {
                    if (z2) {
                        str5 = str3;
                    }
                } else if (z2) {
                    try {
                        str4 = this.l.a(c0225c, fa2, this);
                    } catch (AdobeDCXException unused) {
                        str4 = null;
                    }
                    if (str4 == null) {
                        new C0229e(this, hashMap3).a();
                        return null;
                    }
                    new File(str4.substring(0, str4.lastIndexOf(File.separator))).mkdirs();
                    a(str4);
                    try {
                        org.apache.commons.io.b.b(new File(str3), new File(str4));
                        str5 = str4;
                    } catch (IOException e3) {
                        b(str4);
                        new C0229e(this, hashMap3).a();
                        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentCopyFailure, null, e3);
                    }
                } else if (str3 != null) {
                    if ((c0225c.m() == null || c0225c.m().equals("unmodified")) && c0225c.d() != null) {
                        if (r() != null && com.adobe.creativesdk.foundation.internal.utils.n.b(r(), c0231f.r())) {
                            if (adobeDCXException == null) {
                                new C0229e(this, hashMap3).a();
                                return null;
                            }
                            throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorComponentCopyFailure, "Attempted to copy a component without a local file to a composite bound to an incompatible service or cloud.");
                        }
                    }
                }
                if (str5 != null) {
                    hashMap3.put(c0225c.b(), str5);
                }
            } else {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                try {
                    arrayList = new ArrayList();
                    hashMap2 = hashMap3;
                } catch (AdobeDCXException e4) {
                    e = e4;
                    hashMap = hashMap3;
                    c0231f2 = c0231f;
                }
                try {
                    Ha a2 = fa2.a(ha, fa, ha2, j, z, str, str2, !c0231f.equals(this), arrayList3, arrayList, arrayList4);
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        this.l.a((C0225c) it2.next(), fa2);
                    }
                    int i = 0;
                    while (i < arrayList3.size()) {
                        C0225c c0225c2 = (C0225c) arrayList3.get(i);
                        ArrayList arrayList5 = arrayList;
                        String str6 = (String) arrayList5.get(i);
                        HashMap hashMap4 = hashMap2;
                        String str7 = (String) hashMap4.get(str6);
                        if (str7 != null) {
                            if (!this.l.a(c0225c2.i(), fa2, this, str7)) {
                                return null;
                            }
                            obj = null;
                            fa2.b((String) null, c0225c2);
                        } else {
                            obj = null;
                            C0225c c0225c3 = fa.b().get(str6);
                            if (c0225c3 != null) {
                                String d2 = fa.d(c0225c3);
                                if (d2 != null) {
                                    fa2.b(d2, c0225c2);
                                }
                                i++;
                                arrayList = arrayList5;
                                hashMap2 = hashMap4;
                            }
                        }
                        i++;
                        arrayList = arrayList5;
                        hashMap2 = hashMap4;
                    }
                    HashMap hashMap5 = hashMap2;
                    if (!c0231f.equals(this)) {
                        Iterator it3 = hashMap5.values().iterator();
                        while (it3.hasNext()) {
                            b((String) it3.next());
                        }
                    }
                    return a2;
                } catch (AdobeDCXException e5) {
                    e = e5;
                    c0231f2 = c0231f;
                    hashMap = hashMap2;
                    if (!c0231f2.equals(this)) {
                        new C0229e(this, hashMap).a();
                    }
                    throw e;
                }
            }
        }
        if (adobeDCXException == null) {
            new C0229e(this, hashMap3).a();
            return null;
        }
        throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorComponentCopyFailure, "Attempted to copy a component that lacks both a local file and a server href.");
    }

    public boolean a(C0235h c0235h) throws AdobeDCXException {
        Aa o = o();
        AdobeDCXException e2 = null;
        if (c0235h == null && !new File(C()).exists()) {
            if (o != null) {
                o.d(this, null);
            }
            return true;
        }
        boolean z = false;
        try {
            z = a(c0235h, true, (Ya) null);
        } catch (AdobeDCXException e3) {
            e2 = e3;
        }
        if (o != null) {
            o.d(this, e2);
        }
        if (e2 == null) {
            return z;
        }
        throw e2;
    }

    boolean a(C0235h c0235h, boolean z, Ya ya) throws AdobeDCXException {
        C0233g p = p();
        if (c0235h != null && c0235h.d().compareTo(A().d()) != 0) {
            p = A();
        }
        boolean z2 = true;
        if (c0235h != null) {
            if (!a(c0235h, p, A())) {
                z2 = false;
            }
        } else {
            c0235h = A().i();
        }
        if (z2 && p == A() && c0235h != null) {
            c0235h.g().g(A().d());
        }
        if (z2) {
            z2 = this.l.a(c0235h != null ? c0235h.g() : null, this);
        }
        if (z2 && z) {
            Fa a2 = Fa.a(q());
            if (a2 != null) {
                a2.a(this.z);
                a(a2, false);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            c(c0235h.g().i());
        }
        if (z2 && ya != null) {
            ya.a(ya.a(this), false);
        }
        if (z2) {
            S();
            U();
            b((Fa) null);
            O();
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            r8 = this;
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa r0 = r8.o()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r8.D()
            r1.<init>(r2)
            boolean r1 = r1.exists()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L2a
            java.io.File r1 = new java.io.File
            java.lang.String r4 = r8.G()
            r1.<init>(r4)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L2a
            if (r0 == 0) goto L29
            r0.a(r8, r3)
        L29:
            return r2
        L2a:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r1 = r8.p()
            r4 = 0
            if (r1 == 0) goto L5f
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r1 = r8.p()
            boolean r1 = r1.o()
            if (r1 != 0) goto L3c
            goto L5f
        L3c:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r1 = r8.t()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            java.lang.String r5 = r8.q()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            boolean r1 = r8.a(r1, r5)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            if (r1 == 0) goto L7e
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g r1 = r8.t()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            java.lang.String r1 = r1.c()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            r8.n = r1     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r1 = r8.p()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            boolean r1 = r8.a(r1, r3)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            if (r1 != 0) goto L7f
            goto L7e
        L5f:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r1 = r8.p()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            java.lang.String r5 = r8.q()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            boolean r1 = r8.a(r1, r5)     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            if (r1 == 0) goto L7e
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r1 = r8.p()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            java.lang.String r1 = r1.c()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            r8.n = r1     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            r8.T()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            r8.U()     // Catch: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException -> L81
            goto L7f
        L7e:
            r2 = 0
        L7f:
            r1 = r3
            goto L83
        L81:
            r1 = move-exception
            r2 = 0
        L83:
            if (r2 == 0) goto L97
            java.lang.String r5 = r8.F()
            java.lang.String r6 = r8.j()
            boolean r5 = com.adobe.creativesdk.foundation.internal.storage.model.util.f.b(r5, r6)
            if (r5 == 0) goto L97
            r8.S()
            goto L98
        L97:
            r2 = 0
        L98:
            java.io.File r5 = new java.io.File
            java.lang.String r6 = r8.D()
            r5.<init>(r6)
            java.io.File r6 = new java.io.File
            java.lang.String r7 = r8.G()
            r6.<init>(r7)
            if (r2 == 0) goto Lb8
            boolean r7 = r5.exists()
            if (r7 == 0) goto Lb8
            boolean r5 = r5.delete()
            if (r5 == 0) goto Lc4
        Lb8:
            boolean r5 = r6.exists()
            if (r5 == 0) goto Lc5
            boolean r5 = r6.delete()
            if (r5 != 0) goto Lc5
        Lc4:
            r2 = 0
        Lc5:
            if (r2 == 0) goto Lcd
            r8.c(r3)
            r8.N()
        Lcd:
            if (r0 == 0) goto Ld2
            r0.a(r8, r1)
        Ld2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f.a():boolean");
    }

    boolean a(C0235h c0235h, C0233g c0233g, C0233g c0233g2) throws AdobeDCXException {
        C0225c a2 = Ia.a((InterfaceC0223b) c0235h);
        C0225c a3 = Ia.a((InterfaceC0223b) c0233g);
        if (a2 == null || a3 == null) {
            return true;
        }
        if (a2.d().equals(a3.d()) && !c0235h.m() && !c0233g.m()) {
            if (c0233g.m() && !c0235h.a(c0233g, c0233g2)) {
                return false;
            }
            if (c0235h.f() == null || !c0235h.f().g()) {
                return true;
            }
            c0235h.f().a(c0235h);
            return true;
        }
        if (!c0235h.m() && !c0233g.m()) {
            C0225c a4 = Ia.a((InterfaceC0223b) i());
            if (a4 != null && !a4.d().equals(a3.d()) && !c0235h.a(c0233g, c0233g2)) {
                return false;
            }
        } else {
            Ma n = c0235h.n();
            Ia h2 = c0233g.h();
            C0233g i = i();
            Ia h3 = i != null ? i.h() : null;
            if (h2 != null && (n.a(h2, h3) || n.g())) {
                a2 = n.a(c0235h);
            }
        }
        if (c0233g != A()) {
            return true;
        }
        Ka i2 = a2.i();
        i2.c(a3.d());
        return c0235h.a((C0225c) i2, (String) null, false) != null;
    }

    public void a(boolean z) {
        this.t = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void a(Fa fa) {
        this.x = new WeakReference<>(fa);
    }

    private boolean a(C0233g c0233g, String str) throws AdobeDCXException {
        String d2;
        String c2;
        boolean z;
        Qa a2 = Qa.a(this, D());
        String g2 = a2.g();
        if (r() != null && !g2.equals(r().toString())) {
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidJournal, "Composite href in journal " + g2 + " doesn't match the href from the composite " + r().toString(), null, D());
        }
        if (a2.j()) {
            Fa a3 = Fa.a(F());
            if (a3 != null) {
                a3.a(this.z);
                C0235h.b(this, a3);
                C0235h i = c0233g != null ? c0233g.i() : null;
                Fa g3 = i != null ? i.g() : null;
                if (c0233g != null && g3 != null) {
                    boolean z2 = true;
                    if (a2.l()) {
                        g3.f("committedDelete");
                    } else {
                        Iterator<String> it = a2.f().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            C0225c c0225c = g3.b().get(next);
                            if (c0225c != null) {
                                Ka e2 = a2.e(c0225c);
                                if (e2 != null) {
                                    if (c0225c.m().equals("modified")) {
                                        C0225c c0225c2 = a3.b().get(next);
                                        boolean a4 = u().a(c0225c, g3, a3) ^ z2;
                                        if (a4 && (c2 = g3.c(c0225c)) != null) {
                                            a4 = !a3.c(c0225c2).equals(c2);
                                        }
                                        if (a4 && (d2 = g3.d(c0225c)) != null) {
                                            a4 = !d2.equals(a3.d(c0225c2));
                                        }
                                        if (a4) {
                                            e2.g("modified");
                                            e2.a(c0225c.f());
                                        } else {
                                            e2.g("unmodified");
                                        }
                                    } else if (c0225c.m().equals("pendingDelete")) {
                                        e2.g("pendingDelete");
                                    } else {
                                        e2.g("unmodified");
                                    }
                                    g3.f(e2);
                                } else if (a2.c(c0225c)) {
                                    Ka i2 = c0225c.i();
                                    i2.g("committedDelete");
                                    g3.f(i2);
                                } else if (a2.b(c0225c)) {
                                    a(c0225c, g3);
                                }
                            }
                            z2 = true;
                        }
                        a2.b(g3);
                        if (r() == null && g2 != null) {
                            a(URI.create(g2));
                            g3.a(URI.create(g2));
                        }
                        if (a(g3.u(), a3.u()) && g3.i().equals("modified")) {
                            g3.f(c0233g.g().m ? "modified" : "unmodified");
                        }
                    }
                    if (str != null) {
                        z = true;
                        g3.a(str, true);
                    } else {
                        z = true;
                    }
                    c0233g.a(g3);
                    return z;
                }
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestReadFailure, (String) null);
            }
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestReadFailure, (String) null);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorIncompleteJournal, "Journal is not complete", null, D());
    }

    private boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
