package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.IOException;

@zzark
/* loaded from: classes2.dex */
public final class zzasy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasy> CREATOR = new zzata();
    private ParcelFileDescriptor zzdzi;
    private Parcelable zzdzj;
    private boolean zzdzk;

    @SafeParcelable.Constructor
    public zzasy(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdzi = parcelFileDescriptor;
        this.zzdzj = null;
        this.zzdzk = true;
    }

    private final <T> ParcelFileDescriptor zzh(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new Lc(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
                zzbbd.zzb("Error transporting the ad response", e);
                com.google.android.gms.ads.internal.zzbv.i().zza(e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = null;
        }
    }

    private final ParcelFileDescriptor zzwl() {
        if (this.zzdzi == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzdzj.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzdzi = zzh(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzdzi;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzwl();
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.zzdzi, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzdzk) {
            ParcelFileDescriptor parcelFileDescriptor = this.zzdzi;
            if (parcelFileDescriptor == null) {
                zzbbd.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    IOUtils.a(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.zzdzj = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzdzk = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    zzbbd.zzb("Could not read from parcel file descriptor", e2);
                    IOUtils.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.a(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzdzj;
    }

    public zzasy(SafeParcelable safeParcelable) {
        this.zzdzi = null;
        this.zzdzj = safeParcelable;
        this.zzdzk = false;
    }
}
