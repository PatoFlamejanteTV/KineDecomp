package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AudioGroupInfo.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a */
    private final long f21457a;

    /* renamed from: b */
    private final String f21458b;

    /* renamed from: c */
    private final int f21459c;

    /* renamed from: d */
    private final String f21460d;

    /* renamed from: e */
    private String f21461e;

    /* compiled from: AudioGroupInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final int f21462a;

        /* renamed from: b */
        private final int f21463b;

        /* renamed from: c */
        private final int f21464c;

        /* renamed from: d */
        private final int f21465d;

        /* renamed from: e */
        private final Cursor f21466e;

        public a(Cursor cursor, String str, String str2, String str3, String str4) {
            this.f21466e = cursor;
            this.f21462a = cursor.getColumnIndexOrThrow(str);
            this.f21463b = str3 == null ? -1 : cursor.getColumnIndex(str3);
            this.f21465d = str2 == null ? -1 : cursor.getColumnIndex(str2);
            this.f21464c = str4 != null ? cursor.getColumnIndex(str4) : -1;
        }

        public List<s> a() {
            ArrayList arrayList = new ArrayList(this.f21466e.getCount() - (this.f21466e.getPosition() + 1));
            while (this.f21466e.moveToNext()) {
                arrayList.add(b());
            }
            return arrayList;
        }

        public s b() {
            int i = this.f21465d;
            String str = null;
            String string = (i == -1 || this.f21466e.isNull(i)) ? null : this.f21466e.getString(this.f21465d);
            long j = this.f21466e.getLong(this.f21462a);
            int i2 = this.f21463b;
            int i3 = (i2 == -1 || this.f21466e.isNull(i2)) ? -1 : this.f21466e.getInt(this.f21463b);
            int i4 = this.f21464c;
            if (i4 != -1 && !this.f21466e.isNull(i4)) {
                str = this.f21466e.getString(this.f21464c);
            }
            return new s(j, string, i3, str);
        }
    }

    public s(long j, String str, int i, String str2) {
        this.f21457a = j;
        this.f21458b = str;
        this.f21459c = i;
        this.f21460d = str2;
    }

    public String a() {
        return this.f21458b;
    }

    public long b() {
        return this.f21457a;
    }

    public int c() {
        return this.f21459c;
    }

    public void a(String str) {
        this.f21461e = str;
    }
}
