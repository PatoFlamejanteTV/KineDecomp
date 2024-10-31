package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: ProjectAspectRatio.java */
/* loaded from: classes.dex */
public /* synthetic */ class kb {

    /* renamed from: a */
    static final /* synthetic */ int[] f24309a;

    /* renamed from: b */
    static final /* synthetic */ int[] f24310b = new int[KMProto.KMProject.AspectRatio.values().length];

    static {
        try {
            f24310b[KMProto.KMProject.AspectRatio.ASPECT_R_16_9.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24310b[KMProto.KMProject.AspectRatio.ASPECT_SQUARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f24310b[KMProto.KMProject.AspectRatio.ASPECT_R_9_16.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f24309a = new int[ProjectAspectRatio.values().length];
        try {
            f24309a[ProjectAspectRatio.R_16_9.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f24309a[ProjectAspectRatio.SQUARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f24309a[ProjectAspectRatio.R_9_16.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
