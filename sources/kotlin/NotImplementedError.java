package kotlin;

import com.facebook.share.internal.ShareConstants;

/* compiled from: Standard.kt */
/* loaded from: classes3.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
    }

    public /* synthetic */ NotImplementedError(String str, int i, kotlin.jvm.internal.f fVar) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
