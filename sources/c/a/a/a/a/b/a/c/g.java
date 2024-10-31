package c.a.a.a.a.b.a.c;

import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.ACLibraryManager;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.auth.k;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.C0630yb;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

/* compiled from: ACLibraryManagerUtil.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Observer f3452a = new f();

    public static boolean a() {
        return c() != null;
    }

    public static void b() {
        if (!c.a.a.a.a.b.a.a.b.f()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("application/vnd.adobe.element.color+dcx");
            arrayList.add("application/vnd.adobe.element.colortheme+dcx");
            arrayList.add("application/vnd.adobe.element.image+dcx");
            arrayList.add("application/vnd.adobe.element.brush+dcx");
            arrayList.add("application/vnd.adobe.element.look+dcx");
            arrayList.add("application/vnd.adobe.element.3d+dcx");
            arrayList.add("application/vnd.adobe.element.characterstyle+dcx");
            arrayList.add("application/vnd.adobe.element.layerstyle+dcx");
            arrayList.add("application/vnd.adobe.element.video+dcx");
            arrayList.add("application/vnd.adobe.element.pattern+dcx");
            arrayList.add("application/vnd.adobe.element.template+dcx");
            arrayList.add("application/vnd.adobe.element.material+dcx");
            arrayList.add("application/vnd.adobe.element.light+dcx");
            arrayList.add("application/vnd.adobe.element.animation+dcx");
            c.a.a.a.a.b.a.a.b.a(com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.e.a(arrayList), c.a.a.a.a.b.a.a.a());
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNotificationManagerSwitchedToPrivateCloudNotification, f3452a);
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNotificationManagerSwitchedToPublicCloudNotification, f3452a);
        }
        c.a.a.a.a.b.a.a.b.c().b();
    }

    public static String c() {
        return k.a().b().getAdobeID().split("@")[0];
    }

    public static String d() {
        String c2 = Za.c(c.a.a.a.c.a.a.b().a().getFilesDir().getPath(), c());
        if (com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c() != null) {
            c2 = Za.d(Za.c(c2, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c().getGUID()), "Design Libraries");
        }
        File file = new File(c2);
        if (file.exists() || file.mkdirs()) {
            return c2;
        }
        return null;
    }

    public static C0614ub a(ACLibraryManager aCLibraryManager) {
        String a2 = c.a.a.a.a.b.a.b.b.c.a();
        C0614ub c0614ub = null;
        if (a2 != null) {
            Iterator<C0614ub> it = aCLibraryManager.e().iterator();
            while (it.hasNext()) {
                C0614ub next = it.next();
                if (next.k().equals(a2)) {
                    c0614ub = next;
                }
            }
        }
        return c0614ub;
    }

    public static ArrayList<C0622wb> a(C0614ub c0614ub, C0630yb c0630yb) {
        if (c.a.a.a.a.b.a.a.b.c() != null && c.a.a.a.a.b.a.a.b.c().e() != null) {
            return c0614ub.a(c0630yb, c.a.a.a.a.b.a.a.b.c().e());
        }
        return new ArrayList<>();
    }

    private static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<C0622wb> a(C0614ub c0614ub, String[] strArr) {
        ArrayList<C0622wb> b2;
        ArrayList<C0622wb> arrayList = new ArrayList<>();
        if (c.a.a.a.a.b.a.a.b.c() != null && c.a.a.a.a.b.a.a.b.c().e() != null && (b2 = c0614ub.b(c.a.a.a.a.b.a.a.b.c().e())) != null) {
            Iterator<C0622wb> it = b2.iterator();
            while (it.hasNext()) {
                C0622wb next = it.next();
                if (a(strArr, next.j())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
