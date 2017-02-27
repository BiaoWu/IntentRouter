package com.biao.intent.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author biaowu.
 */
class ContextIntentImpl implements ContextIntent {
  final Context context;

  ContextIntentImpl(Context context) {
    this.context = context;
  }

  @Override
  public void startActivity(String key) {
    startActivity(key, null);
  }

  @Override
  public void startActivity(String key, Bundle args) {
    IntentProvider router = IntentRouter.get(key);
    if (router != null) {
      Intent intent = router.provide(context, args);
      if (intent != null) {
        context.startActivity(intent);
      }
    }
  }
}
