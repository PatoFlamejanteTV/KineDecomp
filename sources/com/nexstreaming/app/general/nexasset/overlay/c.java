package com.nexstreaming.app.general.nexasset.overlay;

import com.nexstreaming.app.general.nexasset.assetpackage.ItemType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OverlayAssetFactory.java */
/* loaded from: classes2.dex */
public /* synthetic */ class c {

    /* renamed from: a */
    static final /* synthetic */ int[] f19638a = new int[ItemType.values().length];

    static {
        try {
            f19638a[ItemType.overlay.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19638a[ItemType.lottie.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19638a[ItemType.renderitem.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
