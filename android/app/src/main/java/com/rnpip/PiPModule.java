package com.rnpip;

import android.app.PictureInPictureParams;
import android.os.Build;
import android.util.Rational;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = PiPModule.MODULE_NAME)
class PiPModule extends ReactContextBaseJavaModule {

   ReactApplicationContext mContext;

   public static final String MODULE_NAME = "PiPModule";
   public static final String EVENT_PIP_MOD_CHANGE = "EVENT_PIP_MOD_CHANGE";
   private static DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter;

   public PiPModule(ReactApplicationContext context) {
      super(context);
      this.mContext = context;
   }

   @Override
   public void initialize() {
      super.initialize();
      eventEmitter = getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
   }

   @NonNull
   @Override
   public String getName() {
      return MODULE_NAME;
   }

   @ReactMethod
   public void enablePiPMode(int width, int height) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         int ratWidth = width > 0 ? width : 380;
         int ratHeight = height > 0 ? height : 214;

         Rational ratio = new Rational(ratWidth, ratHeight);
         PictureInPictureParams.Builder pipBuilder = new PictureInPictureParams.Builder();
         pipBuilder.setAspectRatio(ratio).build();

         mContext.getCurrentActivity().enterPictureInPictureMode(pipBuilder.build());
      }
   }

   public static void onPipModeChanged(Boolean isPiPMode) {
      eventEmitter.emit(EVENT_PIP_MOD_CHANGE, isPiPMode);
   }
}
