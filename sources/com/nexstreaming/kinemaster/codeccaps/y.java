package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;

/* compiled from: CapabilityReporter.java */
/* loaded from: classes.dex */
/* synthetic */ class y {

    /* renamed from: a */
    static final /* synthetic */ int[] f20139a = new int[CapabilityChecker.TagType.values().length];

    static {
        try {
            f20139a[CapabilityChecker.TagType.Export.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20139a[CapabilityChecker.TagType.ExportOnly.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20139a[CapabilityChecker.TagType.Preview.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20139a[CapabilityChecker.TagType.Transcode.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
