package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmt;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    final int f624a;
    ParcelFileDescriptor b;
    private Parcelable c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f624a = i;
        this.b = parcelFileDescriptor;
        this.c = null;
        this.d = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.f624a = 1;
        this.b = null;
        this.c = safeParcelable;
        this.d = false;
    }

    protected <T> ParcelFileDescriptor a(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e) {
            e = e;
            autoCloseOutputStream = null;
        }
        try {
            new Thread(new a(this, autoCloseOutputStream, bArr)).start();
            return createPipe[0];
        } catch (IOException e2) {
            e = e2;
            com.google.android.gms.ads.internal.util.client.zzb.b("Error transporting the ad response", e);
            zzp.h().zzc(e, true);
            zzmt.zzb(autoCloseOutputStream);
            return null;
        }
    }

    public <T extends SafeParcelable> T a(Parcelable.Creator<T> creator) {
        if (this.d) {
            if (this.b == null) {
                com.google.android.gms.ads.internal.util.client.zzb.b("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.b));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    zzmt.zzb(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.c = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.d = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e);
                }
            } catch (Throwable th2) {
                zzmt.zzb(dataInputStream);
                throw th2;
            }
        }
        return (T) this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.b == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.c.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.b = a(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        zzl.a(this, parcel, i);
    }
}
