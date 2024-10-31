package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.xmp.XMPException;

/* compiled from: AdobeDCXMutableMetadata.java */
/* loaded from: classes.dex */
public class Ma extends Ia {
    Ma() {
    }

    static boolean a(com.adobe.xmp.b bVar, com.adobe.xmp.b bVar2) {
        return bVar.u() && bVar2.u() && (bVar.getYear() < bVar2.getYear() || bVar.getMonth() < bVar2.getMonth() || bVar.getDay() < bVar2.getDay() || bVar.getHour() < bVar2.getHour() || bVar.getMinute() < bVar2.getMinute() || bVar.getSecond() < bVar2.getSecond() || bVar.x() < bVar2.x());
    }

    public void a(Fa fa) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        if (a(Ja.a()).getValue().equals(str)) {
            return;
        }
        a("copied", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(C0233g c0233g, C0225c c0225c) throws AdobeDCXException, XMPException {
        super(c0233g, c0225c);
    }

    public Ma(Fa fa) {
        super(fa);
    }

    public Ma(com.adobe.xmp.f fVar) {
        super(fVar);
    }

    static com.adobe.xmp.b a(com.adobe.xmp.f fVar, Integer num) {
        try {
            com.adobe.xmp.c.b a2 = fVar.a("http://ns.adobe.com/xap/1.0/mm/", com.adobe.xmp.i.a("History", num.intValue()), "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "when");
            if (a2 == null || a2.getValue() == null) {
                return null;
            }
            return com.adobe.xmp.k.b(a2.getValue());
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableMetadata.getNextHistoryDate", e2.getMessage());
            return null;
        }
    }

    static void a(com.adobe.xmp.f fVar, int i, com.adobe.xmp.f fVar2, int i2) {
        String str;
        try {
            String a2 = com.adobe.xmp.i.a("History", i2);
            String a3 = com.adobe.xmp.i.a("History", i);
            com.adobe.xmp.e a4 = fVar2.a("http://ns.adobe.com/xap/1.0/mm/", a2, (com.adobe.xmp.b.b) null);
            if (a4.next() == null) {
                return;
            }
            com.adobe.xmp.b.e eVar = new com.adobe.xmp.b.e();
            eVar.j(true);
            fVar.a("http://ns.adobe.com/xap/1.0/mm/", "History", i, (String) null, eVar);
            while (a4.hasNext()) {
                com.adobe.xmp.c.c cVar = (com.adobe.xmp.c.c) a4.next();
                String str2 = "";
                if (cVar != null) {
                    str2 = cVar.getPath();
                    str = cVar.getValue();
                } else {
                    str = "";
                }
                int lastIndexOf = str2.lastIndexOf(58);
                fVar.a("http://ns.adobe.com/xap/1.0/mm/", a3, "http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", lastIndexOf != -1 ? str2.substring(lastIndexOf + 1) : str2, str);
            }
        } catch (XMPException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableMetadata.insertHistoryItem", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0261  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ia r19, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ia r20) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ma.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ia, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ia):boolean");
    }
}
