package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f2227a;
    private final String b;

    public i(String str, String... strArr) {
        this.b = str;
        this.f2227a = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.f2227a.add(str2);
        }
    }

    public abstract zzag.zza a(Map<String, zzag.zza> map);

    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Set<String> set) {
        return set.containsAll(this.f2227a);
    }

    public Set<String> b() {
        return this.f2227a;
    }
}
