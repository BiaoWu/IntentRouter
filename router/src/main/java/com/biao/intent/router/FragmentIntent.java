package com.biao.intent.router;

import android.app.Fragment;
import android.content.Intent;

/**
 * @author biaowu.
 */
class FragmentIntent extends ComponentIntentImpl {
  private Fragment fragment;

  FragmentIntent(Fragment fragment) {
    super(fragment.getActivity());
    this.fragment = fragment;
  }

  @Override protected void startActivityForResult(Intent intent, int requestCode) {
    fragment.startActivityForResult(intent, requestCode);
  }
}
