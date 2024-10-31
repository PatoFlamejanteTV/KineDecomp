package com.nexstreaming.kinemaster.mediastore;

import android.content.Context;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: MediaSupportType.kt */
/* loaded from: classes.dex */
public enum MediaSupportType {
    Unknown,
    CheckAsync,
    Supported,
    NotSupported(true, R.string.media_nosupport_unknown),
    NotSupported_VideoCodec(true, R.string.media_nosupport_video_codec),
    NotSupported_VideoProfile(true, R.string.media_nosupport_video_profile),
    NotSupported_VideoLevel(true, R.string.media_nosupport_video_level),
    NotSupported_VideoFPS(true, R.string.media_nosupport_video_fps),
    NotSupported_Container(true, R.string.media_nosupport_container_format),
    NotSupported_ResolutionTooHigh(true, R.string.media_nosupport_max_resolution),
    NotSupported_ResolutionTooLow(true, R.string.media_nosupport_min_resolution),
    NotSupported_DurationTooShort(true, R.string.media_nosupport_min_duration),
    NotSupported_AudioCodec(true, R.string.media_nosupport_audio_codec),
    NotSupported_AudioProfile(true, R.string.media_nosupport_audio_profile),
    NeedTranscodeFPS(false, R.string.media_nosupport_video_fps),
    NeedTranscodeRes(false, R.string.media_nosupport_max_resolution),
    NeedTranscodeAVSync(false, R.string.media_nosupport_video_fps);

    private final boolean isNotSupported;
    private int stringResource;

    MediaSupportType() {
        this.stringResource = 0;
        this.isNotSupported = false;
    }

    public final String getNotSupportedReason(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        int i = this.stringResource;
        if (i == 0) {
            return null;
        }
        return context.getString(i);
    }

    public final boolean isNotSupported() {
        return this.isNotSupported;
    }

    public final boolean needsTranscode() {
        return this == NeedTranscodeFPS || this == NeedTranscodeRes || this == NeedTranscodeAVSync;
    }

    MediaSupportType(boolean z, int i) {
        this.isNotSupported = z;
        this.stringResource = i;
    }
}
