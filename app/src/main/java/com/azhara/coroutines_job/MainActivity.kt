package com.azhara.coroutines_job

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

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

        btn_start.setOnClickListener {
            if (!::job.isInitialized){
                initJob()
            }
        }
    }

    private fun initJob(){
        btn_start.text = "Start Job#1"
        tv_job_status.text = ""
        job = Job()

        // fungsi spesial pada job dimana saat job berjalan dapat memberitahu aktifitas apapun seperti cancel job, memperbarui loading dll ataupun job selesai dijalankan
        // fungsi ini akan selalu di eksekusi sesuai permintaan
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if (msg.isNullOrBlank()){
                    msg = "Unknown cancellation error"
                }
                println("$job was cancelled, reason: $msg")
                showToast(msg)
            }
        }

        job_progress.min = PROGRESS_MIN
        job_progress.max = PROGRESS_MAX
    }

    private fun showToast(msg: String) {
        GlobalScope.launch(Dispatchers.Main){
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

    }
}
