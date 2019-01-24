package FireBase
import connectors.FirestoreConnection._
import Model.{Employee, EmployeeDataBean}
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.QuerySnapshot
import com.google.firebase.database.{DataSnapshot, DatabaseError, DatabaseReference, ValueEventListener}
import connectors.FirebaseConnection

class FireBaseGet {

  import com.google.firebase.database.DatabaseError
  import com.google.firebase.database.FirebaseDatabase
  import com.google.firebase.database.ValueEventListener

  val database: FirebaseDatabase = FirebaseDatabase.getInstance
  val ref: DatabaseReference = database.getReference("employeeDetails").child("2")

  // Attach a listener to read the data at our posts reference
  ref.addValueEventListener(new ValueEventListener() {
    def onDataChange(dataSnapshot: DataSnapshot): Unit = {
      val post: EmployeeDataBean = dataSnapshot.getValue(classOf[EmployeeDataBean])
      println(post.toCase.toString)
    }

    override

    def onCancelled(databaseError: DatabaseError): Unit = {
      println("The read failed: " + databaseError.getCode)
    }
  })}
