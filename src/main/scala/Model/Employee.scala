package Model

import scala.beans.BeanProperty

class EmployeeDataBean() {

  @BeanProperty var EmployeeId: String = _
  @BeanProperty var Name: String = _
  @BeanProperty var Age: Int = _

  def toCase: Employee = {
    Employee(EmployeeId, Name, Age)
  }
}
case class Employee(
                     EmployeeId: String,
                     Name: String,
                     Age: Int) {
  def toBean: EmployeeDataBean = {
    val employeeData = new EmployeeDataBean()
    employeeData.EmployeeId = EmployeeId
    employeeData.Name = Name
    employeeData.Age = Age
    employeeData
  }
}
