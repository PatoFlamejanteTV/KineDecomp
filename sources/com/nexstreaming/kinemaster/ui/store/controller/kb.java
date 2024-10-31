package com.nexstreaming.kinemaster.ui.store.controller;

import com.nexstreaming.kinemaster.network.AssetEnv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StoreActivity.java */
/* loaded from: classes2.dex */
public /* synthetic */ class kb {

    /* renamed from: a */
    static final /* synthetic */ int[] f23574a = new int[AssetEnv.values().length];

    static {
        try {
            f23574a[AssetEnv.DRAFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23574a[AssetEnv.STAGING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23574a[AssetEnv.PRODUCTION.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
