package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContentActionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 1, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public AppContentAnnotation b() {
        ArrayList<AppContentAnnotation> b = AppContentUtils.b(this.a_, this.c, "action_annotation", this.b_);
        if (b.size() == 1) {
            return b.get(0);
        }
        return null;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public List<AppContentCondition> c() {
        return AppContentUtils.c(this.a_, this.c, "action_conditions", this.b_);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String d() {
        return e("action_content_description");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public Bundle e() {
        return AppContentUtils.d(this.a_, this.c, "action_data", this.b_);
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentActionEntity.a(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String f() {
        return e("action_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String g() {
        return e("overflow_text");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String h() {
        return e(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentActionEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public AppContentAction a() {
        return new AppContentActionEntity(this);
    }

    public String toString() {
        return AppContentActionEntity.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentActionEntity) a()).writeToParcel(parcel, i);
    }
}
