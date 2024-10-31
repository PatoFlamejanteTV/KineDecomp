package android.support.v4.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import b.b.f.a;
import b.b.f.b;
import b.b.f.c;
import b.b.f.d;

/* loaded from: classes.dex */
public class NotificationCompat {

    /* loaded from: classes.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void b(RemoteViews remoteViews) {
            int color;
            if (this.f965a.getColor() != 0) {
                color = this.f965a.getColor();
            } else {
                color = this.f965a.mContext.getResources().getColor(a.notification_material_background_media_default_color);
            }
            remoteViews.setInt(b.status_bar_latest_event_content, "setBackgroundColor", color);
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        int a(int i) {
            return i <= 3 ? d.notification_template_big_media_narrow_custom : d.notification_template_big_media_custom;
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle, android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle
        int c() {
            return this.f965a.getContentView() != null ? d.notification_template_media_custom : super.c();
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle, android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.f965a.getBigContentView() != null) {
                contentView = this.f965a.getBigContentView();
            } else {
                contentView = this.f965a.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews a2 = a();
            buildIntoRemoteViews(a2, contentView);
            if (Build.VERSION.SDK_INT >= 21) {
                b(a2);
            }
            return a2;
        }

        @Override // android.support.v4.media.app.NotificationCompat.MediaStyle, android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = this.f965a.getContentView() != null;
            if (Build.VERSION.SDK_INT >= 21) {
                if (!z2 && this.f965a.getBigContentView() == null) {
                    z = false;
                }
                if (z) {
                    RemoteViews b2 = b();
                    if (z2) {
                        buildIntoRemoteViews(b2, this.f965a.getContentView());
                    }
                    b(b2);
                    return b2;
                }
            } else {
                RemoteViews b3 = b();
                if (z2) {
                    buildIntoRemoteViews(b3, this.f965a.getContentView());
                    return b3;
                }
            }
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.f965a.getHeadsUpContentView() != null) {
                contentView = this.f965a.getHeadsUpContentView();
            } else {
                contentView = this.f965a.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews a2 = a();
            buildIntoRemoteViews(a2, contentView);
            if (Build.VERSION.SDK_INT >= 21) {
                b(a2);
            }
            return a2;
        }
    }

    private NotificationCompat() {
    }

    /* loaded from: classes.dex */
    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: e, reason: collision with root package name */
        int[] f1424e = null;

        /* renamed from: f, reason: collision with root package name */
        MediaSessionCompat.Token f1425f;

        /* renamed from: g, reason: collision with root package name */
        boolean f1426g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f1427h;

        public MediaStyle() {
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return MediaSessionCompat.Token.fromToken(parcelable);
                }
                return null;
            }
            IBinder binder = BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder == null) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.writeStrongBinder(binder);
            obtain.setDataPosition(0);
            MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }

        Notification.MediaStyle a(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f1424e;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f1425f;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.MediaStyle()));
            } else if (this.f1426g) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        RemoteViews b() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, c(), true);
            int size = this.f965a.mActions.size();
            int[] iArr = this.f1424e;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            applyStandardTemplate.removeAllViews(b.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    if (i < size) {
                        applyStandardTemplate.addView(b.media_actions, a(this.f965a.mActions.get(this.f1424e[i])));
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                    }
                }
            }
            if (this.f1426g) {
                applyStandardTemplate.setViewVisibility(b.end_padder, 8);
                applyStandardTemplate.setViewVisibility(b.cancel_action, 0);
                applyStandardTemplate.setOnClickPendingIntent(b.cancel_action, this.f1427h);
                applyStandardTemplate.setInt(b.cancel_action, "setAlpha", this.f965a.mContext.getResources().getInteger(c.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(b.end_padder, 0);
                applyStandardTemplate.setViewVisibility(b.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        int c() {
            return d.notification_template_media;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return a();
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return b();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f1427h = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f1425f = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f1424e = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.f1426g = z;
            }
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews a(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.f965a.mContext.getPackageName(), d.notification_media_action);
            remoteViews.setImageViewResource(b.action0, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(b.action0, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(b.action0, action.getTitle());
            }
            return remoteViews;
        }

        RemoteViews a() {
            int min = Math.min(this.f965a.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, a(min), false);
            applyStandardTemplate.removeAllViews(b.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(b.media_actions, a(this.f965a.mActions.get(i)));
                }
            }
            if (this.f1426g) {
                applyStandardTemplate.setViewVisibility(b.cancel_action, 0);
                applyStandardTemplate.setInt(b.cancel_action, "setAlpha", this.f965a.mContext.getResources().getInteger(c.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(b.cancel_action, this.f1427h);
            } else {
                applyStandardTemplate.setViewVisibility(b.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        int a(int i) {
            return i <= 3 ? d.notification_template_big_media_narrow : d.notification_template_big_media;
        }
    }
}
