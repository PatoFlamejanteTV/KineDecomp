package android.support.v4.app;

import android.arch.lifecycle.r;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: android.support.v4.app.FragmentState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* renamed from: a */
    final String f779a;

    /* renamed from: b */
    final int f780b;

    /* renamed from: c */
    final boolean f781c;

    /* renamed from: d */
    final int f782d;

    /* renamed from: e */
    final int f783e;

    /* renamed from: f */
    final String f784f;

    /* renamed from: g */
    final boolean f785g;

    /* renamed from: h */
    final boolean f786h;
    final Bundle i;
    final boolean j;
    Bundle k;
    Fragment l;

    /* renamed from: android.support.v4.app.FragmentState$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<FragmentState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f779a = fragment.getClass().getName();
        this.f780b = fragment.mIndex;
        this.f781c = fragment.mFromLayout;
        this.f782d = fragment.mFragmentId;
        this.f783e = fragment.mContainerId;
        this.f784f = fragment.mTag;
        this.f785g = fragment.mRetainInstance;
        this.f786h = fragment.mDetached;
        this.i = fragment.mArguments;
        this.j = fragment.mHidden;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment, FragmentManagerNonConfig fragmentManagerNonConfig, r rVar) {
        if (this.l == null) {
            Context b2 = fragmentHostCallback.b();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(b2.getClassLoader());
            }
            if (fragmentContainer != null) {
                this.l = fragmentContainer.instantiate(b2, this.f779a, this.i);
            } else {
                this.l = Fragment.instantiate(b2, this.f779a, this.i);
            }
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(b2.getClassLoader());
                this.l.mSavedFragmentState = this.k;
            }
            this.l.setIndex(this.f780b, fragment);
            Fragment fragment2 = this.l;
            fragment2.mFromLayout = this.f781c;
            fragment2.mRestored = true;
            fragment2.mFragmentId = this.f782d;
            fragment2.mContainerId = this.f783e;
            fragment2.mTag = this.f784f;
            fragment2.mRetainInstance = this.f785g;
            fragment2.mDetached = this.f786h;
            fragment2.mHidden = this.j;
            fragment2.mFragmentManager = fragmentHostCallback.f731e;
            if (FragmentManagerImpl.f732a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        Fragment fragment3 = this.l;
        fragment3.mChildNonConfig = fragmentManagerNonConfig;
        fragment3.mViewModelStore = rVar;
        return fragment3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f779a);
        parcel.writeInt(this.f780b);
        parcel.writeInt(this.f781c ? 1 : 0);
        parcel.writeInt(this.f782d);
        parcel.writeInt(this.f783e);
        parcel.writeString(this.f784f);
        parcel.writeInt(this.f785g ? 1 : 0);
        parcel.writeInt(this.f786h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }

    FragmentState(Parcel parcel) {
        this.f779a = parcel.readString();
        this.f780b = parcel.readInt();
        this.f781c = parcel.readInt() != 0;
        this.f782d = parcel.readInt();
        this.f783e = parcel.readInt();
        this.f784f = parcel.readString();
        this.f785g = parcel.readInt() != 0;
        this.f786h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
    }
}
