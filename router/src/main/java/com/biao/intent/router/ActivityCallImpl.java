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
import android.content.Intent;

/**
 * @author biaowu.
 */
class ActivityCallImpl extends CommonCallImpl {
  private Activity activity;

  ActivityCallImpl(Activity activity) {
    super(activity);
    this.activity = activity;
  }

  @Override
  protected void startActivityForResult(Intent intent, int requestCode) {
    activity.startActivityForResult(intent, requestCode);
  }
}
