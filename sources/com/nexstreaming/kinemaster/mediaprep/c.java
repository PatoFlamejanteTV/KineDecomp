package com.nexstreaming.kinemaster.mediaprep;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepState.java */
/* loaded from: classes.dex */
public /* synthetic */ class C {

    /* renamed from: a */
    static final /* synthetic */ int[] f20772a = new int[MediaPrepState.values().length];

    static {
        try {
            f20772a[MediaPrepState.FailedPermanent.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20772a[MediaPrepState.FailNotSupported.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20772a[MediaPrepState.FailDownload.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20772a[MediaPrepState.FailTranscoding.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20772a[MediaPrepState.FailedCanRetry.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
