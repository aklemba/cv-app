package pl.adamklemba.cvapp.commonview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import pl.adamklemba.cvapp.R

class ErrorDialog(@StringRes private val messageId: Int) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(messageId)
            .setPositiveButton(R.string.ok) { _, _ -> dismiss() }
            .create()

    companion object {
        val TAG = ErrorDialog::class.java.name
    }
}
