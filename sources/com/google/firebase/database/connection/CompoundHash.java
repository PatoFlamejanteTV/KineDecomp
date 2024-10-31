package com.google.firebase.database.connection;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CompoundHash {

    /* renamed from: a */
    private final List<List<String>> f16723a;

    /* renamed from: b */
    private final List<String> f16724b;

    public CompoundHash(List<List<String>> list, List<String> list2) {
        if (list.size() == list2.size() - 1) {
            this.f16723a = list;
            this.f16724b = list2;
            return;
        }
        throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
    }

    public List<String> a() {
        return Collections.unmodifiableList(this.f16724b);
    }

    public List<List<String>> b() {
        return Collections.unmodifiableList(this.f16723a);
    }
}
