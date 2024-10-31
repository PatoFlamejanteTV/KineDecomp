package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.C0533a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/* compiled from: AdobeStorageTimeIndexCollation.java */
/* loaded from: classes.dex */
public class ea extends da {

    /* renamed from: c */
    private ArrayList<String> f6571c;

    /* renamed from: d */
    private ArrayList<String> f6572d;

    /* JADX WARN: Removed duplicated region for block: B:23:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.ArrayList<com.adobe.creativesdk.foundation.internal.storage.aa> r26) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.ea.b(java.util.ArrayList):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.da
    public boolean a(ArrayList<C0533a> arrayList) {
        this.f6572d = new ArrayList<>();
        this.f6571c = new ArrayList<>();
        this.f6565a = new ArrayList<>();
        ArrayList<aa> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            C0533a c0533a = arrayList.get(i);
            aa aaVar = new aa();
            aaVar.f5495e = i;
            aaVar.f5491a = c0533a;
            aaVar.f5492b = c0533a.getName();
            aaVar.f5493c = c0533a.getModificationDate();
            if (c0533a.getModificationDate() == null) {
                aaVar.f5493c = c0533a.getCreationDate();
            }
            arrayList2.add(aaVar);
        }
        b(arrayList2);
        int size = d().size();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList3.add(new ArrayList());
        }
        Iterator<aa> it = arrayList2.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            ((ArrayList) arrayList3.get(next.f5494d)).add(next);
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            this.f6565a.add((ArrayList) it2.next());
        }
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.da
    public ArrayList<String> d() {
        return this.f6571c;
    }

    private long a(Date date, Calendar calendar) {
        Date time = calendar.getTime();
        return (time.getTime() - date.getTime()) / 86400000;
    }

    private String a(String str, Date date) {
        return new SimpleDateFormat(str).format(date);
    }
}
