package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.database.Cursor;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AudioTrackInfo.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a */
    public static final String[] f21467a = {"_id", "_data", "title", "_size", "duration", "artist_id", "artist", "_display_name"};

    /* renamed from: b */
    private final String f21468b;

    /* renamed from: c */
    private final String f21469c;

    /* renamed from: d */
    private final int f21470d;

    /* renamed from: e */
    private final String f21471e;

    /* renamed from: f */
    private final String f21472f;

    /* renamed from: g */
    private String f21473g;

    /* renamed from: h */
    private com.nexstreaming.app.general.nexasset.assetpackage.b f21474h;

    /* compiled from: AudioTrackInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final int f21475a;

        /* renamed from: b */
        private final int f21476b;

        /* renamed from: c */
        private final int f21477c;

        /* renamed from: d */
        private final int f21478d;

        /* renamed from: e */
        private final int f21479e;

        /* renamed from: f */
        private final int f21480f;

        /* renamed from: g */
        private final int f21481g;

        /* renamed from: h */
        private final int f21482h;
        private final Cursor i;

        public a(Cursor cursor) {
            this.i = cursor;
            this.f21475a = cursor.getColumnIndex("_id");
            this.f21476b = cursor.getColumnIndex("_data");
            this.f21477c = cursor.getColumnIndex("title");
            this.f21478d = cursor.getColumnIndex("_size");
            this.f21479e = cursor.getColumnIndex("duration");
            this.f21480f = cursor.getColumnIndex("artist_id");
            this.f21481g = cursor.getColumnIndex("artist");
            this.f21482h = cursor.getColumnIndex("_display_name");
        }

        public List<u> a() {
            ArrayList arrayList = new ArrayList(this.i.getCount() - (this.i.getPosition() + 1));
            if (EditorGlobal.t()) {
                while (this.i.moveToNext()) {
                    u b2 = b();
                    if (b2.e().toLowerCase().contains("demo")) {
                        arrayList.add(b2);
                    }
                }
            } else if (EditorGlobal.f24025d) {
                while (this.i.moveToNext()) {
                    u b3 = b();
                    if (b3.e().toLowerCase().contains("auto_test_file")) {
                        arrayList.add(b3);
                    }
                }
            } else {
                while (this.i.moveToNext()) {
                    arrayList.add(b());
                }
            }
            return arrayList;
        }

        public u b() {
            String string = this.i.isNull(this.f21477c) ? null : this.i.getString(this.f21477c);
            String string2 = this.i.isNull(this.f21482h) ? null : this.i.getString(this.f21482h);
            int i = this.i.isNull(this.f21479e) ? -1 : this.i.getInt(this.f21479e);
            if (string == null) {
                string = string2;
            }
            return new u(string, i, this.i.getString(this.f21476b), this.i.getString(this.f21476b));
        }

        public File c() {
            return new File(this.i.getString(this.f21476b)).getParentFile();
        }
    }

    public u(String str, int i, String str2, String str3) {
        this.f21468b = str;
        this.f21469c = str;
        this.f21470d = i;
        this.f21472f = str2;
        this.f21471e = str3;
    }

    public com.nexstreaming.app.general.nexasset.assetpackage.b a() {
        return this.f21474h;
    }

    public String b() {
        return this.f21468b;
    }

    public int c() {
        return this.f21470d;
    }

    public String d() {
        String str = this.f21469c;
        return str == null ? this.f21468b : str;
    }

    public String e() {
        return this.f21472f;
    }

    public String f() {
        return this.f21471e;
    }

    public String g() {
        return this.f21473g;
    }

    public void a(String str) {
        this.f21473g = str;
    }

    public u(String str, String str2, int i, String str3, String str4) {
        this(str, str2, i, str3, str4, null);
    }

    public u(String str, String str2, int i, String str3, String str4, com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
        this.f21468b = str;
        this.f21469c = str2;
        this.f21470d = i;
        this.f21472f = str3;
        this.f21471e = str4;
        this.f21474h = bVar;
    }
}
