package com.example.ez02_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s1: EditText = findViewById(R.id.s1)
        val s2: EditText = findViewById(R.id.s2)
        val s3: EditText = findViewById(R.id.s3)
        val s4: EditText = findViewById(R.id.s4)
        val s5: EditText = findViewById(R.id.s5)

        val c1: EditText = findViewById(R.id.c1)
        val c2: EditText = findViewById(R.id.c2)
        val c3: EditText = findViewById(R.id.c3)
        val c4: EditText = findViewById(R.id.c4)
        val c5: EditText = findViewById(R.id.c5)

        val p1: EditText = findViewById(R.id.p1)
        val p2: EditText = findViewById(R.id.p2)
        val p3: EditText = findViewById(R.id.p3)
        val p4: EditText = findViewById(R.id.p4)
        val p5: EditText = findViewById(R.id.p5)

        val tc: TextView = findViewById(R.id.tc)
        val gpa: TextView = findViewById(R.id.zxZ)

        val ok: Button = findViewById(R.id.ok)
        val cl: Button = findViewById(R.id.cl)

        cl.setOnClickListener {
            // Clear all EditText fields
            listOf(s1, s2, s3, s4, s5, c1, c2, c3, c4, c5, p1, p2, p3, p4, p5)
                .forEach { it.text.clear() }

            // Set TextViews to "0"
            tc.text = "0"
            gpa.text = "0"
        }

        ok.setOnClickListener {
            val s1Value = s1.text.toString()
            val s2Value = s2.text.toString()
            val s3Value = s3.text.toString()
            val s4Value = s4.text.toString()
            val s5Value = s5.text.toString()

            val c1Value = c1.text.toString().toDoubleOrNull()
            val c2Value = c2.text.toString().toDoubleOrNull()
            val c3Value = c3.text.toString().toDoubleOrNull()
            val c4Value = c4.text.toString().toDoubleOrNull()
            val c5Value = c5.text.toString().toDoubleOrNull()

            val p1Value = p1.text.toString().toDoubleOrNull()
            val p2Value = p2.text.toString().toDoubleOrNull()
            val p3Value = p3.text.toString().toDoubleOrNull()
            val p4Value = p4.text.toString().toDoubleOrNull()
            val p5Value = p5.text.toString().toDoubleOrNull()

            if (s1Value.isBlank() || s2Value.isBlank() || s3Value.isBlank() || s4Value.isBlank() || s5Value.isBlank()) {
                Toast. makeText(applicationContext,"กรุณากรอกSubjectให้ครบ", Toast. LENGTH_SHORT).show()
            } else if (c1Value == null || c2Value == null || c3Value == null || c4Value == null || c5Value == null) {
                Toast. makeText(applicationContext,"กรุณากรอกcreditให้ครบ", Toast. LENGTH_SHORT).show()
            } else if (p1Value == null || p2Value == null || p3Value == null || p4Value == null || p5Value == null) {
                Toast. makeText(applicationContext,"กรุณากรอกPointให้ครบ", Toast. LENGTH_SHORT).show()
            } else {
                val totalCredits = (c1Value + c2Value + c3Value + c4Value + c5Value).toInt()
                val g1 = c1Value / totalCredits * p1Value
                val g2 = c2Value / totalCredits * p2Value
                val g3 = c3Value / totalCredits * p3Value
                val g4 = c4Value / totalCredits * p4Value
                val g5 = c5Value / totalCredits * p5Value
                val gpaValue = g1 + g2 + g3 + g4 + g5
                gpa.text = gpaValue.toString()
                tc.text = totalCredits.toString()
            }
        }
    }

    }



