package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.kinemasterfree.R;
import kotlin.TypeCastException;

/* compiled from: AudioEffect.kt */
/* loaded from: classes2.dex */
public final class b implements Comparable<b>, Parcelable {

    /* renamed from: c */
    private final int f22224c;

    /* renamed from: d */
    private final String f22225d;

    /* renamed from: e */
    private final AudioEffectType f22226e;

    /* renamed from: f */
    private final IABManager.BillingType f22227f;

    /* renamed from: b */
    public static final a f22223b = new a(null);

    /* renamed from: a */
    private static final b f22222a = new b(R.string.audio_normal, null, AudioEffectType.NORMAL, IABManager.BillingType.FREE);
    public static final Parcelable.Creator<b> CREATOR = new com.nexstreaming.kinemaster.ui.projectedit.audioeffect.a();

    /* compiled from: AudioEffect.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final b a() {
            return b.f22222a;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(int i, String str, AudioEffectType audioEffectType, IABManager.BillingType billingType) {
        kotlin.jvm.internal.h.b(audioEffectType, "effectType");
        kotlin.jvm.internal.h.b(billingType, "billingType");
        this.f22224c = i;
        this.f22225d = str;
        this.f22226e = audioEffectType;
        this.f22227f = billingType;
    }

    public final IABManager.BillingType d() {
        return this.f22227f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final AudioEffectType e() {
        return this.f22226e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.h.a(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            b bVar = (b) obj;
            return this.f22224c == bVar.f22224c && !(kotlin.jvm.internal.h.a((Object) this.f22225d, (Object) bVar.f22225d) ^ true) && this.f22226e == bVar.f22226e && this.f22227f == bVar.f22227f;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffect");
    }

    public final String f() {
        return this.f22225d;
    }

    public final int g() {
        return this.f22224c;
    }

    public int hashCode() {
        int i = this.f22224c * 31;
        String str = this.f22225d;
        return ((((i + (str != null ? str.hashCode() : 0)) * 31) + this.f22226e.hashCode()) * 31) + this.f22227f.hashCode();
    }

    public String toString() {
        return "AudioEffect(nameId=" + this.f22224c + ", jsonFileName=" + this.f22225d + ", effectType=" + this.f22226e + ", billingType=" + this.f22227f + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.b(parcel, "dest");
        parcel.writeInt(this.f22224c);
        parcel.writeString(this.f22225d);
        parcel.writeInt(this.f22226e.ordinal());
        parcel.writeInt(this.f22227f.ordinal());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Parcel parcel) {
        this(parcel.readInt(), parcel.readString(), AudioEffectType.values()[parcel.readInt()], IABManager.BillingType.values()[parcel.readInt()]);
        kotlin.jvm.internal.h.b(parcel, ShareConstants.FEED_SOURCE_PARAM);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        String str;
        kotlin.jvm.internal.h.b(bVar, FacebookRequestErrorClassification.KEY_OTHER);
        if (this.f22227f.ordinal() > bVar.f22227f.ordinal()) {
            return 1;
        }
        if (this.f22227f.ordinal() < bVar.f22227f.ordinal()) {
            return -1;
        }
        String str2 = this.f22225d;
        if (str2 == null || (str = bVar.f22225d) == null) {
            return 1;
        }
        return str2.compareTo(str);
    }
}
