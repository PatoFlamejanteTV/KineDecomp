package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppContentSection a(int i, int i2) {
        return new AppContentSectionRef(this.b, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String b() {
        return "section_id";
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String c() {
        return "card_id";
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        super.release();
        int size = this.b.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = this.b.get(i);
            if (dataHolder != null) {
                dataHolder.i();
            }
        }
    }
}
