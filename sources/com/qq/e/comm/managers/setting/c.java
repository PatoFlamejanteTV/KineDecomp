package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private JSONObject f24993a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private String f24994a;

        /* renamed from: b */
        private c f24995b;

        public a(String str, c cVar) {
            this.f24994a = str;
            this.f24995b = cVar;
        }

        public final String a() {
            return this.f24994a;
        }

        public final c b() {
            return this.f24995b;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a */
        private String f24996a;

        /* renamed from: b */
        private com.qq.e.comm.managers.setting.b f24997b;

        private b(String str, com.qq.e.comm.managers.setting.b bVar) {
            this.f24996a = str;
            this.f24997b = bVar;
        }

        /* synthetic */ b(String str, com.qq.e.comm.managers.setting.b bVar, byte b2) {
            this(str, bVar);
        }

        public final String a() {
            return this.f24996a;
        }

        public final com.qq.e.comm.managers.setting.b b() {
            return this.f24997b;
        }
    }

    public c() {
        this.f24993a = new JSONObject();
    }

    public c(String str) {
        this();
        GDTLogger.d("Initialize GDTAPPSetting,Json=" + str);
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            this.f24993a = new JSONObject(str);
        } catch (JSONException e2) {
            GDTLogger.e("JsonException While build GDTAPPSetting Instance from JSON", e2);
        }
    }

    private static Pair<String, String> a(Context context, String str) {
        File dir = context.getDir(Constants.SETTING.SETTINGDIR, 0);
        if (dir.exists()) {
            File file = new File(dir, str + ".sig");
            File file2 = new File(dir, str + ".cfg");
            if (file.exists() && file2.exists()) {
                try {
                    return new Pair<>(StringUtil.readAll(file), StringUtil.readAll(file2));
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    public static a a(Context context) {
        Pair<String, String> a2 = a(context, Constants.SETTING.DEV_CLOUD_SETTING);
        if (a2 == null) {
            return null;
        }
        try {
            if (com.qq.e.comm.util.a.a().a((String) a2.first, (String) a2.second)) {
                return new a((String) a2.first, new c(new String(Base64.decode((String) a2.second, 0), "UTF-8")));
            }
            GDTLogger.e("verify local dev cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.e("exception while loading local dev cloud setting", th);
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, Constants.SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    private static final boolean a(Context context, String str, String str2, String str3) {
        String format;
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            format = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        } else {
            if (com.qq.e.comm.util.a.a().a(str2, str3)) {
                return b(context, str, str2, str3);
            }
            format = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
        }
        GDTLogger.e(format);
        return false;
    }

    public static b b(Context context) {
        Pair<String, String> a2 = a(context, Constants.SETTING.SDK_CLOUD_SETTING);
        if (a2 == null) {
            return null;
        }
        try {
            if (com.qq.e.comm.util.a.a().a((String) a2.first, (String) a2.second)) {
                return new b((String) a2.first, new com.qq.e.comm.managers.setting.b(new String(Base64.decode((String) a2.second, 0), "UTF-8")), (byte) 0);
            }
            GDTLogger.e("verify local sdk cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.e("exception while loading local sdk cloud setting", th);
            return null;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        return a(context, Constants.SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007f A[Catch: Exception -> 0x0082, TRY_LEAVE, TryCatch #9 {Exception -> 0x0082, blocks: (B:40:0x007a, B:35:0x007f), top: B:39:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            java.lang.String r1 = "e_qq_com_setting"
            java.io.File r5 = r5.getDir(r1, r0)
            boolean r1 = r5.exists()
            if (r1 != 0) goto L10
            r5.mkdirs()
        L10:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            java.lang.String r3 = ".cfg"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r5, r2)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r6 = ".sig"
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r2.<init>(r5, r6)
            r5 = 0
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r6.write(r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            java.io.FileWriter r8 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            r8.write(r7)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L60
            r6.close()     // Catch: java.lang.Exception -> L53
            r8.close()     // Catch: java.lang.Exception -> L53
        L53:
            r5 = 1
            return r5
        L55:
            r5 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L78
        L5a:
            r7 = move-exception
            r8 = r5
            r5 = r6
            r6 = r7
            goto L78
        L5f:
            r8 = r5
        L60:
            r5 = r6
            goto L66
        L62:
            r6 = move-exception
            r8 = r5
            goto L78
        L65:
            r8 = r5
        L66:
            r1.delete()     // Catch: java.lang.Throwable -> L77
            r2.delete()     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L71
            r5.close()     // Catch: java.lang.Exception -> L76
        L71:
            if (r8 == 0) goto L76
            r8.close()     // Catch: java.lang.Exception -> L76
        L76:
            return r0
        L77:
            r6 = move-exception
        L78:
            if (r5 == 0) goto L7d
            r5.close()     // Catch: java.lang.Exception -> L82
        L7d:
            if (r8 == 0) goto L82
            r8.close()     // Catch: java.lang.Exception -> L82
        L82:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.c.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public Object a(String str) {
        return this.f24993a.opt(str);
    }

    public Object a(String str, String str2) {
        JSONObject optJSONObject = this.f24993a.optJSONObject(Constants.KEYS.PLACEMENTS);
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        try {
            this.f24993a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }

    public void a(String str, Object obj, String str2) {
        try {
            JSONObject optJSONObject = this.f24993a.optJSONObject(Constants.KEYS.PLACEMENTS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f24993a.putOpt(Constants.KEYS.PLACEMENTS, optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }
}
