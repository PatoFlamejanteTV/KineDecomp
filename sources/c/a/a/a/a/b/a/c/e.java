package c.a.a.a.a.b.a.c;

import android.app.Activity;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXLocalStorageScheme;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.F;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.adobe.creativesdk.foundation.storage.sd;
import com.google.protos.datapol.SemanticAnnotations;
import org.json.JSONException;

/* compiled from: ACLibraryAssetRenditionUtils.java */
/* loaded from: classes.dex */
public class e {
    public static boolean a(int i, C0614ub c0614ub, C0622wb c0622wb, sd<String, AdobeLibraryException> sdVar, Handler handler) {
        return b(i, c0614ub, c0622wb, sdVar, handler);
    }

    private static boolean b(int i, C0614ub c0614ub, C0622wb c0622wb, sd<String, AdobeLibraryException> sdVar, Handler handler) {
        boolean z = i == 0;
        c cVar = new c(sdVar);
        d dVar = new d(sdVar);
        if (a(c0614ub, c0622wb)) {
            F f2 = (F) c0614ub;
            for (Hb hb : c0622wb.i()) {
                String j = hb.j();
                String m = hb.m();
                if (j != null && j.equals("primary")) {
                    if (!z) {
                        Integer.toString(i);
                    }
                    if ((hb.o() && m != null && m.startsWith("image/")) && i > 400) {
                        f2.a(c0622wb, hb, i, handler, sdVar, dVar);
                        return true;
                    }
                }
                if (ia.a(m)) {
                    try {
                        String a2 = Za.a(AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeCopyOnWrite).a(hb.b(), f2.i().w(), f2.i(), false);
                        if (a2 != null) {
                            sdVar.b(a2);
                            return true;
                        }
                        continue;
                    } catch (Exception e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeLibraryElement:FetchRendition", "Rendition candidate failure for local element" + e2.getMessage());
                    }
                }
            }
        }
        return c0614ub.a(c0622wb.c(), i, z, cVar, dVar, handler);
    }

    public static void a(int i, C0614ub c0614ub, Hb hb, C0622wb c0622wb, sd<String, AdobeLibraryException> sdVar, Handler handler) {
        boolean z = i == 0;
        a aVar = new a(sdVar);
        b bVar = new b(sdVar);
        if (a(c0614ub, c0622wb)) {
            F f2 = (F) c0614ub;
            String j = hb.j();
            String m = hb.m();
            if (j != null && j.equals("primary")) {
                if (!z) {
                    Integer.toString(i);
                }
                if ((hb.o() && m != null && m.startsWith("image/")) && i > 400) {
                    f2.a(c0622wb, hb, i, handler, sdVar, bVar);
                    return;
                }
            }
            if (ia.a(m)) {
                try {
                    String a2 = Za.a(AdobeDCXLocalStorageScheme.AdobeDCXLocalStorageSchemeCopyOnWrite).a(hb.b(), f2.i().w(), f2.i(), false);
                    if (a2 != null) {
                        sdVar.b(a2);
                        return;
                    }
                } catch (Exception e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeLibraryElement:FetchRendition", "Rendition candidate failure for local element" + e2.getMessage());
                }
            }
        }
        c0614ub.a(hb, aVar, bVar, handler);
    }

    public static int a(C0622wb c0622wb, int i, Activity activity, boolean z) {
        int i2;
        int[] iArr = {110, 160, 400, 500, SemanticAnnotations.SemanticType.ST_IDENTIFYING_ID_VALUE};
        int[] iArr2 = {400, 800, SemanticAnnotations.SemanticType.ST_ANONYMOUS_DATA_VALUE, SemanticAnnotations.SemanticType.ST_PERSONAL_DATA_VALUE, 3100, 5000};
        if (z) {
            i2 = i + 1;
        } else {
            iArr = iArr2;
            i2 = 1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels / i2;
        Object obj = null;
        if (c0622wb.h() != null && c0622wb.h().l() != null) {
            try {
                obj = c0622wb.h().l().get("adobestock");
            } catch (JSONException unused) {
            }
        }
        int i4 = 0;
        if (obj != null) {
            int abs = Math.abs(iArr[0] - i3);
            for (int i5 = 1; i5 < iArr.length; i5++) {
                int abs2 = Math.abs(iArr[i5] - i3);
                if (abs2 < abs) {
                    abs = abs2;
                    i4 = i5;
                }
            }
            return iArr[i4];
        }
        if (c0622wb.j().equals("application/vnd.adobe.element.characterstyle+dcx")) {
            return 0;
        }
        return i3;
    }

    public static boolean a(C0614ub c0614ub, C0622wb c0622wb) {
        if (!((F) c0614ub).i().p().c().equals("modified")) {
            return false;
        }
        for (Hb hb : c0622wb.i()) {
            if (hb.b() != null && hb.b().m().equals("modified")) {
                return true;
            }
        }
        return false;
    }
}
