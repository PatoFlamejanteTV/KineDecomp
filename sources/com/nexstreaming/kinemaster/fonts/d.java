package com.nexstreaming.kinemaster.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemType;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.fonts.Font;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FontManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f20395a;

    /* renamed from: b, reason: collision with root package name */
    private List<c> f20396b = null;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Font> f20397c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontManager.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final String f20398a;

        /* renamed from: b, reason: collision with root package name */
        private final int f20399b;

        /* renamed from: c, reason: collision with root package name */
        private final List<Font> f20400c = new ArrayList();

        a(String str, int i) {
            this.f20398a = str;
            this.f20399b = i;
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public List<Font> a() {
            return Collections.unmodifiableList(this.f20400c);
        }

        List<Font> b() {
            return this.f20400c;
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public String getId() {
            return this.f20398a;
        }

        @Override // com.nexstreaming.kinemaster.fonts.c
        public String getName(Context context) {
            int i = this.f20399b;
            if (i != 0) {
                return context.getString(i);
            }
            return null;
        }
    }

    public static d b() {
        if (f20395a == null) {
            f20395a = new d();
        }
        return f20395a;
    }

    private Map<String, Font> c() {
        if (this.f20397c == null) {
            List<Font> a2 = com.nexstreaming.kinemaster.fonts.a.a();
            this.f20397c = new HashMap();
            for (Font font : a2) {
                this.f20397c.put(font.getId(), font);
            }
        }
        return this.f20397c;
    }

    private static Map<String, Integer> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("latin", Integer.valueOf(R.string.fontcoll_latin));
        hashMap.put("hangul", Integer.valueOf(R.string.fontcoll_korean));
        hashMap.put("chs", Integer.valueOf(R.string.fontcoll_chs));
        hashMap.put("cht", Integer.valueOf(R.string.fontcoll_cht));
        hashMap.put("japanese", Integer.valueOf(R.string.fontcoll_jp));
        hashMap.put("android", Integer.valueOf(R.string.fontcoll_android));
        return hashMap;
    }

    private void e() {
        Map<String, Integer> d2 = d();
        HashMap hashMap = new HashMap();
        for (Font font : c().values()) {
            String e2 = font.e();
            a aVar = (a) hashMap.get(e2);
            if (aVar == null) {
                Integer num = d2.get(e2);
                if (num == null) {
                    num = Integer.valueOf(R.string.fontcoll_other);
                }
                a aVar2 = new a(e2, num.intValue());
                hashMap.put(e2, aVar2);
                aVar = aVar2;
            }
            aVar.b().add(font);
        }
        this.f20396b = Collections.unmodifiableList(new ArrayList(hashMap.values()));
    }

    public List<c> a() {
        if (this.f20396b == null) {
            e();
        }
        return this.f20396b;
    }

    public Typeface a(String str) {
        if (str != null && str.trim().length() >= 1) {
            String substring = str.substring(str.indexOf(47) + 1);
            Font font = c().get(substring);
            if (font != null) {
                try {
                    return font.b(KineMasterApplication.f24056d.getApplicationContext());
                } catch (Font.TypefaceLoadException unused) {
                    return null;
                }
            }
            r a2 = h.e().a(substring);
            if (a2 != null && a2.getType() == ItemType.font) {
                try {
                    AssetPackageReader a3 = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), a2.getPackageURI(), a2.getAssetPackage().getAssetId());
                    try {
                        return a3.f(a2.getFilePath());
                    } catch (AssetPackageReader.LocalPathNotAvailableException e2) {
                        Log.e("FontManager", "Error loading typeface: " + substring, e2);
                        return null;
                    } finally {
                        C1702f.a(a3);
                    }
                } catch (IOException e3) {
                    Log.e("FontManager", "Error loading typeface: " + substring, e3);
                    return null;
                }
            }
            Log.w("FontManager", "Typeface not found: " + substring);
        }
        return null;
    }
}
