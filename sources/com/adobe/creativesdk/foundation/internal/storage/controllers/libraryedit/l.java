package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.F;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.I;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.adobe.creativesdk.foundation.storage.vd;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import java.util.List;

/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    AdobeDesignLibraryEditOperation f6226a;

    /* renamed from: b */
    x f6227b;

    /* renamed from: c */
    FragmentManager f6228c;

    /* renamed from: d */
    private String f6229d;
    private a k;

    /* renamed from: f */
    private volatile int f6231f = 0;

    /* renamed from: g */
    private volatile boolean f6232g = false;

    /* renamed from: h */
    private final String f6233h = "color";
    private final String i = "colortheme";
    private final String j = "characterstyle";

    /* renamed from: e */
    private Gb f6230e = Gb.f();

    public l(String str, FragmentManager fragmentManager, AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation, x xVar) {
        this.f6226a = adobeDesignLibraryEditOperation;
        this.f6227b = xVar;
        this.f6228c = fragmentManager;
        this.f6229d = str;
    }

    public static /* synthetic */ int c(l lVar) {
        int i = lVar.f6231f;
        lVar.f6231f = i + 1;
        return i;
    }

    private void e() {
        this.k = new a();
        this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_DELETE;
        f();
        try {
            Gb.f().b(this.f6229d);
        } catch (AdobeLibraryException e2) {
            e2.printStackTrace();
        }
        this.k.a(true);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
        this.f6227b.onComplete();
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
        this.f6227b.onComplete();
    }

    private void f() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b(true);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(true);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED);
    }

    private void g() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b(true);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(true);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_STARTED);
    }

    /* compiled from: AdobeDesignLibraryEditSession.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public AdobeDesignLibraryEditOperation f6234a;

        /* renamed from: b */
        private boolean f6235b = false;

        /* renamed from: c */
        private boolean f6236c = false;

        public boolean a() {
            if (!this.f6235b) {
                return false;
            }
            this.f6235b = false;
            return true;
        }

        public boolean b() {
            return this.f6236c;
        }

        public void c() {
            this.f6235b = true;
        }

        public void a(boolean z) {
            this.f6236c = z;
        }
    }

    private void c(I i) {
        this.k = new a();
        this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_RENAME;
        u uVar = new u();
        uVar.a(null, Gb.f().d(this.f6229d), new b(this));
        uVar.a(i);
        uVar.show(this.f6228c, "LibCompRename");
    }

    private void d() {
        this.k = new a();
        this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_DELETE;
        f();
        try {
            C0614ub d2 = Gb.f().d(this.f6229d);
            AdobeCollaborationType f2 = d2.f();
            if (!d2.q() && !f2.equals(AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER)) {
                Gb.f().b(this.f6229d);
                this.k.a(true);
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
                this.f6227b.onComplete();
            }
            com.adobe.creativesdk.foundation.internal.collaboration.h.c().a("/assets/adobe-libraries/" + d2.k(), AdobeAuthIdentityManagementService.K().e(), new h(this, d2));
        } catch (AdobeLibraryException e2) {
            this.k.a(false);
            e2.printStackTrace();
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
            this.f6227b.onComplete();
        }
    }

    public void b() {
        int i = k.f6225a[this.f6226a.ordinal()];
        if (i == 1) {
            c();
            return;
        }
        if (i == 2) {
            a(false);
            return;
        }
        if (i == 3) {
            a(true);
        } else if (i == 4) {
            d();
        } else {
            if (i != 5) {
                return;
            }
            e();
        }
    }

    public void a(I i) {
        int i2 = k.f6225a[this.f6226a.ordinal()];
        if (i2 == 6) {
            b(i);
        } else {
            if (i2 != 7) {
                return;
            }
            c(i);
        }
    }

    private void a(C0614ub c0614ub, C0614ub c0614ub2, C0622wb c0622wb, C0622wb c0622wb2, vd vdVar, Handler handler) {
        this.f6231f = 0;
        this.f6232g = false;
        List<Hb> i = c0622wb.i();
        if (i != null && i.size() != 0) {
            Iterator<Hb> it = i.iterator();
            while (it.hasNext()) {
                new Thread(new g(this, it.next(), c0614ub2, c0622wb2, i, handler, vdVar)).start();
            }
            return;
        }
        vdVar.a();
    }

    private void b(I i) {
        this.k = new a();
        this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_RENAME;
        u uVar = new u();
        if (n.b().a() != null) {
            uVar.a(n.b().a().get(0).b(), n.b().a().get(0).a(), new i(this));
            uVar.a(i);
            uVar.show(this.f6228c, "AssetRename");
        }
    }

    private void c() {
        this.k = new a();
        this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_ERASE;
        if (n.b().a() != null) {
            g();
            try {
                n.b().a().get(0).a().a(n.b().a().get(0).b());
                this.k.a(true);
            } catch (AdobeLibraryException unused) {
                this.k.a(false);
            }
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
            this.f6227b.onComplete();
        }
    }

    public Pair<String, Object> a(Hb hb) {
        char c2;
        String h2 = hb.h();
        int hashCode = h2.hashCode();
        if (hashCode == -148162608) {
            if (h2.equals("application/vnd.adobe.color+json")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 478927531) {
            if (hashCode == 1689183565 && h2.equals("application/vnd.adobe.colortheme+json")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (h2.equals("application/vnd.adobe.characterstyle+json")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            return new Pair<>("color", hb.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "color"));
        }
        if (c2 == 1) {
            return new Pair<>("colortheme", hb.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "colortheme"));
        }
        if (c2 != 2) {
            return null;
        }
        return new Pair<>("characterstyle", hb.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "characterstyle"));
    }

    private void a(boolean z) {
        this.k = new a();
        if (z) {
            this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_COPY;
        } else {
            this.k.f6234a = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_MOVE;
        }
        Handler handler = new Handler();
        C0614ub d2 = this.f6230e.d(this.f6229d);
        if (n.b().a() != null) {
            g();
            C0614ub a2 = n.b().a().get(0).a();
            if (a2.k().equals(this.f6229d)) {
                this.k.c();
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
                this.f6227b.onComplete();
            } else {
                C0622wb b2 = n.b().a().get(0).b();
                try {
                    a(d2, a2, b2, ((F) d2).a(b2.e(), b2.j()), new j(this, z, a2, b2), handler);
                } catch (AdobeLibraryException unused) {
                    this.k.a(false);
                    com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(false);
                    this.f6227b.onComplete();
                }
            }
        }
    }

    public a a() {
        return this.k;
    }
}
