package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.mediastore.MediaSupportType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public /* synthetic */ class Cb {

    /* renamed from: a */
    static final /* synthetic */ int[] f21798a = new int[MediaSupportType.values().length];

    static {
        try {
            f21798a[MediaSupportType.Supported.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21798a[MediaSupportType.NeedTranscodeAVSync.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21798a[MediaSupportType.NeedTranscodeFPS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21798a[MediaSupportType.NeedTranscodeRes.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
