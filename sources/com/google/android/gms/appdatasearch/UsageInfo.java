package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f766a;
    final DocumentId b;
    final long c;
    int d;
    public final String e;
    final DocumentContents f;
    final boolean g;
    int h;
    int i;

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private DocumentId f767a;
        private String d;
        private DocumentContents e;
        private long b = -1;
        private int c = -1;
        private int g = -1;
        private boolean f = false;
        private int h = 0;

        public zza a(int i) {
            this.c = i;
            return this;
        }

        public zza a(long j) {
            this.b = j;
            return this;
        }

        public zza a(DocumentContents documentContents) {
            this.e = documentContents;
            return this;
        }

        public zza a(DocumentId documentId) {
            this.f767a = documentId;
            return this;
        }

        public zza a(boolean z) {
            this.f = z;
            return this;
        }

        public UsageInfo a() {
            return new UsageInfo(this.f767a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public zza b(int i) {
            this.h = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.f766a = i;
        this.b = documentId;
        this.c = j;
        this.d = i2;
        this.e = str;
        this.f = documentContents;
        this.g = z;
        this.h = i3;
        this.i = i4;
    }

    private UsageInfo(DocumentId documentId, long j, int i, String str, DocumentContents documentContents, boolean z, int i2, int i3) {
        this(1, documentId, j, i, str, documentContents, z, i2, i3);
    }

    public UsageInfo(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexApi.AppIndexingLink> list, int i) {
        this(1, a(str, intent), System.currentTimeMillis(), 0, (String) null, a(intent, str2, uri, str3, list).a(), false, -1, i);
    }

    public static DocumentContents.zza a(Intent intent, String str, Uri uri, String str2, List<AppIndexApi.AppIndexingLink> list) {
        String string;
        DocumentContents.zza zzaVar = new DocumentContents.zza();
        zzaVar.a(a(str));
        if (uri != null) {
            zzaVar.a(a(uri));
        }
        if (list != null) {
            zzaVar.a(a(list));
        }
        String action = intent.getAction();
        if (action != null) {
            zzaVar.a(b("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zzaVar.a(b("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zzaVar.a(b("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("intent_extra_data_key")) != null) {
            zzaVar.a(b("intent_extra_data", string));
        }
        return zzaVar.a(str2).a(true);
    }

    public static DocumentId a(String str, Intent intent) {
        return a(str, a(intent));
    }

    private static DocumentId a(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection a(Uri uri) {
        return new DocumentSection(uri.toString(), new RegisterSectionInfo.zza("web_url").a(4).a(true).b("url").a());
    }

    private static DocumentSection a(String str) {
        return new DocumentSection(str, new RegisterSectionInfo.zza(ShareConstants.WEB_DIALOG_PARAM_TITLE).a(1).b(true).b("name").a(), "text1");
    }

    private static DocumentSection a(List<AppIndexApi.AppIndexingLink> list) {
        zzox.zza zzaVar = new zzox.zza();
        zzox.zza.C0037zza[] c0037zzaArr = new zzox.zza.C0037zza[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0037zzaArr.length) {
                zzaVar.zzaCU = c0037zzaArr;
                return new DocumentSection(zzse.zzf(zzaVar), new RegisterSectionInfo.zza("outlinks").a(true).b(".private:outLinks").a("blob").a());
            }
            c0037zzaArr[i2] = new zzox.zza.C0037zza();
            AppIndexApi.AppIndexingLink appIndexingLink = list.get(i2);
            c0037zzaArr[i2].zzaCW = appIndexingLink.f773a.toString();
            c0037zzaArr[i2].viewId = appIndexingLink.c;
            if (appIndexingLink.b != null) {
                c0037zzaArr[i2].zzaCX = appIndexingLink.b.toString();
            }
            i = i2 + 1;
        }
    }

    private static String a(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes(Keyczar.DEFAULT_ENCODING));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection b(String str, String str2) {
        return new DocumentSection(str2, new RegisterSectionInfo.zza(str).a(true).a(), str);
    }

    public DocumentContents a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzj zzjVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.b, Long.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.i));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj zzjVar = CREATOR;
        zzj.a(this, parcel, i);
    }
}
