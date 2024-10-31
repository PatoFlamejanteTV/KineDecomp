package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* loaded from: classes.dex */
public class HereContent implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1898a;
    private final String b;
    private final List<Action> c;

    /* loaded from: classes.dex */
    public static final class Action implements SafeParcelable {
        public static final zza CREATOR = new zza();

        /* renamed from: a, reason: collision with root package name */
        final int f1899a;
        private final String b;
        private final String c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Action(int i, String str, String str2) {
            this.f1899a = i;
            this.b = str;
            this.c = str2;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zza zzaVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return zzw.a(this.b, action.b) && zzw.a(this.c, action.c);
        }

        public int hashCode() {
            return zzw.a(this.b, this.c);
        }

        public String toString() {
            return zzw.a(this).a(ShareConstants.WEB_DIALOG_PARAM_TITLE, this.b).a("uri", this.c).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zza zzaVar = CREATOR;
            zza.a(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HereContent(int i, String str, List<Action> list) {
        this.f1898a = i;
        this.b = str;
        this.c = list;
    }

    public String a() {
        return this.b;
    }

    public List<Action> b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HereContent)) {
            return false;
        }
        HereContent hereContent = (HereContent) obj;
        return zzw.a(this.b, hereContent.b) && zzw.a(this.c, hereContent.c);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a(ShareConstants.WEB_DIALOG_PARAM_DATA, this.b).a("actions", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.a(this, parcel, i);
    }
}
