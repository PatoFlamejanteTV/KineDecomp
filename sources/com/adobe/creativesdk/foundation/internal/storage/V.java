package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;

/* compiled from: AdobeStorageAlphaIndexCollation.java */
/* loaded from: classes.dex */
public class V extends da {

    /* renamed from: c */
    ArrayList<String> f5264c;

    @Override // com.adobe.creativesdk.foundation.internal.storage.da
    public boolean a(ArrayList<C0533a> arrayList) {
        this.f6565a = new ArrayList<>();
        this.f5264c = new ArrayList<>();
        if (arrayList == null) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            C0533a c0533a = arrayList.get(i);
            aa aaVar = new aa();
            aaVar.f5491a = c0533a;
            aaVar.f5492b = c0533a.getName();
            aaVar.f5495e = i;
            String str = "" + Character.toUpperCase(c0533a.getName().charAt(0));
            ArrayList<aa> arrayList2 = new ArrayList<>();
            if (!this.f5264c.contains(str)) {
                aaVar.f5494d = this.f6565a.size();
                arrayList2.add(aaVar);
                this.f6565a.add(arrayList2);
                this.f5264c.add(str);
            } else {
                int indexOf = this.f5264c.indexOf(str);
                ArrayList<aa> arrayList3 = this.f6565a.get(indexOf);
                aaVar.f5494d = arrayList3.size();
                arrayList3.add(aaVar);
                this.f6565a.set(indexOf, arrayList3);
            }
        }
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.da
    public ArrayList<String> d() {
        return this.f5264c;
    }
}
