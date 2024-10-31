package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABData.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c */
    public static final a f19428c = new a();

    /* renamed from: a */
    private static LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> f19426a = new LinkedHashMap<>();

    /* renamed from: b */
    private static LinkedHashMap<IABConstant.SKUType, List<Purchase>> f19427b = new LinkedHashMap<>();

    private a() {
    }

    public final LinkedHashMap<IABConstant.SKUType, List<Purchase>> a() {
        return f19427b;
    }

    public final LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> b() {
        return f19426a;
    }

    public final LinkedHashMap<String, SKUDetails> a(IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(sKUType, "type");
        return f19426a.get(sKUType);
    }
}
