package com.nexstreaming.app.general.iab.a;

import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: CallbackSubject.kt */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a */
    private ArrayList<a> f19429a = new ArrayList<>();

    public final void a(a aVar) {
        h.b(aVar, "observer");
        if (this.f19429a.contains(aVar)) {
            return;
        }
        this.f19429a.add(aVar);
    }

    public final void b(a aVar) {
        h.b(aVar, "observer");
        if (this.f19429a.contains(aVar)) {
            this.f19429a.remove(aVar);
        }
    }

    public final void a(boolean z, int i, boolean z2) {
        Iterator<a> it = this.f19429a.iterator();
        while (it.hasNext()) {
            it.next().a(z, i, z2);
        }
    }

    public final void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
        Iterator<a> it = this.f19429a.iterator();
        while (it.hasNext()) {
            it.next().a(linkedHashMap);
        }
    }

    public final void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        h.b(iABError, "error");
        Iterator<a> it = this.f19429a.iterator();
        while (it.hasNext()) {
            it.next().a(linkedHashMap, iABError, str);
        }
    }

    public final void a(boolean z, Purchase purchase, String str) {
        Iterator<a> it = this.f19429a.iterator();
        while (it.hasNext()) {
            it.next().a(z, purchase, str);
        }
    }
}
