package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AudioTrackInfo.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f3679a = {"_id", "_data", ShareConstants.WEB_DIALOG_PARAM_TITLE, "_size", "duration", "artist_id", "artist", "_display_name"};
    private final String b;
    private final int c;
    private final String d;
    private final String e;

    public n(String str, int i, String str2, String str3) {
        this.b = str;
        this.c = i;
        this.e = str2;
        this.d = str3;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    /* compiled from: AudioTrackInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f3680a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final Cursor i;

        public a(Cursor cursor) {
            this.i = cursor;
            this.f3680a = cursor.getColumnIndex("_id");
            this.b = cursor.getColumnIndex("_data");
            this.c = cursor.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_TITLE);
            this.d = cursor.getColumnIndex("_size");
            this.e = cursor.getColumnIndex("duration");
            this.f = cursor.getColumnIndex("artist_id");
            this.g = cursor.getColumnIndex("artist");
            this.h = cursor.getColumnIndex("_display_name");
        }

        public n a() {
            String string = this.i.isNull(this.c) ? null : this.i.getString(this.c);
            String string2 = this.i.isNull(this.h) ? null : this.i.getString(this.h);
            int i = this.i.isNull(this.e) ? -1 : this.i.getInt(this.e);
            if (string != null) {
                string2 = string;
            }
            return new n(string2, i, this.i.getString(this.b), this.i.getString(this.b));
        }

        public List<n> b() {
            ArrayList arrayList = new ArrayList(this.i.getCount() - (this.i.getPosition() + 1));
            while (this.i.moveToNext()) {
                arrayList.add(a());
            }
            return arrayList;
        }

        public File c() {
            return new File(this.i.getString(this.b)).getParentFile();
        }
    }
}
