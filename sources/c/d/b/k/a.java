package c.d.b.k;

import com.nexstreaming.kinemaster.mediastore.MediaSupportType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranscodeUtil.java */
/* loaded from: classes.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f3824a = new int[MediaSupportType.values().length];

    static {
        try {
            f3824a[MediaSupportType.NeedTranscodeRes.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3824a[MediaSupportType.NeedTranscodeAVSync.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3824a[MediaSupportType.NeedTranscodeFPS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
