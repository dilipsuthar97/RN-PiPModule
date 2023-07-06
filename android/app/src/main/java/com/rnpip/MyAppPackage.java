package com.rnpip;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyAppPackage implements ReactPackage {
   @NonNull
   @Override
   public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactApplicationContext) {
      List<NativeModule> modules = new ArrayList<>();
      // Add all your future native module here
      modules.add(new PiPModule(reactApplicationContext));
      return modules;
   }

   @NonNull
   @Override
   public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactApplicationContext) {
      return Collections.emptyList();
   }
}
