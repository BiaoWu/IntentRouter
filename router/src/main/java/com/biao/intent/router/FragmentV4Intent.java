package com.biao.intent.router;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * @author biaowu.
 */
class FragmentV4Intent extends ComponentIntentImpl {
  private Fragment fragment;

  FragmentV4Intent(Fragment fragment) {
    super(fragment.getActivity());
    this.fragment = fragment;
  }

  @Override protected void startActivityForResult(Intent intent, int requestCode) {
    fragment.startActivityForResult(intent, requestCode);
  }
}
