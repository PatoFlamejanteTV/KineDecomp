package com.nexstreaming.kinemaster.mediaprep;

/* loaded from: classes.dex */
public enum MediaPrepState {
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
        switch (this) {
            case FailedPermanent:
            case FailNotSupported:
            case FailDownload:
            case FailTranscoding:
            case FailedCanRetry:
                return true;
            default:
                return false;
        }
    }
}
