
package scala.Firestore
import Model.{Employee, EmployeeDataBean}
import scala.util.{Failure, Success, Try}
import com.google.cloud.firestore.{CollectionReference, DocumentReference, WriteResult}
import connectors.FirebaseConnection.db



class FirestorePost {
  var employeeData = Employee("A","JAYSON",13)

  def beanToFirestore[B](docId: String, col: CollectionReference, bean: B): Either[String, WriteResult] = {
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
  beanToFirestore[EmployeeDataBean](employeeData.EmployeeId, db.collection("employeedata"), employeeData.toBean)


}
