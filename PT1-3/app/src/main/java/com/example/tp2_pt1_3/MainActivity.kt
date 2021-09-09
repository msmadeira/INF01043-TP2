package com.example.tp2_pt1_3

import android.content.Context
import android.content.Intent
import android.hardware.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var mAccelerometer : Sensor ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                val x = findViewById<EditText>(R.id.x_value)
                val z = findViewById<EditText>(R.id.z_value)
                val y = findViewById<EditText>(R.id.y_value)

                if (x.text.isNotBlank()) {
                    val hasBigChangeX = Math.abs(event.values[0] - x.text.toString().toFloat()) >= 3.0;
                    val hasBigChangeZ = Math.abs(event.values[1] - z.text.toString().toFloat()) >= 3.0;
                    val hasBigChangeY = Math.abs(event.values[2] - y.text.toString().toFloat()) >= 3.0;

                    if (hasBigChangeX || hasBigChangeY || hasBigChangeZ) {
                        val intent = Intent(this, WarningMessageActivity::class.java)
                        startActivity(intent)
                    }
                }

                x.setText(event.values[0].toString())
                z.setText(event.values[1].toString())
                y.setText(event.values[2].toString())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this, mAccelerometer)
    }
}