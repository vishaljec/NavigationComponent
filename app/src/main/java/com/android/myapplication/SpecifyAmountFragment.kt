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
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {
    var navControl: NavController? = null
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val amount = BigDecimal(input_amount.text.toString())
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navControl?.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
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
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

}