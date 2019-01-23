package Firestore
import com.google.cloud.firestore.DocumentReference
import Model.Employee
import com.google.cloud.firestore._
import com.google.firebase.cloud.FirestoreClient
import com.google.api.core.ApiFuture

class FirestoreGet {

  //import com.google.api.core.ApiFuture
  //import com.google.cloud.firestore.QuerySnapshot
  val db: Firestore = FirestoreClient.getFirestore
  val query: ApiFuture[QuerySnapshot] = db.collection("employeedata").get()

  //import com.google.cloud.firestore.QuerySnapshot

  val querySnapshot: QuerySnapshot = query.get()

  //import com.google.cloud.firestore.QueryDocumentSnapshot

  val documents: List[QueryDocumentSnapshot] = querySnapshot.getDocuments()

  import com.google.cloud.firestore.QueryDocumentSnapshot
  import scala.collection.JavaConversions._

  for (document <- documents) {
    System.out.println("User: " + document.getId)
    System.out.println("First: " + document.getString("EmployeeId"))

    System.out.println("Last: " + document.getString("Name"))
    System.out.println("Born: " + document.getInt(field="Age"))
  }

  //asynchronously retrieve all documents//asynchronously retrieve all documents
//
//  def fetchDocSnapshots(docIds: Seq[String])(col: CollectionReference): Either[String, Seq[DocumentSnapshot]] = {
//    val documentSnapshots:DocumentSnapshot = docIds.map(id => col.document(id).get()).map(af => af.get())
//
//    val docRef: DocumentReference = db.collection("employeedata").document("1")
//
//    val future = docRef.get()
//    val document:DocumentSnapshot= future.get()
//    if (documentSnapshots.exists(!_.exists())) Left("Something went wrong")
//    else Right(documentSnapshots)
//  }
}
