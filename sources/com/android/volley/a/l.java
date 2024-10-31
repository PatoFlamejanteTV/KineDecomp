package com.android.volley.a;

import android.graphics.Bitmap;
import com.android.volley.a.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ m f8022a;

    public l(m mVar) {
        this.f8022a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        HashMap hashMap2;
        LinkedList linkedList;
        m.d dVar;
        Bitmap bitmap;
        m.d dVar2;
        m.d dVar3;
        hashMap = this.f8022a.f8027e;
        for (m.a aVar : hashMap.values()) {
            linkedList = aVar.f8033d;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                m.c cVar = (m.c) it.next();
                dVar = cVar.f8036b;
                if (dVar != null) {
                    if (aVar.a() == null) {
                        bitmap = aVar.f8031b;
                        cVar.f8035a = bitmap;
                        dVar2 = cVar.f8036b;
                        dVar2.a(cVar, false);
                    } else {
                        dVar3 = cVar.f8036b;
                        dVar3.a(aVar.a());
                    }
                }
            }
        }
        hashMap2 = this.f8022a.f8027e;
        hashMap2.clear();
        this.f8022a.f8029g = null;
    }
}
