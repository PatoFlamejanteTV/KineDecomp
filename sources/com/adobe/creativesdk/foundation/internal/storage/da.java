package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;

/* compiled from: AdobeStorageSortIndexCollation.java */
/* loaded from: classes.dex */
public abstract class da {

    /* renamed from: b */
    public AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState f6566b = c.a.a.a.c.a.c.b();

    /* renamed from: a */
    public ArrayList<ArrayList<aa>> f6565a = new ArrayList<>();

    public ArrayList<C0533a> a() {
        ArrayList<C0533a> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f6565a.size(); i++) {
            ArrayList<aa> arrayList2 = this.f6565a.get(i);
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                arrayList.add(arrayList2.get(i2).f5491a);
            }
        }
        return arrayList;
    }

    public abstract boolean a(ArrayList<C0533a> arrayList);

    public ArrayList<C0533a> b() {
        ArrayList<C0533a> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f6565a.size(); i++) {
            ArrayList<aa> arrayList2 = this.f6565a.get(i);
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                arrayList.add(arrayList2.get(i2).f5491a);
            }
        }
        return arrayList;
    }

    public int c() {
        return this.f6565a.size();
    }

    public abstract ArrayList<String> d();

    public boolean a(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6565a.size(); i3++) {
            i2 += this.f6565a.get(i3).size();
            int i4 = i2 - 1;
            if (i == i4) {
                return true;
            }
            if (i < i4) {
                return false;
            }
        }
        return false;
    }

    public int b(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6565a.size(); i3++) {
            int size = this.f6565a.get(i3).size();
            if (i >= i2 && i < i2 + size) {
                return i3;
            }
            i2 += size;
        }
        return -1;
    }
}
