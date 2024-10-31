package com.nexstreaming.kinemaster.mediaprep;

/* loaded from: classes.dex */
public enum MediaPrepState {
    None,
    Downloading,
    Transcoding,
    PartiallyCompleted,
    UserInterventionRequired,
    UserInterventionCancel,
    CancelOnRemoval,
    Busy,
    Completed,
    FailedPermanent,
    FailNotSupported,
    FailDownload,
    FailTranscoding,
    FailedCanRetry,
    Unknown;

    public boolean isFailed() {
        int i = C.f20772a[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }
}
