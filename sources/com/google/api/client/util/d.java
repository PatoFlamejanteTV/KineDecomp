package com.google.api.client.util;

import java.util.Comparator;

/* compiled from: ClassInfo.java */
/* loaded from: classes.dex */
class d implements Comparator<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ClassInfo f2550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ClassInfo classInfo) {
        this.f2550a = classInfo;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(String str, String str2) {
        if (str == str2) {
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
