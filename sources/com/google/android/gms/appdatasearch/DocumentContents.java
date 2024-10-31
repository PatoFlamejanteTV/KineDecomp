package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f755a;
    final DocumentSection[] b;
    public final String c;
    public final boolean d;
    public final Account e;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private List<DocumentSection> f756a;
        private String b;
        private boolean c;
        private Account d;

        public zza a(Account account) {
            this.d = account;
            return this;
        }

        public zza a(DocumentSection documentSection) {
            if (this.f756a == null) {
                this.f756a = new ArrayList();
            }
            this.f756a.add(documentSection);
            return this;
        }

        public zza a(String str) {
            this.b = str;
            return this;
        }

        public zza a(boolean z) {
            this.c = z;
            return this;
        }

        public DocumentContents a() {
            return new DocumentContents(this.b, this.c, this.d, this.f756a != null ? (DocumentSection[]) this.f756a.toArray(new DocumentSection[this.f756a.size()]) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account) {
        this.f755a = i;
        this.b = documentSectionArr;
        this.c = str;
        this.d = z;
        this.e = account;
    }

    DocumentContents(String str, boolean z, Account account, DocumentSection... documentSectionArr) {
        this(1, documentSectionArr, str, z, account);
        BitSet bitSet = new BitSet(zzh.a());
        for (DocumentSection documentSection : documentSectionArr) {
            int i = documentSection.e;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zzh.a(i));
                }
                bitSet.set(i);
            }
        }
    }

    public DocumentSection a(String str) {
        zzx.a(str);
        if (this.b == null) {
            return null;
        }
        for (DocumentSection documentSection : this.b) {
            if (str.equals(documentSection.a().b)) {
                return documentSection;
            }
        }
        return null;
    }

    public String a() {
        DocumentSection a2 = a("web_url");
        if (a2 != null) {
            return a2.c;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.a(this, parcel, i);
    }
}
