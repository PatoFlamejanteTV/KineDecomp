package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzs extends zzu implements Place {
    private boolean c;
    private final zzp d;
    private final String e;

    public zzs(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.d = context != null ? zzp.a(context) : null;
        this.c = a("place_is_logging_enabled", false);
        this.e = a("place_id", "");
    }

    private void j(String str) {
        if (!this.c || this.d == null) {
            return;
        }
        this.d.a(this.e, str);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Place a() {
        PlaceImpl.zza b = new PlaceImpl.zza().b(this.c);
        this.c = false;
        PlaceImpl a2 = b.c(d().toString()).b(b("place_attributions", Collections.emptyList())).a(e()).a(p()).a(f()).a(g()).b(i().toString()).d(j().toString()).a(l()).b(m()).a(k()).a(n()).a(o()).a();
        a2.a(h());
        a2.a(this.d);
        return a2;
    }

    public CharSequence d() {
        j("getAddress");
        return a("place_address", "");
    }

    public String e() {
        j("getId");
        return this.e;
    }

    public LatLng f() {
        j("getLatLng");
        return (LatLng) a("place_lat_lng", LatLng.CREATOR);
    }

    public float g() {
        j("getLevelNumber");
        return a("place_level_number", 0.0f);
    }

    public Locale h() {
        j("getLocale");
        String a2 = a("place_locale", "");
        return !TextUtils.isEmpty(a2) ? new Locale(a2) : Locale.getDefault();
    }

    public CharSequence i() {
        j("getName");
        return a("place_name", "");
    }

    public CharSequence j() {
        j("getPhoneNumber");
        return a("place_phone_number", "");
    }

    public List<Integer> k() {
        j("getPlaceTypes");
        return a("place_types", Collections.emptyList());
    }

    public int l() {
        j("getPriceLevel");
        return a("place_price_level", -1);
    }

    public float m() {
        j("getRating");
        return a("place_rating", -1.0f);
    }

    public LatLngBounds n() {
        j("getViewport");
        return (LatLngBounds) a("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri o() {
        j("getWebsiteUri");
        String a2 = a("place_website_uri", (String) null);
        if (a2 == null) {
            return null;
        }
        return Uri.parse(a2);
    }

    public boolean p() {
        j("isPermanentlyClosed");
        return a("place_is_permanently_closed", false);
    }
}
