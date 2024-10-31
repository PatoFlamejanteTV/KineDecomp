package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

/* loaded from: classes.dex */
public final class ParticipantResult implements SafeParcelable {
    public static final Parcelable.Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1388a;
    private final String b;
    private final int c;
    private final int d;

    public ParticipantResult(int i, String str, int i2, int i3) {
        this.f1388a = i;
        this.b = (String) zzx.a(str);
        zzx.a(MatchResult.a(i2));
        this.c = i2;
        this.d = i3;
    }

    public ParticipantResult(String str, int i, int i2) {
        this(1, str, i, i2);
    }

    public int a() {
        return this.f1388a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParticipantResultCreator.a(this, parcel, i);
    }
}
