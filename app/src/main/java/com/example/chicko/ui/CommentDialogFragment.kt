package com.example.chicko.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.chicko.R
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.AddCommendDialogBinding
import java.util.logging.Level.INFO

class CommentDialogFragment : DialogFragment() {
//    private lateinit var binding: AddCommendDialogBinding
    private lateinit var comment: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
        super.onCreateView(inflater, container, savedInstanceState)

        val view: View = inflater.inflate(R.layout.add_commend_dialog, container, false)
        val binding: AddCommendDialogBinding = AddCommendDialogBinding.inflate(layoutInflater)

        binding.submitComment.setOnClickListener{
            Log.w("t", "dddddddddddddddddddddddddddddddddddd")
            comment = binding.addCommentInput.text.toString()
            ProvidersDataSource.addComment("shalgham", 1, comment)
            Log.w("Comment", comment)
            activity?.onBackPressed();
//            getFragmentManager()?.popBackStack();
        }
        return view

    }

    override fun onStart() {
        super.onStart()
//        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}