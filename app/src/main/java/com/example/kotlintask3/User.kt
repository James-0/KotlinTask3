package com.example.kotlintask3

import android.os.Parcel
import android.os.Parcelable

data class User(var fName: String?, var lName: String?, var uName: String?,
                var email: String?, var dob: String?, var password: String?, var quote: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fName)
        parcel.writeString(lName)
        parcel.writeString(uName)
        parcel.writeString(email)
        parcel.writeString(dob)
        parcel.writeString(password)
        parcel.writeString(quote)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}