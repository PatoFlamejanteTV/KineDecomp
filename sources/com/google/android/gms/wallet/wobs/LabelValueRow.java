package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LabelValueRow implements SafeParcelable {
    public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    String f2317a;
    String b;
    ArrayList<LabelValue> c;
    private final int d;

    LabelValueRow() {
        this.d = 1;
        this.c = zzmj.zzqs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LabelValueRow(int i, String str, String str2, ArrayList<LabelValue> arrayList) {
        this.d = i;
        this.f2317a = str;
        this.b = str2;
        this.c = arrayList;
    }

    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
