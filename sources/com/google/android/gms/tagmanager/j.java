package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class j {

    /* renamed from: a */
    private final Set<String> f14205a;

    /* renamed from: b */
    private final String f14206b;

    public j(String str, String... strArr) {
        this.f14206b = str;
        this.f14205a = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.f14205a.add(str2);
        }
    }
}
