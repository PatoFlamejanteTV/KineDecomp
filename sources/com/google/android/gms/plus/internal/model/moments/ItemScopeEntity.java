package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> ae = new HashMap<>();
    String A;
    String B;
    String C;
    ItemScopeEntity D;
    String E;
    String F;
    String G;
    String H;
    ItemScopeEntity I;
    double J;
    ItemScopeEntity K;
    double L;
    String M;
    ItemScopeEntity N;
    List<ItemScopeEntity> O;
    String P;
    String Q;
    String R;
    String S;
    ItemScopeEntity T;
    String U;
    String V;
    String W;
    ItemScopeEntity X;
    String Y;
    String Z;

    /* renamed from: a, reason: collision with root package name */
    final Set<Integer> f2162a;
    String aa;
    String ab;
    String ac;
    String ad;
    final int b;
    ItemScopeEntity c;
    List<String> d;
    ItemScopeEntity e;
    String f;
    String g;
    String h;
    List<ItemScopeEntity> i;
    int j;
    List<ItemScopeEntity> k;
    ItemScopeEntity l;
    List<ItemScopeEntity> m;
    String n;
    String o;
    ItemScopeEntity p;
    String q;
    String r;
    String s;
    List<ItemScopeEntity> t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;

    static {
        ae.put("about", FastJsonResponse.Field.a("about", 2, ItemScopeEntity.class));
        ae.put("additionalName", FastJsonResponse.Field.e("additionalName", 3));
        ae.put("address", FastJsonResponse.Field.a("address", 4, ItemScopeEntity.class));
        ae.put("addressCountry", FastJsonResponse.Field.d("addressCountry", 5));
        ae.put("addressLocality", FastJsonResponse.Field.d("addressLocality", 6));
        ae.put("addressRegion", FastJsonResponse.Field.d("addressRegion", 7));
        ae.put("associated_media", FastJsonResponse.Field.b("associated_media", 8, ItemScopeEntity.class));
        ae.put("attendeeCount", FastJsonResponse.Field.a("attendeeCount", 9));
        ae.put("attendees", FastJsonResponse.Field.b("attendees", 10, ItemScopeEntity.class));
        ae.put("audio", FastJsonResponse.Field.a("audio", 11, ItemScopeEntity.class));
        ae.put("author", FastJsonResponse.Field.b("author", 12, ItemScopeEntity.class));
        ae.put("bestRating", FastJsonResponse.Field.d("bestRating", 13));
        ae.put("birthDate", FastJsonResponse.Field.d("birthDate", 14));
        ae.put("byArtist", FastJsonResponse.Field.a("byArtist", 15, ItemScopeEntity.class));
        ae.put(ShareConstants.FEED_CAPTION_PARAM, FastJsonResponse.Field.d(ShareConstants.FEED_CAPTION_PARAM, 16));
        ae.put("contentSize", FastJsonResponse.Field.d("contentSize", 17));
        ae.put("contentUrl", FastJsonResponse.Field.d("contentUrl", 18));
        ae.put("contributor", FastJsonResponse.Field.b("contributor", 19, ItemScopeEntity.class));
        ae.put("dateCreated", FastJsonResponse.Field.d("dateCreated", 20));
        ae.put("dateModified", FastJsonResponse.Field.d("dateModified", 21));
        ae.put("datePublished", FastJsonResponse.Field.d("datePublished", 22));
        ae.put("description", FastJsonResponse.Field.d("description", 23));
        ae.put("duration", FastJsonResponse.Field.d("duration", 24));
        ae.put("embedUrl", FastJsonResponse.Field.d("embedUrl", 25));
        ae.put("endDate", FastJsonResponse.Field.d("endDate", 26));
        ae.put("familyName", FastJsonResponse.Field.d("familyName", 27));
        ae.put("gender", FastJsonResponse.Field.d("gender", 28));
        ae.put("geo", FastJsonResponse.Field.a("geo", 29, ItemScopeEntity.class));
        ae.put("givenName", FastJsonResponse.Field.d("givenName", 30));
        ae.put("height", FastJsonResponse.Field.d("height", 31));
        ae.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.d(ShareConstants.WEB_DIALOG_PARAM_ID, 32));
        ae.put("image", FastJsonResponse.Field.d("image", 33));
        ae.put("inAlbum", FastJsonResponse.Field.a("inAlbum", 34, ItemScopeEntity.class));
        ae.put("latitude", FastJsonResponse.Field.b("latitude", 36));
        ae.put("location", FastJsonResponse.Field.a("location", 37, ItemScopeEntity.class));
        ae.put("longitude", FastJsonResponse.Field.b("longitude", 38));
        ae.put("name", FastJsonResponse.Field.d("name", 39));
        ae.put("partOfTVSeries", FastJsonResponse.Field.a("partOfTVSeries", 40, ItemScopeEntity.class));
        ae.put("performers", FastJsonResponse.Field.b("performers", 41, ItemScopeEntity.class));
        ae.put("playerType", FastJsonResponse.Field.d("playerType", 42));
        ae.put("postOfficeBoxNumber", FastJsonResponse.Field.d("postOfficeBoxNumber", 43));
        ae.put("postalCode", FastJsonResponse.Field.d("postalCode", 44));
        ae.put("ratingValue", FastJsonResponse.Field.d("ratingValue", 45));
        ae.put("reviewRating", FastJsonResponse.Field.a("reviewRating", 46, ItemScopeEntity.class));
        ae.put("startDate", FastJsonResponse.Field.d("startDate", 47));
        ae.put("streetAddress", FastJsonResponse.Field.d("streetAddress", 48));
        ae.put("text", FastJsonResponse.Field.d("text", 49));
        ae.put("thumbnail", FastJsonResponse.Field.a("thumbnail", 50, ItemScopeEntity.class));
        ae.put("thumbnailUrl", FastJsonResponse.Field.d("thumbnailUrl", 51));
        ae.put("tickerSymbol", FastJsonResponse.Field.d("tickerSymbol", 52));
        ae.put("type", FastJsonResponse.Field.d("type", 53));
        ae.put("url", FastJsonResponse.Field.d("url", 54));
        ae.put("width", FastJsonResponse.Field.d("width", 55));
        ae.put("worstRating", FastJsonResponse.Field.d("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.b = 1;
        this.f2162a = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ItemScopeEntity(Set<Integer> set, int i, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i2, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f2162a = set;
        this.b = i;
        this.c = itemScopeEntity;
        this.d = list;
        this.e = itemScopeEntity2;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = list2;
        this.j = i2;
        this.k = list3;
        this.l = itemScopeEntity3;
        this.m = list4;
        this.n = str4;
        this.o = str5;
        this.p = itemScopeEntity4;
        this.q = str6;
        this.r = str7;
        this.s = str8;
        this.t = list5;
        this.u = str9;
        this.v = str10;
        this.w = str11;
        this.x = str12;
        this.y = str13;
        this.z = str14;
        this.A = str15;
        this.B = str16;
        this.C = str17;
        this.D = itemScopeEntity5;
        this.E = str18;
        this.F = str19;
        this.G = str20;
        this.H = str21;
        this.I = itemScopeEntity6;
        this.J = d;
        this.K = itemScopeEntity7;
        this.L = d2;
        this.M = str22;
        this.N = itemScopeEntity8;
        this.O = list6;
        this.P = str23;
        this.Q = str24;
        this.R = str25;
        this.S = str26;
        this.T = itemScopeEntity9;
        this.U = str27;
        this.V = str28;
        this.W = str29;
        this.X = itemScopeEntity10;
        this.Y = str30;
        this.Z = str31;
        this.aa = str32;
        this.ab = str33;
        this.ac = str34;
        this.ad = str35;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean a(FastJsonResponse.Field field) {
        return this.f2162a.contains(Integer.valueOf(field.h()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        switch (field.h()) {
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return Integer.valueOf(this.j);
            case 10:
                return this.k;
            case 11:
                return this.l;
            case 12:
                return this.m;
            case 13:
                return this.n;
            case 14:
                return this.o;
            case 15:
                return this.p;
            case 16:
                return this.q;
            case 17:
                return this.r;
            case 18:
                return this.s;
            case 19:
                return this.t;
            case 20:
                return this.u;
            case 21:
                return this.v;
            case 22:
                return this.w;
            case 23:
                return this.x;
            case 24:
                return this.y;
            case 25:
                return this.z;
            case 26:
                return this.A;
            case 27:
                return this.B;
            case 28:
                return this.C;
            case 29:
                return this.D;
            case 30:
                return this.E;
            case 31:
                return this.F;
            case 32:
                return this.G;
            case 33:
                return this.H;
            case 34:
                return this.I;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            case 36:
                return Double.valueOf(this.J);
            case 37:
                return this.K;
            case 38:
                return Double.valueOf(this.L);
            case 39:
                return this.M;
            case 40:
                return this.N;
            case 41:
                return this.O;
            case 42:
                return this.P;
            case 43:
                return this.Q;
            case 44:
                return this.R;
            case 45:
                return this.S;
            case 46:
                return this.T;
            case 47:
                return this.U;
            case 48:
                return this.V;
            case 49:
                return this.W;
            case 50:
                return this.X;
            case 51:
                return this.Y;
            case 52:
                return this.Z;
            case 53:
                return this.aa;
            case 54:
                return this.ab;
            case 55:
                return this.ac;
            case 56:
                return this.ad;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
        return ae;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : ae.values()) {
            if (a(field)) {
                if (itemScopeEntity.a(field) && b(field).equals(itemScopeEntity.b(field))) {
                }
                return false;
            }
            if (itemScopeEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity a() {
        return this;
    }

    public int hashCode() {
        int i = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = ae.values().iterator();
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
        zza zzaVar = CREATOR;
        zza.a(this, parcel, i);
    }
}
