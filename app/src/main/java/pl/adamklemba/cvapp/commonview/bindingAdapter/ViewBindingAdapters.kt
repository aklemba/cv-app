package pl.adamklemba.cvapp.commonview.bindingAdapter

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visible")
fun View.setVisible(visible: Boolean) {
   visibility = if (visible) View.VISIBLE else View.GONE
}