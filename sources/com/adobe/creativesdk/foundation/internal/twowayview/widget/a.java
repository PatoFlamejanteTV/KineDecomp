package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseLayoutManager.java */
/* loaded from: classes.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f6829a = new int[BaseLayoutManager.UpdateOp.values().length];

    static {
        try {
            f6829a[BaseLayoutManager.UpdateOp.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6829a[BaseLayoutManager.UpdateOp.REMOVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6829a[BaseLayoutManager.UpdateOp.MOVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
