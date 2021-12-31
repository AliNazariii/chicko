package com.example.chicko

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.chicko.databinding.ActivityAddServiceBinding
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView

import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.chicko.data.ProvidersDataSource


class AddServiceActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
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

        val addButton = binding.addButton
        addButton.setOnClickListener {
            ProvidersDataSource.addProvider(
                1,
                nameTextView.editText?.text.toString(),
                addressTextView.editText?.text.toString(),
                callNumberTextView.editText?.text.toString()
            )
        }


//        val navController = findNavController(R.id.nav_host_fragment_content_add_service)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

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
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_add_service)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}