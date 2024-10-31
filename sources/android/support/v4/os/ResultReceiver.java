package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };

    /* renamed from: a */
    final boolean f1546a;

    /* renamed from: b */
    final Handler f1547b;

    /* renamed from: c */
    IResultReceiver f1548c;

    /* renamed from: android.support.v4.os.ResultReceiver$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<ResultReceiver> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    /* loaded from: classes.dex */
    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f1547b;
            if (handler != null) {
                handler.post(new MyRunnable(i, bundle));
            } else {
                resultReceiver.a(i, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyRunnable implements Runnable {

        /* renamed from: a */
        final int f1550a;

        /* renamed from: b */
        final Bundle f1551b;

        MyRunnable(int i, Bundle bundle) {
            this.f1550a = i;
            this.f1551b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f1550a, this.f1551b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.f1546a = true;
        this.f1547b = handler;
    }

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void send(int i, Bundle bundle) {
        if (this.f1546a) {
            Handler handler = this.f1547b;
            if (handler != null) {
                handler.post(new MyRunnable(i, bundle));
                return;
            } else {
                a(i, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.f1548c;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.send(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f1548c == null) {
                this.f1548c = new MyResultReceiver();
            }
            parcel.writeStrongBinder(this.f1548c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f1546a = false;
        this.f1547b = null;
        this.f1548c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
}
