package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTable.java */
/* loaded from: classes2.dex */
public class r<C, R, V> extends Bb<Table.Cell<R, C, V>, V> {

    /* renamed from: b */
    final /* synthetic */ AbstractC1542s f15833b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(AbstractC1542s abstractC1542s, Iterator it) {
        super(it);
        this.f15833b = abstractC1542s;
    }

    @Override // com.google.common.collect.Bb
    public V a(Table.Cell<R, C, V> cell) {
        return cell.getValue();
    }
}
