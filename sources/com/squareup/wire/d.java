package com.squareup.wire;

import java.util.Comparator;

/* compiled from: EnumAdapter.java */
/* loaded from: classes.dex */
final class d implements Comparator<m> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        return mVar.getValue() - mVar2.getValue();
    }
}
