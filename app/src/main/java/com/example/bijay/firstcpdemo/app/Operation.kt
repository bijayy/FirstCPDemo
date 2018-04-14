package com.example.bijay.firstcpdemo.app

import android.app.Activity
import android.support.design.widget.Snackbar
import android.util.Log
import com.example.bijay.firstcpdemo.R
import com.example.bijay.firstcpdemo.data.SqliteDatabaseAdapter
import com.example.bijay.firstcpdemo.validation.Validation
import kotlinx.android.synthetic.main.activity_main.*

class Operation {

    private val TAG = Operation::class.java.simpleName
    private var activity: Activity? = null

    constructor( activity: Activity) {
        this.activity = activity

        Log.d(TAG, "Constructor invoked")
    }

    fun insert(name: String, age: String) {
        if (Validation.isValid(name, age)) {
            val sqliteDatabaseAdapter = SqliteDatabaseAdapter(activity)
            val rowId = sqliteDatabaseAdapter.insert(name, age)

            if (rowId > -1) {
                Snackbar.make(activity!!.etAge,activity?.getString(R.string.data_added_message) + rowId, Snackbar.LENGTH_LONG).show()
            } else
                Snackbar.make(activity!!.etAge, activity?.getString(R.string.record_add_fail_message)!!, Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(activity!!.etAge, activity?.getString(R.string.provide_insert_data_message)!!, Snackbar.LENGTH_LONG).show()
        }

        Log.d(TAG, "insert() running in thread: ${Thread.currentThread().name}")
    }

    fun update (name: String, newName: String) {

        if (Validation.isValid(name, newName)) {
            val sqliteDatabaseAdapter = SqliteDatabaseAdapter(activity)
            val totalRowUpdated = sqliteDatabaseAdapter.update(name, newName)

            if (totalRowUpdated > 0) {
                Snackbar.make(activity!!.etAge, activity?.getString(R.string.record_updated_message) + totalRowUpdated, Snackbar.LENGTH_LONG).show()
            } else
                Snackbar.make(activity?.etAge!!, activity?.getString(R.string.no_record_updated_message)!!, Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(activity!!.etAge, activity!!.getString(R.string.provide_update_data_message), Snackbar.LENGTH_LONG).show()
        }

        Log.d(TAG, "update() running in thread: ${Thread.currentThread().name}")
    }

    fun delete(name: String) {
        if (Validation.isValid(name)) {
            val sqliteDatabaseAdapter = SqliteDatabaseAdapter(activity)
            val totalRowDeleted = sqliteDatabaseAdapter.delete(name)

            if (totalRowDeleted > 0) {
                Snackbar.make(activity!!.etAge, activity!!.getString(R.string.record_deleted_message) + totalRowDeleted, Snackbar.LENGTH_LONG).show()
            } else
                Snackbar.make(activity!!.etAge, activity!!.getString(R.string.no_record_deleted), Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(activity!!.etAge, activity!!.getString(R.string.provide_delete_data_message), Snackbar.LENGTH_LONG).show()
        }

        Log.d(TAG, "delete() running in thread: ${Thread.currentThread().name}")
    }

    fun select(name: String) {
        val sqliteDatabaseAdapter = SqliteDatabaseAdapter(activity)
        val buffer = sqliteDatabaseAdapter.select(name)

        if (buffer.length > 0)
            Snackbar.make(activity!!.etAge, "$buffer", Snackbar.LENGTH_LONG).show()
        else
            Snackbar.make(activity!!.etAge, activity!!.getString(R.string.no_data_message), Snackbar.LENGTH_LONG).show()

        Log.d(TAG, "select() running in thread: ${Thread.currentThread().name}")
    }
}