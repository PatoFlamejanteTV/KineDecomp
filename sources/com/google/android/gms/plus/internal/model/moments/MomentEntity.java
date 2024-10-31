package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> h = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    final Set<Integer> f2163a;
    final int b;
    String c;
    ItemScopeEntity d;
    String e;
    ItemScopeEntity f;
    String g;

    static {
        h.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.d(ShareConstants.WEB_DIALOG_PARAM_ID, 2));
        h.put("result", FastJsonResponse.Field.a("result", 4, ItemScopeEntity.class));
        h.put("startDate", FastJsonResponse.Field.d("startDate", 5));
        h.put("target", FastJsonResponse.Field.a("target", 6, ItemScopeEntity.class));
        h.put("type", FastJsonResponse.Field.d("type", 7));
    }

    public MomentEntity() {
        this.b = 1;
        this.f2163a = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MomentEntity(Set<Integer> set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.f2163a = set;
        this.b = i;
        this.c = str;
        this.d = itemScopeEntity;
        this.e = str2;
        this.f = itemScopeEntity2;
        this.g = str3;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean a(FastJsonResponse.Field field) {
        return this.f2163a.contains(Integer.valueOf(field.h()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        switch (field.h()) {
            case 2:
                return this.c;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
            case 7:
                return this.g;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
        return h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : h.values()) {
            if (a(field)) {
                if (momentEntity.a(field) && b(field).equals(momentEntity.b(field))) {
                }
                return false;
            }
            if (momentEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public MomentEntity a() {
        return this;
    }

    public int hashCode() {
        int i = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = h.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            FastJsonResponse.Field<?, ?> next = it.next();
            if (a(next)) {
                i = b(next).hashCode() + i2 + next.h();
            } else {
                i = i2;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.a(this, parcel, i);
    }
}
