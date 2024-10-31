package com.bumptech.glide.g.a;

import com.bumptech.glide.g.a.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public class b<T> implements d.a<List<T>> {
    @Override // com.bumptech.glide.g.a.d.a
    public List<T> create() {
        return new ArrayList();
    }
}
