package com.example.chicko.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.chicko.R
import com.example.chicko.data.CategoriesDataSource
import com.example.chicko.data.Database
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.ActivityAddServiceBinding


class AddServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddServiceBinding
    val SELECT_PICTURE = 110
    lateinit var avatar: ImageView
    lateinit var photoUploadIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "ثبت سرویس‌دهنده"

        val nameTextView = binding.name
        val addressTextView = binding.address
        val callNumberTextView = binding.callNumber
        avatar = binding.avatar
        photoUploadIcon = binding.photoUploadIcon

        val profileUpload = binding.cardView
        profileUpload.setOnClickListener {
            imageChooser()
        }

        val items = Database.Categories.map { it.name }
        val adapter = ArrayAdapter(this, R.layout.category_dropdown_item, items)
        (binding.menu.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        val addButton = binding.addButton
        addButton.setOnClickListener {
            ProvidersDataSource.addProvider(
                CategoriesDataSource.getCategoryByName(binding.menu.editText?.text.toString())!!.ID,
                nameTextView.editText?.text.toString(),
                addressTextView.editText?.text.toString(),
                callNumberTextView.editText?.text.toString()
            )
            finish()
        }
    }

    fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                val selectedImageUri: Uri? = data?.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    photoUploadIcon.visibility = View.GONE
                    avatar.setImageURI(selectedImageUri)
                }
            }
        }

    }
}