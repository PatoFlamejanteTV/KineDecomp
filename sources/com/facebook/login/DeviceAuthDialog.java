package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class DeviceAuthDialog extends DialogFragment {
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile a currentRequestState;
    private C0752k deviceAuthMethodHandler;
    private Dialog dialog;
    private TextView instructions;
    private ProgressBar progressBar;
    private volatile ScheduledFuture scheduledPoll;
    private AtomicBoolean completed = new AtomicBoolean();
    private boolean isBeingDestroyed = false;
    private boolean isRetry = false;
    private LoginClient.Request mRequest = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0750i();

        /* renamed from: a, reason: collision with root package name */
        private String f9354a;

        /* renamed from: b, reason: collision with root package name */
        private String f9355b;

        /* renamed from: c, reason: collision with root package name */
        private String f9356c;

        /* renamed from: d, reason: collision with root package name */
        private long f9357d;

        /* renamed from: e, reason: collision with root package name */
        private long f9358e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        public String a() {
            return this.f9354a;
        }

        public void b(String str) {
            this.f9355b = str;
            this.f9354a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", str);
        }

        public String c() {
            return this.f9356c;
        }

        public String d() {
            return this.f9355b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return this.f9358e != 0 && (new Date().getTime() - this.f9358e) - (this.f9357d * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f9355b);
            parcel.writeString(this.f9356c);
            parcel.writeLong(this.f9357d);
            parcel.writeLong(this.f9358e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(Parcel parcel) {
            this.f9355b = parcel.readString();
            this.f9356c = parcel.readString();
            this.f9357d = parcel.readLong();
            this.f9358e = parcel.readLong();
        }

        public void a(String str) {
            this.f9356c = str;
        }

        public void a(long j) {
            this.f9357d = j;
        }

        public long b() {
            return this.f9357d;
        }

        public void b(long j) {
            this.f9358e = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeLogin(String str, Utility.PermissionsPair permissionsPair, String str2) {
        this.deviceAuthMethodHandler.a(str2, FacebookSdk.getApplicationId(), str, permissionsPair.getGrantedPermissions(), permissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null);
        this.dialog.dismiss();
    }

    private GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.currentRequestState.c());
        return new GraphRequest(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new C0746e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.d());
            }
            C0752k c0752k = this.deviceAuthMethodHandler;
            if (c0752k != null) {
                c0752k.c();
            }
            this.dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccess(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, null, null), "me", bundle, HttpMethod.GET, new C0749h(this, str)).executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void poll() {
        this.currentRequestState.b(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void presentConfirmation(String str, Utility.PermissionsPair permissionsPair, String str2, String str3) {
        String string = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_continue_as);
        String string3 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_cancel);
        String format = String.format(string2, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterfaceOnClickListenerC0748g(this, str, permissionsPair, str2)).setPositiveButton(string3, new DialogInterfaceOnClickListenerC0747f(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedulePoll() {
        this.scheduledPoll = C0752k.b().schedule(new RunnableC0745d(this), this.currentRequestState.b(), TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentRequestState(a aVar) {
        this.currentRequestState = aVar;
        this.confirmationCode.setText(aVar.d());
        this.instructions.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(aVar.a())), (Drawable) null, (Drawable) null);
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(aVar.d())) {
            AppEventsLogger.newLogger(getContext()).logSdkEvent(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE, null, null);
        }
        if (aVar.e()) {
            schedulePoll();
        } else {
            poll();
        }
    }

    protected int getLayoutResId(boolean z) {
        return z ? com.facebook.common.R.layout.com_facebook_smart_device_dialog_fragment : com.facebook.common.R.layout.com_facebook_device_auth_dialog_fragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View initializeContentView(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), (ViewGroup) null);
        this.progressBar = (ProgressBar) inflate.findViewById(com.facebook.common.R.id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(com.facebook.common.R.id.confirmation_code);
        ((Button) inflate.findViewById(com.facebook.common.R.id.cancel_button)).setOnClickListener(new ViewOnClickListenerC0744c(this));
        this.instructions = (TextView) inflate.findViewById(com.facebook.common.R.id.com_facebook_device_auth_instructions);
        this.instructions.setText(Html.fromHtml(getString(com.facebook.common.R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = new Dialog(getActivity(), com.facebook.common.R.style.com_facebook_auth_dialog);
        this.dialog.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return this.dialog;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a aVar;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (C0752k) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().d();
        if (bundle != null && (aVar = (a) bundle.getParcelable(REQUEST_STATE_KEY)) != null) {
            setCurrentRequestState(aVar);
        }
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.isBeingDestroyed) {
            return;
        }
        onCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(FacebookException facebookException) {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.d());
            }
            this.deviceAuthMethodHandler.a(facebookException);
            this.dialog.dismiss();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void startLogin(LoginClient.Request request) {
        this.mRequest = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, deviceRedirectUriString);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new C0743b(this)).executeAsync();
    }
}
