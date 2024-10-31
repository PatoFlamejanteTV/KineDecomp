package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Message implements SafeParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final NearbyDevice[] b = {NearbyDevice.f2105a};

    /* renamed from: a, reason: collision with root package name */
    final int f2095a;
    private final byte[] c;
    private final String d;
    private final String e;
    private final NearbyDevice[] f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Message(int i, byte[] bArr, String str, String str2, NearbyDevice[] nearbyDeviceArr) {
        this.f2095a = i;
        this.d = (String) zzx.a(str2);
        this.e = str == null ? "" : str;
        if (a(this.e, this.d)) {
            zzx.b(bArr == null, "Content must be null for a device presence message.");
        } else {
            zzx.a(bArr);
            zzx.b(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), 102400);
        }
        this.c = bArr;
        this.f = (nearbyDeviceArr == null || nearbyDeviceArr.length == 0) ? b : nearbyDeviceArr;
        zzx.b(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public static boolean a(String str, String str2) {
        return str.equals("__reserved_namespace") && str2.equals("__device_presence");
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public byte[] c() {
        return this.c;
    }

    public NearbyDevice[] d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.e, message.e) && TextUtils.equals(this.d, message.d) && Arrays.equals(this.c, message.c);
    }

    public int hashCode() {
        return zzw.a(this.e, this.d, Integer.valueOf(Arrays.hashCode(this.c)));
    }

    public String toString() {
        return "Message{namespace='" + this.e + "', type='" + this.d + "', content=[" + (this.c == null ? 0 : this.c.length) + " bytes], devices=" + Arrays.toString(d()) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
