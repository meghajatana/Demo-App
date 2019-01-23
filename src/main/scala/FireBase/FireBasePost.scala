package FireBase

import Model.Employee
import com.google.api.core.ApiFuture
import connectors.FirebaseConnection

class FireBasePost {
  var employeeData = Employee("2","Jasmine",23)
  def post(employeeData: Employee, refPath: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(employeeData.EmployeeId)
    ref.setValueAsync(employeeData.toBean)
  }
  private def parseAsEmployee(employeeData: Employee): Employee = {
    Employee(employeeData.EmployeeId, employeeData.Name, employeeData.Age)
  }
  val employeeDataBean = parseAsEmployee(employeeData)
  post(employeeDataBean, "employeeDetails")

  def get[T](personData: T, refPath: String, key: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(key)
    ref.setValueAsync(personData)
  }
  private def parseAsEmployeeDataBean(employeeData: Employee): Employee = {
    Employee(employeeData.EmployeeId, employeeData.Name, employeeData.Age)
  }
  val employeeDataNormal = parseAsEmployee(employeeData).toBean
}
