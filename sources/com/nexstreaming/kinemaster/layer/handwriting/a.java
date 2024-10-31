package com.nexstreaming.kinemaster.layer.handwriting;

import com.nexstreaming.kinemaster.wire.KMProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawingAction.java */
/* loaded from: classes.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f20643a = new int[KMProto.KMProject.DrawingActionType.values().length];

    static {
        try {
            f20643a[KMProto.KMProject.DrawingActionType.ERASE_ALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20643a[KMProto.KMProject.DrawingActionType.STROKE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
