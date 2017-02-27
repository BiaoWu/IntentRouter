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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author biaowu.
 */
abstract class ComponentIntentImpl extends ContextIntentImpl implements ComponentIntent {

  ComponentIntentImpl(Context context) {
    super(context);
  }

  @Override
  public void startActivityForResult(String key, int requestCode) {
    startActivityForResult(key, requestCode, null);
  }

  @Override
  public void startActivityForResult(String key, int requestCode, Bundle args) {
    IntentProvider router = IntentRouter.get(key);
    if (router != null) {
      Intent intent = router.provide(context, args);
      if (intent != null) {
        startActivityForResult(intent, requestCode);
      } else {
        IntentRouter.handleException(new IntentProvideException(key, args));
      }
    } else {
      IntentRouter.handleException(new IntentProviderNotFoundException(key));
    }
  }

  abstract void startActivityForResult(Intent intent, int requestCode);
}