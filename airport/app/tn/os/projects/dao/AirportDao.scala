package tn.os.projects.dao

import com.google.inject.ImplementedBy

import tn.os.projects.model.Airport

@ImplementedBy(classOf[AirportDaoImpl])
trait AirportDao {
  def airports : List[Airport]
}