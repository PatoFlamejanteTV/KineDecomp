package c.c.a.a.a.b.b.a.a;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* compiled from: Info.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    @SerializedName("codecMem")
    public int f3521a;

    /* renamed from: b */
    @SerializedName("highRes")
    public int f3522b;

    /* renamed from: c */
    @SerializedName("encodingRes")
    public int f3523c;

    /* renamed from: d */
    @SerializedName("reencodingRes")
    public int f3524d;

    /* renamed from: e */
    public int f3525e;

    /* renamed from: f */
    @SerializedName("layerMaxDec")
    public int f3526f;

    /* renamed from: g */
    public long f3527g;

    public static a a(String str) {
        try {
            return (a) new Gson().fromJson(str, a.class);
        } catch (Exception e2) {
            Log.e("dci.data.model", e2.getMessage(), e2);
            return null;
        }
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
