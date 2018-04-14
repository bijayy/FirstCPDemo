package com.example.bijay.firstcpdemo.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.bijay.firstcpdemo.R
import com.example.bijay.firstcpdemo.validation.Validation
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.SQLException

class MainActivity : AppCompatActivity(), TextWatcher {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName.addTextChangedListener(this)
        etAge.addTextChangedListener(this)
        etNewName.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {
        if (etName.text.hashCode() == s?.hashCode()) {

            if (!Validation.isValid(s.toString()))
                textInputLayoutName.error = getString(R.string.required_text)
            else
                textInputLayoutName.error = getString(R.string.blank_text)
        } else if (etAge.text.hashCode() == s?.hashCode()) {

            if (!Validation.isValid(s.toString()))
                textInputLayoutAge.error = getString(R.string.required_text)
            else
                textInputLayoutAge.error = getString(R.string.blank_text)
        } else if (etNewName.text.hashCode() == s?.hashCode()) {

            if (!Validation.isValid(s.toString()))
                textInputLayoutNewName.error = getString(R.string.required_text)
            else
                textInputLayoutNewName.error = getString(R.string.blank_text)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    fun click(view: View) {

        val name = etName.text.toString()
        val age = etAge.text.toString()

        try {
            when (view.id) {
                R.id.btnInsert -> {
                    Operation(this).insert(name, age)
                }

                R.id.btnUpdate -> {
                    val newName = etNewName.text.toString()
                    Operation(this).update(name, newName)
                }

                R.id.btnDelete -> {
                    Operation(this).delete(name)
                }

                R.id.btnSelect -> {
                    Operation(this).select(name)
                }

                else -> {
                    Snackbar.make(etName, getString(R.string.something_went_wrong_message), Snackbar.LENGTH_LONG).show()
                }
            }
        } catch (sqlException: SQLException) {
            Log.d(TAG, "click() running in thread: ${Thread.currentThread().name}", sqlException)
            Snackbar.make(etAge, "${sqlException.message}", Snackbar.LENGTH_LONG).show()
        }
        catch (runtimeException: RuntimeException) {
            Log.d(TAG, "click() running in thread: ${Thread.currentThread().name}", runtimeException)
            Snackbar.make(etAge, "${runtimeException.message}", Snackbar.LENGTH_LONG).show()
        }
    }
}
