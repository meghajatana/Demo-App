package FireBase



import connectors.FirebaseConnection

import com.google.firebase.database.{DatabaseError, ValueEventListener,DataSnapshot}




class FireBaseGet {
    def getData()={
      val ref = FirebaseConnection.ref("employeeDetails")
      ref.addValueEventListener(new ValueEventListener {
        override def onDataChange(snapshot: DataSnapshot): Unit = {
          print(snapshot.getValue())
        }

        override def onCancelled(error: DatabaseError): Unit = ???
      })


    }
}