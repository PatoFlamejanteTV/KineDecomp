package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;

/* compiled from: MediaPrepView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.k */
/* loaded from: classes2.dex */
/* synthetic */ class C2030k {

    /* renamed from: a */
    static final /* synthetic */ int[] f22682a = new int[MediaPrepState.values().length];

    static {
        try {
            f22682a[MediaPrepState.Downloading.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22682a[MediaPrepState.Transcoding.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22682a[MediaPrepState.Busy.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22682a[MediaPrepState.FailedPermanent.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22682a[MediaPrepState.FailNotSupported.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f22682a[MediaPrepState.FailDownload.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f22682a[MediaPrepState.FailTranscoding.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f22682a[MediaPrepState.FailedCanRetry.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f22682a[MediaPrepState.UserInterventionRequired.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f22682a[MediaPrepState.UserInterventionCancel.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f22682a[MediaPrepState.Unknown.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
