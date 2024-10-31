package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;

/* compiled from: AudioEffect.kt */
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public b createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.h.b(parcel, ShareConstants.FEED_SOURCE_PARAM);
        return new b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public b[] newArray(int i) {
        return new b[i];
    }
}
