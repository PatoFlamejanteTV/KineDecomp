package kotlinx.coroutines.internal;

import com.facebook.share.internal.ShareConstants;

/* compiled from: ArrayCopy.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <E> void a(E[] eArr, int i, E[] eArr2, int i2, int i3) {
        kotlin.jvm.internal.h.b(eArr, ShareConstants.FEED_SOURCE_PARAM);
        kotlin.jvm.internal.h.b(eArr2, ShareConstants.DESTINATION);
        System.arraycopy(eArr, i, eArr2, i2, i3);
    }
}
