package com.squareup.okhttp.internal.http;

import java.util.Comparator;

/* compiled from: OkHeaders.java */
/* loaded from: classes3.dex */
class p implements Comparator<String> {
    @Override // java.util.Comparator
    /* renamed from: a */
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
        return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
    }
}
