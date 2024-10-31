package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.f;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class BinaryImagesConverter {
    private static final String DATA_DIR = "/data";
    private final Context context;
    private final FileIdStrategy fileIdStrategy;

    /* loaded from: classes.dex */
    public interface FileIdStrategy {
        String createId(File file) throws IOException;
    }

    public BinaryImagesConverter(Context context, FileIdStrategy fileIdStrategy) {
        this.context = context;
        this.fileIdStrategy = fileIdStrategy;
    }

    private File correctDataPath(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith(DATA_DIR)) {
            return file;
        }
        try {
            return new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e2) {
            f.f().c(CrashlyticsCore.TAG, "Error getting ApplicationInfo", e2);
            return file;
        }
    }

    private static JSONObject createBinaryImageJson(String str, ProcMapEntry procMapEntry) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", procMapEntry.address);
        jSONObject.put("size", procMapEntry.size);
        jSONObject.put("name", procMapEntry.path);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static byte[] generateBinaryImagesJsonString(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e2) {
            f.f().b(CrashlyticsCore.TAG, "Binary images string is null", e2);
            return new byte[0];
        }
    }

    private File getLibraryFile(String str) {
        File file = new File(str);
        return !file.exists() ? correctDataPath(file) : file;
    }

    private static boolean isRelevant(ProcMapEntry procMapEntry) {
        return (procMapEntry.perms.indexOf(120) == -1 || procMapEntry.path.indexOf(47) == -1) ? false : true;
    }

    private static String joinMapsEntries(JSONArray jSONArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    private JSONArray parseProcMapsJson(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str2 : joinMapsEntries(new JSONObject(str).getJSONArray("maps")).split("\\|")) {
                ProcMapEntry parse = ProcMapEntryParser.parse(str2);
                if (parse != null && isRelevant(parse)) {
                    try {
                        try {
                            jSONArray.put(createBinaryImageJson(this.fileIdStrategy.createId(getLibraryFile(parse.path)), parse));
                        } catch (JSONException e2) {
                            f.f().a(CrashlyticsCore.TAG, "Could not create a binary image json string", e2);
                        }
                    } catch (IOException e3) {
                        f.f().a(CrashlyticsCore.TAG, "Could not generate ID for file " + parse.path, e3);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e4) {
            f.f().b(CrashlyticsCore.TAG, "Unable to parse proc maps string", e4);
            return jSONArray;
        }
    }

    public byte[] convert(String str) throws IOException {
        return generateBinaryImagesJsonString(parseProcMapsJson(str));
    }
}
