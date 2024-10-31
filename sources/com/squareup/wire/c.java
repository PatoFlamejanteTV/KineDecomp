package com.squareup.wire;

import java.util.Comparator;

/* compiled from: EnumAdapter.java */
/* loaded from: classes3.dex */
class c implements Comparator<m> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(m mVar, m mVar2) {
        return mVar.getValue() - mVar2.getValue();
    }
}
