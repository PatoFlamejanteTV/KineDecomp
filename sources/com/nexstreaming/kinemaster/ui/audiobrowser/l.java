package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AudioGroupInfo.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final long f3677a;
    private final String b;
    private final int c;
    private final String d;

    public l(long j, String str, int i, String str2) {
        this.f3677a = j;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    public String a() {
        return this.b;
    }

    public long b() {
        return this.f3677a;
    }

    public int c() {
        return this.c;
    }

    /* compiled from: AudioGroupInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f3678a;
        private final int b;
        private final int c;
        private final int d;
        private final Cursor e;

        public a(Cursor cursor, String str, String str2, String str3, String str4) {
            this.e = cursor;
            this.f3678a = cursor.getColumnIndexOrThrow(str);
            this.b = str3 == null ? -1 : cursor.getColumnIndex(str3);
            this.d = str2 == null ? -1 : cursor.getColumnIndex(str2);
            this.c = str4 != null ? cursor.getColumnIndex(str4) : -1;
        }

        public l a() {
            return new l(this.e.getLong(this.f3678a), (this.d == -1 || this.e.isNull(this.d)) ? null : this.e.getString(this.d), (this.b == -1 || this.e.isNull(this.b)) ? -1 : this.e.getInt(this.b), (this.c == -1 || this.e.isNull(this.c)) ? null : this.e.getString(this.c));
        }

        public List<l> b() {
            ArrayList arrayList = new ArrayList(this.e.getCount() - (this.e.getPosition() + 1));
            while (this.e.moveToNext()) {
                arrayList.add(a());
            }
            return arrayList;
        }
    }
}
