package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScoresEntry createFromParcel(Parcel parcel) {
        ScoresEntry scoresEntry = new ScoresEntry();
        scoresEntry.scoreKey = parcel.readString();
        scoresEntry.scoreValue = parcel.readInt();
        return scoresEntry;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScoresEntry[] newArray(int i) {
        return new ScoresEntry[i];
    }
}
