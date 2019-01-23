import FireBase.{FireBaseGet, FireBasePost}
import Firestore.FirestorePost
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.{CollectionReference, DocumentReference, DocumentSnapshot, WriteResult}
import Model.Employee

import scala.beans.BeanProperty
import connectors.FirebaseConnection
import connectors.FirebaseConnection._

import scala.util.{Failure, Success, Try}

object EmployeeData extends App {
   val FBP=new FireBasePost()
    val  FSP=new FirestorePost()
  val FBG=new FireBaseGet()
  FBG.getData()




}
