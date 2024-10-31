package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;

/* compiled from: OptionPanelAddTaskMedia.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.zd */
/* loaded from: classes2.dex */
/* synthetic */ class C2089zd {

    /* renamed from: a */
    static final /* synthetic */ int[] f22805a = new int[MediaPrepState.values().length];

    static {
        try {
            f22805a[MediaPrepState.Downloading.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22805a[MediaPrepState.Transcoding.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22805a[MediaPrepState.FailDownload.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22805a[MediaPrepState.FailTranscoding.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22805a[MediaPrepState.FailedCanRetry.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
