package com.biao.intent.router;

import android.os.Bundle;

/**
 * @author biaowu.
 */
public interface ContextIntent {
  void startActivity(String key);

  void startActivity(String key, Bundle args);
}
