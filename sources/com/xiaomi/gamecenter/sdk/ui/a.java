package com.xiaomi.gamecenter.sdk.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.gamecenter.sdk.ui.ActionTransfor;

/* loaded from: classes3.dex */
final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ActionTransfor.DataAction createFromParcel(Parcel parcel) {
        ActionTransfor.DataAction dataAction = new ActionTransfor.DataAction();
        dataAction.f26634a = parcel.readString();
        dataAction.f26635b = ActionTransfor.ActionResult.valueOf(parcel.readString());
        dataAction.f26636c = parcel.readBundle();
        dataAction.f26637d = parcel.readInt();
        return dataAction;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ActionTransfor.DataAction[] newArray(int i) {
        return new ActionTransfor.DataAction[i];
    }
}
