package com.linroid.viewit.widget

import android.content.Context
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.widget.FrameLayout
import timber.log.Timber

/**
 * @author linroid <linroid@gmail.com>
 * @since 25/01/2017
 */
class InsetsFrameLayout : FrameLayout {
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    private fun init() {
        clipToPadding = false
        fitsSystemWindows = true
        ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
            Timber.i(insets.toString())
            setPadding(insets.systemWindowInsetLeft, insets.systemWindowInsetTop, insets.systemWindowInsetRight, insets.systemWindowInsetBottom);
            return@setOnApplyWindowInsetsListener insets.consumeSystemWindowInsets()
        }
    }
}
