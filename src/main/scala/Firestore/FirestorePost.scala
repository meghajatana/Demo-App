package Firestore
import scala.util._
import Model.{Employee, EmployeeDataBean}
import com.google.cloud.firestore.{CollectionReference, DocumentReference, Firestore, WriteResult}
import com.google.firebase.cloud.FirestoreClient
class FirestorePost {
  val db: Firestore = FirestoreClient.getFirestore
  var employeeData = Employee("1","Srishti",25)
       def writeBeanToFirestore[B](docId: String, col: CollectionReference, bean: B): Either[String, WriteResult] = {
            val newDocRef: DocumentReference = col.document(docId)
            val tryWrite =
                Try {
                    newDocRef.set(bean).get()
                }
            tryWrite match {
                case Failure(ex) => Left(s"error: $ex")
                case Success(v) => Right(v)
            }
        }
        writeBeanToFirestore[EmployeeDataBean](employeeData.EmployeeId, db.collection("employeedata"), employeeData.toBean)
}
