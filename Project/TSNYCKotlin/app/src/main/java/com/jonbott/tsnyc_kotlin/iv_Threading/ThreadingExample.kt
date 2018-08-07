package com.jonbott.tsnyc_kotlin.iv_Threading

import android.os.AsyncTask
import com.jonbott.kotlincomparison.Utilities.Threading
import io.reactivex.disposables.CompositeDisposable

object ThreadingExample {
    private val bag = CompositeDisposable()

    fun threading_oldSchool() {
        println("Starting Example01")

        val task = object: AsyncTask<String, Int, String>() {
            override fun doInBackground(vararg p0: String?): String {
                //do something useful
                Thread.sleep(2000)
                return "AsyncTask is finished"
            }

            override fun onProgressUpdate(vararg progress: Int?) {
                if(progress == null) return
                println("in progress: ${progress[0]}")
            }

            override fun onPostExecute(result: String?) {
                println("onPostExecute: result = $result")
            }
        }
        task.execute("some useful arguments")

        println("finished main block of Example01")
    }

    fun threading_RxJava() {
        println("Staring Example02")


        var disposable = Threading.async(task = {
            //do something useful
            Thread.sleep(2000)
            "Task Finished: some useful message" //implicitly returned
        }, finished = { result ->
            this.doSomething()

            println("Finished: result: $result")
        })

        println("Finishing Example02")
        bag.add(disposable)
    }

    fun threading_coroutines() {

    }

    private fun doSomething() {
        println("Doing something useful")
    }

    fun cleanUp() {
        bag.dispose()
    }
}