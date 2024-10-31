package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class zzb extends zzu implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private String g() {
        return a("ap_description", "");
    }

    private String h() {
        return a("ap_primary_text", "");
    }

    private String i() {
        return a("ap_secondary_text", "");
    }

    private List<AutocompletePredictionEntity.SubstringEntity> j() {
        return a("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List<AutocompletePredictionEntity.SubstringEntity> k() {
        return a("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List<AutocompletePredictionEntity.SubstringEntity> l() {
        return a("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction a() {
        return AutocompletePredictionEntity.a(e(), f(), d(), g(), j(), h(), k(), i(), l());
    }

    public int d() {
        return a("ap_personalization_type", 6);
    }

    public String e() {
        return a("ap_place_id", (String) null);
    }

    public List<Integer> f() {
        return a("ap_place_types", Collections.emptyList());
    }
}
