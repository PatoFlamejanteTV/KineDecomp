package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.oh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public /* synthetic */ class C1975oh {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f22474a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f22475b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f22476c = new int[TimelineView.TrackType.values().length];

    static {
        try {
            f22476c[TimelineView.TrackType.Text.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22476c[TimelineView.TrackType.OtherAudio.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22476c[TimelineView.TrackType.Music.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22476c[TimelineView.TrackType.VideoLayer.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22476c[TimelineView.TrackType.OtherLayer.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f22476c[TimelineView.TrackType.BGM.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f22476c[TimelineView.TrackType.Other.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        f22475b = new int[TimelineView.AnimType.values().length];
        try {
            f22475b[TimelineView.AnimType.AddClip.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f22475b[TimelineView.AnimType.DeleteClip.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        f22474a = new int[MediaPrepState.values().length];
        try {
            f22474a[MediaPrepState.Busy.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f22474a[MediaPrepState.FailedPermanent.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f22474a[MediaPrepState.FailNotSupported.ordinal()] = 3;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f22474a[MediaPrepState.FailDownload.ordinal()] = 4;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f22474a[MediaPrepState.FailTranscoding.ordinal()] = 5;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f22474a[MediaPrepState.FailedCanRetry.ordinal()] = 6;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f22474a[MediaPrepState.UserInterventionCancel.ordinal()] = 7;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f22474a[MediaPrepState.UserInterventionRequired.ordinal()] = 8;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f22474a[MediaPrepState.Unknown.ordinal()] = 9;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f22474a[MediaPrepState.Downloading.ordinal()] = 10;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f22474a[MediaPrepState.Transcoding.ordinal()] = 11;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f22474a[MediaPrepState.Completed.ordinal()] = 12;
        } catch (NoSuchFieldError unused21) {
        }
    }
}
