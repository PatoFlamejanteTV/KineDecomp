package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CycleDetectingLockFactory.java */
/* loaded from: classes2.dex */
public class m extends ThreadLocal<ArrayList<CycleDetectingLockFactory.a>> {
    @Override // java.lang.ThreadLocal
    public ArrayList<CycleDetectingLockFactory.a> initialValue() {
        return Lists.b(3);
    }
}
