package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.people.Person;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {

    /* renamed from: a, reason: collision with root package name */
    final Set<Integer> f2164a;
    final int b;
    String c;
    AgeRangeEntity d;
    String e;
    String f;
    int g;
    CoverEntity h;
    String i;
    String j;
    int k;
    String l;
    ImageEntity m;
    boolean n;
    String o;
    NameEntity p;
    String q;
    int r;
    List<OrganizationsEntity> s;
    List<PlacesLivedEntity> t;
    int u;
    int v;
    String w;
    String x;
    List<UrlsEntity> y;
    boolean z;
    public static final com.google.android.gms.plus.internal.model.people.zza CREATOR = new com.google.android.gms.plus.internal.model.people.zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> A = new HashMap<>();

    /* loaded from: classes.dex */
    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> e = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2165a;
        final int b;
        int c;
        int d;

        static {
            e.put("max", FastJsonResponse.Field.a("max", 2));
            e.put("min", FastJsonResponse.Field.a("min", 3));
        }

        public AgeRangeEntity() {
            this.b = 1;
            this.f2165a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public AgeRangeEntity(Set<Integer> set, int i, int i2, int i3) {
            this.f2165a = set;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2165a.contains(Integer.valueOf(field.h()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object b(FastJsonResponse.Field field) {
            switch (field.h()) {
                case 2:
                    return Integer.valueOf(this.c);
                case 3:
                    return Integer.valueOf(this.d);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
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
            return e;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : e.values()) {
                if (a(field)) {
                    if (ageRangeEntity.a(field) && b(field).equals(ageRangeEntity.b(field))) {
                    }
                    return false;
                }
                if (ageRangeEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public AgeRangeEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = e.values().iterator();
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

    /* loaded from: classes.dex */
    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2166a;
        final int b;
        CoverInfoEntity c;
        CoverPhotoEntity d;
        int e;

        /* loaded from: classes.dex */
        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> e = new HashMap<>();

            /* renamed from: a, reason: collision with root package name */
            final Set<Integer> f2167a;
            final int b;
            int c;
            int d;

            static {
                e.put("leftImageOffset", FastJsonResponse.Field.a("leftImageOffset", 2));
                e.put("topImageOffset", FastJsonResponse.Field.a("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.b = 1;
                this.f2167a = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public CoverInfoEntity(Set<Integer> set, int i, int i2, int i3) {
                this.f2167a = set;
                this.b = i;
                this.c = i2;
                this.d = i3;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean a(FastJsonResponse.Field field) {
                return this.f2167a.contains(Integer.valueOf(field.h()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object b(FastJsonResponse.Field field) {
                switch (field.h()) {
                    case 2:
                        return Integer.valueOf(this.c);
                    case 3:
                        return Integer.valueOf(this.d);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zzd zzdVar = CREATOR;
                return 0;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
                return e;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : e.values()) {
                    if (a(field)) {
                        if (coverInfoEntity.a(field) && b(field).equals(coverInfoEntity.b(field))) {
                        }
                        return false;
                    }
                    if (coverInfoEntity.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public CoverInfoEntity a() {
                return this;
            }

            public int hashCode() {
                int i = 0;
                Iterator<FastJsonResponse.Field<?, ?>> it = e.values().iterator();
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
                zzd zzdVar = CREATOR;
                zzd.a(this, parcel, i);
            }
        }

        /* loaded from: classes.dex */
        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> f = new HashMap<>();

            /* renamed from: a, reason: collision with root package name */
            final Set<Integer> f2168a;
            final int b;
            int c;
            String d;
            int e;

            static {
                f.put("height", FastJsonResponse.Field.a("height", 2));
                f.put("url", FastJsonResponse.Field.d("url", 3));
                f.put("width", FastJsonResponse.Field.a("width", 4));
            }

            public CoverPhotoEntity() {
                this.b = 1;
                this.f2168a = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public CoverPhotoEntity(Set<Integer> set, int i, int i2, String str, int i3) {
                this.f2168a = set;
                this.b = i;
                this.c = i2;
                this.d = str;
                this.e = i3;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected boolean a(FastJsonResponse.Field field) {
                return this.f2168a.contains(Integer.valueOf(field.h()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected Object b(FastJsonResponse.Field field) {
                switch (field.h()) {
                    case 2:
                        return Integer.valueOf(this.c);
                    case 3:
                        return this.d;
                    case 4:
                        return Integer.valueOf(this.e);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                zze zzeVar = CREATOR;
                return 0;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
                return f;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field<?, ?> field : f.values()) {
                    if (a(field)) {
                        if (coverPhotoEntity.a(field) && b(field).equals(coverPhotoEntity.b(field))) {
                        }
                        return false;
                    }
                    if (coverPhotoEntity.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public CoverPhotoEntity a() {
                return this;
            }

            public int hashCode() {
                int i = 0;
                Iterator<FastJsonResponse.Field<?, ?>> it = f.values().iterator();
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
                zze zzeVar = CREATOR;
                zze.a(this, parcel, i);
            }
        }

        static {
            f.put("coverInfo", FastJsonResponse.Field.a("coverInfo", 2, CoverInfoEntity.class));
            f.put("coverPhoto", FastJsonResponse.Field.a("coverPhoto", 3, CoverPhotoEntity.class));
            f.put("layout", FastJsonResponse.Field.a("layout", 4, new StringToIntConverter().a("banner", 0), false));
        }

        public CoverEntity() {
            this.b = 1;
            this.f2166a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CoverEntity(Set<Integer> set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.f2166a = set;
            this.b = i;
            this.c = coverInfoEntity;
            this.d = coverPhotoEntity;
            this.e = i2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2166a.contains(Integer.valueOf(field.h()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object b(FastJsonResponse.Field field) {
            switch (field.h()) {
                case 2:
                    return this.c;
                case 3:
                    return this.d;
                case 4:
                    return Integer.valueOf(this.e);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return f;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : f.values()) {
                if (a(field)) {
                    if (coverEntity.a(field) && b(field).equals(coverEntity.b(field))) {
                    }
                    return false;
                }
                if (coverEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public CoverEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = f.values().iterator();
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
            zzc zzcVar = CREATOR;
            zzc.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> d = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2169a;
        final int b;
        String c;

        static {
            d.put("url", FastJsonResponse.Field.d("url", 2));
        }

        public ImageEntity() {
            this.b = 1;
            this.f2169a = new HashSet();
        }

        public ImageEntity(String str) {
            this.f2169a = new HashSet();
            this.b = 1;
            this.c = str;
            this.f2169a.add(2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImageEntity(Set<Integer> set, int i, String str) {
            this.f2169a = set;
            this.b = i;
            this.c = str;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2169a.contains(Integer.valueOf(field.h()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object b(FastJsonResponse.Field field) {
            switch (field.h()) {
                case 2:
                    return this.c;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : d.values()) {
                if (a(field)) {
                    if (imageEntity.a(field) && b(field).equals(imageEntity.b(field))) {
                    }
                    return false;
                }
                if (imageEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public ImageEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = d.values().iterator();
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
            zzf zzfVar = CREATOR;
            zzf.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> i = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2170a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;

        static {
            i.put("familyName", FastJsonResponse.Field.d("familyName", 2));
            i.put("formatted", FastJsonResponse.Field.d("formatted", 3));
            i.put("givenName", FastJsonResponse.Field.d("givenName", 4));
            i.put("honorificPrefix", FastJsonResponse.Field.d("honorificPrefix", 5));
            i.put("honorificSuffix", FastJsonResponse.Field.d("honorificSuffix", 6));
            i.put("middleName", FastJsonResponse.Field.d("middleName", 7));
        }

        public NameEntity() {
            this.b = 1;
            this.f2170a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public NameEntity(Set<Integer> set, int i2, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f2170a = set;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2170a.contains(Integer.valueOf(field.h()));
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
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : i.values()) {
                if (a(field)) {
                    if (nameEntity.a(field) && b(field).equals(nameEntity.b(field))) {
                    }
                    return false;
                }
                if (nameEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NameEntity a() {
            return this;
        }

        public int hashCode() {
            int i2 = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = i.values().iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    return i3;
                }
                FastJsonResponse.Field<?, ?> next = it.next();
                if (a(next)) {
                    i2 = b(next).hashCode() + i3 + next.h();
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            zzg zzgVar = CREATOR;
            zzg.a(this, parcel, i2);
        }
    }

    /* loaded from: classes.dex */
    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> l = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2171a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        boolean h;
        String i;
        String j;
        int k;

        static {
            l.put("department", FastJsonResponse.Field.d("department", 2));
            l.put("description", FastJsonResponse.Field.d("description", 3));
            l.put("endDate", FastJsonResponse.Field.d("endDate", 4));
            l.put("location", FastJsonResponse.Field.d("location", 5));
            l.put("name", FastJsonResponse.Field.d("name", 6));
            l.put("primary", FastJsonResponse.Field.c("primary", 7));
            l.put("startDate", FastJsonResponse.Field.d("startDate", 8));
            l.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, FastJsonResponse.Field.d(ShareConstants.WEB_DIALOG_PARAM_TITLE, 9));
            l.put("type", FastJsonResponse.Field.a("type", 10, new StringToIntConverter().a("work", 0).a("school", 1), false));
        }

        public OrganizationsEntity() {
            this.b = 1;
            this.f2171a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public OrganizationsEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.f2171a = set;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = z;
            this.i = str6;
            this.j = str7;
            this.k = i2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2171a.contains(Integer.valueOf(field.h()));
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
                    return Boolean.valueOf(this.h);
                case 8:
                    return this.i;
                case 9:
                    return this.j;
                case 10:
                    return Integer.valueOf(this.k);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return l;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : l.values()) {
                if (a(field)) {
                    if (organizationsEntity.a(field) && b(field).equals(organizationsEntity.b(field))) {
                    }
                    return false;
                }
                if (organizationsEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public OrganizationsEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = l.values().iterator();
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
            zzh zzhVar = CREATOR;
            zzh.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> e = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2172a;
        final int b;
        boolean c;
        String d;

        static {
            e.put("primary", FastJsonResponse.Field.c("primary", 2));
            e.put("value", FastJsonResponse.Field.d("value", 3));
        }

        public PlacesLivedEntity() {
            this.b = 1;
            this.f2172a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PlacesLivedEntity(Set<Integer> set, int i, boolean z, String str) {
            this.f2172a = set;
            this.b = i;
            this.c = z;
            this.d = str;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2172a.contains(Integer.valueOf(field.h()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object b(FastJsonResponse.Field field) {
            switch (field.h()) {
                case 2:
                    return Boolean.valueOf(this.c);
                case 3:
                    return this.d;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return e;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : e.values()) {
                if (a(field)) {
                    if (placesLivedEntity.a(field) && b(field).equals(placesLivedEntity.b(field))) {
                    }
                    return false;
                }
                if (placesLivedEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public PlacesLivedEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = e.values().iterator();
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
            zzi zziVar = CREATOR;
            zzi.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f = new HashMap<>();

        /* renamed from: a, reason: collision with root package name */
        final Set<Integer> f2173a;
        final int b;
        String c;
        int d;
        String e;
        private final int g;

        static {
            f.put("label", FastJsonResponse.Field.d("label", 5));
            f.put("type", FastJsonResponse.Field.a("type", 6, new StringToIntConverter().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a(FacebookRequestErrorClassification.KEY_OTHER, 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
            f.put("value", FastJsonResponse.Field.d("value", 4));
        }

        public UrlsEntity() {
            this.g = 4;
            this.b = 1;
            this.f2173a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public UrlsEntity(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.g = 4;
            this.f2173a = set;
            this.b = i;
            this.c = str;
            this.d = i2;
            this.e = str2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected boolean a(FastJsonResponse.Field field) {
            return this.f2173a.contains(Integer.valueOf(field.h()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected Object b(FastJsonResponse.Field field) {
            switch (field.h()) {
                case 4:
                    return this.e;
                case 5:
                    return this.c;
                case 6:
                    return Integer.valueOf(this.d);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
            return f;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field<?, ?> field : f.values()) {
                if (a(field)) {
                    if (urlsEntity.a(field) && b(field).equals(urlsEntity.b(field))) {
                    }
                    return false;
                }
                if (urlsEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Deprecated
        public int f() {
            return 4;
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public UrlsEntity a() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator<FastJsonResponse.Field<?, ?>> it = f.values().iterator();
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
            zzj zzjVar = CREATOR;
            zzj.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class zza {
        public static int a(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        A.put("aboutMe", FastJsonResponse.Field.d("aboutMe", 2));
        A.put("ageRange", FastJsonResponse.Field.a("ageRange", 3, AgeRangeEntity.class));
        A.put("birthday", FastJsonResponse.Field.d("birthday", 4));
        A.put("braggingRights", FastJsonResponse.Field.d("braggingRights", 5));
        A.put("circledByCount", FastJsonResponse.Field.a("circledByCount", 6));
        A.put("cover", FastJsonResponse.Field.a("cover", 7, CoverEntity.class));
        A.put("currentLocation", FastJsonResponse.Field.d("currentLocation", 8));
        A.put("displayName", FastJsonResponse.Field.d("displayName", 9));
        A.put("gender", FastJsonResponse.Field.a("gender", 12, new StringToIntConverter().a("male", 0).a("female", 1).a(FacebookRequestErrorClassification.KEY_OTHER, 2), false));
        A.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.d(ShareConstants.WEB_DIALOG_PARAM_ID, 14));
        A.put("image", FastJsonResponse.Field.a("image", 15, ImageEntity.class));
        A.put("isPlusUser", FastJsonResponse.Field.c("isPlusUser", 16));
        A.put("language", FastJsonResponse.Field.d("language", 18));
        A.put("name", FastJsonResponse.Field.a("name", 19, NameEntity.class));
        A.put("nickname", FastJsonResponse.Field.d("nickname", 20));
        A.put("objectType", FastJsonResponse.Field.a("objectType", 21, new StringToIntConverter().a("person", 0).a("page", 1), false));
        A.put("organizations", FastJsonResponse.Field.b("organizations", 22, OrganizationsEntity.class));
        A.put("placesLived", FastJsonResponse.Field.b("placesLived", 23, PlacesLivedEntity.class));
        A.put("plusOneCount", FastJsonResponse.Field.a("plusOneCount", 24));
        A.put("relationshipStatus", FastJsonResponse.Field.a("relationshipStatus", 25, new StringToIntConverter().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
        A.put("tagline", FastJsonResponse.Field.d("tagline", 26));
        A.put("url", FastJsonResponse.Field.d("url", 27));
        A.put("urls", FastJsonResponse.Field.b("urls", 28, UrlsEntity.class));
        A.put("verified", FastJsonResponse.Field.c("verified", 29));
    }

    public PersonEntity() {
        this.b = 1;
        this.f2164a = new HashSet();
    }

    public PersonEntity(String str, String str2, ImageEntity imageEntity, int i, String str3) {
        this.b = 1;
        this.f2164a = new HashSet();
        this.j = str;
        this.f2164a.add(9);
        this.l = str2;
        this.f2164a.add(14);
        this.m = imageEntity;
        this.f2164a.add(15);
        this.r = i;
        this.f2164a.add(21);
        this.x = str3;
        this.f2164a.add(27);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersonEntity(Set<Integer> set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List<OrganizationsEntity> list, List<PlacesLivedEntity> list2, int i5, int i6, String str9, String str10, List<UrlsEntity> list3, boolean z2) {
        this.f2164a = set;
        this.b = i;
        this.c = str;
        this.d = ageRangeEntity;
        this.e = str2;
        this.f = str3;
        this.g = i2;
        this.h = coverEntity;
        this.i = str4;
        this.j = str5;
        this.k = i3;
        this.l = str6;
        this.m = imageEntity;
        this.n = z;
        this.o = str7;
        this.p = nameEntity;
        this.q = str8;
        this.r = i4;
        this.s = list;
        this.t = list2;
        this.u = i5;
        this.v = i6;
        this.w = str9;
        this.x = str10;
        this.y = list3;
        this.z = z2;
    }

    public static PersonEntity a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean a(FastJsonResponse.Field field) {
        return this.f2164a.contains(Integer.valueOf(field.h()));
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
                return Integer.valueOf(this.g);
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return this.j;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.h());
            case 12:
                return Integer.valueOf(this.k);
            case 14:
                return this.l;
            case 15:
                return this.m;
            case 16:
                return Boolean.valueOf(this.n);
            case 18:
                return this.o;
            case 19:
                return this.p;
            case 20:
                return this.q;
            case 21:
                return Integer.valueOf(this.r);
            case 22:
                return this.s;
            case 23:
                return this.t;
            case 24:
                return Integer.valueOf(this.u);
            case 25:
                return Integer.valueOf(this.v);
            case 26:
                return this.w;
            case 27:
                return this.x;
            case 28:
                return this.y;
            case 29:
                return Boolean.valueOf(this.z);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> b() {
        return A;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : A.values()) {
            if (a(field)) {
                if (personEntity.a(field) && b(field).equals(personEntity.b(field))) {
                }
                return false;
            }
            if (personEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public PersonEntity a() {
        return this;
    }

    public int hashCode() {
        int i = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = A.values().iterator();
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
        com.google.android.gms.plus.internal.model.people.zza zzaVar = CREATOR;
        com.google.android.gms.plus.internal.model.people.zza.a(this, parcel, i);
    }
}
