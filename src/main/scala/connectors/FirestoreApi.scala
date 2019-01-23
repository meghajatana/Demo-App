package connectors

import com.google.cloud.firestore.{ CollectionReference, DocumentReference, DocumentSnapshot, WriteResult }

import scala.util.{ Failure, Success, Try }

trait FirestoreApi {

  def fetchDocSnapshot(docId: String)(col: CollectionReference): Either[String, DocumentSnapshot] = {
    val docSnapshot = col.document(docId).get().get()
    if (docSnapshot.exists()) Right(docSnapshot) else Left("Something went wrong")
  }

  def fetchDocSnapshots(docIds: Seq[String])(col: CollectionReference): Either[String, Seq[DocumentSnapshot]] = {
    val documentSnapshots =
      docIds.map(id => col.document(id).get()).map(af => af.get())

    if (documentSnapshots.exists(!_.exists())) Left("Something went wrong")
    else Right(documentSnapshots)
  }

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

}

object FirestoreApiImpl extends FirestoreApi