package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.Moment;

/* loaded from: classes.dex */
public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity c;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity d() {
        synchronized (this) {
            if (this.c == null) {
                byte[] g = g("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(g, 0, g.length);
                obtain.setDataPosition(0);
                this.c = MomentEntity.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.c;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public MomentEntity a() {
        return d();
    }
}
