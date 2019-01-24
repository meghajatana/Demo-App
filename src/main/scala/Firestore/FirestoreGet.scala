package Firestore
import com.google.cloud.firestore.DocumentReference
import Model.{Employee, EmployeeDataBean}
import com.google.cloud.firestore._
import com.google.firebase.cloud.FirestoreClient
import com.google.api.core.ApiFuture
import connectors.FirestoreConnection._
class FirestoreGet {

  def fetchDocSnapshot(docId: String)(col: CollectionReference): Either[String, DocumentSnapshot] = {
    val docSnapshot = col.document(docId).get().get()
    if (docSnapshot.exists()) Right(docSnapshot) else Left("Something wrong")
  }
  def getSnapshotFromFireStore(docIds: String, collectionName: String): Either[String, DocumentSnapshot] = fetchDocSnapshot(docIds)(db.collection(collectionName))
  val snapshot= getSnapshotFromFireStore("A","employeedata")
  val data: Either[String,Employee] = snapshot.map(value => value.toObject(classOf[EmployeeDataBean]).toCase)
//  def fx(p:Employee):Unit = {
//    println(p)
//  }

  data.foreach(print(_))

  //data.map(fx)
}



