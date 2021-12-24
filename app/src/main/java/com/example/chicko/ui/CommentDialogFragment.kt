package com.example.chicko.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.chicko.R
import com.example.chicko.data.ProvidersDataSource

class CommentDialogFragment : DialogFragment() {
    private lateinit var comment: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
        val view: View = inflater.inflate(R.layout.add_comment_dialog, container, false)
        view.findViewById<Button>(R.id.submit_comment).setOnClickListener {
            Log.w("t", "dddddddddddddddddddddddddddddddddddd")
            comment = view.findViewById<EditText>(R.id.add_comment_input).text.toString()
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
        dialog!!.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}