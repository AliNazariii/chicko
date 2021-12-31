package com.example.chicko.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.R
import com.example.chicko.adapter.CommentsAdapter
import com.example.chicko.data.CommentsDataSource
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.ActivityServiceBinding
import com.example.chicko.ui.CommentDialogFragment
import com.example.chicko.utils.withPersianDigits

fun fillStar(star: ImageView) {
    star.setImageResource(R.drawable.ic_baseline_star_pink_24)
}

fun fillAllStars(stars: List<ImageView>, serviceId: Int, username: String) {
    stars.forEach { imageView -> imageView.setImageResource(R.drawable.ic_baseline_star_border_24) }
    stars.forEachIndexed { index, imageView ->
        if (index <= ProvidersDataSource.getMyScoreToService(
                serviceId, username
            ) - 1
        ) fillStar(imageView)
    }
}

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding
    private lateinit var recyclerView: RecyclerView


    companion object {
        const val SERVICE_ID = "service_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val username = "shalgham"

        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent?.extras?.getInt(SERVICE_ID)
        val service = ProvidersDataSource.getServiceById(id!!)!!

        binding.banner.setImageResource(service.banner)
        binding.title.text = service.name
        binding.addressTextview.text = service.address
        binding.phoneTextview.text = service.phone.withPersianDigits

        showAverageScore()

        showScoreCommentSummary()

        binding.callBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + service.phone))
            startActivity(intent)
        }

        val commentBundle = Bundle()
        commentBundle.putInt("service_id", id)
        val commentDialogFragment = CommentDialogFragment()
        commentDialogFragment.arguments = commentBundle
        binding.commentBtn.setOnClickListener {
            commentDialogFragment.show(supportFragmentManager, "Comment Fragment")
        }

        binding.share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                val url = "http://chicko.ir/services/${service.ID}\n"
                val name = service.name + "\n"
                val address = "آدرس: ${service.address}" + "\n"
                val phone = "شماره تلفن: ${service.phone}" + "\n"
                putExtra(Intent.EXTRA_TEXT, url + address + phone)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        val stars = listOf<ImageView>(
            binding.star1,
            binding.star2,
            binding.star3,
            binding.star4,
            binding.star5
        )
        fillAllStars(stars, service.ID, username)
        stars.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                ProvidersDataSource.addOrEditScore(index + 1, username, service.ID)
                fillAllStars(stars, service.ID, username)
                showAverageScore()
                showScoreCommentSummary()
            }
        }

        loadComments()
    }

    fun loadComments() {
        val id = intent?.extras?.getInt(SERVICE_ID)!!
        recyclerView = binding.commentsRecyclerview
        val dataSet = CommentsDataSource().loadComments(id).reversed()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CommentsAdapter(this, dataSet)

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            LinearLayoutManager.VERTICAL
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun showAverageScore() {
        val id = intent?.extras?.getInt(SERVICE_ID)!!
        val averageScore = ProvidersDataSource.getAverageScore(id)
        val averageString = String.format("%.1f", averageScore)
        binding.scoreTextView.text = "${averageString.withPersianDigits} / ۵"
    }

    fun showScoreCommentSummary() {
        val id = intent?.extras?.getInt(SERVICE_ID)!!
        binding.infoTextview.text =
            "${ProvidersDataSource.getTotalScoreCount(id).withPersianDigits} رای | ${
                ProvidersDataSource.getTotalCommentCount(id).withPersianDigits
            } نظر"
    }

//    /**
//     * Enables back button support. Simply navigates one element up on the stack.
//     */
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}