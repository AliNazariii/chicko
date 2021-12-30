package com.example.chicko.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.chicko.R
import com.example.chicko.activities.ServiceActivity
import com.example.chicko.data.ProvidersDataSource

class CommentDialogFragment : DialogFragment() {
    override fun onDismiss(dialog: DialogInterface) {
        (activity as ServiceActivity).loadComments()
        (activity as ServiceActivity).showScoreCommentSummary()
        super.onDismiss(dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.add_comment_dialog, container, false)
        val comment = view.findViewById<EditText>(R.id.add_comment_input)
        view.findViewById<Button>(R.id.submit_comment).setOnClickListener {
            ProvidersDataSource.addComment(
                "shalgham",
                arguments?.getInt("service_id")!!,
                comment.text.toString()
            )
            this.dismiss()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<EditText>(R.id.add_comment_input)?.text?.clear()
    }

    override fun onStart() {
        super.onStart()
        dialog!!.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}