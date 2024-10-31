package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {

    /* renamed from: a, reason: collision with root package name */
    public final String f1877a;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f1878a;

        public PlacesOptions a() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.f1877a = builder.f1878a;
    }
}
