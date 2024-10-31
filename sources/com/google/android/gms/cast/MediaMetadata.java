package com.google.android.gms.cast;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzkv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MediaMetadata {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f830a = {null, "String", "int", "double", "ISO-8601 date String"};
    private static final a b = new a().a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", ShareConstants.WEB_DIALOG_PARAM_TITLE, 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
    private final List<WebImage> c;
    private final Bundle d;
    private int e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f831a = new HashMap();
        private final Map<String, String> b = new HashMap();
        private final Map<String, Integer> c = new HashMap();

        public a a(String str, String str2, int i) {
            this.f831a.put(str, str2);
            this.b.put(str2, str);
            this.c.put(str, Integer.valueOf(i));
            return this;
        }

        public String a(String str) {
            return this.b.get(str);
        }

        public int b(String str) {
            Integer num = this.c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this.c = new ArrayList();
        this.d = new Bundle();
        this.e = i;
    }

    private void a(JSONObject jSONObject, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"metadataType".equals(next)) {
                    String a2 = b.a(next);
                    if (a2 == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.d.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.d.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.d.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(a2)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                switch (b.b(a2)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        } else {
                                            this.d.putString(a2, (String) obj2);
                                            break;
                                        }
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        } else {
                                            this.d.putInt(a2, ((Integer) obj2).intValue());
                                            break;
                                        }
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        } else {
                                            this.d.putDouble(a2, ((Double) obj2).doubleValue());
                                            break;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && zzkv.zzbT((String) obj2) != null) {
                                            this.d.putString(a2, (String) obj2);
                                            break;
                                        }
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public void a() {
        this.d.clear();
        this.c.clear();
    }

    public void a(JSONObject jSONObject) {
        a();
        this.e = 0;
        try {
            this.e = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzkv.zza(this.c, jSONObject);
        switch (this.e) {
            case 0:
                a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 1:
                a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 2:
                a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
                return;
            case 3:
                a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 4:
                a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
                return;
            default:
                a(jSONObject, new String[0]);
                return;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return a(this.d, mediaMetadata.d) && this.c.equals(mediaMetadata.c);
    }

    public int hashCode() {
        int i = 17;
        Iterator<String> it = this.d.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (i2 * 31) + this.c.hashCode();
            }
            i = this.d.get(it.next()).hashCode() + (i2 * 31);
        }
    }
}
