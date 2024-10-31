package com.nexstreaming.app.general.nexasset.assetpackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public /* synthetic */ class g {

    /* renamed from: a */
    static final /* synthetic */ int[] f19531a;

    /* renamed from: b */
    static final /* synthetic */ int[] f19532b = new int[InstallSourceType.values().length];

    static {
        try {
            f19532b[InstallSourceType.STORE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19532b[InstallSourceType.APP_ASSETS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19532b[InstallSourceType.FOLDER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f19531a = new int[ItemType.values().length];
        try {
            f19531a[ItemType.audio.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19531a[ItemType.font.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
