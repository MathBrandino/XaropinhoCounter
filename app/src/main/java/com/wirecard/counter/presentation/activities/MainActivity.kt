package com.wirecard.counter.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.EventDay
import com.wirecard.counter.R
import com.wirecard.counter.vm.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    private val userViewModel: UserViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val events = ArrayList<EventDay>()

        val today = Calendar.getInstance()
        today.add(Calendar.DAY_OF_YEAR, 26)

        for (i in 0 until today.get(Calendar.DAY_OF_MONTH)) {
            val someDay = today.clone() as Calendar
            someDay.add(Calendar.DAY_OF_YEAR, -i)

            val dayOfWeek = someDay.get(Calendar.DAY_OF_WEEK)
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {

                val day = someDay.get(Calendar.DAY_OF_MONTH)

                val image = if (day % 2 == 0) R.drawable.ic_check else R.drawable.ic_warning

                events.add(EventDay(someDay, image))
            }

        }


        calendar.setEvents(events)
    }
}
