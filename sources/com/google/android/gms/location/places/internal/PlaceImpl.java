package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzl CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    final int f1882a;
    final boolean b;
    private final String c;
    private final Bundle d;

    @Deprecated
    private final PlaceLocalization e;
    private final LatLng f;
    private final float g;
    private final LatLngBounds h;
    private final String i;
    private final Uri j;
    private final boolean k;
    private final float l;
    private final int m;
    private final long n;
    private final List<Integer> o;
    private final List<Integer> p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final List<String> u;
    private final Map<Integer, String> v;
    private final TimeZone w;
    private Locale x;
    private zzp y;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private int f1883a = 0;
        private String b;
        private Bundle c;
        private String d;
        private LatLng e;
        private float f;
        private LatLngBounds g;
        private String h;
        private Uri i;
        private boolean j;
        private float k;
        private int l;
        private long m;
        private List<Integer> n;
        private String o;
        private String p;
        private String q;
        private List<String> r;
        private boolean s;

        public zza a(float f) {
            this.f = f;
            return this;
        }

        public zza a(int i) {
            this.l = i;
            return this;
        }

        public zza a(Uri uri) {
            this.i = uri;
            return this;
        }

        public zza a(LatLng latLng) {
            this.e = latLng;
            return this;
        }

        public zza a(LatLngBounds latLngBounds) {
            this.g = latLngBounds;
            return this;
        }

        public zza a(String str) {
            this.b = str;
            return this;
        }

        public zza a(List<Integer> list) {
            this.n = list;
            return this;
        }

        public zza a(boolean z) {
            this.j = z;
            return this;
        }

        public PlaceImpl a() {
            return new PlaceImpl(this.f1883a, this.b, this.n, Collections.emptyList(), this.c, this.d, this.o, this.p, this.q, this.r, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.s, PlaceLocalization.a(this.d, this.o, this.p, this.q, this.r));
        }

        public zza b(float f) {
            this.k = f;
            return this;
        }

        public zza b(String str) {
            this.d = str;
            return this;
        }

        public zza b(List<String> list) {
            this.r = list;
            return this;
        }

        public zza b(boolean z) {
            this.s = z;
            return this;
        }

        public zza c(String str) {
            this.o = str;
            return this;
        }

        public zza d(String str) {
            this.p = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceImpl(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i2, long j, boolean z2, PlaceLocalization placeLocalization) {
        this.f1882a = i;
        this.c = str;
        this.p = Collections.unmodifiableList(list);
        this.o = list2;
        this.d = bundle == null ? new Bundle() : bundle;
        this.q = str2;
        this.r = str3;
        this.s = str4;
        this.t = str5;
        this.u = list3 == null ? Collections.emptyList() : list3;
        this.f = latLng;
        this.g = f;
        this.h = latLngBounds;
        this.i = str6 == null ? "UTC" : str6;
        this.j = uri;
        this.k = z;
        this.l = f2;
        this.m = i2;
        this.n = j;
        this.v = Collections.unmodifiableMap(new HashMap());
        this.w = null;
        this.x = null;
        this.b = z2;
        this.e = placeLocalization;
    }

    private void a(String str) {
        if (!this.b || this.y == null) {
            return;
        }
        this.y.a(this.c, str);
    }

    public void a(zzp zzpVar) {
        this.y = zzpVar;
    }

    public void a(Locale locale) {
        this.x = locale;
    }

    public String b() {
        a("getId");
        return this.c;
    }

    public List<Integer> c() {
        a("getPlaceTypes");
        return this.p;
    }

    public List<Integer> d() {
        a("getTypesDeprecated");
        return this.o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzl zzlVar = CREATOR;
        return 0;
    }

    public String e() {
        a("getName");
        return this.q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) obj;
        return this.c.equals(placeImpl.c) && zzw.a(this.x, placeImpl.x) && this.n == placeImpl.n;
    }

    public String f() {
        a("getAddress");
        return this.r;
    }

    public LatLng g() {
        a("getLatLng");
        return this.f;
    }

    public float h() {
        a("getLevelNumber");
        return this.g;
    }

    public int hashCode() {
        return zzw.a(this.c, this.x, Long.valueOf(this.n));
    }

    public LatLngBounds i() {
        a("getViewport");
        return this.h;
    }

    public Uri j() {
        a("getWebsiteUri");
        return this.j;
    }

    public String k() {
        a("getPhoneNumber");
        return this.s;
    }

    public String l() {
        a("getRegularOpenHours");
        return this.t;
    }

    public List<String> m() {
        a("getAttributions");
        return this.u;
    }

    public boolean n() {
        a("isPermanentlyClosed");
        return this.k;
    }

    public float o() {
        a("getRating");
        return this.l;
    }

    public int p() {
        a("getPriceLevel");
        return this.m;
    }

    public long q() {
        return this.n;
    }

    public Bundle r() {
        return this.d;
    }

    public String s() {
        return this.i;
    }

    @Deprecated
    public PlaceLocalization t() {
        a("getLocalization");
        return this.e;
    }

    public String toString() {
        return zzw.a(this).a(ShareConstants.WEB_DIALOG_PARAM_ID, this.c).a("placeTypes", this.p).a("locale", this.x).a("name", this.q).a("address", this.r).a("phoneNumber", this.s).a("latlng", this.f).a("viewport", this.h).a("websiteUri", this.j).a("isPermanentlyClosed", Boolean.valueOf(this.k)).a("priceLevel", Integer.valueOf(this.m)).a("timestampSecs", Long.valueOf(this.n)).toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Place a() {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl zzlVar = CREATOR;
        zzl.a(this, parcel, i);
    }
}
