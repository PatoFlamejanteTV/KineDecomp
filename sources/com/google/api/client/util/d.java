package com.google.api.client.util;

import java.util.Comparator;

/* compiled from: ClassInfo.java */
/* loaded from: classes2.dex */
public class d implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ ClassInfo f14983a;

    public d(ClassInfo classInfo) {
        this.f14983a = classInfo;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        if (Objects.a(str, str2)) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }
}
