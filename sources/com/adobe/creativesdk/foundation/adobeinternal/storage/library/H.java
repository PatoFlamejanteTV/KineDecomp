package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.sb;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdobeLibraryMerger.java */
/* loaded from: classes.dex */
public class H implements sb {
    public static void a(C0231f c0231f, C0233g c0233g, C0233g c0233g2, com.adobe.creativesdk.foundation.adobeinternal.imageservice.w wVar, ArrayList arrayList) {
        Na na;
        Na na2;
        List<Na> a2;
        List<Na> a3;
        if (c0233g2 == null) {
            c0233g2 = c0231f.i();
        }
        if (c0233g2 == null) {
            return;
        }
        try {
            na = F.a(c0233g);
        } catch (AdobeLibraryException e2) {
            e2.printStackTrace();
            na = null;
        }
        if (na != null && (a3 = c0233g.a(na)) != null) {
            for (Na na3 : a3) {
                Na c2 = c0233g2.c(na3.e());
                if (c2 != null) {
                    if (((Long) na3.a("library#modified")).longValue() != ((Long) c2.a("library#modified")).longValue()) {
                        if (wVar != null && !wVar.a(na3.e(), na3.f())) {
                            return;
                        }
                    } else if (c2.a("library#removed") != null && wVar != null && !wVar.b(na3.e(), na3.f())) {
                        return;
                    }
                } else if (wVar != null && !wVar.b(na3.e(), na3.f())) {
                    return;
                }
            }
        }
        try {
            na2 = F.a(c0233g2);
        } catch (AdobeLibraryException e3) {
            e3.printStackTrace();
            na2 = null;
        }
        if (na2 == null || (a2 = c0233g2.a(na2)) == null) {
            return;
        }
        for (Na na4 : a2) {
            if (a(na4, arrayList)) {
                Na c3 = c0233g.c(na4.e());
                Object a4 = na4.a("library#removed");
                Object a5 = c3 != null ? c3.a("library#removed") : null;
                if (c3 == null || (a4 == null && a5 != null)) {
                    if (wVar != null && !wVar.c(na4.e(), na4.f())) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean a(Na na, ArrayList arrayList) {
        return na.f() != null && (arrayList == null || arrayList.size() == 0 || arrayList.contains(na.f()));
    }

    public static boolean a(C0235h c0235h) {
        boolean z;
        try {
            Na a2 = F.a((C0233g) c0235h);
            if (a2 != null) {
                List<Na> a3 = c0235h.a(a2);
                z = false;
                for (int i = 0; i < a3.size(); i++) {
                    try {
                        Na na = a3.get(i);
                        if (na.a("library#removed") != null) {
                            na.b("library#removed");
                            z = true;
                        }
                    } catch (AdobeLibraryException e2) {
                        e = e2;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "ensureBranchDataValid", e.getMessage());
                        return z;
                    }
                }
            } else {
                z = false;
            }
            Na a4 = F.a(c0235h);
            if (a4 != null) {
                List<Na> a5 = c0235h.a(a4);
                for (int i2 = 0; i2 < a5.size(); i2++) {
                    Na na2 = a5.get(i2);
                    if (na2.a("library#removed") == null) {
                        na2.a(Long.valueOf(ia.a()), "library#removed");
                        z = true;
                    }
                }
            }
        } catch (AdobeLibraryException e3) {
            e = e3;
            z = false;
        }
        return z;
    }

    public static List<C0225c> a(C0231f c0231f) {
        ArrayList arrayList = new ArrayList();
        for (C0225c c0225c : c0231f.p().b()) {
            String str = null;
            try {
                str = c0231f.p().c(c0225c);
            } catch (AdobeDCXException e2) {
                e2.printStackTrace();
            }
            if (c0225c == null || str == null) {
                arrayList.add(c0225c);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x023f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01da A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f r23, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g r24, com.adobe.creativesdk.foundation.adobeinternal.imageservice.w r25, java.util.ArrayList r26, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D r27) throws com.adobe.creativesdk.foundation.storage.AdobeLibraryException {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.library.H.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g, com.adobe.creativesdk.foundation.adobeinternal.imageservice.w, java.util.ArrayList, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D):com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h");
    }

    private static boolean a(Na na, C0233g c0233g) {
        Na a2 = c0233g.a(na, (Ba) null);
        return a2 != null && "removed_elements".equals(a2.d());
    }
}
