/*
 * Copyright (C) 2017 BiaoWu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.biao.intent.router;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

/**
 * @author biaowu.
 */
public class IntentRouter {
  private static final ArrayMap<String, IntentProvider> routers = new ArrayMap<>();
  private static IntentRouterExceptionHandler exceptionHandler;

  private IntentRouter() {
    // no instance
  }

  public static void register(String key, IntentProvider router) {
    if (TextUtils.isEmpty(key)) {
      throw new IllegalArgumentException("key can not be null");
    }
    if (router == null) {
      throw new IllegalArgumentException("router can not be null");
    }
    if (routers.containsKey(key)) {
      throw new IllegalArgumentException("key(" + key + ") is exist");
    }

    routers.put(key, router);
  }

  public static ContextCall with(Context context) {
    return new ContextCallImpl(context);
  }

  public static ActivityCall with(Activity activity) {
    return new ActivityCallImpl(activity);
  }

  public static FragmentCall with(android.app.Fragment fragment) {
    return new FragmentCallImpl(fragment);
  }

  public static FragmentCall with(android.support.v4.app.Fragment fragmentV4) {
    return new FragmentV4CallImpl(fragmentV4);
  }

  public static void setExceptionHandler(IntentRouterExceptionHandler handler) {
    if (exceptionHandler != null) {
      throw new IllegalArgumentException("exceptionHandler already been set");
    }
    exceptionHandler = handler;
  }

  static void handleException(Exception e) {
    if (exceptionHandler != null) {
      exceptionHandler.handle(e);
    }
  }

  static IntentProvider get(String key) {
    return routers.get(key);
  }
}
