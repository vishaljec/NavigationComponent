package com.android.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_chooser_recipient.*

class ChooserRecipientFragment : Fragment(), View.OnClickListener {
    var navControl: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chooser_recipient, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(input_recipient.text.toString())) {
                    val bundle = bundleOf("recipient" to input_recipient.text.toString())
                    navControl?.navigate(
                        R.id.action_chooserRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                }

            }
            R.id.cancel_btn -> {
                activity?.onBackPressed()
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControl = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }


}