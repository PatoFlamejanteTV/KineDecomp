package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Date;

/* loaded from: classes.dex */
public interface MediaStoreItem {
    Bundle a(Class<?> cls);

    String a(Context context);

    MediaItemType b();

    MSID c();

    Date f();

    String h();

    long i();

    int j();

    int k();

    int l();

    int m();

    boolean n();

    String o();

    MediaSupportType p();

    ResultTask<MediaSupportType> q();

    boolean r();

    int s();

    boolean t();

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
        NeedTranscodeRes(false, R.string.media_nosupport_max_resolution);

        final boolean notSupported;
        int string_rsrc;

        MediaSupportType() {
            this.string_rsrc = 0;
            this.notSupported = false;
        }

        MediaSupportType(boolean z, int i) {
            this.notSupported = z;
            this.string_rsrc = i;
        }

        public String getNotSupportedReason(Context context) {
            if (this.string_rsrc == 0) {
                return null;
            }
            return context.getString(this.string_rsrc);
        }

        public boolean isNotSupported() {
            return this.notSupported;
        }

        public boolean needsTranscode() {
            return this == NeedTranscodeFPS || this == NeedTranscodeRes;
        }
    }
}
