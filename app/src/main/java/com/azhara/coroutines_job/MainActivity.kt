package com.azhara.coroutines_job

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {

    private val PROGRESS_MIN = 0
    private val PROGRESS_MAX = 100
    private val JOB_TIME = 4000L
    /*
    Dapat menggunkan Job atau CompletableJob, CompletableJob memiliki lebih banyak fitur
    Salah satunya completeExceptionally() yang dapat memberikan penyelesaian job dengan pengecualian tertentu
    */
    private lateinit var job: CompletableJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initJob(){
        btn_start.text = "Start Job#1"
        tv_job_status.text = ""
        job = Job()

    }
}
