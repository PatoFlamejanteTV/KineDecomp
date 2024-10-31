package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityManager.java */
/* loaded from: classes.dex */
public /* synthetic */ class v {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20136a = new int[CapabilityManager.CapabilityMode.values().length];

    static {
        try {
            f20136a[CapabilityManager.CapabilityMode.MAXIMIZE_RESOLUTION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20136a[CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
