package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;

/* loaded from: classes.dex */
public class zzr extends zzu implements PlacePhotoMetadata {
    private final String c;

    public zzr(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = e("photo_fife_url");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata a() {
        return new zzq(this.c, d(), e(), f(), this.b_);
    }

    public int d() {
        return a("photo_max_width", 0);
    }

    public int e() {
        return a("photo_max_height", 0);
    }

    public CharSequence f() {
        return a("photo_attributions", (String) null);
    }
}
